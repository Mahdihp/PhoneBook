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
            txt += "<table class='table table-hover' >"

            txt += "<thead class='thead-light'>"
            txt += "<tr>"
            txt += "<th scope='col'> ID </th>"
            txt += "<th scope='col'> Name </th>"
            txt += "<th scope='col'> Address </th>"
            txt += "<th scope='col'> Mobile </th>"
            txt += "<th scope='col'> Delete </th>"
            txt += "<th scope='col'> Update </th>"
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
                txt += "<td><button data-toggle='modal' data-target='#exampleModalCenter' class='btn btn-danger' name=\"delete\" onclick=\"deleteById(" + myObj[x].id + ")\" type=\"button\" > Delete </button></td>";
                txt += "<td><button data-toggle='modal' data-target='#updateRowModal' class='btn btn-secondary' name=\"update\" onclick=\"update(" + myObj[x].id + ")\" type=\"button\" > Update </button></td>";
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

function deleteById(id) {
    $('#exampleModal').on('show.bs.modal', function (event) {
        var button = $(event.relatedTarget) // Button that triggered the modal
        var recipient = button.data('whatever') // Extract info from data-* attributes
        // If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
        // Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
        var modal = $(this)
        modal.find('.modal-title').text('New message to ' + recipient)
        modal.find('.modal-body input').val(recipient)
    });
    $("#cancel").on("click", function(){
        $("#exampleModal").modal('hide');
    });
    $("#ok").on("click", function(){
        var deleteUrl = "http://localhost:8080/api/contactservice/delete/"+id;
        console.log(deleteUrl);
        $.ajax({
            url: deleteUrl,
            type: "POST",
            contentType: "application/json",
            dataType: "json",
            success: function (data, status, xhr) {
                $("#exampleModal").modal('hide');
                homePage();
            }
            ,
            error: function (jqXhr, textStatus, errorMessage) { // error callback
                console.log("ErrorIng: " + errorMessage);
            }
        });

    });
}

function update(id) {
    console.log(id)
    $('#updateRowModal').on('show.bs.modal', function (event) {
        var button = $(event.relatedTarget) // Button that triggered the modal
        var recipient = button.data('whatever') // Extract info from data-* attributes
        // If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
        // Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
        var modal = $(this)
        modal.find('.modal-title').text('Save Information:')
        modal.find('.modal-body input').val(recipient)

    });
    var updateUrl = "http://localhost:8080/api/contactservice/contact?id="+ id;
    $.get(updateUrl , function (data) {
        // console.log(data);
        var myObject =  data["contactEntityData"];
        $("#id").val(myObject["id"]);
        $("#name").val(myObject["name"]);
        $("#address").val(myObject["address"]);
        $("#phone").val(myObject["phone"]);
        $("#mobile").val(myObject["mobile"]);
        $("#email").val(myObject["email"]);
    })

    $("#btnCancel").on("click", function(){
        $("#updateRowModal").modal('hide');
    });
    $("#btnOK").on("click", function(){
        // $("#id").val();
        var id =  $("#id").val();
        var name =  $("#name").val();
        var address = $("#address").val();
        var phone = $("#phone").val();
        var mobile = $("#mobile").val();
        var email = $("#email").val();
        var json = "{ \"id\":" + id + ",\"name\":\"" + name + "\",\"address\":\"" + address
            + "\",\"phone\":\"" + phone
            + "\",\"mobile\":\"" + mobile
            + "\",\"email\":\"" + email
            +"\"}";
        // console.log(json)
        save(json);
    });


}

function save(json) {
    var updateUrl = "http://localhost:8080/api/contactservice/update";
    $.ajax({
        url: updateUrl,
        type: "POST",
        data: json,
        contentType: "application/json",
        dataType: "json",
        success: function (data, status, xhr) {
            console.log(data);
            $("#updateRowModal").modal('hide');
            loadContact();
        },
        error: function (jqXhr, textStatus, errorMessage) { // error callback
            console.log("Error: " + errorMessage);
        }
    });
}

function insertTacher() {
    var fname = $("#fname").val();
    var lname = $("#lname").val();
    var style = $("#style").val();
    if (fname == "" || lname == ""){
        return;
    }
    // var json = "{\"id\":" + 0 + ",\"fname\":\"" + fname + "\",\"lname\":\"" + lname + "\",\"style\":\"" + style + "\"}";
    var json = {"id": 0, "fname": fname, "lname": lname, "style": style};
    // console.log(json);
    var updateUrl = "http://localhost:8080/api/contactservice/add";
    $.ajax({
        url: updateUrl,
        type: "POST",
        data: JSON.stringify(json),
        contentType: "application/json",
        dataType: "json",
        success: function (data, status, xhr) {
            // console.log(data);
            homePage();

        }
        ,
        error: function (jqXhr, textStatus, errorMessage) { // error callback
            console.log("Error: " + errorMessage);
        }
    });
}

function search() {
    var updateUrl = "http://localhost:8080/api/contactservice/teachersname?name=";
    var name = $("#searchField").val();
    updateUrl += name;

    console.log(updateUrl);
    $.ajax({
        url: updateUrl,
        type: "GET",
        data: "query",
        contentType: "application/json",
        dataType: "json",
        success: function (myObj) {
            // var myObj = JSON.stringify(result);
            var txt = "";
            console.log(myObj);
            txt += "<table border='1px' class='table table-hover table-bordered'>"

            txt += "<tr>"
            txt += "<th> ID </th>"
            txt += "<th> First Name </th>"
            txt += "<th> Last Name </th>"
            txt += "<th> Style </th>"
            // txt += "<th> Delete </th>"
            // txt += "<th> Update </th>"
            txt += "</tr>"
            var i = 1;
            for (x in myObj) {
                txt += "<tr>"
                txt += "<td>" + i + "</td>";
                txt += "<td>" + myObj[x].fname + "</td>";
                txt += "<td>" + myObj[x].lname + "</td>";
                txt += "<td>" + myObj[x].style + "</td>";
                // txt += "<td><button name=\"delete\" onclick=\"deleteById(" + myObj[x].id + ")\" type=\"button\" > Delete </button></td>";
                // txt += "<td><button name=\"update\" onclick=\"update(" + myObj[x].id + ")\" type=\"button\" > Update </button></td>";
                txt += "</tr>"
                i++;
            }


            txt += "</table>"
            $("#teachers").append(txt);
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log(textStatus);
        }
    });
}

function cancel() {
    $("#form").hide();
}

function insertPage() {
    window.location = "http://localhost:8080/insert.html";
}

function homePage() {
    window.location = "http://localhost:8080/index.html";

}

function seachPage() {
    this.location = "http://localhost:8080/search.html";
}