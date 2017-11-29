var out = "";
var xmlhttp = new XMLHttpRequest();
var url = "http://192.168.35.189:8080/shareweb/api/companies";

xmlhttp.onreadystatechange=function() {
    if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
        myFunction(xmlhttp.responseText);
    }
}
xmlhttp.open("GET", url, true);
xmlhttp.send();

function myFunction(response) {
    var arr = JSON.parse(response);
    var i;
    

    for(i = 0; i < arr.length; i++) {
        out += "<tr class='odd gradeX'><td>" +
        arr[i].companyName +
        "</td><td>" +
        arr[i].companyOwner +
        "</td><td>" +
        arr[i].companyDescription +
        "</td><td>" +
        arr[i].growth +
        "</td><td>" +
        arr[i].registeredDate +
        "</td></td>";
    }
    
    out += "</tr>";
   // $("#table-body-normal").html(out);
   
}

$(document).ready(function() {
	
	 $("#table-body-normal").html(out);
    $('#dataTables-example').DataTable({
            responsive: true
    });
});
