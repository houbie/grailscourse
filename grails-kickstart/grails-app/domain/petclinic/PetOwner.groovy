package petclinic

class PetOwner extends Person {

    String address
    String city
    String telephone

    static hasMany = [pets: Pet]

    static constraints = {
        address blank: false
        city blank: false
        telephone matches: /\d+/, blank: false
    }
}
