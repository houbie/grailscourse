package groovykickstart.basics

import spock.lang.Specification
import spock.lang.Unroll

import static java.io.File.*


class ScriptsSpec extends Specification {
    @Unroll
    def "test script #script"() {
        Class.forName(script).newInstance().run()

        where:
        script << scriptClasses
    }

    private def getScriptClasses() {
        def basePath = "src${separator}main${separator}groovy${separator}"
        def result = []
        new File(basePath).eachFileRecurse {
            if (it.name =~ /_\d+/) {
                result << (it.path - basePath - '.groovy').replaceAll(separator, '.')
            }
        }
        println result
        return result
    }
}
