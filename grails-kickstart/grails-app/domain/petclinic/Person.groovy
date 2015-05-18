package petclinic

class Person {

    String firstName
    String lastName

    static constraints = {
        firstName nullable: false, maxSize: 20
        lastName nullable: false, maxSize: 20
    }

    String toString() { "$firstName $lastName" }
}
