<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page isELIgnored="false" %>
<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">

<title>Complex Form</title>
</head>
<body class="" style="background: #e2e2e2">
	<div class="container mt-4">
		<div class="row">
			<div class="col-md-8 offset-md-2">
				<div class="card">
					<div class="card-body">
						<h3 class="text-center">${title }</h3>
						<form action="processRegistration" method="post">
							<div class="mb-3">
								<label for="exampleInputEmail1" class="form-label">Your
									Name</label> <input type="text" class="form-control"
									placeholder="Enter First name" name="firstname" />
							</div>

							<div class="mb-3">
								<label for="exampleInputEmail1" class="form-label">Your
									Name</label> <input type="text" class="form-control"
									placeholder="Enter Last name" name="lastname" />
							</div>

							<div class="mb-3">
								<label for="exampleInputEmail1" class="form-label">Email
									address</label> <input type="email" class="form-control"
									id="email" name="email" aria-describedby="emailHelp">
								
							</div>

							<div class="mb-3">
								<label for="exampleInputPassword1" class="form-label">Password</label>
								<input type="password" class="form-control"
									id="password" name="password">
							</div>

							<div class="mb-3">
								<label for="exampleInputPassword1" class="form-label">Your
									DOB</label>
									 <input type="text" class="form-control"
									id="exampleInputPassword1" name="date" placeholder="dd/mm/yyyy">
							</div>


							<div class="mb-3">
								<label for="exampleInputEmail1" class="form-label">Your
									Address</label> <input type="text" class="form-control"
									placeholder="Enter Your Address" name="address" />
							</div>

							<div class="mb-3">
								<label for="exampleInputEmail1" class="form-label">Your
									City</label> <input type="text" class="form-control"
									placeholder="Enter Your City" name="city" />
							</div>



							<div class="container text-center">
								<button type="submit" class="btn btn-primary">Submit</button>
							</div>




						</form>


					</div>



				</div>

			</div>

		</div>

	</div>


	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>
</body>
</html>