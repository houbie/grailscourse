package petclinic

class Speciality {

    String name

    static constraints = {
        name blank: false, minSize: 3, maxSize: 20, unique: true
    }
}

