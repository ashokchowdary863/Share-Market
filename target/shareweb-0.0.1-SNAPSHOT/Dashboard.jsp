<jsp:include page="header.jsp" />

<div id="page-wrapper" ng-app="angularDashboardTable">
	<div ng-controller="listdata">
	<div ng-repeat="user in dashboard">
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">Dashboard</h1>
			</div>
			<!-- /.col-lg-12 -->
		</div>
		<!-- /.row -->
		<div class="row">
			<div class="col-lg-3 col-md-6">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<div class="row">
							<div class="col-xs-3">
								<i class="fa fa-money fa-3x"></i>
							</div>
							<div class="col-xs-9 text-right">
								<h2>{{ user.userAmount }}</h2>
								<div>Wallet</div>
							</div>
						</div>
					</div>
					<a href="WalletDetails.jsp">
						<div class="panel-footer">
							<span class="pull-left">View Wallet Details</span> <span
								class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
							<div class="clearfix"></div>
						</div>
					</a>
				</div>
			</div>
			<div class="col-lg-3 col-md-6">
				<div class="panel panel-green">
					<div class="panel-heading">
						<div class="row">
							<div class="col-xs-3">
								<i class="glyphicon glyphicon-transfer fa-3x"></i>
							</div>
							<div class="col-xs-9 text-right">
								<h2>{{user.totalShares}}</h2>
								<div>Transactions!</div>
							</div>
						</div>
					</div>
					<a href="TransactionHistory.jsp">
						<div class="panel-footer">
							<span class="pull-left">View Trasaction Details</span> <span
								class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
							<div class="clearfix"></div>
						</div>
					</a>
				</div>
			</div>
			<div class="col-lg-3 col-md-6">
				<div class="panel panel-yellow">
					<div class="panel-heading">
						<div class="row">
							<div class="col-xs-3">
								<i class="fa fa-shopping-cart fa-3x"></i>
							</div>
							<div class="col-xs-9 text-right">
								<h2>{{user.boughtShares}}</h2>
								<div>Bought Shares!</div>
							</div>
						</div>
					</div>
					<a href="BoughtShares.jsp">
						<div class="panel-footer">
							<span class="pull-left">View Details</span> <span
								class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
							<div class="clearfix"></div>
						</div>
					</a>
				</div>
			</div>
			<div class="col-lg-3 col-md-6">
				<div class="panel panel-red">
					<div class="panel-heading">
						<div class="row">
							<div class="col-xs-3">
								<i class="fa fa-support fa-3x"></i>
							</div>
							<div class="col-xs-9 text-right">
								<h2>{{user.soldShares}}</h2>
								<div>Sold shares!</div>
							</div>
						</div>
					</div>
					<a href="SoldShares.jsp">
						<div class="panel-footer">
							<span class="pull-left">View Details</span> <span
								class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
							<div class="clearfix"></div>
						</div>
					</a>
				</div>
			</div>
		</div>
		<!-- /.row -->
		<div class="row">
			<div class="col-lg-8">
				<div class="panel panel-default">
					<div class="panel-heading">
						<i class="fa fa-bar-chart-o fa-fw"></i> Shares Area Chart

					</div>
					<!-- /.panel-heading -->
					<div class="panel-body">
						<div id="morris-area-chart"></div>
					</div>
					<!-- /.panel-body -->
				</div>
				<!-- /.panel -->

			</div>

		</div>
		<!-- /.panel -->

	</div>
	<!-- /.col-lg-4 -->
</div>
<!-- /.row -->

</div>


</div>
<script src="app/angular.js"></script>
<script src="app/dirPagination.js"></script>

<script src="app/dashboad.js"></script>
