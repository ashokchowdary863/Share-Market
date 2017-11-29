<!DOCTYPE html>
<html>

<body>

<br><br>
<div id="id01"></div>
<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script>
var xmlhttp = new XMLHttpRequest();
var url = "http://localhost:8080/shareweb/api/companies";

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
    var out = "<div class='container'><table class='table table-bordered'>";

    for(i = 0; i < arr.length; i++) {
        out += "<tr><th>" +
        arr[i].companyName +
        "</th><th>" +
        arr[i].companyOwner +
        "</th><th>" +
        arr[i].companyDescription +
        "</th><th>" +
        arr[i].growth +
        "</th><th>" +
        arr[i].registeredDate +
        "</th></th>";
    }
    out += "</table></div>";
    document.getElementById("id01").innerHTML = out;
}
</script>

</body>
</html>
