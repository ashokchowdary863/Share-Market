<jsp:include page="header.jsp" />
<div id="page-wrapper">
	<br> <br>
	<div class="panel-heading">
		<h3>Messaging System</h3>
	</div>
	<!-- /.panel-heading -->

	<!-- Nav tabs -->
	<ul class="nav nav-tabs">
		<li class="active"><a href="#sendMsg" data-toggle="tab"
			aria-expanded="true">Send Message</a></li>
		<li><a href="#inbox" data-toggle="tab" aria-expanded="false">Inbox</a></li>
		<li><a href="#sentbox" data-toggle="tab" aria-expanded="false">SentBox</a></li>

	</ul>

	<!-- Tab panes -->
	<div class="tab-content">
		<div class="tab-pane fade active in" id="sendMsg">
			<br>
			<br>
			<div class="panel panel-green">
				<div class="panel-heading">Send Message</div>
				<div class="panel-body"></div>
				<form class="form-horizontal" action="SendingLogs.jsp" method="post">
					<div class="form-group">
						<label for="inputEmail3" class="col-sm-2 control-label">From</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" id="sender" name="sender"
								value="ashokkumar863" required disabled>
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-2 control-label">To</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" id="reciever"
								name="reciever" placeholder="Enter reciptant username" required>
						</div>
					</div>

					<div class="form-group">
						<label for="inputPassword3" class="col-sm-2 control-label">Message</label>
						<div class="col-sm-4">
							<textarea class="form-control" rows="5" id="message"
								name="message" required></textarea>
						</div>
					</div>

					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-6">
							<button type="submit" class="btn btn-success">Click to
								send the message</button>
						</div>
					</div>
				</form>
			</div>
		</div>
		<div class="tab-pane fade" id="inbox">
		<br><br>
			<div class="panel panel-warning">
				<div class="panel-heading">InBox</div>
				<div class="panel-body">
					<p>Will Update Soon</p>
				</div>
			
			</div>
		</div>
		<div class="tab-pane fade" id="sentbox">
		<br><br>
			<div class="panel panel-success">
				<div class="panel-heading">SentBox</div>
				<div class="panel-body">
					<p>Will Update Soon</p>
				</div>
			</div>
		</div>


	</div>
	<!-- /.panel-body -->
</div>