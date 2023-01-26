import React from 'react';
import Btn from './Btn';
import AsyncBtn from './AsyncBtn';
import '../index.css';

const Welcome = () => {
    return (
        <div className='square'>
          <h1>Hello, world</h1>
          <div className='d2'>
            <Btn />
            <AsyncBtn />
          </div>
        </div>
        );
    };

export default Welcome;