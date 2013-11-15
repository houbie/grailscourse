package groovykickstart.showcase

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@ToString
@EqualsAndHashCode(excludes = ['regression'])
class Bug {
    String title
    String description
    String reporter
    String project
    private boolean regression

    void setTitle(String title) {
        this.title = title
        regression = (title =~ /^\s*Regression\s*:?/)
    }

    boolean isRegression() {
        return regression
    }
}
