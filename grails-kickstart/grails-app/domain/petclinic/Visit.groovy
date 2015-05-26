package petclinic

class Visit {

    Date date = new Date()
    String description

    @Override
    String toString() { description }

    static belongsTo = [pet: Pet]

    static constraints = {
        description blank: false
    }
}