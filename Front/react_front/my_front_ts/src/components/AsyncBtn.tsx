import React, {useState} from "react";

const AsyncBtn = () => {
  const [word, setWord] = useState('');

  const onChangeHandler = (e: React.ChangeEvent<HTMLInputElement>) => {
    setWord(e.target.value);
  }

  const asyncBbuttonHandler = (e: any) => {
    e.preventDefault();
    let word = onChangeHandler;
		
	    fetch('http://www.testbackpage.com/input', {
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
  };

  return (
    <div>
      <form >
        Enter a random word : <input type="text" id="inputWord" onChange={onChangeHandler}/>

        <button type="button" onClick={asyncBbuttonHandler}>
          비동기버튼
        </button>
      </form>
    </div>
  );
};

export default AsyncBtn;
