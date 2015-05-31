package petclinic

import geb.Page

class PersonListPage extends Page {
    static url = "/person"
    static at = { title == 'Person List' }
    static content = {
        rows { $('tbody tr') }
        row { index -> rows[index] }
        personLink { index -> row(index).find('a') }
    }

}
