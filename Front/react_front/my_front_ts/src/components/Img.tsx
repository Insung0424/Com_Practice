import React from 'react';
import '../index.css';

type IMG = {
  Url: string, 
  imgUrl: string, 
  altDes: string
}

const Img = (props: IMG) => {
  return (
    <div>
      <br></br>
      <a href={props.Url} >
        <img src={props.imgUrl} alt={props.altDes} />
      </a>
    </div>
  );
};

export default Img;