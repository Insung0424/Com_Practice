import React, { useState } from 'react';
import Img from './Img';
import '../index.css';

function Btn() {
    const [show, setShow] = useState(false);
  
    const onClick = () => {
        setShow(!show);
    }
  
    return (
      <div className='two'>
        <button className='btn' onClick={onClick}>
          {show ? 'OFF' : 'ON'}
        </button>
        {show && <Img />}
      </div>
    )
  }

export default Btn;