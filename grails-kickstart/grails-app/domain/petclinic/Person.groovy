package petclinic

class Person {

    String firstName
    String lastName

    @Override
    String toString() { "$firstName $lastName" }

    static constraints = {
        firstName blank: false
        lastName blank: false
    }
}