package petclinic

class Owner extends Person {

    static hasMany = [pets: Pet]

    String address
    String city
    String telephone

    static constraints = {
        telephone nullable: true
    }

//     static mappedBy = [pets: 'none'] //make pet.owner independent of owner.pets (create two unidirectional relations)
}
