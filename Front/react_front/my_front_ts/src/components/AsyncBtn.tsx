import React, {useState} from "react";

const AsyncBtn = () => {
  const [word, setWord] = useState('');

  const onChangeHandler = (e: React.ChangeEvent<HTMLInputElement>) => {
    setWord(e.target.value);
  }

  const asyncBbuttonHandler = (e: any) => {
    e.preventDefault();
    if (word == '') {
      alert("Please enter a word");
      return;
    }
    console.log(word);
		
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
      setWord('');
      alert(data);
    });
};

  return (
    <div>
      <form >
        Please enter a word : <input value={word} type="text" id="inputWord" onChange={onChangeHandler}/>

        <button type="button" onClick={asyncBbuttonHandler}>
          비동기버튼
        </button>
      </form>
    </div>
  );
};

export default AsyncBtn;
