package groovykickstart.advanced

//dynamically add methods and properties at runtime
String.metaClass.shuffle = {
    def list = delegate as List
    Collections.shuffle(list)
    return list.join()
}

println 'Hello groovy!'.shuffle()






//intercept missing methods (or properties)
class Tagger {
    private StringBuilder xml = new StringBuilder()

    def methodMissing(String name, args) {
        xml << '<' << name << '>' << args.join() << '</' << name << '>'
        return this
    }

    String toString() { xml }
}

assert new Tagger().firstName('John').lastName('Smith').toString() == '<firstName>John</firstName><lastName>Smith</lastName>'

//but:
assert new Tagger().class('java.lang.String').hashCode('yes').equals('yes').toString() == 'false'
