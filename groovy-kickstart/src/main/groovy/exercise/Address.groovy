package exercise

import groovy.transform.Canonical

@Canonical
class Address {
    String street
    String city
    String state
    String zip
}
