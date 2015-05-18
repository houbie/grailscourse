package petclinic

class Pet {

    static belongsTo = [owner: Owner]

    String name
    PetType type
    Date birthDate
//    Set<Visit> visits

    static constraints = {
    }

    String toString() { name }
}
