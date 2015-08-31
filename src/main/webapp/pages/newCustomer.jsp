<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SpringMVC</title>
<script type="text/javascript" src="<c:url value="/resources/js/jqueryUI/jquery-1.11.3.js"></c:url>	"></script>
<link rel="stylesheet" href="<c:url value="/resources/dist/css/bootstrap.min.css"/>"/>
<script type="text/javascript" src="<c:url value="/resources/dist/js/bootstrap.min.js"></c:url>	"></script>
</head>
<body>
	<nav>
		<nav class="navbar navbar-inverse">
			<div class="container-fluid">
				<div class="navbar-header">
					<a class="navbar-brand" href="#">Simple SpringMVC Practice</a>
				</div>
			</div>
		</nav>
	</nav>

	<div class="container">
		<div class="row">
			<div class="col-md-4">
				<h2>Login Form</h2>
				<form:form commandName="customer" method="post">
					<div class="form-group">
						<label for="uname">UserName:</label>
						<form:input path="uname" cssClass="form-control" />
					</div>
					<div class="form-group">
						<label for="pword">Password:</label>
						<form:input path="pword" cssClass="form-control" />
					</div>
					<input type="submit" class="btn btn-success" value="Login">
				</form:form>
				<a href="register.htm">new user register here</a>

			</div>
			<div class="col-md-8">
				<h2>List of Books</h2>
				<p>One cool feature of the ThemeRoller is that you can select a
					theme from the gallery and then customize it to your liking using
					the roll your own tab. Just select the "Gallery" tab and find the
					theme you like; then go to the "Roll Your Own" tab and make your
					tweaks. As you make changes on the "Roll Your Own" page, you will
					see those changes reflected by the various widgets and animations
					on the right side. This makes it easy to make changes and see what
					those will look like with the various jQuery widgets. Once you have
					a theme you like, you can download that theme to your computer.
					When you click the download button, you will be taken to a page
					where you can either download the entire jQuery library or pick and
					choose your items. This makes it very easy to get the smallest
					download you can.</p>
			</div>
		</div>

	</div>

</body>
</html>