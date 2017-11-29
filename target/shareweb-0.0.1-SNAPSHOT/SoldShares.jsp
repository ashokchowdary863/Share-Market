<jsp:include page="header.jsp" />
<div id="page-wrapper" ng-app="angularTableSoldTransactions">
	<div role="main" class="col-lg-12">
<br><br>
<div class="panel panel-primary" class="col-lg-12">
  <div class="panel-heading">
    <h3 class="panel-title">Sold Shares</h3>
  </div>
  <div class="panel-body">
    	<div class="col-lg-10">
			
			<div class="bs-component" ng-controller="listdata">

				
				<center>
					<form class="form-inline">
						<div class="form-group">
							<label>Search</label> <input type="text" ng-model="search"
								class="form-control" placeholder="Search">
						</div>
					</form>
				</center>
				<br>
				<table class="table table-bordered table-hover">
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


							<th ng-click="sort('soldPrice')">Price at Sold <span
								class="glyphicon sort-icon" ng-show="sortKey=='soldPrice'"
								ng-class="{'glyphicon-chevron-up':reverse,'glyphicon-chevron-down':!reverse}"></span>
							</th>

							<th ng-click="sort('soldDate')">Sold Date <span
								class="glyphicon sort-icon" ng-show="sortKey=='soldDate'"
								ng-class="{'glyphicon-chevron-up':reverse,'glyphicon-chevron-down':!reverse}"></span>
							</th>

						</tr>
					</thead>
					<tbody>
						<tr
							dir-paginate="transaction in transactions|orderBy:sortKey:reverse|filter:search|itemsPerPage:5"
							pagination-id="beforeLogin">
							<td>{{transaction.companyName}}</td>
							<td>{{transaction.totalAmount}}</td>
							<td>{{transaction.noOfShares}}</td>
							<td>{{transaction.performedDate}}</td>

							<td>{{transaction.soldPrice}}</td>
							<td>{{transaction.soldDate}}</td>
						</tr>
					</tbody>
				</table>
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
	<script src="app/angular.js"></script>
	<script src="app/dirPagination.js"></script>
	<script src="app/sold-transactions.js"></script>
</div>
</body>

</html>