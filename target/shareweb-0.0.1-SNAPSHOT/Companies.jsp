<jsp:include page="header.jsp" />
<div id="page-wrapper" ng-app="angularTable">
	<div class="col-lg-12">
	<br><br>	
<div class="panel panel-primary">
  <div class="panel-heading">
    <h3 class="panel-title">List of Companies Registered</h3>
  </div>
  <div class="panel-body">
    <div class="bs-component" ng-controller="listdata">

			
			
				<form class="form-inline">
					<div class="form-group">
						<label>Search</label> <input type="text" ng-model="search"
							class="form-control" placeholder="Search">
					</div>
				</form>
			
			<br>
			<table class="table table-striped table-hover">
				<thead>
					<tr>
						<th ng-click="sort('companyName')">Comapny Name <span
							class="glyphicon sort-icon" ng-show="sortKey=='companyName'"
							ng-class="{'glyphicon-chevron-up':reverse,'glyphicon-chevron-down':!reverse}"></span>
						</th>
						<th ng-click="sort('companyOwner')">Company Owner <span
							class="glyphicon sort-icon" ng-show="sortKey=='companyOwner'"
							ng-class="{'glyphicon-chevron-up':reverse,'glyphicon-chevron-down':!reverse}"></span>
						</th>
						<th ng-click="sort('companyDescription')">Company Description
							<span class="glyphicon sort-icon"
							ng-show="sortKey=='companyDescription'"
							ng-class="{'glyphicon-chevron-up':reverse,'glyphicon-chevron-down':!reverse}"></span>
						</th>
						<th ng-click="sort('growth')">Growth <span
							class="glyphicon sort-icon" ng-show="sortKey=='growth'"
							ng-class="{'glyphicon-chevron-up':reverse,'glyphicon-chevron-down':!reverse}"></span>
						</th>
						<th ng-click="sort('registeredDate')">Registered Date <span
							class="glyphicon sort-icon" ng-show="sortKey=='registeredDate'"
							ng-class="{'glyphicon-chevron-up':reverse,'glyphicon-chevron-down':!reverse}"></span>
						</th>

					</tr>
				</thead>
				<tbody>
					<tr
						dir-paginate="company in companies|orderBy:sortKey:reverse|filter:search|itemsPerPage:7"
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
		<script src="app/angular.js"></script>
					<script src="app/dirPagination.js"></script>
					<script src="app/app.js"></script>
		</center>
		<small>Growth values indicates growth of the company when
			compared to previous year.</small><span>Data: {{ companies.sid }} </span>
  </div>
</div>
		
	</div>
</div>