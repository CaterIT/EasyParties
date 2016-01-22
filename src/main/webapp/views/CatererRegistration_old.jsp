<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Cater Page</title>
<link href="resources/css/style.css" rel="stylesheet" />
</head>
<body>
<div id="header" align="center">
<h1><a href="" ><img src="resources/images/logo.png" alt="Buk Party Website" align="left"></a>BukParty.com</h1>
</div>

<form class="webdesigntuts-workshop"  action="" method="" text-align="center">		    
<input type="search" placeholder="Search...">		    	
<button>Search</button>
</form>
<script src="resources/js/prefixfree.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>

<br>
<section>
<input type="radio" id="profile" value="1" name="tractor" checked='checked' />    
<input type="radio" id="settings" value="2" name="tractor" />      
<input type="radio" id="posts" value="3" name="tractor" />
<input type="radio" id="books" value="4" name="tractor" />

<nav>   
<label for="profile" class='fontawesome-camera-retro'></label>
<label for="settings" class='fontawesome-film'></label>
<label for="posts" class='fontawesome-calendar'></label>
<label for="books" class='fontawesome-list-alt'></label>
</nav>

<article class='uno'>
<h2>
<img alt='Cater Image'  src='resources/images/logo.png' />
<%String caterName = request.getParameter("id");
out.println("");
%> "Introduction"

<span id="Description"> Introduction</span></h2>
<script type="text/javascript">
$(document).ready(function(){
	var xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
	    if (xhttp.readyState == 4 && xhttp.status == 200) {
	    	var data = xhttp.responseText;
	    	var jsonData = JSON.parse(data);
	    document.getElementById("Description").innerHTML = jsonData.data; 
	    }
	  };
	  xhttp.open("POST", "${pageContext.request.contextPath}"+"/getCaterDescription/?q=<% out.print(caterName); %>", true);
	  xhttp.send();
});

</script>
<footer>
<ul>
<li class='fontawesome-link'></li>
<li class='fontawesome-paper-clip'></li>
<li class='fontawesome-sitemap'></li>
<li class='fontawesome-wrench'></li>
<li class='fontawesome-magic'></li>
</ul>
</footer>
</article>

<article class='dos fontawesome-wrench' id="Introduction">
<p>Introduction about the cater</p>

</article>

<article class='tres fontawesome-file-alt'>
<ol>
<li>Paw Bhaji</li>
<li>Chole</li>
<li>Lassi</li>
<li>Rabri</li>
<li>Matar Paneer</li>
<li>Puri</li>
</ol>
</article>

<article class='cuatro fontawesome-copy'>
<dl>
<dt>Customer 1</dt>
<dd>It is an awesome cater.</dd>
<dt>Customer 2</dt>
<dd>Serving is perfect.</dd>
</dl>
</article>
</section>
</body>
</html>
</jsp>