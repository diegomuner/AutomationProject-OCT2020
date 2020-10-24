
function success() {
	 if(document.getElementById("username").value!=="") { 
	     if(document.getElementById("password").value!==""){

		
	    document.getElementById('button').disabled = false; 
        } else { 
            document.getElementById('button').disabled = true;
        }


	}
}

