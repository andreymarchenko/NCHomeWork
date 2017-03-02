function validate() {
    var a = document.forms["form"]["a"].value;
    var b = document.forms["form"]["b"].value;
    var c = document.forms["form"]["c"].value;

    var regexp = /^(?:\+|\-)?\d+(?:\.\d+)?(?:e(?:\+|\-)?\d+)?$/;

    if(!regexp.test(a) || a === "") {
        alert("error");
        return false;
    }
    if(!regexp.test(b) || b === "") {
        alert("error");
        return false;
    }
    if(!regexp.test(c) || c === "") {
        alert("error");
        return false;
    }

    return true;
}