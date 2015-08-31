<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script type="text/javascript" src="<c:url value="/resources/js/jqueryUI/jquery-1.11.3.js"></c:url>	"></script>
<link rel="stylesheet" href="<c:url value="/resources/dist/css/bootstrap.min.css"/>"/>
<link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>"/>
<script type="text/javascript" src="/resources/dist/js/bootstrap.min.js"></script>
<style type="text/css">
</style>
<script type="text/javascript">

var prefix='/UsePropertiesFile';

	var getAllBook = function(){
		$.ajax({
			type: "GET",
			url: prefix + '/getAllBook',
			dataType: 'json',
			contentType: 'application/json',
			success : function(result){
				alert('Get Result'+result);
			},
			error: function(jqXHR, textStatus, errorThrown){
				alert('alert form error'+jqXHR.status + ' ' + jqXHR.responseText);
			}
		});
	};
	
	var madedeleteCall = function(bid) {
		alert("Do you want to delete the book");
		$.ajax({
			type : "DELETE",
			url : '/UsePropertiesFile' + '/delete/' + bid,
			dataType: 'json',
			async: true,
			success: function(result) {
	            alert(result);
	        },
	        error: function(jqXHR, textStatus, errorThrown) {
	            alert(jqXHR.status + ' ' + jqXHR.responseText);
	        }
		});
	};
	

	var saveData = function(bid) {
		$.ajax({
	        type: 'POST',
	        url:  prefix + '/saveData',
	        data: 'bid='+bid+'&bname='+$('#bookname'+bid).val()+'&isbn='+$('#bookisbn'+bid).val()+'&price='+$('#bookprice'+bid).val()+'&author='+$('#bookauthor'+bid).val(),
	        async: true,
	        success: function (data) {
	        	if(bid!=0){
	        		$('#showbname'+bid).html(data.bname);
		        	$('#showisbn'+bid).html(data.isbn);
		        	$('#showprice'+bid).html(data.price);
		        	$('#showauthor'+bid).html(data.author);
	        	}else{
	        		
	        	}
	        	
	          },
	        error: function(jqXHR, textStatus, errorThrown) {
	            alert(jqXHR.status + ' ' + jqXHR.responseText);
	        }
	    });
		getAllBook();
		$('.editbutton').show();
		$('.deletebuttton').show();
		$('#savebutton'+bid).hide();
		$('.showbook'+bid).show();
		$('.book'+bid).hide();
		
	};
	
	var EditData = function(bid){
		$('.showbook'+bid).hide();
		$('.book'+bid).show();
		$('.editbutton').hide();
		$('#savebutton'+bid).show();
		$('.deletebuttton').hide();
	};
	
	var addNewData = function(){
		var input1 = '<input type="text" id="bookname'+0+'" size="10" placeholder="Book Name">';
		var input2 = '<input type="text" id="bookisbn'+0+'" size="10" placeholder="ISBN">';
		var input3 = '<input type="text" id="bookprice'+0+'" size="10" placeholder="Price">';
		var input4 = '<input type="text" id="bookauthor'+0+'" size="10" placeholder="Author">';
		var save ='<button onclick="saveData('+0+')" style="background-color: #3CB371;"><span class="glyphicon glyphicon-save">Save</span></button>';
		$('#bookTable tr:last').after('<tr><td>'+input1+'</td><td>'+input2+'</td><td>'+input3+'</td><td>'+input4+'</td><td>'+save+'</td></tr>');
		
	};
	
	

</script>
<style type="text/css">
	
</style>
</head>
<body>

	<nav>
		<nav class="navbar navbar-inverse">
			<div class="container-fluid">
				<div class="navbar-header">
					<a class="navbar-brand" href="#">Simple SpringMVC Practice</a>
				</div>
				<div>
					<ul class="nav navbar-nav navbar-right">
        <li class="dropdown">
		<a class="dropdown-toggle" data-toggle="dropdown" href="#"><span class="glyphicon glyphicon-user"></span> ${customer.uname}<span class="caret"></span></a>
			<ul class="dropdown-menu">
            <li><a href="#">profile</a></li>
            <li><a href="#">Account</a></li>
            <li><a href="#">LogOut</a></li>
          </ul>
		</li>
      </ul>			
				</div>

			</div>
		</nav>
	</nav>


	<div class="container">

		<div class="row">
			<div class="col-md-6">
				<div id="result"></div>
				<div id="editValue"></div>
				<h2>AddNew Book</h2>
				
				
				
			</div>
			<div class="col-md-6">
				<h2>Book List</h2>
				<table class="table" id="bookTable">
					<tr>
						<th>Book Name</th>
						<th>ISBN</th>
						<th>Price</th>
						<th>Author</th>
						<th>Update</th>
					</tr>
					<c:forEach items="${books}" var="book">
						<tr>
							<td>
							<p class="showbook${book.bid}" id="showbname${book.bid}" >${book.bname}</p>
							<input type="text"  value="${book.bname}" class="book${book.bid}" id="bookname${book.bid}" hidden="true" size="10"></td>
							
							<td>
							<p class="showbook${book.bid}" id="showisbn${book.bid}">${book.isbn}</p>
							<input type="text" value="${book.isbn}" class="book${book.bid}" id="bookisbn${book.bid}" hidden="true" size="10"></td>
								
							<td>
							<p class="showbook${book.bid}" id="showprice${book.bid}">${book.price}</p>
							<input type="text" value="${book.price}" class="book${book.bid}" id="bookprice${book.bid}" hidden="true" size="10"></td>
							
							<td>
							<p class="showbook${book.bid}" id="showauthor${book.bid}">${book.author}</p>
							<input type="text" value="${book.author}" class="book${book.bid}" id="bookauthor${book.bid}" hidden="true" size="10"></td>
							<td>
			
								
										<button class="editbutton" onclick="EditData('${book.bid}')" style="background-color: #87CEFA;"><span class="glyphicon glyphicon-edit">Edit</span></button>
										<button class="deletebuttton" onclick="madedeleteCall('${book.bid}')" style="background-color: #F08080;"><span class="glyphicon glyphicon-trash">Delete</span></button>
										<button id="savebutton${book.bid}" onclick="saveData('${book.bid}')" hidden="true" style="background-color: #3CB371;"><span class="glyphicon glyphicon-save">Save</span></button>
									

							
							<%-- 	 <div class="row">
								 	<div class="col-xs-4">
								 	<button class="editbutton" onclick="EditData('${book.bid}')" style="background-color: #87CEFA;"><span class="glyphicon glyphicon-edit">Edit</span></button>
								 	</div>
								 	<div class="col-xs-4">
								 		<button id="savebutton${book.bid}" onclick="saveData('${book.bid}')" hidden="true" style="background-color: #3CB371;"><span class="glyphicon glyphicon-save">Save</span></button>
								 	</div>
								 	<div class="col-xs-4">
								 		<button class="deletebuttton" onclick="madedeleteCall('${book.bid}')" style="background-color: #F08080;"><span class="glyphicon glyphicon-trash">Delete</span></button>
								 	</div>
 --%>										
	 
							</td>
						</tr>
					</c:forEach>
				</table>
				<div class="row">
					<button id="addNew" onclick="addNewData()">Add New</button>
				</div>

			</div>
		</div>
	</div>

</body>
</html>