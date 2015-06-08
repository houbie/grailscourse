package petclinic

class PetType {

    static hasMany = [tags: Tag]
    String name

    @Override
    String toString() { name }

    static constraints = {
        name blank: false, minSize: 3, maxSize: 20, unique: true
    }
}