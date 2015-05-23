package petclinic

class Vet extends Person {

    static hasMany = [specialities: Speciality]
}