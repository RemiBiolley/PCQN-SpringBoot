function OnOff_1() {
    console.log(document.getElementById("tips1").style.display);
    if (document.getElementById("tips1").style.display == "none" || document.getElementById("tips1").style.display == "")
        document.getElementById("tips1").style.display = "block";
    else
        document.getElementById("tips1").style.display = "none";
}