<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<sf:form action="Login" method="post" modelAttribute="caterer"
		cssClass="signup-page">
		<sf:input id="un" path="username"
			cssClass="form-control margin-bottom-20" ></sf:input>
		<sf:input id="pass" path="password"
			cssClass="form-control margin-bottom-20" ></sf:input>
		<input type="submit" value="Submit" class="btn btn-primary" />
	</sf:form>
</body>
</html>