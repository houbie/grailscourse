import grails.util.Environment
import petclinic.Owner
import petclinic.Pet
import petclinic.PetType

class BootStrap {

    def init = { servletContext ->

        if (Environment.current== Environment.DEVELOPMENT) {
            PetType catType = new PetType(name: 'cat').save(failOnError: true)
            PetType dogType = new PetType(name: 'dog').save(failOnError: true)
            Pet felix = new Pet(name: 'Felix', type: catType, birthDate: new GregorianCalendar(2001, 1, 20).time)
            Pet pluto = new Pet(name: 'Pluto', type: dogType, birthDate: new GregorianCalendar(1999, 12, 2).time)

            new Owner(firstName: 'John', lastName: 'Smith', address: '3th avenue 22', city: 'New-York').addToPets(felix).addToPets(pluto).save(failOnError: true)
            new Owner(firstName: 'Jack', lastName: 'Jones', address: '2nd street 55', city: 'Denver').save(failOnError: true)
        }


    }
    def destroy = {
    }
}
