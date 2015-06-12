<%
/*  attrs contains all "input-xxx" attributes provided to the g:field tag

    the model for this template contains:
    bean
    property
    type (property class, String, Boolean etc)
    beanClass
    label
    value
    constraints (grails.validation.ConstrainedProperty)
    persistentProperty (grails.core.GrailsDomainClassProperty)
    errors
    required
    invalid
    prefix (embedded beans)
*/
    if (!attrs.name) {
        attrs.name = (prefix ?: '') + property
    }
    if (!attrs.value) {
        attrs.value = value
    }
    if (required) attrs.required = ""
    if (invalid) attrs.invalid = ""
    if (constraints && !constraints.editable) {
        attrs.readonly = ""
    }
    if (!attrs.class) {
        attrs.class = 'form-control'
    }
%>
--constraints: ${constraints*.getClass()}--
--persistentProperty: ${persistentProperty*.getClass()}--
${raw(g.field(attrs))}