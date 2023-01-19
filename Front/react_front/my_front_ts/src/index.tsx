import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';

// ========================================
class Screen extends React.Component {
  render() {
    return (
      <div className='d1'>
        <Welcome />
      </div>
    );
  }
}

class Welcome extends React.Component {
  render() {
    return ( 
      <div className='square'>
        <h1>Hello, world</h1>
        <p>폴더 경로 재작업 후 확인 완료</p>
        <p>타입스크립트로 변경 후 확인 완료</p>
        <div className='d2'>
          <Btn />
        </div>
      </div>
    );
  }
}

function Btn() {
  type showButton = [show:boolean, setShow: boolean];

  const showButton = React.useState(false)
  const onClick = () => showButton[1]((prev) => !prev)

  return (
    <div className='two'>
      <button className='btn' onClick={onClick}>
        {showButton[0] ? 'OFF' : 'ON'}
      </button>
      {showButton[0] && <Img />}
    </div>
  )
}

const Img = ({Url, imgUrl, altDes}) => (
    <div>
      <br></br>
      <a href={Url} >
        <img src={imgUrl} alt={altDes} />
      </a>
    </div>
);

Img.defaultProps = {
  Url : "http://192.168.0.173:8080/",
  imgUrl : '/images/Hello_World.png',
  altDes : 'Hello_World.png'
}

ReactDOM.render(
  <Screen />,
  document.getElementById('root')
);