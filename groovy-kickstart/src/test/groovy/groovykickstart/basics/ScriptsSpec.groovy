package groovykickstart.basics

import spock.lang.Specification
import spock.lang.Unroll


class ScriptsSpec extends Specification {
    @Unroll
    def "test script #script"() {
        Class.forName(script).newInstance().run()

        where:
        script << scriptClasses
    }

    private def getScriptClasses() {
        def basePath = 'src/main/groovy'
        def result = []
        new File(basePath).eachFileRecurse {
            if (it.name=~/_\d+/) {
                result << it.path[basePath.size() + 1..-8].replaceAll(/\W/, '.')
            }
        }
        println result
        return result
    }
}
