<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Dinh Phu
  Date: 7/9/2020
  Time: 3:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Customers</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
</head>
<body>
 Customer Form
    <div id="wrapper">
        <div id="header">
            <h2>CRM - Customer Relationship Manager</h2>
        </div>
    </div>

<div id="container">
    <h3>Save Customer</h3>

    <form:form action="saveCustomer" modelAttribute="customer" method="post">

        <table>
            <tbody>

                <tr>
                    <td><label >First Name</label></td>
                    <td><form:input path="firstName"/></td>
                </tr>

                <tr>
                    <td><label >Last Name</label></td>
                    <td><form:input path="lastName"/></td>
                </tr>

                <tr>
                    <td><label >Email</label></td>
                    <td><form:input path="email"/></td>
                </tr>
                <tr>
                    <td><label ></label></td>
                    <td><input type="submit" value="Save" class="save"></td>
                </tr>
            </tbody>
        </table>

    </form:form>
</div>

<p><a href="${pageContext.request.contextPath}/customer/list">Back to List</a></p>
</body>
</html>
