function solveRequest() {
    var a = document.forms["form"]["a"].value;
    var b = document.forms["form"]["b"].value;
    var c = document.forms["form"]["c"].value;

    var url = "/taskservlet";

    $.ajax({
        url: url,
        data: {
            A: a,
            B: b,
            C: c
        },
        success: function (result) {
            jSon = JSON.parse(result)
            addRow(jSon);
        }
    });

    function addRow(result) {
        var equation = a + "x^2 + " + b + "x + " + c;
        var roots = ""

        switch (result.length){
            case 0:
                roots = "Решений нет"
                break;
            case 1:
                roots = "x = " + result[0]
                break;
            case 2:
                roots = "x1 = " + result[0] + "<br>" + "x2 = " + result[1]
                break;
        };


        var row = "<tr onclick='deleteRow(this)'><td class='equation-column'>" + equation + "</td><td>" + roots + "</td></tr>";

        $("#table > tbody:last-child").append(row);
    }
}

