<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Actors Page</title>
</head>
<body>
<H1>רשימת שחקנים</H1>
<table>
   <thead>
	  <tr><TH>ID</TH><TH>שם פרטי</TH><TH>שם משפחה</TH><TH>תאריך עדכון</TH><TH>פעולה</TH></tr>
	  </tr>
	</thead>
	<tbody>
	<c:forEach items="${actorim}" var="sahkan">
	  <tr>
		  <td><c:out  value="${sahkan.actorId}"/></td>
		  <td><c:out  value="${sahkan.firstName}"/></td>
		  <td><c:out  value="${sahkan.lastName}"/></td>
		   <td><c:out value="${sahkan.lastUpdate}"/></td>
		   <td>
		  <a href="ActorController?myaction=delete&id=<c:out  value="${sahkan.actorId}"/>">מחיקה</a>
		  <a href="ActorController?myaction=update&id=<c:out  value="${sahkan.actorId}"/>">עדכון</a>
		  </td>
		   
	  </tr>
	  </c:forEach>
	</tbody>
</table>
</body>
</html>

