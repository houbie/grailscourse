package petclinic

import geb.Page

class PersonCreatePage extends Page {
    static url = "/person/create"
    static at = { title == 'Create Person' }
    static content = {
        firstName { $("input[name=firstName]") }
        lastName { $("input[name=lastName]") }
        submitButton { $('#create') }
    }

}
