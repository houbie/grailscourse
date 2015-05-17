package exercise

import groovy.transform.Canonical

@Canonical
class Customer {
    int customerNumber
    String lastName
    String firstName
    Address address
    int discount
}
