import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';

// ========================================
class Screen extends React.Component {
  render() {
    return (
      <div className='d1'>
        <Welcome />
        <div className='d2'>
          <Btn />
        </div>
      </div>
    );
  }
}

class Welcome extends React.Component {
  render() {
    return ( 
      <div>
        <h1>Hello, world</h1>
        <p>폴더 경로 재작업 후 확인 완료</p>
      </div>
      
    );
  }
}

function Btn() {
  const [show, setShow] = React.useState(false)
  const onClick = () => setShow((prev) => !prev)

  return (
    <div className='two'>
      <button onClick={onClick}>
        {show ? 'OFF' : 'ON'}
      </button>
      {show && <Img />}
    </div>
  )
}

const Img = () => {
  let pageUrl = 'http://localhost:8080/';
  const onClick = () => document.location.href = pageUrl;
  return (
    <div>
      <br></br>
      <a href="javascript:void(0);" onClick={onClick}>
        <img src='/images/Hello_World.png' alt="Hello_World'.png"/>
      </a>
    </div>
  )
}


const root = ReactDOM.createRoot(document.getElementById("root"));
root.render(<Screen />);