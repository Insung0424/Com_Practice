import React, { useState } from "react";
import ProgressiveImage from "react-progressive-graceful-image";
import "../index.css";
import "../ImgComponent/Img.css";

const Btn = () => {
  const [show, setShow] = useState(false);

  const onOffHandler = () => setShow(!show);

  return (
    <div className="two">
      <button className="btn" onClick={onOffHandler}>
        {show ? "OFF" : "ON"}
      </button>
      {show && (
        <ProgressiveImage src="/Images/high.jpg" placeholder="/Images/tiny.jpg">
          {(src, loading) => (
            <img
              className={`image${loading ? " loading" : " loaded"}`}
              src="/Images/high.jpg"
              alt="sea beach"
              width="1980"
              height="1086"
            />
          )}
        </ProgressiveImage>
      )}
    </div>
  );
};

export default Btn;
