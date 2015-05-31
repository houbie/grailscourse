package petclinic

import geb.spock.GebSpec
import grails.test.mixin.integration.Integration
import spock.lang.Shared
import spock.lang.Stepwise

@Integration
@Stepwise
class PersonSpec extends GebSpec {
    @Shared
    def personId

    void "create a new person"() {
        when:
        to PersonCreatePage
        firstName = 'Chuck'
        lastName = 'Norris'
        submitButton.click()

        then:
        at PersonDetailPage

        when:
        personId = id.substring(id.lastIndexOf('/') + 1)
        to PersonListPage

        then:
        row(-1).find('a').text() == 'Chuck'
    }

    void 'edit a person'() {
        when:
        to PersonEditPage, personId
        form.firstName = 'Chucky'
        submitButton.click()

        then:
        at PersonDetailPage
        firstName == 'Chucky'
    }

    void "delete a person"() {
        when:
        to PersonDetailPage, personId
        withConfirm(true) { deleteButton.click() }

        then:
        at PersonListPage
        $('div.message', text: contains('deleted'))
    }

}
