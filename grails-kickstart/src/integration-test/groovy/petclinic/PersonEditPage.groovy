package petclinic

import geb.Page

class PersonEditPage extends Page {
    static url = "/person/edit"
    static at = { title == 'Edit Person' }
    static content = {
        form {module PersonFormModule}
        submitButton { $('.save') }
    }


}
