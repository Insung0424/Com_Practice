<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<P>  Random DB Value : ${ randomData.word }  </P>

<a href="http://localhost/swagger-ui/index.html"><button type="button">GO Swagger</button></a>
<br>
<div>
<form>
	Please enter a word :<input id="inputWord" type="text"/>
	<button type="button" onClick="postData()">Async Button</button>
</form>
</div>
<script type="text/javascript">
	  
	function postData() {
		let word = document.getElementById("inputWord").value;
	    console.log(word);
	    if(word == '') {
	    	alert("Please enter a word");
	    	return;
	    }
		
	    fetch('/input', {
		    method: 'POST', 
		    headers: {
		      'Content-Type': 'application/json',
		    },
		    body: JSON.stringify({ word: word }), 
		  })
		  .then( (response) => {
			  return response.text();
		  })
		  .then((data) => {
			  alert(data);
		  });
	    document.getElementById("inputWord").value = "";
	}
</script>

</body>
</html>
