<%@ page import="petclinic.PetOwner" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'pet.label', default: 'Pet')}"/>
    <title>Double select demo</title>
</head>

<body>
<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
    </ul>
</div>

<div role="main">
    <g:select id="ownerSelect" name="owner" from="${owners}" optionKey="id"/>
    <tmpl:petSelect pets="${pets}"/>
</div>
<script type="text/javascript">
    $('#ownerSelect').on('change', function () {
        console.log('change', this.value);
        $('#petSelect').load('${createLink(action: "filterPets")}' + '/' + this.value)
    });
</script>
</body>
</html>
