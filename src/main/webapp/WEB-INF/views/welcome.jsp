<!DOCTYPE html>
<%@page import="edu.osumc.bmi.ird.spring.tutorial.controller.UserResource" %>
<%@include file="taglib.jsp" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>

<h2>Welcome <%=UserResource.getCurrentUser().getUsername()%>
</h2>

<h2>Authorities <%=UserResource.getCurrentUser().getAuthorities()%>
</h2>

<h3>Name: <sec:authentication property="name"/></h3>

<h3>
    <sec:authorize access="hasRole('ROLE_ADMIN')">
        <a href="${rootURL}admin">Administration</a>
    </sec:authorize>
</h3>

<a href="${rootURL}user/list">User Table</a><br/>
<a href="${rootURL}user/json">User in Json Array</a>

<p><a href="${rootURL}logout">Logout</a></p>
</body>