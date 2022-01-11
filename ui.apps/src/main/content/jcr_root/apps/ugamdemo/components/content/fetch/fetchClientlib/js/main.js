function loadDoc() {
    var request = new XMLHttpRequest();
	button.disabled = true;
    request.open("GET", "/conf/acara/api/export/sofia", "true");
 	request.onreadystatechange = function() {
        if(this.readyState === 4 && this.status === 200) {
            document.getElementById("result").innerHTML = this.responseText;
            if(request.readyState === 4 && request.status === 200){button.disabled = false;}
        }
    };

    request.send();
}