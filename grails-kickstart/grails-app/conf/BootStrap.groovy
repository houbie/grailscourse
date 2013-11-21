import petclinic.Owner
import petclinic.Pet
import petclinic.PetType

class BootStrap {

    def init = { servletContext ->
        Owner john = new Owner(firstName: 'John', lastName: 'Smit', address: '3th avennue', city: 'New-York').save(failOnError: true)
        Owner ivo = new Owner(firstName: 'Ivo', lastName: 'Houbrechts', address: 'Veldstraat 50', city: 'Lichtaart').save(failOnError: true)
        PetType catType = new PetType(name: 'cat').save(failOnError: true)
        PetType dogType = new PetType(name: 'dog').save(failOnError: true)
        Pet felix = new Pet(name: 'Felix', type: catType, birthDate: new GregorianCalendar(2001, 1, 20).time, owner: ivo).save(failOnError: true)
        Pet pluto = new Pet(name: 'Pluto', type: dogType, birthDate: new GregorianCalendar(1999, 12, 2).time, owner: ivo).save(failOnError: true)


        ivo.addToPets(felix).addToPets(pluto).save(failOnError: true)
        john.addToPets(felix).save(failOnError: true)
    }
    def destroy = {
    }
}
