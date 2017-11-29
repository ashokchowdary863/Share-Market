<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/data.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>


<div id="container"
	style="min-width: 310px; height: 400px; margin: 0 auto"></div>

<table id="datatable">
	<thead>
		<tr>
			<th></th>
			<th>Bought Price</th>
			<th>Sold Price</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<th>Apples</th>
			<td>100</td>
			<td>200</td>
		</tr>
		<tr>
			<th>Pears</th>
			<td>2</td>
			<td>0</td>
		</tr>
		<tr>
			<th>Plums</th>
			<td>5</td>
			<td>11</td>
		</tr>
		<tr>
			<th>Bananas</th>
			<td>1</td>
			<td>1</td>
		</tr>
		<tr>
			<th>Oranges</th>
			<td>2</td>
			<td>4</td>
		</tr>
		<tr>
			<th>asd</th>
			<td>2</td>
			<td>4</td>
		</tr>
		<tr>
			<th>asd1</th>
			<td>2</td>
			<td>4</td>
		</tr>
	</tbody>
</table>
<script>
	$(function() {
		$('#container').highcharts(
				{
					data : {
						table : 'datatable'
					},
					chart : {
						type : 'column'
					},
					title : {
						text : 'Data extracted from a HTML table in the page'
					},
					yAxis : {
						allowDecimals : false,
						title : {
							text : 'Units'
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
	});
</script>