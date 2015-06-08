package petclinic

class Tag {

    String name
    String code

    @Override
    String toString() { "$name -$code" }

    static constraints = {
        name unique: true
        code unique: true
    }
}