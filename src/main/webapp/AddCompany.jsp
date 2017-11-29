<jsp:include page="header.jsp" />
<div id="page-wrapper">
	<br>
	<br>
	<div class="panel panel-info">
		<div class="panel-heading">
			<h3 class="panel-title">Add a company</h3>
		</div>
		<div class="panel-body">
			<form class="form-horizontal" id="addCompanyForm">

				<div class="form-group">
					<label for="inputEmail3" class="col-sm-4 control-label">
						Company Name </label>
					<div class="col-sm-6">
						<input type="text" class="form-control" id="companyName"
							name="companyName" placeholder="Ex:Google" required>
					</div>
				</div>
				<div class="form-group">
					<label for="inputPassword3" class="col-sm-4 control-label">Company
						Owner </label>
					<div class="col-sm-6">
						<input type="text" class="form-control" id="companyOwner"
							name="companyOwner" placeholder="Ex:Rebekha Mikelson" prequired>
					</div>
				</div>
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-4 control-label">Company
						Description </label>
					<div class="col-sm-6">
						<input type="text" class="form-control" id="companyDesc"
							name="companyDesc"
							placeholder="Ex:Software Developmemnt,World's biggest Search Engine"
							required>
					</div>
				</div>

				<div class="form-group">
					<label for="inputEmail3" class="col-sm-4 control-label">Growth
					</label>
					<div class="col-sm-6">
						<input type="number" class="form-control" id="growth"
							name="growth" placeholder="Ex:1" required>
					</div>
				</div>
				<center>
					<input type="submit" value="Click to add new Company"
						class="btn btn-success" />
				</center>
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
	<script src="app/add-company.js"></script>
</div>