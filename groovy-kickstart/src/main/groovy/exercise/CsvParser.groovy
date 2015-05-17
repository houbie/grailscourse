package exercise

import org.apache.commons.beanutils.BeanUtils

/**
 * @author Ivo Houbrechts
 */
class CsvParser {
    def parse(File csv) {
        def customers = []
        def headers
        csv.splitEachLine(';') { values ->
            if (headers) {
                def customer = new Customer(address: new Address())
                values.eachWithIndex { value, index ->
                    BeanUtils.setProperty(customer, headers[index], value)
                }
                customers << customer
            } else {
                headers = values
            }
        }
        return customers
    }

    static void main(String[] args) {
        new File('.').absolutePath
        println new CsvParser().parse(new File('src/main/resources/customers.csv'))
    }
}
