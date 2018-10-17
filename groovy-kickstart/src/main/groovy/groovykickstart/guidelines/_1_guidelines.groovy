package groovykickstart.guidelines

//optional ()

//in configuration (Gradle example)
compile 'org.codehaus.groovy:groovy-all:2.4.3'

// in code
compile('println "Hello world!"')

//optional return
title = 'Groovy'

String toString() { title }

//more then one statement: explicit
def compile(String code) {
    def shell = new GroovyShell()
    try {
        return shell.evaluate(code)
    } catch (e) {
        return "Error: $e.message"
    }
}

//Strings: prefer single quotes
println 'constant string'
println "Hello, I'm Ivo"
println "GString with variable content ${new Date()}"

//typing:
// local variables: flow typing (def)
// (public) method signatures: explicit typing