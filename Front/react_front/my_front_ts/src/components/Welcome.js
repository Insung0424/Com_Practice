import React from 'react';
import Btn from './Btn';
import '../index.css';

const Welcome = () => {
    return (
        <div className='square'>
          <h1>Hello, world</h1>
          <div className='d2'>
            <Btn />
          </div>
        </div>
        );
    };

export default Welcome;