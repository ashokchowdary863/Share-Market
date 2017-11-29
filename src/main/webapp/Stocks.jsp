<jsp:include page="header.jsp" />

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/data.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>

<div id="page-wrapper">

	<div id="container"
		style="min-width: 310px; height: 400px; margin: 0 auto"></div>

	<table class='table table-bordered' id='datatable'>
		<thead>
			<tr>
				<th></th>
				<th>Bought Price</th>
				<th>Sold Price</th>
			</tr>
		</thead>
		<tbody id="tableBody">
		<tr>
		<th>15</th>
		<td>22000</td>
		<td>19800</td>
		</tr>
		<tr>
		<th>16</th>
		<td>22000</td>
		<td>11990</td>
		</tr>
		<tr>
		<th>17</th>
		<td>21000</td>
		<td>11810</td>
		</tr>
		<tr>
		<th>18</th>
		<td>19000</td>
		<td>11800</td>
		</tr>
		</tbody>
	</table>
</div>

<script>
	
	var xmlhttp = new XMLHttpRequest();
	var userId = sessionStorage.getItem("userId");
	var url = "http://192.168.35.189:8080/shareweb/api/transactions/users/"
			+ userId;

	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			myFunction(xmlhttp.responseText);
		}
	}
	xmlhttp.open("GET", url, true);
	xmlhttp.send();

	function myFunction(response) {
		var arr = JSON.parse(response);
		var i;
		var out = "";
		for (i = 0; i < arr.length; i++) {
			out += "<tr><th>" + arr[i].transcationId + "</th><td>"
					+ arr[i].totalAmount + "</td><td>" + arr[i].soldPrice
					+ "</td></tr>";
		}
		out += "";
		document.getElementById("tableBody").innerHTML = out;
	}
	function loadCharts() {
		$('#container').highcharts(
				{
					data : {
						table : 'datatable'
					},
					chart : {
						type : 'column'
					},
					title : {
						text : 'Graphical Representation of Shares'
					},
					yAxis : {
						allowDecimals : false,
						title : {
							text : 'Money'
						}
					},
					tooltip : {
						formatter : function() {
							return '<b>' + this.series.name + '</b><br/>'
									+ this.point.y + ' '
									+ this.point.name.toLowerCase();
						}
					}
				});
	};
	loadCharts();
</script>
