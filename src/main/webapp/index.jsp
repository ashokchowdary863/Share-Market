<!DOCTYPE html>
<html lang="en" ng-app="angularTable">
<meta name="google-signin-client_id"
	content="542143104500-iu0roqkie8j7f8k0k9mmdlut34abpgoj.apps.googleusercontent.com">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Share Broking System</title>

<!-- Bootstrap core CSS -->
<link href="frontpage_assets/bootstrap.min.css" rel="stylesheet">
<link href="frontpage_assets/login.css" rel="stylesheet">

<link
	href="frontpage_assets/assets/css/ie10-viewport-bug-workaround.css"
	rel="stylesheet">

<link href="frontpage_assets/justified-nav.css" rel="stylesheet">

<script src="frontpage_assets/ie-emulation-modes-warning.js"></script>

</head>

<body>

	<div class="container">
		<div class="panel-body">
			<h3 class="text-muted">Share Broking System</h3>
			<br> <br>
			<!-- Nav tabs -->
			<ul class="nav nav-justified">
				<li class="active"><a href="#home" data-toggle="tab"
					aria-expanded="true">Home</a></li>
				<li><a href="#about" data-toggle="tab">About</a></li>
				<li><a href="#companies" data-toggle="tab">Companies</a></li>
				<li><a href="#login" data-toggle="tab">Login</a></li>
				<li><a href="#register" data-toggle="tab">Register</a>
				<li><a href="#contactus" data-toggle="tab">Contact Us</a></li>
			</ul>

			<!-- Tab panes -->
			<div class="tab-content">
				<div class="tab-pane fade  active in" id="home">
					<div class="jumbotron">
						<h1>Want to spend money in a profitable business.</h1>
						<p class="lead">Then why to waste time and money.Buy shares of
							multinational companies and be cool.</p>
						<p>
							<a class="btn btn-lg btn-success" href="#register"
								data-toggle="tab" role="button">Get started today</a>
						</p>

					</div>
				</div>



				<div class="tab-pane fade" id="about">
					<div class="col-lg-12">
						<h1 class="page-header">
							About Us <small>It's Nice to Meet You!</small>
						</h1>
						<p>
							<i>Don't just do something because it's a trendy idea and
								will make you a lot of money. The reason I say that is because
								any kind of venture involves going through difficult times. If
								you're doing something you are passionate about and really
								believe in, then that will carry you through,"</i> said American
							businessman -<b>Jerry Greenfield.</b><br> For a financial
							portal born in late 1999, just when bursting of the dotcom bubble
							was about to nearly bring down both financial markets and the
							fledgling worldwide web, we couldn't have chosen a more difficult
							time to launch. But it was really passion and belief that saw us
							through. A single-minded passion to become the country's greatest
							resource for financial information on the Internet. And the
							belief, that through it, we would be able to make a difference to
							people's financial lives.
						</p>
					</div>

				</div>




				<div class="tab-pane fade" id="companies">
					<div role="main" class="container theme-showcase">

						<div class="col-lg-12">
							<div class="page-header">
								<h2 id="tables">Registered Companies</h2>
							</div>
							<div class="bs-component" ng-controller="listdata">


								<center>
									<form class="form-inline">
										<div class="form-group">
											<label>Search</label> <input type="text" ng-model="search"
												class="form-control" placeholder="Search">
										</div>
									</form>
								</center>
								<table class="table table-bordered table-hover">
									<thead>
										<tr>
											<th ng-click="sort('companyName')">Comapny Name <span
												class="glyphicon sort-icon" ng-show="sortKey=='companyName'"
												ng-class="{'glyphicon-chevron-up':reverse,'glyphicon-chevron-down':!reverse}"></span>
											</th>
											<th ng-click="sort('companyOwner')">Company Owner <span
												class="glyphicon sort-icon"
												ng-show="sortKey=='companyOwner'"
												ng-class="{'glyphicon-chevron-up':reverse,'glyphicon-chevron-down':!reverse}"></span>
											</th>
											<th ng-click="sort('companyDescription')">Company
												Description <span class="glyphicon sort-icon"
												ng-show="sortKey=='companyDescription'"
												ng-class="{'glyphicon-chevron-up':reverse,'glyphicon-chevron-down':!reverse}"></span>
											</th>
											<th ng-click="sort('growth')">Growth <span
												class="glyphicon sort-icon" ng-show="sortKey=='growth'"
												ng-class="{'glyphicon-chevron-up':reverse,'glyphicon-chevron-down':!reverse}"></span>
											</th>
											<th ng-click="sort('registeredDate')">Registered Date <span
												class="glyphicon sort-icon"
												ng-show="sortKey=='registeredDate'"
												ng-class="{'glyphicon-chevron-up':reverse,'glyphicon-chevron-down':!reverse}"></span>
											</th>

										</tr>
									</thead>
									<tbody>
										<tr
											dir-paginate="company in companies|orderBy:sortKey:reverse|filter:search|itemsPerPage:10"
											pagination-id="beforeLogin">
											<td>{{company.companyName}}</td>
											<td>{{company.companyOwner}}</td>
											<td>{{company.companyDescription}}</td>
											<td>{{company.growth}}</td>
											<td>{{company.registeredDate}}</td>
										</tr>
									</tbody>
								</table>
								<center>
									<dir-pagination-controls pagination-id="beforeLogin">
									</dir-pagination-controls>
							</div>
							</center>
							<small>Growth values indicates growth of the company when
								compared to previous year.</small><span>Data: {{ companies.sid }}
							</span>
						</div>
					</div>
					<script src="app/angular.js"></script>
					<script src="app/dirPagination.js"></script>
					<script src="app/app.js"></script>
				</div>



				<div class="tab-pane fade" id="login">


					<div class="row">
						<div class="col-xs-12">
							<div class="form-wrap">
								<h1>Login Page:Share Broking System</h1>
								<form role="form" id="login-form" autocomplete="off">
									<div class="form-group">
										<label for="email" class="sr-only">Email</label> <input
											type="text" name="username" id="username"
											class="form-control" placeholder="Ex:hakit001" required>
									</div>
									<div class="form-group">
										<label for="key" class="sr-only">Password</label> <input
											type="password" name="password" id="password"
											class="form-control" placeholder="Password" required>
									</div>
									<div class="checkbox">
										<span class="character-checkbox" onclick="showPassword()"></span>
										<span class="label">Show password</span>
									</div>
									<input type="submit" id="btn-login"
										class="btn btn-custom btn-lg btn-block" value="Log in">
								</form>

								Sign Up with google:
								<div class="g-signin2" data-onsuccess="onSignIn"></div>
								<a href="#" onclick="signOut();" id="signout">Sign out</a> <a
									href="javascript:;" class="forget" data-toggle="modal"
									data-target=".forget-modal">Forgot your password?</a>
								<hr>
							</div>
						</div>
					</div>



					<div class="modal fade forget-modal" tabindex="-1" role="dialog"
						aria-labelledby="myForgetModalLabel" aria-hidden="true">
						<div class="modal-dialog modal-sm">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal">
										<span aria-hidden="true">×</span> <span class="sr-only">Close</span>
									</button>
									<h4 class="modal-title">Forgot password</h4>
								</div>
								<div class="modal-body">
									<p>Type your email account</p>
									<input type="email" name="recovery-email" id="recovery-email"
										class="form-control">
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-danger"
										data-dismiss="modal">Cancel</button>
									<button type="button" class="btn btn-success"
										id="forgot-password">Recovery</button>
								</div>
							</div>
							<!-- /.modal-content -->
						</div>
						<!-- /.modal-dialog -->
					</div>
				</div>





				<div class="tab-pane fade" id="register">


					<br> <br>

					<div class="col-md-8 col-md-offset-2 well well-sm">
						<center>
							<h3>Registration Form</h3>
						</center>
						<form class="form-horizontal" id="RegistrationForm">

							<div class="form-group">
								<label for="inputEmail3" class="col-sm-2 control-label">User
									Name</label>
								<div class="col-sm-6">
									<input type="text" class="form-control" id="username"
										name="username" placeholder="Ex:ashokkumar863" required>
								</div>
							</div>
							<div class="form-group">
								<label for="inputPassword3" class="col-sm-2 control-label">First
									Name</label>
								<div class="col-sm-6">
									<input type="text" class="form-control" id="firstname"
										name="firstname" placeholder="Ex:Ashok Kumar" required>
								</div>
							</div>
							<div class="form-group">
								<label for="inputEmail3" class="col-sm-2 control-label">Last
									Name</label>
								<div class="col-sm-6">
									<input type="text" class="form-control" id="lastname"
										name="lastname" placeholder="Ex:Karasala" required>
								</div>
							</div>
							<div class="form-group">
								<label for="inputPassword3" class="col-sm-2 control-label">Password
								</label>
								<div class="col-sm-6">
									<input type="password" class="form-control" id="password"
										name="password" placeholder="">
								</div>
							</div>
							<div class="form-group">
								<label for="inputPassword3" class="col-sm-2 control-label">Email
									Address</label>
								<div class="col-sm-6">
									<input type="email" class="form-control" id="email"
										name="email" placeholder="Ex:ashokrj863@gmail.com">
								</div>
							</div>

							<div class="form-group">
								<label for="inputPassword3" class="col-sm-2 control-label">Mobile
									Number</label>
								<div class="col-sm-6">
									<input type="text" class="form-control" id="user_mobileno"
										name="user_mobileno" placeholder="Ex:994XXXXXXX" required>
								</div>
							</div>
							<div class="form-group">
								<label for="inputEmail3" class="col-sm-2 control-label">Bank
									Account Number </label>
								<div class="col-sm-6">
									<input type="text" class="form-control" id="accountno"
										name="accountno" placeholder="Ex:622303435883" required>
								</div>
							</div>
							<div class="form-group">
								<label for="inputPassword3" class="col-sm-2 control-label">PAN
									Number</label>
								<div class="col-sm-6">
									<input type="text" class="form-control" id="pan" name="pan"
										placeholder="Ex:EUPKXXXXXX" required>
								</div>
							</div>
							<div class="form-group">
								<label for="inputEmail3" class="col-sm-2 control-label">State
								</label>
								<div class="col-sm-6">
									<input type="text" class="form-control" id="state" name="state"
										placeholder="Ex:Andhra Pradesh" required>
								</div>
							</div>
							<div class="form-group">
								<label for="inputPassword3" class="col-sm-2 control-label">Country
								</label>
								<div class="col-sm-6">
									<input type="text" class="form-control" id="country"
										name="country" placeholder="Ex:India" required>
								</div>
							</div>





							<div class="form-group">
								<label for="inputEmail3" class="col-sm-2 control-label">ZipCode
								</label>
								<div class="col-sm-6">
									<input type="text" class="form-control" id="zipcode"
										name="zipcode" placeholder="Ex:5XXXXX" required>
								</div>
							</div>


							<div class="form-group">
								<div class="col-sm-offset-2 col-sm-10">
									<button type="submit" class="btn btn-success" id="regClick">Register</button>
								</div>
								<div id="regStatus"></div>
							</div>
						</form>
					</div>

				</div>



				<div class="tab-pane fade" id="contactus">
					<br>
					<div class="row">
						<div class="col-md-8 col-md-offset-2">
							<div class="well well-sm">
								<form class="form-horizontal" method="post">
									<fieldset>
										<legend class="text-center header">Contact us</legend>

										<div class="form-group">
											<span class="col-md-1 col-md-offset-2 text-center"><i
												class="fa fa-user bigicon"></i></span>
											<div class="col-md-8">
												<input id="fname" name="name" type="text"
													placeholder="First Name" class="form-control">
											</div>
										</div>
										<div class="form-group">
											<span class="col-md-1 col-md-offset-2 text-center"><i
												class="fa fa-user bigicon"></i></span>
											<div class="col-md-8">
												<input id="lname" name="name" type="text"
													placeholder="Last Name" class="form-control">
											</div>
										</div>

										<div class="form-group">
											<span class="col-md-1 col-md-offset-2 text-center"><i
												class="fa fa-envelope-o bigicon"></i></span>
											<div class="col-md-8">
												<input id="email" name="email" type="text"
													placeholder="Email Address" class="form-control">
											</div>
										</div>

										<div class="form-group">
											<span class="col-md-1 col-md-offset-2 text-center"><i
												class="fa fa-phone-square bigicon"></i></span>
											<div class="col-md-8">
												<input id="phone" name="phone" type="text"
													placeholder="Phone" class="form-control">
											</div>
										</div>

										<div class="form-group">
											<span class="col-md-1 col-md-offset-2 text-center"><i
												class="fa fa-pencil-square-o bigicon"></i></span>
											<div class="col-md-8">
												<textarea class="form-control" id="message" name="message"
													placeholder="Enter your massage for us here. We will get back to you within 2 business days."
													rows="7"></textarea>
											</div>
										</div>

										<div class="form-group">
											<div class="col-md-12 text-center">
												<button type="submit" class="btn btn-primary btn-lg">Submit</button>
											</div>
										</div>
									</fieldset>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<script src="bower_components/jquery/dist/jquery.min.js"></script>
		<script src="https://apis.google.com/js/platform.js" async defer></script>
		<script>
			$(document).ready(function() {
				$("#signout").hide();
			});
			function onSignIn(googleUser) {
				var id_token = googleUser.getAuthResponse().id_token;
				var profile = googleUser.getBasicProfile();
				console.log('ID: ' + profile.getId()); // Do not send to your backend! Use an ID token instead.
				console.log('Name: ' + profile.getName());
				console.log('Image URL: ' + profile.getImageUrl());
				console.log('Email: ' + profile.getEmail());
				$
						.ajax({
							type : "POST",
							data : JSON.stringify(),
							dataType : "json",
							url : "http://localhost:8080/shareweb/api/users/addgoogleuser/"
									+ id_token,
							contentType : "application/json",
							success : function(data, textStatus, jqXHR) {
								var loginData = {
									"userName" : data.customerUserName,
									"password" : "alacriti123"

								};
								if (data.role === "customer") {
									alert("Registered Successfully....\n UserName:"
											+ data.customerUserName
											+ "\nPassword : alacriti123 \nUpdate your information after Login");
									$
											.ajax({
												type : "POST",
												data : JSON
														.stringify(loginData),
												dataType : "json",
												url : "http://localhost:8080/shareweb/api/login",
												contentType : "application/json",
												success : function(data,
														textStatus, jqXHR) {
													console.log(data);
													if (data.userId != 0) {
														window.location = "Dashboard.jsp";
														sessionStorage.setItem(
																"userId",
																data.userId);
														sessionStorage.setItem(
																"userName",
																data.userName);
														sessionStorage.setItem(
																"userRole",
																data.role);
													} else {
														alert("Incorrect username or password");
													}
												}
											});
								} else if (data.role = "ee") {
									var loginData = {
										"userName" : data.customerUserName,
										"password" : data.customerPassword

									};

									$
											.ajax({
												type : "POST",
												data : JSON
														.stringify(loginData),
												dataType : "json",
												url : "http://localhost:8080/shareweb/api/login",
												contentType : "application/json",
												success : function(data,
														textStatus, jqXHR) {
													console.log(data);
													if (data.userId != 0) {
														alert("Logged in successfully");
														window.location = "Dashboard.jsp";
														sessionStorage.setItem(
																"userId",
																data.userId);
														sessionStorage.setItem(
																"userName",
																data.userName);
														sessionStorage.setItem(
																"userRole",
																data.role);
													} else {
														alert("Incorrect username or password");
													}
												}
											});

								} else {
									alert("Update Failed");
								}
							}
						});
				$("#signout").show();
				console.log("token:" + id_token);
			}

			function signOut() {
				$("#signout").hide();
				var auth2 = gapi.auth2.getAuthInstance();
				auth2.signOut().then(function() {
					console.log('User signed out.');
				});
			}
		</script>

		<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
		<script src="bower_components/jquery/dist/jquery.min.js"></script>
		<script src="https://apis.google.com/js/platform.js" async defer></script>
		<script src="frontpage_assets/ie10-viewport-bug-workaround.js"></script>
		<script src="frontpage_assets/login.js"></script>
		<script src="app/forgot.js"></script>

		<script src="js/registration.js"></script>
		<script src="js/login.js"></script><!-- Bootstrap Core JavaScript -->
		<script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

		<!-- Metis Menu Plugin JavaScript -->
		<script src="bower_components/metisMenu/dist/metisMenu.min.js"></script>

		<!-- Morris Charts JavaScript -->
		<script src="bower_components/raphael/raphael-min.js"></script>
		<script src="bower_components/morrisjs/morris.min.js"></script>
		<script src="js/morris-data.js"></script>

		<!-- Custom Theme JavaScript -->
		<script src="dist/js/sb-admin-2.js"></script>
</body>
</html>
