package exercise

import groovy.transform.CompileStatic
import org.apache.commons.beanutils.BeanUtils

/**
 * @author Ivo Houbrechts
 */
@CompileStatic
class CsvParser {
    Collection<Customer> parseCustomers(File customerCsv) {
        Collection<Customer> customers = []
        Collection<String> headers
        customerCsv.splitEachLine(';') { values ->
            if (!headers) {
                //groovy type bug -> splitEachLine declares values as String[], but it is List<String>
                headers = values as List
            } else {
                def customer = new Customer(address: new Address())
                values.eachWithIndex { String value, int index ->
                    BeanUtils.setProperty(customer, headers[index], value)
                }
                customers << customer
            }
        }
        return customers
    }

    Collection<Order> parseOrders(File orderCsv) {
        Map<Integer, Order> orders = [:]
        Map<String, Integer> orderLineHeaders = [:]
        int orderNrIndex
        int customerNrIndex

        orderCsv.splitEachLine(';') { values ->
            if (!orderLineHeaders) {
                values.eachWithIndex { String value, int index ->
                    switch (value) {
                        case 'orderNr': orderNrIndex = index
                            break
                        case 'customerNr': customerNrIndex = index
                            break
                        default: orderLineHeaders[value - 'orderLine.'] = index
                    }
                }
            } else {
                def orderNr = values[orderNrIndex].toInteger()
                def customerNr = values[customerNrIndex].toInteger()
                orders.putIfAbsent(orderNr, new Order(orderNr: orderNr, customerNr: customerNr, orderLines: []))
                def orderLine = new OrderLine()
                orderLineHeaders.each { String key, int index ->
                    BeanUtils.setProperty(orderLine, key, values[index])
                }
                orders[orderNr].orderLines << orderLine
            }
        }
        return orders.values()
    }

    static void main(String[] args) {
        def csvParser = new CsvParser()
        def customers = csvParser.parseCustomers(new File('src/main/resources/customers.csv'))
        println customers
        def orders = csvParser.parseOrders(new File('src/main/resources/orders.csv'))
        println "############"
        println orders
    }
}
