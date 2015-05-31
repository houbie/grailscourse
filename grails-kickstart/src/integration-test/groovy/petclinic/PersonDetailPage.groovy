package petclinic

import geb.Page

class PersonDetailPage extends Page {
    static url = "/person/show"
    static at = { title == 'Show Person' }
    static content = {
        id { $('form').@action }
        firstName { $('div.property-value', 'aria-labelledby': 'firstName-label').text() }
        deleteButton { $('input.delete') }
    }
}
