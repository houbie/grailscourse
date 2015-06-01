package petclinic
import geb.spock.GebSpec
//@Integration
class SampleGebSpec extends GebSpec {

    void "test something"() {
        when: "The home page is visited"
        go '/'
        report('tst')

        then: "The title is correct"
        title == "Welcome to Grails"
        $('a', text: endsWith('Controller')).size() == 7
        $('a', text: ~/petclinic.+Controller/).size() == 7

        when:
        $('a', text: ~/.+PersonController/).click()

        then: "The list has 9 elements"
        $('tbody').find('ol')*.find('td')*.text() == ['James', 'Helen', 'Linda', 'Rafael', 'Henry', 'Sharon', 'John', 'Jane', 'Woody']
    }
}
