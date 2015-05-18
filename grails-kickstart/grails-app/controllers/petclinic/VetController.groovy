package petclinic

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class VetController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Vet.list(params), model:[vetCount: Vet.count()]
    }

    def show(Vet vet) {
        respond vet
    }

    def create() {
        respond new Vet(params)
    }

    @Transactional
    def save(Vet vet) {
        if (vet == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (vet.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond vet.errors, view:'create'
            return
        }

        vet.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'vet.label', default: 'Vet'), vet.id])
                redirect vet
            }
            '*' { respond vet, [status: CREATED] }
        }
    }

    def edit(Vet vet) {
        respond vet
    }

    @Transactional
    def update(Vet vet) {
        if (vet == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (vet.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond vet.errors, view:'edit'
            return
        }

        vet.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'vet.label', default: 'Vet'), vet.id])
                redirect vet
            }
            '*'{ respond vet, [status: OK] }
        }
    }

    @Transactional
    def delete(Vet vet) {

        if (vet == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        vet.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'vet.label', default: 'Vet'), vet.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'vet.label', default: 'Vet'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
