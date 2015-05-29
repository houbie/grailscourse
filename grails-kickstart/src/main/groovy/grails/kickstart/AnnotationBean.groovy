package grails.kickstart

import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import javax.annotation.PostConstruct
import javax.sql.DataSource

@Component
@Slf4j
class AnnotationBean {
    @Autowired
    private DataSource dataSource

    @Autowired
    private EchoService echoService

    @PostConstruct
    void init() {
        assert dataSource
        assert echoService
    }

    String echo(String s) { echoService.echo(s) }
}
