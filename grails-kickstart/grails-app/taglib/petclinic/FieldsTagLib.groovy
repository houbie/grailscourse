package petclinic

import grails.util.GrailsNameUtils

class FieldsTagLib {
    static namespace = "f"
    static defaultEncodeAs = [taglib: 'raw']

    static final String BEAN_PAGE_SCOPE_VARIABLE = 'f:with:bean'

    @Lazy
    def formFieldsTagLib = grailsApplication.mainContext.getBean('grails.plugin.formfields.FormFieldsTagLib')

    def field = { attrs, body ->
        if (!attrs.'input-class') {
            attrs.'input-class' = 'form-control'
        }
        formFieldsTagLib.field.call(attrs, body)
    }

    def displayList = { attrs, body ->
        def bean = attrs.remove('bean')
        if (!bean) throwTagError("Tag [displayList] is missing required attribute [bean]")
        out << '<ol class="property-list">'
        out << f.with(bean: bean) {
            out << body()
        }
        out << '</ol>'
    }

    def displayItem = { attrs, body ->
        def property = attrs.property
        if (!property) throwTagError("Tag [displayItem] is missing required attribute [property]")

        def bean = resolveBean(attrs.remove('bean'))
        def domainClassName = GrailsNameUtils.getPropertyNameRepresentation(bean.getClass())
        def propertyNaturalName = GrailsNameUtils.getNaturalName(property)

        out << '<li class="fieldcontain">'
        out << "<span id=\"${property}-label\" class=\"property-label\">"
        out << g.message(code: "${domainClassName}.${property}.label", default: propertyNaturalName)
        out << '</span>'
        out << "<div class=\"property-value\" aria-labelledby=\"${property}-label\">"
        out << f.display(attrs, body)
        out << '</div>'
        out << '</li >'
    }


    private Object resolveBean(beanAttribute) {
        def bean = pageScope.variables[BEAN_PAGE_SCOPE_VARIABLE]
        if (!bean) {
            // Tomcat throws NPE if you query pageScope for null/empty values
            if (beanAttribute.toString()) {
                bean = pageScope.variables[beanAttribute]
            }
        }
        if (!bean) bean = beanAttribute
        bean
    }
}
