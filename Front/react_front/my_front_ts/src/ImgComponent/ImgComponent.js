import React, { useState, useEffect } from "react"; 
import './ImgComponent.css';

const ImgComponent = ({ placeholderSrc, src, ...props }) => {
  const [imgSrc, setImgSrc] = useState(placeholderSrc || src);

  useEffect(() => {
    const img = new Image();
    img.src = src;
    img.onload = () => {
      setImgSrc(src);
    };
  }, [src]);

  const customClass =
  placeholderSrc && imgSrc === placeholderSrc ? "loading" : "loaded";

  return (
    <a href="http://www.testbackpage.com">
    <img
      {...{ src: placeholderSrc, ...props }}
      alt={props.altDes || ""}
      className={`image ${customClass}`}
    /></a>
  );
};

export default ImgComponent;
