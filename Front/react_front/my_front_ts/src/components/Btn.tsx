import React, { useState } from 'react';
import Img from './Img';
import '../index.css';

const IMG = {
  Url : "http://www.testbackpage.com",
  imgUrl : '/images/Hello_World.png',
  altDes : 'Hello_World.png',
}

const Btn = () => {
    const [show, setShow] = useState(false);
  
    const onOffHandler = () => setShow(!show);
  
    return (
      <div className='two'>
        <button className='btn' onClick={onOffHandler}>
          {show ? 'OFF' : 'ON'}
        </button>
        {show && <Img Url={IMG.Url} imgUrl={IMG.imgUrl} altDes={IMG.altDes}/>}
      </div>
    )
  }

export default Btn;