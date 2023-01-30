import React, { useState } from 'react';
import ImgComponent from '../ImgComponent/ImgComponent';
import '../index.css';

const Btn = () => {
    const [show, setShow] = useState(false);
  
    const onOffHandler = () => setShow(!show);
  
    return (
      <div className='two'>
        <button className='btn' onClick={onOffHandler}>
          {show ? 'OFF' : 'ON'}
        </button>
        {show && <ImgComponent alt='high.jpg' placeholderSrc='../images/tiny.jpg' src='../images/high.jpg'/>}
      </div>
    )
  }

export default Btn;