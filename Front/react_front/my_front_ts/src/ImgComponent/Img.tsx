import React from 'react';
import '../index.css';
import ImgComponent from './ProgressiveImg';

type IMG = {
  Url: string, 
  imgUrl: string, 
  altDes: string,
  tImgUrl: string
}

const Img = (props: IMG) => {
  return (
    <div>
      <br></br>
      <a href={props.Url} >
        <ImgComponent placeholderSrc={props.tImgUrl} src={props.imgUrl} width="1980px" height="1086px"/>
      </a>
    </div>
  );
};

export default Img;