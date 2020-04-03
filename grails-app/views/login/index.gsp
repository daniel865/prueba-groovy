<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main" />
    <g:set var="entityName" value="${message(code: 'user.label', default: 'User')}" />
    <title><g:message code="default.login.label" args="[entityName]" /></title>
</head>
<body>
<a href="#login-user" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
    </ul>
</div>
<div id="login-user" class="content scaffold-create" role="main">
    <h1><g:message code="default.login.label" args="[entityName]" /></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <g:hasErrors bean="${this.user}">
        <ul class="errors" role="alert">
            <g:eachError bean="${this.user}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
            </g:eachError>
        </ul>
    </g:hasErrors>
    <g:form action="login">
        <fieldset class="form">
            <f:field bean="user" property="name"/>
            <f:field bean="user" property="document" />
        </fieldset>
        <fieldset class="buttons">
            <g:submitButton name="login" class="login" value="${message(code: 'default.button.login.label', default: 'Login')}" />
        </fieldset>
    </g:form>
</div>
</body>
</html>
