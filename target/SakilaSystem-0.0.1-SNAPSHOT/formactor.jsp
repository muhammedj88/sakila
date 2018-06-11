<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Actor Update Form</title>
</head>
<body>
<form action="ActorController" method="post" name="frm">
<div>
<label for="id_param">ID (readonly)</label>
<input readonly type="text" name="id_param" value="<c:out  value="${sahkan.actorId}"/>"/>
</div>

<div>
<label for="f_name_param">First Name</label>
<input type="text" name="f_name_param" value="<c:out  value="${sahkan.firstName}"/>"/>
</div>

<div>
<label for="l_name_param">Last Name</label>
<input type="text" name="l_name_param" value="<c:out  value="${sahkan.lastName}"/>"/>
</div>

<div>
<label for="update_param">Update Date (readonly)</label>
<input readonly type="text" name="update_param" value="<c:out  value="${sahkan.lastUpdate}"/>"/>
</div>

<input type="submit" value="עדכן"/>
</form>
</body>
</html>

