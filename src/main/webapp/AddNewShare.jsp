<jsp:include page="header.jsp" />

<script src="app/jquery.easy-autocomplete.js"></script> 
<div id="page-wrapper">
<br><br>
	<div class="panel panel-info">
		<div class="panel-heading">
			<h3 class="panel-title">Add a New Share</h3>
		</div>
		<div class="panel-body">
			<form class="form-horizontal" id="addShareForm">

				<div class="form-group">
					<label for="inputEmail3" class="col-sm-4 control-label">Company Name
						 </label>
					<div class="col-sm-6">
						<input id="provider-json" class="form-control" placeholder="Enter Company Name" />
					</div>
				</div>
				<div class="form-group">
					<label for="inputPassword3" class="col-sm-4 control-label">Share Price
						</label>
					<div class="col-sm-6">
						<input type="text" class="form-control" id="sharePrice"
							name="sharePrice" placeholder="Enter share price" required>
					</div>
				</div>
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-4 control-label">No Of Shares
						</label>
					<div class="col-sm-6">
						<input type="number" class="form-control" id="noOfShares"
							name="noOfShares" placeholder="Enter no of Shares" required>
					</div>
				</div>

				<div class="form-group">
					<label for="inputEmail3" class="col-sm-4 control-label">Brokerage Percentage
					</label>
					<div class="col-sm-6">
						<input type="number" class="form-control" id="BPerc"
							name="BPerc" placeholder="Enter Brokerage Percentage" required>
					</div>
				</div>
				<center><input type="submit" value="Click to add new Share"
					class="btn btn-success" /></center>
			</form>

		</div>
	</div>
	<script>
		$(document).ready(function(){
			
			var role=sessionStorage.getItem("userRole");
			if(role!="admin"){
					alert("You are not authorized");
					window.location="Dashboard.jsp";
				}
		});
		</script>
	<script src="app/add-share.js"></script>
	<script src="app/add-company.js"></script>
</div>