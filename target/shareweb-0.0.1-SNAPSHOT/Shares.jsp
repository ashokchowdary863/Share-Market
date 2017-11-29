<jsp:include page="header.jsp" />

<div id="page-wrapper" ng-app="angularTableShares">

	<div role="main" class="container theme-showcase" ng-controller="listdataShares">

		<div class="col-lg-10">
			<div class="page-header">
				<h2 id="tables">Companies available with shares</h2>
			</div>
			<div class="bs-component" >
				
				<center>
					<form class="form-inline">
						<div class="form-group">
							<label>Search</label> <input type="text" ng-model="search"
								class="form-control" placeholder="Search">
						</div>
					</form>
					<br>
				</center>
				<table class="table table-bordered table-hover">
					<thead>
						<tr>
							<th ng-click="sort('sid')">Share ID <span
								class="glyphicon sort-icon" ng-show="sortKey=='sid'"
								ng-class="{'glyphicon-chevron-up':reverse,'glyphicon-chevron-down':!reverse}"></span>
							</th>
							<th ng-click="sort('companyName')">Company Name <span
								class="glyphicon sort-icon" ng-show="sortKey=='companyName'"
								ng-class="{'glyphicon-chevron-up':reverse,'glyphicon-chevron-down':!reverse}"></span>
							</th>
							<th ng-click="sort('currentSharePrice')">Current Share Price
								<span class="glyphicon sort-icon"
								ng-show="sortKey=='currentSharePrice'"
								ng-class="{'glyphicon-chevron-up':reverse,'glyphicon-chevron-down':!reverse}"></span>
							</th>
							<th ng-click="sort('previousSharePrice')">Previous Share
								Price <span class="glyphicon sort-icon"
								ng-show="sortKey=='previousSharePrice'"
								ng-class="{'glyphicon-chevron-up':reverse,'glyphicon-chevron-down':!reverse}"></span>
							</th>
							
							<th ng-click="sort('noOfShares')">No of shares Available<span
								class="glyphicon sort-icon" ng-show="sortKey=='noOfShares'"
								ng-class="{'glyphicon-chevron-up':reverse,'glyphicon-chevron-down':!reverse}"></span>
							</th>
							<th ng-click="sort('announcedDate')">Announced Date<span
								class="glyphicon sort-icon" ng-show="sortKey=='announcedDate'"
								ng-class="{'glyphicon-chevron-up':reverse,'glyphicon-chevron-down':!reverse}"></span>
							</th>
							<th>Click to Buy</th>
						</tr>
					</thead>
					<tbody>
						<tr
							dir-paginate="share in shares|orderBy:sortKey:reverse|filter:search|itemsPerPage:6"
							pagination-id="share.id + 'sharesNation'">
							<td>{{share.sid}}</td>
							<td><a href="#" ng-click="loadCompany(share.cid,share.sid)"
								data-toggle="modal" data-target="#myModal">
									{{share.companyName}} </a></td>
							<td>{{share.currentSharePrice}}</td>
							<td>{{share.previousSharePrice}}</td>
							
							<td>{{share.noOfShares}}</td>
							<td>{{share.announcedDate}}</td>

							<td><a href="#" ng-click="loadCompany(share.cid,share.sid)"
								data-toggle="modal" data-target="#buyModal"><button
										type="button" class="btn btn-info">Buy Share</button></a></td>
						</tr>
					</tbody>
				</table>
				<center>
					<dir-pagination-controls pagination-id="share.id + 'sharesNation'">
					</dir-pagination-controls>

					<div id="myModal" class="modal fade" role="dialog">
						<div class="modal-dialog">

							<!-- Modal content-->
							<div class="modal-content" ng-repeat="data in companyData">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal">&times;</button>
									<h4 class="modal-title" id="company-title">{{
										data.companyName}}</h4>
								</div>
								<div class="modal-body" id="company-body">
									<div>
										Compnay Owner : {{data.companyOwner}}<br> Company
										Description : {{ data.companyDescription}}<br> Growth :
										{{data.growth}}<br> Registered Date :
										{{data.registeredDate}}<br>
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
							<div class="modal-content" ng-repeat="share in shareData">
								<div class="modal-header" >
									<button type="button" class="close" data-dismiss="modal">&times;</button>
									<h4 class="modal-title" id="company-title">Buy Share</h4>
								</div>
								<div class="modal-body" id="company-body">
									<div>
										<table class="table table-bordered">
											<tr>
												<td>Company Name</td>
												<td>{{share.companyName}}</td>
											</tr>
											<tr>
												<td>Current Share Price</td>
												<td>{{ share.currentSharePrice}}</td>
											</tr>
											<tr>
												<td>Recent Share Price</td>
												<td>{{share.previousSharePrice}}</td>
											</tr>
											<tr>
												<td>No of Shares available</td>
												<td>{{share.noOfShares}}</td>
											</tr>
											<tr>
												<td>Announced Date</td>
												<td>{{share.announcedDate}}</td>
											</tr>
											<tr>
												<td>No of Shares you want to buy</td>
												<td><input ng-model="number" type="number" id="noofShares" class="form-control"/></td>
											</tr>

										</table>
										<br>
										<div class="modal-footer">
											<button type="button" class="btn btn-danger"
												data-dismiss="modal">Cancel</button>
											<button type="button" ng-click="buyShare(share.sid)"
												class="btn btn-success"
										data-dismiss="modal">Confirm
												Buy</button>
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
<script src="app/app3.js"></script>
<script src="app/dirPagination.js"></script>
<script src="app/load-company.js"></script>




</body>

</html>