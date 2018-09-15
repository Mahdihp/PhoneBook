function loadContact() {
    var url = "http://localhost:8080/api/contactservice/contacts";
    var txt = "";
    $.ajax({
        url: url,
        type: "GET",
        contentType: "application/json",
        dataType: "json",
        success: function (data) {
             var myObj = data['data'];
            // console.log(myObj);
            txt += "<table border='1px' class='highlight' >"

            txt += "<thead>"
            txt += "<tr>"
            txt += "<th> ID </th>"
            txt += "<th> Name </th>"
            txt += "<th> Address </th>"
            txt += "<th> Mobile </th>"
            txt += "<th> Delete </th>"
            txt += "<th> Update </th>"
            txt += "</tr>"
            txt += "</thead>"
            var i = 1;
            txt += "<tbody>";
            for (x in myObj) {
                txt += "<tr>"
                txt += "<td>" + i + "</td>";
                txt += "<td>" + myObj[x].name + "</td>";
                txt += "<td>" + myObj[x].address + "</td>";
                txt += "<td>" + myObj[x].mobile + "</td>";
                txt += "<td><a class='waves-effect waves-light btn' name=\"delete\" onclick=\"deleteById(" + myObj[x].id + ")\" type=\"button\" > Delete <i class='fas fa-trash-alt'></i></a></td>";
                txt += "<td><a class='waves-effect waves-light btn' name=\"update\" onclick=\"update(" + myObj[x].id + ")\" type=\"button\" > Update <i class='fas fa-edit'></i></a></td>";
                txt += "</tr>"
                i++;
            }
            txt += "<tbody>";

            txt += "</table>"
            document.getElementById("contactList").innerHTML = txt;

        },
        error: function (jqXhr, textStatus, errorMessage) { // error callback
            console.log("Error: " + errorMessage);
        }
    });
}