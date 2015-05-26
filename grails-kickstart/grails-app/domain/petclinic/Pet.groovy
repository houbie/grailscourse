package petclinic

class Pet {

    String name
    Date birthDate
    PetType type
//    String nickName


    @Override
    String toString() { name }

    static hasMany = [visits: Visit]
    static belongsTo = [owner: PetOwner]

    static constraints = {
        name blank: false, validator: { name, pet ->
            if (!pet.id && pet.owner?.pets?.find { it.name == name }) {
                return 'pet.duplicate'
            }
        }
//        nickName nullable: true
    }
}