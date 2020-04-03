<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main" />
    <g:set var="entityName" value="${message(code: 'user.label', default: 'User')}" />
    <title><g:message code="default.list.label" args="[entityName]" /></title>
</head>

<body>
    <a href="#list-vehicle" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
    <div class="nav" role="navigation">
        <ul>
            <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
            <li><g:link class="login" action="login"><g:message message="${user.name}" code="default.new.label" args="[entityName]" /></g:link></li>
        </ul>
    </div>
    <div>
        <h1>Bienvenido, <g:message message="${user.name}" /></h1>
    </div>
</body>
</html>