package petclinic

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class PetTypeController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond PetType.list(params), model:[petTypeCount: PetType.count()]
    }

    def show(PetType petType) {
        respond petType
    }

    def create() {
        respond new PetType(params)
    }

    @Transactional
    def save(PetType petType) {
        if (petType == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (petType.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond petType.errors, view:'create'
            return
        }

        petType.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'petType.label', default: 'PetType'), petType.id])
                redirect petType
            }
            '*' { respond petType, [status: CREATED] }
        }
    }

    def edit(PetType petType) {
        respond petType
    }

    @Transactional
    def update(PetType petType) {
        if (petType == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (petType.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond petType.errors, view:'edit'
            return
        }

        petType.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'petType.label', default: 'PetType'), petType.id])
                redirect petType
            }
            '*'{ respond petType, [status: OK] }
        }
    }

    @Transactional
    def delete(PetType petType) {

        if (petType == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        petType.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'petType.label', default: 'PetType'), petType.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'petType.label', default: 'PetType'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
