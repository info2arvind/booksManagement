<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script type="text/javascript" src="<c:url value="/resources/js/jqueryUI/jquery-1.11.3.js"></c:url>	"></script>
<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/>">
<link rel="stylesheet" href="<c:url value="/resources/dist/css/bootstrap.min.css"/>"/> 

<style type="text/css"> 
.error {
	color: red;
}

.errorblock {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
</style>
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
			<div class="col-md-4"></div>
			<div class="col-md-8">
				<h1>Registration Form</h1>
				<form:form commandName="customer" method="post" cssClass="form-horizontal">

					<%-- <form:errors path="*" cssClass="errorblock" element="div" /> --%>
					
					<div class="form-group">
					<label class="control-label col-sm-3" for="uname">UserName:</label>
					<div class="col-sm-9">
						<form:input path="uname" cssClass="form-control"
							placeholder="Enter UserName" />
						<form:errors path="uname" cssClass="control-label" style="color:red;" />
					</div>
					
					</div>
					
					<div class="form-group">
					<label class="control-label col-sm-3" for="fullName">FullName
						::</label>
					<div class="col-sm-9">

						<form:input path="fullName" cssClass="form-control"
							placeholder="Enter FullName" />
						<form:errors path="fullName" cssClass="control-label" style="color:red;"/>
					</div></div>
					
					
					<div class="form-group">
					<label class="control-label col-sm-3" for="pword">Password:</label>
					<div class="col-sm-9">

						<form:input path="pword" cssClass="form-control"
							placeholder="Enter password" />
						<form:errors path="pword" cssClass="control-label" style="color:red;" />
					</div></div>
					
					<div class="form-group">
					<label class="control-label col-sm-3" for="confPword">Confirm
						Password:</label>
					<div class="col-sm-9">

						<form:input path="confPword" cssClass="form-control" />
						<form:errors path="confPword" cssClass="control-label" style="color:red;" />
					</div></div>
					
					<div class="form-group">
					<label class="control-label col-sm-3" for="mobileNum">Mobile
						Number :</label>
					<div class="col-sm-9">

						<form:input path="mobileNum" cssClass="form-control" />
						<form:errors path="mobileNum" cssClass="control-label" style="color:red;" />
					</div></div>
					
					<div class="form-group">
					<label class="control-label col-sm-3" for="favnumber">Choose
						Fav Number :</label>
					<div class="col-sm-9">
					  
						<form:radiobuttons path="favnumber" items="${numberList}"
							element="label class='radio-inline'" />
						<form:errors path="favnumber" cssClass="control-label" style="color:red;" />
					</div></div>
					
					<div class="form-group">
					<label class="control-label col-sm-3" for="gender">Gender :</label>
					<div class="col-sm-9">

						<form:radiobutton path="gender" value="m" />
						Male
						<form:radiobutton path="gender" value="f" />
						Female
						<form:errors path="gender" cssClass="error" style="color:red;" />
					</div></div>
					
					
					<div class="form-group"> 
    						<div class="col-sm-offset-3 col-sm-9">
     							 <div class="checkbox">
       								 <label><form:checkbox path="recvNewLetter"
								cssClass="control-label" /> Receive New Letter</label>
      							</div>
    						</div>
  					</div>
					
					<div class="form-group">
					<label class="control-label col-sm-3" for="address">Address
						:</label>
					<div class="col-sm-9">

						<form:textarea path="address" cssClass="form-control" />
						<form:errors path="address" cssClass="control-labels" style="color:red;" />
					</div></div>
					
					<div class="form-group">
					<label class="control-label col-sm-3" for="country">Country :</label>
					<div class="col-sm-9">

						<form:select path="country" cssClass="form-control">
							<form:option value="NONE" label="--- Select ---" />
							<form:options items="${countryList}" />
						</form:select>
						<form:errors path="country" cssClass="control-label" style="color:red;" />
					</div></div>
					
					<div class="form-group">
					<label class="control-label col-sm-3" for="webFramework">Framework :</label>
					<div class="col-sm-9">
					<form:checkboxes path="webFramework" items="${webFramework}" element="label class='checkbox-inline'" />
					<br />
					<form:errors path="webFramework" class="control-label" style="color:red;" />
					</div></div>
					
					 <div class="form-group"> 
    					<div class="col-sm-offset-2 col-sm-10">
     						 <input type="submit" value="register" class="btn btn-success" />
    					</div>
 					 </div>
					
					
				</form:form>
			</div>
		</div>
	</div>

	<%-- <h1>Registration Form</h1>
	<form:form commandName="customer" method="post">
	
	<form:errors path="*" cssClass="errorblock" element="div" />
		<table>
			<tr>
				<td>UserName :</td>
				<td><form:input path="uname" id="uname" /></td>
				<td><form:errors path="uname" cssClass="error"/> </td>
			</tr>
			<tr>
				<td>FullName :</td>
				<td><form:input path="fullName" id="fullName"/> </td>
				<td><form:errors path="fullName" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Password :</td>
				<td><form:password path="pword" id="pword" /></td>
				<td><form:errors path="pword" cssClass="error" /></td>
			</tr>
			
			<tr>
				<td>Confirm Password :</td>
				<td><form:password path="confPword" id="confPword" /></td>
				<td><form:errors path="confPword" cssClass="error" /></td>
			</tr>
			
			<tr>
				<td>Mobile Number :</td>
				<td><form:input path="mobileNum" id="mobileNum"/> </td>
				<td><form:errors path="mobileNum" cssClass="error" /></td>
			</tr>
			
			<tr>
				<td>Choose Fav Number :</td>
				<td><form:radiobuttons path="favnumber" items="${numberList}" id="favnumber" /></td>
				<td><form:errors path="favnumber" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Gender :</td>
				<td><form:radiobutton path="gender" id="genderMale" value="m" />Male
					<form:radiobutton path="gender" id="genderFeMale" value="f" />Female
				</td>
				<td><form:errors path="gender" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Receive New Letter :</td>
				<td><form:checkbox path="recvNewLetter" id="recvNewLetter"/> </td>
			</tr>
			
			<tr>
				<td>Address :</td>
				<td><form:textarea path="address" id="address" /></td>
				<td><form:errors path="address" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Country :</td>
				<td><form:select path="country" id="country">
					<form:option value="NONE" label="--- Select ---" />
					<form:options items="${countryList}"/>
				</form:select>
				</td>
				<td><form:errors path="country" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Framework :</td>
				<td><form:checkboxes items="${webFramework}" path="webFramework" id="webFramework"/>
				</td>
				<td><form:errors path="webFramework" cssClass="error" /></td>
			</tr>
			
			<tr>
				<td><input type="submit" value="register"/></td>
			</tr>
			
			
		</table>
	</form:form> --%>
</body>
</html>