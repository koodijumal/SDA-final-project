var today = new Date();
var dd = today.getDate();
var mm = today.getMonth()+1; //January is 0!
var yyyy = today.getFullYear();

var tomorrow = new Date();
tomorrow.setDate(tomorrow.getDate() + 1);
var dd_tomorrow = tomorrow.getDate();
var mm_tomorrow = tomorrow.getMonth()+1;
var yyyy_tomorrow = tomorrow.getFullYear();

if(dd<10){
    dd='0'+dd;
}
if(mm<10){
    mm='0'+mm;
}
if(dd_tomorrow<10){
    dd_tomorrow='0'+dd_tomorrow;
}
if(mm_tomorrow<10){
    mm_tomorrow='0'+mm_tomorrow;
}

today = yyyy+'-'+mm+'-'+dd;
tomorrow = yyyy_tomorrow+'-'+mm_tomorrow+'-'+dd_tomorrow;
document.getElementById("todayDate").defaultValue =today+"";
document.getElementById("tomorrowDate").defaultValue =tomorrow+"";
document.getElementById("todayDate").setAttribute("min", today+"");
document.getElementById("tomorrowDate").setAttribute("min", tomorrow+"");

function compare()
{
    var startDt = document.getElementById("todayDate").value;
    var endDt = document.getElementById("tomorrowDate").value;

    if ((!startDt || !endDt)){
        // document.getElementById("submitButton").disabled = true;
        document.getElementById("emptyDateErrorMessage").hidden = false;
        document.getElementById("dateErrorMessage").hidden = true;
        return false;
    }
    else if((new Date(startDt).getTime() >= new Date(endDt).getTime()))
    {
        // document.getElementById("submitButton").disabled = true;
        document.getElementById("dateErrorMessage").hidden = false;
        document.getElementById("emptyDateErrorMessage").hidden = true;
        return false;
    }
    else {
        // document.getElementById("submitButton").disabled = false;
        document.getElementById("emptyDateErrorMessage").hidden = true;
        document.getElementById("dateErrorMessage").hidden = true;
        return true;
    }
}