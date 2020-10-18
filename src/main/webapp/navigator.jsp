<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<u>
    <li>
        <a href="${pageContext.request.contextPath}/">Home</a>
    </li>
    <li>
        <a href="${pageContext.request.contextPath}/multiplication.jsp">Tabliczka mnożenia</a>
    </li>
    <li>
        <a href="${pageContext.request.contextPath}/students">Lista studentów</a>
    </li>
    <li>
        <a href="${pageContext.request.contextPath}/student/form">Formularz dodawania studenta</a>
    </li>
</u>