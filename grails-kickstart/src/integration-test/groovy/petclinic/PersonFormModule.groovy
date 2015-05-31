package petclinic

import geb.Module

class PersonFormModule extends Module {
    static content = {
        firstName { $("input[name=firstName]") }
        lastName { $("input[name=lastName]") }
    }

}
