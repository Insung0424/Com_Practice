import '../index.css';

const Img = ({Url, imgUrl, altDes}) => (
    <div>
      <br></br>
      <a href={Url} >
        <img src={imgUrl} alt={altDes} />
      </a>
    </div>
);

Img.defaultProps = {
  Url : "testbackpage.com",
  imgUrl : '/images/Hello_World.png',
  altDes : 'Hello_World.png'
}

export default Img;