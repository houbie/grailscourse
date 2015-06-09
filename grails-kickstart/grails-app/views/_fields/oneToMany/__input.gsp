<%@ page import="petclinic.Tag" %>
<g:select name="tags" value="${petType?.tags*.id}" from="${Tag.list()}" optionKey="id" multiple="true"/>