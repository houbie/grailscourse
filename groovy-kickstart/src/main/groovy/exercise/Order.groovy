package exercise

import groovy.transform.Canonical

@Canonical
class Order {
    int orderNr
    int customerNr
    List<OrderLine> orderLines
}
