package groovykickstart.basics


class BasicTests extends GroovyTestCase {
    void testPackage() {

        scriptClasses.each {
            Class.forName(it).newInstance().run()
        }
    }

    private def getScriptClasses() {
        def basePath = 'src/main/groovy'
        def result = []
        new File(basePath).eachFileRecurse {
            if (it.name=~/_\d+/) {
                result << it.path[basePath.size() + 1 .. -8].replaceAll(/\W/, '.')
            }
        }
        println result
        return result
    }
}
