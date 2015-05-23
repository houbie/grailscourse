package petclinic

class Visit {

    Date date = new Date()
    String description
    Pet pet

    static constraints = {
        description blank: false
    }
}