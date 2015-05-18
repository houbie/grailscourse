package petclinic

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class SpecialtyController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Specialty.list(params), model:[specialtyCount: Specialty.count()]
    }

    def show(Specialty specialty) {
        respond specialty
    }

    def create() {
        respond new Specialty(params)
    }

    @Transactional
    def save(Specialty specialty) {
        if (specialty == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (specialty.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond specialty.errors, view:'create'
            return
        }

        specialty.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'specialty.label', default: 'Specialty'), specialty.id])
                redirect specialty
            }
            '*' { respond specialty, [status: CREATED] }
        }
    }

    def edit(Specialty specialty) {
        respond specialty
    }

    @Transactional
    def update(Specialty specialty) {
        if (specialty == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (specialty.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond specialty.errors, view:'edit'
            return
        }

        specialty.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'specialty.label', default: 'Specialty'), specialty.id])
                redirect specialty
            }
            '*'{ respond specialty, [status: OK] }
        }
    }

    @Transactional
    def delete(Specialty specialty) {

        if (specialty == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        specialty.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'specialty.label', default: 'Specialty'), specialty.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'specialty.label', default: 'Specialty'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
