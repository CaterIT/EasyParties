<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	Welcome ${caterer.name}(${caterer.displayName })

	<sf:form action="CatererAddressAdd" method="post"
		modelAttribute="catererAddress" cssClass="signup-page">
		<table>
			<tbody>
				<tr>
					<td>Lat:</td>
					<td><sf:input id="lat" path="lat"
							cssClass="form-control margin-bottom-20" /></td>
				</tr>
				<tr>
					<td>Long:</td>
					<td><sf:input path="lng"
							cssClass="form-control margin-bottom-20" /></td>
				</tr>
				<tr>
					<td>Line 1:</td>
					<td><sf:input path="addressDetails.line1"
							cssClass="form-control margin-bottom-20" /></td>
				</tr>
				<tr>
					<td>Line 2:</td>
					<td><sf:input path="addressDetails.line2"
							cssClass="form-control margin-bottom-20" /></td>
				</tr>
				<tr>
					<td>Line 3:</td>
					<td><sf:input path="addressDetails.line3"
							cssClass="form-control margin-bottom-20" /></td>
				</tr>
				<tr>
					<td>Line 3:</td>
					<td><sf:input path="addressDetails.pincode"
							cssClass="form-control margin-bottom-20" /></td>
				</tr>
			</tbody>
		</table>
		<input type="submit" value="Submit" class="btn btn-primary">
	</sf:form>
</body>
</html>