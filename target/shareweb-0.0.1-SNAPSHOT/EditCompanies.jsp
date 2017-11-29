<jsp:include page="header.jsp" />

<div id="page-wrapper" ng-app="angularTableSharesEdit">

	<div role="main" class="container theme-showcase"
		ng-controller="listdataSharesEdit">

		<div class="col-lg-10">
			<div class="page-header">
				<h2 id="tables">Companies available with shares</h2>
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
							<th ng-click="sort('brokeragePercentage')">Brokerage
								Percentage<span class="glyphicon sort-icon"
								ng-show="sortKey=='brokeragePercentage'"
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
							<th>Action</th>
						</tr>
					</thead>
					<tbody>
						<tr
							dir-paginate="share in shares|orderBy:sortKey:reverse|filter:search|itemsPerPage:7"
							pagination-id="share.id + 'sharesNation'">
							<td>{{share.sid}}</td>
							<td><a href="#" ng-click="loadCompany(share.cid,share.sid)"
								data-toggle="modal" data-target="#myModal">
									{{share.companyName}} </a></td>
							<td>{{share.currentSharePrice}}</td>
							<td>{{share.previousSharePrice}}</td>
							<td>{{share.brokeragePercentage}}</td>
							<td>{{share.noOfShares}}</td>
							<td>{{share.announcedDate}}</td>

							<td><a href="#" ng-click="loadCompany(share.cid,share.sid)"
								data-toggle="modal" data-target="#buyModal"><button
										type="button" class="btn btn-primary">Click to Edit</button></a></td>
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
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal">&times;</button>
									<h4 class="modal-title" id="company-title">Edit Share
										Details : {{share.companyName}}</h4>
								</div>
								<div class="modal-body" id="company-body">


									<form class="form-horizontal" id="UpdateForm">
											<div class="form-group">
											<label for="inputEmail3" class="col-sm-4 control-label">
												Share ID </label>
											<div class="col-sm-6">
												<input type="text" class="form-control" id="shareId"
													name="shareId" value="{{ share.sid }}"
													required disabled>
											</div>
											</div>
											<div class="form-group">
											<label for="inputEmail3" class="col-sm-4 control-label">
												Company ID </label>
											<div class="col-sm-6">
												<input type="text" class="form-control" id="companyId"
													name="companyId" value="{{ share.cid }}"
													required disabled>
											</div>
										</div>
										<div class="form-group">
											<label for="inputEmail3" class="col-sm-4 control-label">Current
												Share Price </label>
											<div class="col-sm-6">
												<input type="text" class="form-control" id="csprice"
													name="csprice" value="{{ share.currentSharePrice }}"
													required>
											</div>
										</div>
										<div class="form-group">
											<label for="inputPassword3" class="col-sm-4 control-label">Previous
												Price </label>
											<div class="col-sm-6">
												<input type="text" class="form-control" id="pprice"
													name="pprice" value="{{ share.previousSharePrice }}"
													required>
											</div>
										</div>
										<div class="form-group">
											<label for="inputEmail3" class="col-sm-4 control-label">Brokerage
												Percentage </label>
											<div class="col-sm-6">
												<input type="text" class="form-control" id="bpercent"
													name="bpercent" value="{{ share.brokeragePercentage }}"
													required>
											</div>
										</div>

										<div class="form-group">
											<label for="inputEmail3" class="col-sm-4 control-label">No
												Of Shares </label>
											<div class="col-sm-6">
												<input type="number" class="form-control" id="noofshares"
													name="noofshares" value="{{ share.noOfShares }}" required>
											</div>
										</div>
									</form>
									<br>
									<div class="modal-footer">
										<button type="button" class="btn btn-danger"
											data-dismiss="modal">Cancel</button>
										<button type="button"  class="btn btn-success" onclick="editCompany();">Confirm
										</button>
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




<script src="dist/js/sb-admin-2.js"></script>
<script src="app/angular.js"></script>
<script src="app/edit-company.js"></script>
<script src="app/dirPagination.js"></script>





</body>

</html>