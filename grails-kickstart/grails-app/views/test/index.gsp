<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main">
        <title>Test gsp</title>
    </head>
    <body>
    <ul>
    <g:each in="${pets}" var="pet">
        <li>${pet.name}</li>
    </g:each>
        </ul>
    <p>
        <g:select name="foo" from="${1..10}"/>
        <select
    </p>
    </body>
</html>