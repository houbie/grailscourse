import grails.util.Environment
import petclinic.PetOwner
import petclinic.PetType
import petclinic.Speciality
import petclinic.Vet

import static grails.util.Environment.DEVELOPMENT

class BootStrap {

    def init = { servletContext ->

        println '##### Bootstrap'
        if (Environment.current == DEVELOPMENT) {
            if (!Speciality.count()) {
                def radiology = new Speciality(name: 'radiology').save(failOnError: true)
                def surgery = new Speciality(name: 'surgery').save(failOnError: true)
                def dentistry = new Speciality(name: 'dentistry').save(failOnError: true)

                new Vet(firstName: 'James', lastName: 'Carter').save(failOnError: true)
                new Vet(firstName: 'Helen', lastName: 'Leary')
                        .addToSpecialities(radiology)
                        .save(failOnError: true)
                new Vet(firstName: 'Linda', lastName: 'Douglas')
                        .addToSpecialities(surgery)
                        .addToSpecialities(dentistry)
                        .save(failOnError: true)
                new Vet(firstName: 'Rafael', lastName: 'Ortega')
                        .addToSpecialities(surgery)
                        .save(failOnError: true)
                new Vet(firstName: 'Henry', lastName: 'Stevens')
                        .addToSpecialities(radiology)
                        .save(failOnError: true)
                new Vet(firstName: 'Sharon', lastName: 'Jenkins').save(failOnError: true)

                for (String type in ['dog', 'lizard', 'cat', 'snake', 'bird', 'hamster']) {
                new PetType(name: type).save(failOnError: true)
                }
            }

            if (!PetOwner.count) {
                new PetOwner(lastName: 'Smith', firstName: 'John', address: '123 EZ St.', city: 'NO', telephone: '123')
                        .save(failOnError: true)
                new PetOwner(lastName: 'Smith', firstName: 'Jane', address: '456 My Way', city: 'NY', telephone: '456')
                        .save(failOnError: true)
                new PetOwner(lastName: 'Bubinga', firstName: 'Woody', address: '789 Hard Road', city: 'WI', telephone: '789')
                        .save(failOnError: true)
            }
        }
    }
    def destroy = {
    }
}
