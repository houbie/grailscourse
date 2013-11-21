package petclinic

class Pet {

    String name
    PetType type
    Date birthDate
    Owner owner
//    Set<Visit> visits

    static constraints = {
    }

    String toString() { name }
}
