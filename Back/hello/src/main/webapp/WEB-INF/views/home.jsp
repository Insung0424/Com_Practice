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
	input value :<input id="inputWord" type="text"/>
	<button type="button" onClick="postData()">Async Button</button>
</form>
</div>
<script type="text/javascript">
	  
	function postData() {
		let word = document.getElementById("inputWord").value;
	    console.log(word);
		
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
	}
</script>

</body>
</html>
