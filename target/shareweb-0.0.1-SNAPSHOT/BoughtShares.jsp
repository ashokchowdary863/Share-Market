<jsp:include page="header.jsp" />
<div id="page-wrapper" ng-app="angularTableBoughtTransactions"
	ng-controller="listdata">
	<div role="main" class="col-lg-12">

	<br><br>
		<div class="panel panel-primary" class="col-lg-12">
			<div class="panel-heading">
				<h3 class="panel-title">Bought Shares</h3>
			</div>
			<div class="panel-body">

				<div class="col-lg-10">

					<div class="bs-component">

			
						<center>
							<form class="form-inline">
								<div class="form-group">
									<label>Search</label> <input type="text" ng-model="search"
										class="form-control" placeholder="Search">
								</div>
							</form>
						</center>
						<br>
						<table class="table table-striped table-hover">
							<thead>
								<tr>
									<th ng-click="sort('companyName')">Company Name <span
										class="glyphicon sort-icon" ng-show="sortKey=='companyName'"
										ng-class="{'glyphicon-chevron-up':reverse,'glyphicon-chevron-down':!reverse}"></span>
									</th>
									<th ng-click="sort('totalAmount')">Price at Buy <span
										class="glyphicon sort-icon" ng-show="sortKey=='totalAmount'"
										ng-class="{'glyphicon-chevron-up':reverse,'glyphicon-chevron-down':!reverse}"></span>
									</th>
									<th ng-click="sort('noOfShares')">No of Shares <span
										class="glyphicon sort-icon" ng-show="sortKey=='noOfShares'"
										ng-class="{'glyphicon-chevron-up':reverse,'glyphicon-chevron-down':!reverse}"></span>
									</th>
									<th ng-click="sort('performedDate')">Bought Date <span
										class="glyphicon sort-icon" ng-show="sortKey=='performedDate'"
										ng-class="{'glyphicon-chevron-up':reverse,'glyphicon-chevron-down':!reverse}"></span>
									</th>
									<th ng-click="sort('growth')">Growth <span
										class="glyphicon sort-icon" ng-show="sortKey=='growth'"
										ng-class="{'glyphicon-chevron-up':reverse,'glyphicon-chevron-down':!reverse}"></span>
									</th>
									<th>Sell</th>

								</tr>
							</thead>
							<tbody>
								<tr
									dir-paginate="transaction in buytransactions|orderBy:sortKey:reverse|filter:search|itemsPerPage:5"
									pagination-id="beforeLogin">
									<td>{{transaction.companyName}}</td>
									<td>{{transaction.totalAmount}}</td>
									<td>{{transaction.noOfShares}}</td>
									<td>{{transaction.performedDate}}</td>
									<td>{{transaction.growth}}</td>
									<td><a href="#"
										ng-click="define(transaction.transcationId);"
										data-toggle="modal" data-target="#sellModal"><button
												type="button" class="btn btn-info">Click to sell</button></td>

								</tr>
							</tbody>
						</table>
						<div id="sellModal" class="modal fade" role="dialog">
							<div class="modal-dialog">

								<!-- Modal content-->
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal">&times;</button>
										<h4 class="modal-title" id="company-title">Confirmation</h4>
									</div>
									<div class="modal-body" id="company-body">
										<div>Are you sure you want to continue?</div>
									</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-danger"
											data-dismiss="modal">Cancel the transaction</button>
										<button type="button" class="btn btn-success"
											data-dismiss="modal" ng-click="sellShare()">Proceed
											the transaction</button>

									</div>
								</div>
							</div>
							<center>
								<dir-pagination-controls pagination-id="beforeLogin">
								</dir-pagination-controls>
						</div>
						</center>


						<small>Growth values indicates growth of the company when
							compared to previous year.</small>
					</div>



				</div>
			</div>

		</div>

	</div>
	<script src="app/angular.js"></script>
	<script src="app/dirPagination.js"></script>
	<script src="app/bought-transactions.js"></script>
</div>
</body>

</html>