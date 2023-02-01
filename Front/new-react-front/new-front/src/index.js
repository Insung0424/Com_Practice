import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <App />
  </React.StrictMode>
);

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
      // GetAll();
    });
}
