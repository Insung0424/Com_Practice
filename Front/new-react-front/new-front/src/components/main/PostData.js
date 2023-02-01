const PostData = () => {

    const postData = () => {
        let word = document.getElementById("inputText").value;

	    if(word === '') {
	    	alert("Please enter a word");
	    	return;
	    }

	    fetch('/content/plus', {
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
			  document.getElementById("inputText").value = "";
		  });
    }

    return (
        <form>
          Please enter a word : <input type="text" id="inputText" />
          <button type="button" onClick={postData}>
            Insert button
          </button>
        </form>
    );
};

export default PostData;