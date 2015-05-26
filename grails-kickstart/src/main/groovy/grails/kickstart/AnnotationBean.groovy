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
    DataSource dataSource

    @Autowired
    EchoService echoService

    @PostConstruct
    void init() {
        log.info("#######################################")
        log.info("######## DataSource: $dataSource, EchoService: $echoService")
    }
}
