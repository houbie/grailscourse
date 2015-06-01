<%@ page import="petclinic.PetOwner" %>
<f:with bean="pet">
    <f:field property="name"/>
    <f:field property="birthDate"/>
    %{-- only show an empty option in the select when creating a new Pet --}%
    <g:if test="${create}">
        <f:field property="owner">
            <g:select from="${PetOwner.listOrderByFirstName()}" optionKey="id" optionValue="firstName"
                      value="${pet.owner?.id}" name="owner" required="true" noSelection="['': 'Select...']"/>
        </f:field>
    </g:if>
    <g:else>
        <f:field property="owner"/>
    </g:else>
    <f:field property="type"/>
    <f:field property="visits"/>
</f:with>
