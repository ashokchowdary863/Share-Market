
<html lang="en" ng-app="angularTable">
<head>
<meta charset="utf-8">
<title>List of Companies</title>
<link rel="stylesheet" type="text/css" href="app/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="app/bootstrap-theme.min.css">
<link rel="stylesheet" type="text/css" href="app/styles.css">
<title>Shop Broking System</title>
<link rel="shortcut icon"
	href="http://www.alacriti.com/wp-content/themes/alacriti/images/favicon.png"
	type="image/png">
<link href="dist/css/contactus.css" rel="stylesheet">
<!-- Bootstrap Core CSS -->
<link href="bower_components/bootstrap/dist/css/bootstrap.min.css"
	rel="stylesheet">


<!-- MetisMenu CSS -->
<link href="bower_components/metisMenu/dist/metisMenu.min.css"
	rel="stylesheet">

<!-- Timeline CSS -->
<link href="dist/css/timeline.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="dist/css/sb-admin-2.css" rel="stylesheet">

<!-- Morris Charts CSS -->
<!-- <link href="bower_components/morrisjs/morris.css" rel="stylesheet"> -->

<!-- Custom Fonts -->
<link href="bower_components/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">

</head>
<body>
	<div id="wrapper">

		<!-- Navigation -->
		<nav class="navbar navbar-default navbar-static-top" role="navigation"
			style="margin-bottom: 0">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="sr-only">Online Share Market</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="Dashboard.jsp">Share Broking
					System</a>
			</div>




			<div class="navbar-default sidebar" role="navigation">
				<div class="sidebar-nav navbar-collapse">
					<ul class="nav" id="side-menu">
						<li class="sidebar-search">
							<div class="input-group custom-search-form">
								<input type="text" class="form-control" placeholder="Search...">
								<span class="input-group-btn">
									<button class="btn btn-default" type="button">
										<i class="fa fa-search"></i>
									</button>
								</span>
							</div> <!-- /input-group -->
						</li>
						<li><a href="index.jsp"><i class="fa fa-dashboard fa-fw"></i>
								Home</a></li>

						
						<li><a href="Company.jsp"><i
								class="fa fa-mail-reply fa-fw"></i> Companies</a></li>
						<li><a href="ContactUs.jsp"><i
								class="fa  fa-mail-forward fa-fw"></i>Contact Us</a></li>



					</ul>
				</div>
				<!-- /.sidebar-collapse -->
			</div>
			<!-- /.navbar-static-side -->
		</nav>

	</div>
	<!-- /#wrapper -->
	<div id="page-wrapper">

		<br>
		<br>
		<div class="panel panel-green">
			<div class="panel-heading">Registered Companies</div>
			<div class="panel-body">


				<div class="col-lg-12">

					<div class="bs-component" ng-controller="listdata">
						<div class="alert alert-info">
							<p>Sort key: {{sortKey}} , Search String : {{search}}</p>
						</div>
						<form class="form-inline">
							<div class="form-group">
								<label>Search</label> <input type="text" ng-model="search"
									class="form-control" placeholder="Search">
							</div>
						</form>
						<h4>
							<table class="table table-bordered">
								<thead>
									<tr>
										<th ng-click="sort('companyName')">Comapny Name <span
											class="glyphicon sort-icon" ng-show="sortKey=='companyName'"
											ng-class="{'glyphicon-chevron-up':reverse,'glyphicon-chevron-down':!reverse}"></span>
										</th>
										<th ng-click="sort('companyOwner')">Owner <span
											class="glyphicon sort-icon" ng-show="sortKey=='companyOwner'"
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
										<th ng-click="sort('registeredDate')">Reg. Date <span
											class="glyphicon sort-icon"
											ng-show="sortKey=='registeredDate'"
											ng-class="{'glyphicon-chevron-up':reverse,'glyphicon-chevron-down':!reverse}"></span>
										</th>

									</tr>
								</thead>
								<tbody>
									<tr
										dir-paginate="company in companies|orderBy:sortKey:reverse|filter:search|itemsPerPage:5">
										<td>{{company.companyName}}</td>
										<td>{{company.companyOwner}}</td>
										<td>{{company.companyDescription}}</td>
										<td>{{company.growth}}</td>
										<td>{{company.registeredDate}}</td>
									</tr>
								</tbody>
							</table>
						</h4>
						<center>
							<dir-pagination-controls max-size="5" direction-links="true"
								boundary-links="true"> </dir-pagination-controls>
						</center>
						<small>Growth values indicates the increase of profits when compared to previos years</small>
					</div>
				</div>

			</div>
		</div>

	</div>





	</div>
	<script src="app/angular.js"></script>
	<script src="app/dirPagination.js"></script>
	<script src="app/app.js"></script>
</body>
</html>
