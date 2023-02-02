import { useRef } from "react";
import GetONE from "./main/GetONE";
import GetAll from "./main/GetAll";
import PostData from "./main/PostData";

const Main = () => {

  const callGetAllRef = useRef();

  const sendGetAll = () => {
    callGetAllRef.current.GetAll();
  }

  return (
    <main>
      <section>
        <GetONE />
      </section>
      <section>
        <GetAll ref={callGetAllRef}/>
      </section>
      <section>
        <PostData onTakeGetAll={sendGetAll}/>
      </section>
    </main>
  );
};

export default Main;
