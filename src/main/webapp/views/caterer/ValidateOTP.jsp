<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>

	<div class="col-md-6 col-md-offset-3 col-sm-offset-3">
		Please Enter your OTP: <input type="text" id="otp" />
		<button id="validate">Validate</button>
	</div>
	<script type="text/javascript">
	alert("sa");
		$(document).ready(function(){
			alert("sa");
			$("#validate").on("click",function(){
				$.ajax({
					url:"/caterer/CaterOTP",
					data:"userName="+${userName},
					success:function(data){
						if(data==true){
							alert("Successfully validated");
						}else{
							alert("Please try again");
						}
					}
				})
			});
		});	
	</script>
</body>
</html>