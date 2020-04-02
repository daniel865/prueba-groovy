<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main" />
</head>
<body>
<div class="nav" role="navigation">
    <ul>
        <li><g:link class="list" action="index">Users list</g:link></li>
    </ul>
</div>
<div id="show-user" class="content scaffold-show" role="main">
    <f:display bean="user" />
    <g:form resource="${this.user}" method="DELETE">
        <fieldset class="buttons">
            <input class="delete" type="submit" value="delete" />
        </fieldset>
    </g:form>
</div>
</body>
</html>