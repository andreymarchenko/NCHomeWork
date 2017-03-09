/**
 * Created by Andrey on 02.03.2017.
 */
var calculator = function () {
    var a = document.forms["mainForm"]["a"].value;
    var b = document.forms["mainForm"]["b"].value;
    var c = document.forms["mainForm"]["c"].value;

    if (isNumber(a) && isNumber(b) && isNumber(c)) {
        $.get({
            url: "/Calculator",
            data: {
                a: a,
                b: b,
                c: c,
            },
            success: function (result) {
                var resultArray = result.split("/");
                switch (resultArray.length) {
                    case 1: {
                        if (resultArray[0] === "") {
                            addRow("Нет корней");
                            break;
                        }
                        else {
                            var x = "x = " + resultArray[0];
                            addRow(x);
                            break;
                        }
                    }
                    case 2: {
                        var x1 = "x" + "<sub><small>1</small></sub>= " + resultArray[0];
                        var x2 = "x" + "<sub><small>2</small></sub>= " + resultArray[1];
                        addRow(x1 + "<br>" + x2);
                        break;
                    }
                }
            }
        })
    } else return false;

    function addRow(data) {
        var row = "<tr onclick='deleteRow(this)'><td class='equation-column'>"
            + a + "x" + "<sup><small>2</small></sup> + " + b + "x + " + c
            + "</td><td>" + data + "</td></tr>";

        $("#mainTable > tbody:last-child").append(row);
    }
}

function isNumber(number) {
    return !isNaN(parseFloat(number)) && isFinite(number);
}

function deleteRow(row) {
    row.parentNode.removeChild(row);
}