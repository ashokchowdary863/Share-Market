<jsp:include page="header.jsp" />
<div id="page-wrapper" ng-app="angularTableUsers">

	<div role="main" class="container theme-showcase"
		ng-controller="listdataUsers">

		<div class="col-lg-10">
			<div class="page-header">
				<h2 id="tables">Registered Users</h2>
			</div>
			<div class="bs-component">
				
				<center>
					<form class="form-inline">
						<div class="form-group">
							<label>Search</label> <input type="text" ng-model="search"
								class="form-control" placeholder="Search">
						</div>
					</form>
				</center>
				<table class="table table-striped table-hover">
					<thead>
						<tr>
							<th ng-click="sort('id')">User ID <span
								class="glyphicon sort-icon" ng-show="sortKey=='id'"
								ng-class="{'glyphicon-chevron-up':reverse,'glyphicon-chevron-down':!reverse}"></span>
							</th>
							<th ng-click="sort('customerUserName')">User Name <span
								class="glyphicon sort-icon"
								ng-show="sortKey=='customerUserName'"
								ng-class="{'glyphicon-chevron-up':reverse,'glyphicon-chevron-down':!reverse}"></span>
							</th>
							<th ng-click="sort('customerFirstName')">First Name <span
								class="glyphicon sort-icon"
								ng-show="sortKey=='customerFirstName'"
								ng-class="{'glyphicon-chevron-up':reverse,'glyphicon-chevron-down':!reverse}"></span>
							</th>
							<th ng-click="sort('customerLastName')">Last Name Price <span
								class="glyphicon sort-icon"
								ng-show="sortKey=='customerLastName'"
								ng-class="{'glyphicon-chevron-up':reverse,'glyphicon-chevron-down':!reverse}"></span>
							</th>

							<th ng-click="sort('customerEmail')">Email Address<span
								class="glyphicon sort-icon" ng-show="sortKey=='customerEmail'"
								ng-class="{'glyphicon-chevron-up':reverse,'glyphicon-chevron-down':!reverse}"></span>
							</th>
							<th ng-click="sort('customerMobile')">Mobile Number<span
								class="glyphicon sort-icon" ng-show="sortKey=='customerMobile'"
								ng-class="{'glyphicon-chevron-up':reverse,'glyphicon-chevron-down':!reverse}"></span>
							</th>
							<th>Click to Edit</th>
						</tr>
					</thead>
					<tbody>
						<tr
							dir-paginate="user in users|orderBy:sortKey:reverse|filter:search|itemsPerPage:7"
							pagination-id="share.id + 'sharesNation'">
							<td>{{user.id}}</td>
							<td><a href="#" ng-click="loadUser(user.id)"
								data-toggle="modal" data-target="#myModal">
									{{user.customerUserName}} </a></td>
							<td>{{user.customerFirstName}}</td>
							<td>{{user.customerLastName}}</td>

							<td>{{user.customerEmail}}</td>
							<td>{{user.customerMobile}}</td>

							<td><a href="#" ng-click="loadUser(user.id)"
								data-toggle="modal" data-target="#buyModal"><button
										type="button" class="btn btn-info">Edit Information</button></a></td>
						</tr>
					</tbody>
				</table>
				<center>
					<dir-pagination-controls pagination-id="share.id + 'sharesNation'">
					</dir-pagination-controls>

					<div id="myModal" class="modal fade" role="dialog">
						<div class="modal-dialog">

							<!-- Modal content-->
							<div class="modal-content" ng-repeat="user in userData">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal">&times;</button>
									<h4 class="modal-title" id="company-title">{{
										user.customerFirstName}}'s Information</h4>
								</div>
								<div class="modal-body" id="company-body">
									<div>
										<table class="table table-bordered"> 
											<tr>
												<td>User ID</td>
												<td>{{ user.id }}</td>
											</tr>
											<tr>
												<td>User Name</td>
												<td>{{ user.customerUserName }}</td>
											</tr>
											<tr>
												<td>First Name</td>
												<td>{{ user.customerFirstName }}</td>
											</tr>
											<tr>
												<td>Last Name</td>
												<td>{{ user.customerLastName }}</td>
											</tr>
											<tr>
												<td>Email Address</td>
												<td>{{ user.customerEmail }}</td>
											</tr>
											<tr>
												<td>Mobile Number</td>
												<td>{{ user.customerMobile }}</td>
											</tr>
											<tr>
												<td>Account Number</td>
												<td>{{ user.bankAccountNumber }}</td>
											</tr>
											<tr>
												<td>Pan Number</td>
												<td>{{ user.customerPan }}</td>
											</tr>
											<tr>
												<td>Amount</td>
												<td>{{ user.customerAmount }}</td>
											</tr>
											<tr>
												<td>State</td>
												<td>{{ user.customerState }}</td>
											</tr>
											<tr>
												<td>Country</td>
												<td>{{ user.customerCountry }}</td>
											</tr>
											<tr>
												<td>ZipCode/PinCode</td>
												<td>{{ user.customerZipCode }}</td>
											</tr>
											<tr>
												<td>Role</td>
												<td>{{ user.role }}</td>
											</tr>
											<tr>
												<td>Registered Date</td>
												<td>{{ user.createdDate }}</td>
											</tr>
										</table>
									</div>
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-default"
										data-dismiss="modal">Close</button>
								</div>
							</div>
						</div>


					</div>

					<div id="buyModal" class="modal fade" role="dialog">
						<div class="modal-dialog">

							<!-- Modal content-->
							<div class="modal-content" ng-repeat="user in userData">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal">&times;</button>
									<h4 class="modal-title" id="company-title">Edit User Information</h4>
								</div>
								<div class="modal-body" id="company-body">
									<div>
										<table class="table table-bordered"> 
											<tr>
												<td>User ID</td>
												<td><input type="text" class="form-control" value="{{ user.id }}"/></td>
											</tr>
											<tr>
												<td>User Name</td>
												<td><input type="text" class="form-control" value="{{ user.customerUserName }}"/></td>
											</tr>
											<tr>
												<td>First Name</td>
												<td><input type="text" class="form-control" value="{{ user.customerFirstName }}" /></td>
											</tr>
											<tr>
												<td>Last Name</td>
												<td><input type="text" class="form-control" value="{{ user.customerLastName }}" /></td>
											</tr>
											<tr>
												<td>Email Address</td>
												<td><input type="text" class="form-control" value="{{ user.customerEmail }}" /></td>
											</tr>
											<tr>
												<td>Mobile Number</td>
												<td><input type="text" class="form-control" value="{{ user.customerMobile }} "/></td>
											</tr>
											<tr>
												<td>Account Number</td>
												<td><input type="text" class="form-control" value="{{ user.bankAccountNumber }}" /></td>
											</tr>
											<tr>
												<td>Pan Number</td>
												<td><input type="text" class="form-control" value="{{ user.customerPan }}" /></td>
											</tr>
											<tr>
												<td>Amount</td>
												<td><input type="text" class="form-control" value="{{ user.customerAmount }}" /></td>
											</tr>
											<tr>
												<td>State</td>
												<td><input type="text" class="form-control" value="{{ user.customerState }}" /></td>
											</tr>
											<tr>
												<td>Country</td>
												<td><input type="text" class="form-control" value="{{ user.customerCountry }}" /></td>
											</tr>
											<tr>
												<td>ZipCode/PinCode</td>
												<td><input type="text" class="form-control" value="{{ user.customerZipCode }}" /></td>
											</tr>
											<tr>
												<td>Role</td>
												<td><input type="text" class="form-control" value="{{ user.role }}" /></td>
											</tr>
											<tr>
												<td>Registered Date</td>
												<td><input type="text" class="form-control" value="{{ user.createdDate }}" /></td>
											</tr>
										</table>
										<br>
										<div class="modal-footer">
											<button type="button" class="btn btn-danger"
												data-dismiss="modal">Cancel</button>
											<button type="button" ng-click="updateUser(user.sid)"
												class="btn btn-success" data-dismiss="modal">Confirm
												Update Information</button>
										</div>
									</div>

								</div>
							</div>
						</div>

					</div>
				</center>
				<small>Growth values indicates growth of the company when
					compared to previous year. </small>
			</div>
		</div>



	</div>
</div>
</div>






<!-- Custom Theme JavaScript -->
<script src="dist/js/sb-admin-2.js"></script>
<script src="app/angular.js"></script>
<script src="app/users.js"></script>
<script src="app/dirPagination.js"></script>



