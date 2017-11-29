<jsp:include page="header.jsp" />
<div id="page-wrapper">
	<br> <br>
	<div class="panel-heading">
		<h3>Wallet Details</h3>
	</div>
	<!-- /.panel-heading -->

	<!-- Nav tabs -->
	<ul class="nav nav-tabs">
		<li class="active"><a href="#walletHistory" data-toggle="tab"
			aria-expanded="true">Wallet History</a></li>
		<li><a href="#addMoney" data-toggle="tab" aria-expanded="false">Add
				Money</a></li>
		<li><a href="#sendMoney" data-toggle="tab" aria-expanded="false">Transfer
				Money</a></li>

	</ul>

	<!-- Tab panes -->
	<div class="tab-content">
		<div class="tab-pane fade active in" id="walletHistory"
			ng-app="angularTableWalletTransactions">
			<div role="main" class="container theme-showcase">
				<br>
				<br>
				<div class="col-lg-8">

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
									<th ng-click="sort('walletId')">Serial No <span
										class="glyphicon sort-icon" ng-show="sortKey=='walletId'"
										ng-class="{'glyphicon-chevron-up':reverse,'glyphicon-chevron-down':!reverse}"></span>
									</th>
									<th ng-click="sort('reason')">Reason <span
										class="glyphicon sort-icon" ng-show="sortKey=='reason'"
										ng-class="{'glyphicon-chevron-up':reverse,'glyphicon-chevron-down':!reverse}"></span>
									</th>
									<th ng-click="sort('amount')">Total Money left after the
										transaction <span class="glyphicon sort-icon"
										ng-show="sortKey=='amount'"
										ng-class="{'glyphicon-chevron-up':reverse,'glyphicon-chevron-down':!reverse}"></span>
									</th>
									<th ng-click="sort('modifiedDate')">Date <span
										class="glyphicon sort-icon" ng-show="sortKey=='modifiedDate'"
										ng-class="{'glyphicon-chevron-up':reverse,'glyphicon-chevron-down':!reverse}"></span>
									</th>


								</tr>
							</thead>
							<tbody>
								<tr
									dir-paginate="wallet in wallettransactions|orderBy:sortKey:reverse|filter:search|itemsPerPage:5"
									pagination-id="beforeLogin">
									<td>{{wallet.walletId}}</td>
									<td><button class="btn btn-info">{{wallet.reason}}</button></td>
									<td>{{wallet.amount}}</td>
									<td>{{wallet.modifiedDate}}</td>

								</tr>
							</tbody>
						</table>
						<center>
							<dir-pagination-controls pagination-id="beforeLogin">
						</center>
					</div>
					<small>Growth values indicates growth of the company when
						compared to previous year.</small>
				</div>
				<script src="app/angular.js"></script>
				<script src="app/dirPagination.js"></script>
				<script src="app/user-wallet.js"></script>
			</div>
		</div>

		<div class="tab-pane fade" id="addMoney">
			<br> <br>
			<div class="panel panel-green">
				<div class="panel-heading">Process your payment</div>
				<div class="panel-body">
					<div class="row">

						<div class="col-xs-12 col-md-4">
							<div class="panel panel-default">
								<div class="panel-heading">
									<h3 class="panel-title">Billing Details</h3>
								</div>
								<div class="panel-body">
									<form role="form" id="payment-form">
										<div class="row">
											<div class="col-xs-12">
												<div class="form-group">
													<label for="cardNumber">Billing Amount Details </label>
													<div class="input-group"></div>
												</div>
											</div>
										</div>
									</form>
								</div>
							</div>
						</div>




						<div class="col-xs-12 col-md-6">
							<div class="panel panel-default">
								<div class="panel-heading">
									<h3 class="panel-title">
										<img class="pull-right"
											src="http://i76.imgup.net/accepted_c22e0.png">Payment
										Details
									</h3>
								</div>
								<div class="panel-body">
									<form role="form" id="payment-form">
										<div class="row">
											<div class="col-xs-12">
												<div class="form-group">
													<label for="cardNumber">CARD NUMBER</label>
													<div class="input-group">
														<input type="text" class="form-control" name="cardNumber"
															placeholder="Valid Card Number" required autofocus
															data-stripe="number" /> <span class="input-group-addon"><i
															class="fa fa-credit-card"></i></span>
													</div>
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-xs-7 col-md-7">
												<div class="form-group">
													<label for="expMonth">EXPIRATION DATE</label>
													<div class="col-xs-6 col-lg-6 pl-ziro">
														<input type="text" class="form-control" name="expMonth"
															placeholder="MM" required data-stripe="exp_month" />
													</div>
													<div class="col-xs-6 col-lg-6 pl-ziro">
														<input type="text" class="form-control" name="expYear"
															placeholder="YY" required data-stripe="exp_year" />
													</div>
												</div>
											</div>
											<div class="col-xs-5 col-md-5 pull-right">
												<div class="form-group">
													<label for="cvCode">CV CODE</label> <input type="password"
														class="form-control" name="cvCode" placeholder="CV"
														required data-stripe="cvc" />
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-xs-12">
												<div class="form-group">
													<label for="couponCode">COUPON CODE</label> <input
														type="text" class="form-control" name="couponCode" />
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-xs-12">
												<button class="btn btn-success btn-lg btn-block"
													type="submit">Submit Payment</button>
											</div>
										</div>
										<div class="row" style="display: none;">
											<div class="col-xs-12">
												<p class="payment-errors"></p>
											</div>
										</div>
									</form>
								</div>
							</div>
						</div>




					</div>

				</div>

			</div>
			</div>
			
			<div class="tab-pane fade" id="sendMoney">
				<h4>Transfer Money</h4>
				<p>Will Design Soon.</p>
			</div>


		</div>
		<!-- /.panel-body -->
	</div>