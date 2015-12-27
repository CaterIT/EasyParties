<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<div class="col-md-6 col-md-offset-3 col-sm-offset-3">

		<sf:form action="RegisterAndSaveCaterer" method="post"
			modelAttribute="caterer" cssClass="signup-page">
			<h2>Register as a Caterer</h2>
			<input type="hidden" name="catererLineContacts[0].type" value="E"/>
			<input type="hidden" name="catererLineContacts[1].type" value="M"/>
			<table>
				<tbody>
					<tr>
						<td>Display name:</td>
						<td><sf:input id="displayName" path="displayName"
								cssClass="form-control margin-bottom-20" /></td>
					</tr>
					<tr>
						<td>Company name:</td>
						<td><sf:input path="name"
								cssClass="form-control margin-bottom-20" /></td>
					</tr>
					<tr>
						<td>Owner's name:</td>
						<td><sf:input path="ownerName"
								cssClass="form-control margin-bottom-20" /></td>
					</tr>
					<tr>
						<td>Mobile:</td>
						<td><input name="catererLineContacts[1].contact" class="form-control margin-bottom-20" /></td>
					</tr>
					<tr>
						<td>Email:</td>
						<td><input name="catererLineContacts[0].contact" class="form-control margin-bottom-20" /></td>
					</tr>
					<tr>
						<td>Choose user name:</td>
						<td><sf:input path="username"
								cssClass="form-control margin-bottom-20" /></td>
					</tr>
					<tr>
						<td>Password:</td>
						<td><sf:input path="password"
								cssClass="form-control margin-bottom-20" /></td>
					</tr>
					<tr>
						<td>Confirm Password:</td>
						<td><input type="text" class="form-control margin-bottom-20" /></td>
					</tr>
				</tbody>
			</table>
			<input type="submit" value="Submit" class="btn btn-primary">
		</sf:form>
	</div>
</body>
</html>