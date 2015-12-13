<%@taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/fmt" prefix="fn"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<!-- === BEGIN HEADER === -->
<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>BookParty template - <decorator:title /></title>
<!-- Meta -->
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta name="description" content="">
<meta name="author" content="">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1" />
<!-- Favicon -->
<link href="favicon.ico" rel="shortcut icon">
<!-- Bootstrap Core CSS -->
<link rel="stylesheet" href="resources/css/bootstrap.css"
	rel="stylesheet">
<!-- Template CSS -->
<link rel="stylesheet" href="resources/css/animate.css" rel="stylesheet">
<link rel="stylesheet" href="resources/css/font-awesome.css"
	rel="stylesheet">
<link rel="stylesheet" href="resources/css/nexus.css" rel="stylesheet">
<link rel="stylesheet" href="resources/css/responsive.css"
	rel="stylesheet">
<link rel="stylesheet" href="resources/css/custom.css" rel="stylesheet">
<!-- Google Fonts
<link href="http://fonts.googleapis.com/css?family=Roboto:400,300"
	rel="stylesheet" type="text/css">
<link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300"
	rel="stylesheet" type="text/css">
	-->
</head>
<body>
	<div id="pre_header" class="container">
		<div class="row margin-top-10 visible-lg">
			<div class="col-md-6">
				<p>
					<strong>Phone:</strong>&nbsp;1-800-123-4567
				</p>
			</div>
			<div class="col-md-6 text-right">
				<p>
					<strong>Email:</strong>info@example.com
				</p>
			</div>
		</div>
	</div>

	<div class="primary-container-group">
		<!-- Background -->
		<div class="primary-container-background">
			<div class="primary-container"></div>
			<div class="clearfix"></div>
		</div>
		<!--End Background -->
		<div class="primary-container">
			<div id="header" class="container">
				<div class="row">
					<!-- Logo -->
					<div class="logo">
						<a href="index.html" title=""> <img
							src="resources/images/logo.png" alt="Logo" />
						</a>
					</div>
					<!-- End Logo -->
					<ul class="social-icons pull-right hidden-xs">
						<li class="social-rss"><a href="#" target="_blank"
							title="RSS"></a></li>
						<li class="social-twitter"><a href="#" target="_blank"
							title="Twitter"></a></li>
						<li class="social-facebook"><a href="#" target="_blank"
							title="Facebook"></a></li>
						<li class="social-googleplus"><a href="#" target="_blank"
							title="GooglePlus"></a></li>
					</ul>
				</div>
			</div>
			<!-- Top Menu -->
			<div id="hornav" class="container no-padding">
				<div class="row">
					<div class="col-md-12 no-padding">
						<div class="pull-right visible-lg">
							<ul id="hornavmenu" class="nav navbar-nav">
								<li><a href="index.html" class="fa-home">Home</a></li>
								<li><span class="fa-gears">Features</span>
									<ul>
										<li class="parent"><span>Typography</span>
											<ul>
												<li><a href="features-typo-basic.html">Basic
														Typography</a></li>
												<li><a href="features-typo-blockquotes.html">Blockquotes</a>
												</li>
											</ul></li>
										<li class="parent"><span>Components</span>
											<ul>
												<li><a href="features-labels.html">Labels</a></li>
												<li><a href="features-progress-bars.html">Progress
														Bars</a></li>
												<li><a href="features-panels.html">Panels</a></li>
												<li><a href="features-pagination.html">Pagination</a></li>
											</ul></li>
										<li class="parent"><span>Icons</span>
											<ul>
												<li><a href="features-icons.html">Icons General</a></li>
												<li><a href="features-icons-social.html">Social
														Icons</a></li>
												<li><a href="features-icons-font-awesome.html">Font
														Awesome</a></li>
												<li><a href="features-icons-glyphicons.html">Glyphicons</a>
												</li>
											</ul></li>
										<li><a href="features-testimonials.html">Testimonials</a>
										</li>
										<li><a href="features-accordions-tabs.html">Accordions
												& Tabs</a></li>
										<li><a href="features-buttons.html">Buttons</a></li>
										<li><a href="features-carousels.html">Carousels</a></li>
										<li><a href="features-grid.html">Grid System</a></li>
										<li><a href="features-animate-on-scroll.html">Animate
												On Scroll</a></li>
									</ul></li>
								<li><span class="fa-copy">Pages</span>
									<ul>
										<li><a href="pages-about-us.html">About Us</a></li>
										<li><a href="pages-services.html">Services</a></li>
										<li><a href="pages-faq.html">F.A.Q.</a></li>
										<li><a href="pages-about-me.html">About Me</a></li>
										<li><a href="pages-full-width.html">Full Width</a></li>
										<li><a href="pages-left-sidebar.html">Left Sidebar</a></li>
										<li><a href="pages-right-sidebar.html">Right Sidebar</a>
										</li>
										<li><a href="pages-login.html">Login</a></li>
										<li><a href="pages-sign-up.html">Sign-Up</a></li>
										<li><a href="pages-404.html">404 Error Page</a></li>
									</ul></li>
								<li><span class="fa-th">Portfolio</span>
									<ul>
										<li><a href="portfolio-2-column.html">2 Column</a></li>
										<li><a href="portfolio-3-column.html">3 Column</a></li>
										<li><a href="portfolio-4-column.html">4 Column</a></li>
										<li><a href="portfolio-6-column.html">6 Column</a></li>
									</ul></li>
								<li><span class="fa-font">Blog</span>
									<ul>
										<li><a href="blog-list.html">Blog</a></li>
										<li><a href="blog-single.html">Blog Single Item</a></li>
									</ul></li>
								<li><a href="contact.html" class="fa-comment">Contact</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
			<!-- End Top Menu -->
			<!-- === END HEADER === -->
			<!-- === BEGIN CONTENT === -->
			<div id="content">
				<div class="container">
					<div class="row margin-vert-30">
						<div class="col-md-12 margin-top-30">
							<pre>
								
	<decorator:body />
							</pre>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- Footer Menu -->
	<div id="footer">
		<div class="container">
			<div class="row">
				<div id="copyright" class="col-md-4">
					<p>(c) 2014 Your Copyright Info</p>
				</div>
				<div id="footermenu" class="col-md-8">
					<ul class="list-unstyled list-inline pull-right">
						<li><a href="#" target="_blank">Sample Link</a></li>
						<li><a href="#" target="_blank">Sample Link</a></li>
						<li><a href="#" target="_blank">Sample Link</a></li>
						<li><a href="#" target="_blank">Sample Link</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<!-- End Footer Menu -->
</body>
</html>