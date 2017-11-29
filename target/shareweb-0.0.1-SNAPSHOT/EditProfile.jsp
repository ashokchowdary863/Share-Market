<jsp:include page="header.jsp" />
<div id="page-wrapper">
	<br> <br>
	<center>
		<h3>Update Information</h3>
	</center>
	<div class="col-md-12 col-md-offset-2">

		<form class="form-horizontal" id="UpdateForm">

			<div class="form-group">
				<label for="inputEmail3" class="col-sm-2 control-label">User
					Name</label>
				<div class="col-sm-6">
					<input type="text" class="form-control" id="username"
						name="username" placeholder="Ex:ashokkumar863" required>
				</div>
			</div>
			<div class="form-group">
				<label for="inputPassword3" class="col-sm-2 control-label">First
					Name</label>
				<div class="col-sm-6">
					<input type="text" class="form-control" id="firstname"
						name="firstname" placeholder="Ex:Ashok Kumar" required>
				</div>
			</div>
			<div class="form-group">
				<label for="inputEmail3" class="col-sm-2 control-label">Last
					Name</label>
				<div class="col-sm-6">
					<input type="text" class="form-control" id="lastname"
						name="lastname" placeholder="Ex:Karasala" required>
				</div>
			</div>
			<div class="form-group">
				<label for="inputPassword3" class="col-sm-2 control-label">Password
				</label>
				<div class="col-sm-6">
					<input type="password" class="form-control" id="password"
						name="password" placeholder="Enter your password" required>
				</div>
			</div>
			<div class="form-group">
				<label for="inputPassword3" class="col-sm-2 control-label">Email
					Address</label>
				<div class="col-sm-6">
					<input type="email" class="form-control" id="email" name="email"
						placeholder="Ex:ashokrj863@gmail.com">
				</div>
			</div>

			<div class="form-group">
				<label for="inputPassword3" class="col-sm-2 control-label">Mobile
					Number</label>
				<div class="col-sm-6">
					<input type="text" class="form-control" id="user_mobileno"
						name="user_mobileno" placeholder="Ex:994XXXXXXX" required>
				</div>
			</div>
			<div class="form-group">
				<label for="inputEmail3" class="col-sm-2 control-label">Bank
					Account Number </label>
				<div class="col-sm-6">
					<input type="text" class="form-control" id="accountno"
						name="accountno" placeholder="Ex:622303435883" required>
				</div>
			</div>
			<div class="form-group">
				<label for="inputPassword3" class="col-sm-2 control-label">PAN
					Number</label>
				<div class="col-sm-6">
					<input type="text" class="form-control" id="pan" name="pan"
						placeholder="Ex:EUPKXXXXXX" required>
				</div>
			</div>
			<div class="form-group">
				<label for="inputEmail3" class="col-sm-2 control-label">State
				</label>
				<div class="col-sm-6">
					<input type="text" class="form-control" id="state" name="state"
						placeholder="Ex:Andhra Pradesh" required>
				</div>
			</div>
			<div class="form-group">
				<label for="inputPassword3" class="col-sm-2 control-label">Country
				</label>
				<div class="col-sm-6">
					<input type="text" class="form-control" id="country" name="country"
						placeholder="Ex:India" required>
				</div>
			</div>





			<div class="form-group">
				<label for="inputEmail3" class="col-sm-2 control-label">ZipCode
				</label>
				<div class="col-sm-6">
					<input type="text" class="form-control" id="zipcode" name="zipcode"
						placeholder="Ex:5XXXXX" required>
				</div>
			</div>


			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-success" id="regClick">Update the information</button>
				</div>
				<div id="regStatus"></div>
			</div>
		</form>
	</div>
	<script src="app/UpdateDetails.js"></script>
</div>