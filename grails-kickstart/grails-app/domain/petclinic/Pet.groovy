package petclinic

class Pet {

    String name
    Date birthDate
    PetType type
    PetOwner owner

    static hasMany = [visits: Visit]

    static constraints = {
        name blank: false, validator: { name, pet ->
            if (!pet.id && pet.owner?.pets?.find { it.name == name }) {
                return 'pet.duplicate'
            }
        }
    }
}