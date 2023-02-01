import GetONE from "./main/GetONE";
import GetAll from "./main/GetAll";
import PostData from "./main/PostData";

const Main = () => {
  return (
    <main>
      <section>
        <GetONE />
      </section>
      <section>
        <GetAll />
      </section>
      <section>
        <PostData />
      </section>
    </main>
  );
};

export default Main;
