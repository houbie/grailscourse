package petclinic
import grails.transaction.Transactional

@Transactional(readOnly = true)
class TestController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        render(text: "hello jhk")
    }
}
