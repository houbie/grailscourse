package grails.kickstart

import spock.lang.Specification
import spock.lang.Subject

/**
 * @author Ivo Houbrechts
 */
class AnnotationBeanSpec extends Specification {
    @Subject
    def annotationBean = new AnnotationBean()

    def "Echo"() {
        given:
        EchoService echoService = Mock()
        annotationBean.echoService = echoService

        when:
        def result = annotationBean.echo('foo')

        then:
        result == 'foo'
        1 * echoService.echo('foo') >> 'foo'
    }
}
