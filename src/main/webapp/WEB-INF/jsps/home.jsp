<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>Spring Boot with Angularjs Example</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1" />

<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css" />
<!-- <link rel="stylesheet" href="/resources/static/css/lib/bootstrap.css"> -->

<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.6.0/angular.min.js"></script>
<!-- <script type="text/javascript" src="resources/static/js/lib/angular.js"></script> -->
<script type="text/javascript" src="static/js/app/app.js"></script>

</head>
<body>
	<div class="container" ng-app ="app">
	<%-- 
		<div class="row">
	        <h1>Create an Office</h1>
	            <div ng-controller="postOfficeController" class="col-md-3">
	                <form name="officeForm" ng-submit="createOffice()">
	                    <label> Office Location:</label>
	                    <input type="text" name="offLocation"   class="form-control" ng-model="offLocation" required/>
	                    <button type="submit" class="btn btn-primary">Create</button>
	                </form>
	                <p>{{postOfficeCreateMessage}}</p>
	            </div>
	        </div>
		--%>
		<div class="row">
		<h1>Create a Project and Assign to Office </h1>
			<div ng-controller="postProjectController" class="col-md-3">
				<form name="projectForm" ng-submit="submitForm()">
					
					<label>Project Name:</label>
					<input type="text" name="projectname"	class="form-control" ng-model="projectname" required/>
					<br>
					<label>Project Description:</label>
					<input type="text" name="projectdesc" class="form-control" ng-model="projectdesc" required/>
					<br>
					<label>Office Location1:</label>
                    <input type="text" name="loc1" class="form-control" ng-model="loc1"/>
                    <br>
                    <label>Office Location2:</label>
                    <input type="text" name="loc2" class="form-control" ng-model="loc2" />
					
					<button type="submit" class="btn btn-primary">Submit</button>
					
				</form>
				<p>{{postResultMessage}}</p>
			</div>
		</div>
		
		
		
		   
		
		<div class="row">
		
			<div ng-controller="getallProjectsController" class="col-md-3">
				<h3>All Projects with Locations</h3>

				<button ng-click="getAllProjects()">Get All Projects with Locations</button>

				<div ng-show="showAllProjects">
					<ul class="list-group">
						<li ng-repeat="proj in allProjects.data">
						        <h4 class="list-group-item">
								<strong>Project {{$index}}</strong><br />
								Project Id: {{proj.projectId}}<br />
								Project Name: {{proj.projectName}}<br />
								Locations:<ul><li ng-repeat="office in proj.locations">{{office.officeLocation}}</li></ul>
						</h4></li>
					</ul>
				</div>
				<p>{{getResultMessage}}</p>
			</div>
			
			
			
			

			<div ng-controller="getcustomerController" class="col-md-3">
				<h3>Find Project by ID</h3>

				<input type="text" class="form-control" style="width: 100px;"
					ng-model="customerId" /> <br />
				<button ng-click="getCustomer()">Get Project</button>

				<div ng-show="showCustomer">
					Id: {{customer.data.id}}<br />
					First Name: {{customer.data.firstName}}<br />
					Last Name: {{customer.data.lastName}}
				</div>
				<p>{{getResultMessage}}</p>
			</div>
			
			
			

			<div ng-controller="getcustomersbylastnameController" class="col-md-4">
				<h3>Find Project by Location</h3>

				<input type="text" class="form-control" style="width: 100px;" ng-model="customerLastName" /><br />
				<button ng-click="getCustomersByLastName()">Get Project by Location</button>

				<div ng-show="showCustomersByLastName">

					<ul class="list-group">
						<li ng-repeat="customer in allcustomersbylastname.data"><h4	class="list-group-item">
								<strong>Customer {{$index}}</strong><br />
								Id: {{customer.id}}<br />
								First Name: {{customer.firstName}}<br />
								Last Name: {{customer.lastName}}
						</h4></li>
					</ul>
				</div>
				<p>{{getResultMessage}}</p>
			</div>

		</div>
	</div>
</body>
</html>