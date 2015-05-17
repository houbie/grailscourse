package exercise

import groovy.transform.Canonical

@Canonical
class OrderLine {
    String product
    int quantity
    double unitPrice
}
