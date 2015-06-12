package petclinic

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class PetOwnerController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond PetOwner.list(params), model:[petOwnerCount: PetOwner.count()]
    }

    def show(PetOwner petOwner) {

        respond petOwner
    }

    def create() {
        respond new PetOwner(params)
    }

    @Transactional
    def save(PetOwner petOwner) {
        if (petOwner == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (petOwner.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond petOwner.errors, view:'create'
            return
        }

        petOwner.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'petOwner.label', default: 'PetOwner'), petOwner.id])
                redirect petOwner
            }
            '*' { respond petOwner, [status: CREATED] }
        }
    }

    def edit(PetOwner petOwner) {
        respond petOwner
    }

    @Transactional
    def update(PetOwner petOwner) {
        if (petOwner == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (petOwner.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond petOwner.errors, view:'edit'
            return
        }

        petOwner.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'petOwner.label', default: 'PetOwner'), petOwner.id])
                redirect petOwner
            }
            '*'{ respond petOwner, [status: OK] }
        }
    }

    @Transactional
    def delete(PetOwner petOwner) {

        if (petOwner == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        petOwner.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'petOwner.label', default: 'PetOwner'), petOwner.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'petOwner.label', default: 'PetOwner'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
