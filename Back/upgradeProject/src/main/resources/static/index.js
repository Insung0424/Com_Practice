function getOne() {
        const one = document.getElementById('rValue');
        let arr = [];

        fetch('/content/list' , {
            method: 'GET',
            headers: {
              'Content-Type': 'application/json',
            },
          })
          .then( (response) => {
              return response.json();
          })
          .then((data) => {
                data.map((item)=>{
                    arr.push(item.id);
                });
                let id = Math.floor(Math.random() * arr.length);
                fetch('/content/one/'+ arr[id] , {
                    method: 'GET',
                    headers: {
                      'Content-Type': 'application/json',
                    },
                  })
                  .then( (response) => {
                      return response.json();
                  })
                  .then((data) => {
                      one.value = data.word;
                  });
          });

    }

    function GetAll() {
        const DataList = document.getElementById('AllDataList');

        let DynamicHTML = "<table><thead><tr><td>ID</td><td>Word</td><td>button</td></tr></thead><tbody>";
        fetch('/content/list', {
		    method: 'GET',
		    headers: {
		      'Content-Type': 'application/json',
		    },
          })
          .then( (response) => {
              return response.json();
          })
          .then((data) => {
              data.map((item)=>{
                DynamicHTML += "<tr><td>"+ item.id +"</td><td>"+ item.word + "</td><td><button id='delete' type='button' onClick='deleteOne(this)' data-id='"+ item.id +"'>삭제</button></td></tr>";
              });
              DynamicHTML += "</tbody></table>";
              DataList.innerHTML = DynamicHTML;
          });
    }

	function postData() {
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
              GetAll();
		  });

	}

	function deleteOne(e) {
	    const id = e.dataset.id;

	    fetch('/content/minus', {
		    method: 'DELETE',
		    headers: {
		      'Content-Type': 'application/json',
		    },
		    body: JSON.stringify({ id: id }),
		  })
		  .then( (response) => {
			  return response.text();
		  })
		  .then((data) => {
		      if(data == 'Fail'){
			    alert(data);
			  }
			  console.log(data);
			  GetAll();
		  });

	}