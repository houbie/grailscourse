package petclinic

class Vet extends Person {

    static hasMany = [specialties: Specialty]

    static constraints = {
    }
}
