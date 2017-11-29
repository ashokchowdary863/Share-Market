<jsp:include page="header.jsp" />
<div id="page-wrapper"   ng-app="angularTableTransactions">
	<div role="main" class="container theme-showcase">

						<div class="col-lg-10">
							<div class="page-header">
								<h2 id="tables">Transaction History</h2>
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
								<table class="table table-striped table-hover">
									<thead>
										<tr>
											<th ng-click="sort('companyName')">Company Name <span
												class="glyphicon sort-icon" ng-show="sortKey=='companyName'"
												ng-class="{'glyphicon-chevron-up':reverse,'glyphicon-chevron-down':!reverse}"></span>
											</th>
											<th ng-click="sort('totalAmount')">Price at Buy <span
												class="glyphicon sort-icon"
												ng-show="sortKey=='totalAmount'"
												ng-class="{'glyphicon-chevron-up':reverse,'glyphicon-chevron-down':!reverse}"></span>
											</th>
											<th ng-click="sort('noOfShares')">No of Shares
												<span class="glyphicon sort-icon"
												ng-show="sortKey=='noOfShares'"
												ng-class="{'glyphicon-chevron-up':reverse,'glyphicon-chevron-down':!reverse}"></span>
											</th>
											<th ng-click="sort('performedDate')">Bought Date
												<span class="glyphicon sort-icon"
												ng-show="sortKey=='performedDate'"
												ng-class="{'glyphicon-chevron-up':reverse,'glyphicon-chevron-down':!reverse}"></span>
											</th>
											
											<th ng-click="sort('action')">Status <span
												class="glyphicon sort-icon"
												ng-show="sortKey=='action'"
												ng-class="{'glyphicon-chevron-up':reverse,'glyphicon-chevron-down':!reverse}"></span>
											</th>
											<th ng-click="sort('soldPrice')">Price at Sold <span
												class="glyphicon sort-icon"
												ng-show="sortKey=='soldPrice'"
												ng-class="{'glyphicon-chevron-up':reverse,'glyphicon-chevron-down':!reverse}"></span>
											</th>
											<th ng-click="sort('increaseDecrease')">Inc/Dec <span
												class="glyphicon sort-icon"
												ng-show="sortKey=='increaseDecrease'"
												ng-class="{'glyphicon-chevron-up':reverse,'glyphicon-chevron-down':!reverse}"></span>
											</th>
											<th ng-click="sort('soldDate')">Sold Date <span
												class="glyphicon sort-icon"
												ng-show="sortKey=='soldDate'"
												ng-class="{'glyphicon-chevron-up':reverse,'glyphicon-chevron-down':!reverse}"></span>
											</th>

										</tr>
									</thead>
									<tbody>
										<tr
											dir-paginate="transaction in transactions|orderBy:sortKey:reverse|filter:search|itemsPerPage:8">
											<td><a href="#" >{{transaction.companyName}} </a></td>
											<td>{{transaction.totalAmount}}</td>
											<td>{{transaction.noOfShares}}</td>
											<td>{{transaction.performedDate}}</td>
											
											<td><button type="button" class="btn btn-info">{{transaction.action}}</button></td>
											<td>{{transaction.soldPrice}}</td>
											<td><button type="button" class="btn btn-warning">{{transaction.increaseDecrease}}</button></td>
											<td>{{transaction.soldDate}}</td>												
										</tr>
									</tbody>
								</table>
								<center>
									<dir-pagination-controls> </dir-pagination-controls>
							</div>
							</center>
							<small>Growth values indicates growth of the company when
								compared to previous year.</small>
						</div>
					</div>
					<script src="app/angular.js"></script>
					<script src="app/dirPagination.js"></script>
					<script src="app/transactions.js"></script>
				</div>
</body>

</html>