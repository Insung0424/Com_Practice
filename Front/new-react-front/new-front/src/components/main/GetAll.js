import Delete from "./Delete";

const GetAll = () => {
  const GetAll = () => {
    const DataList = document.getElementById("AllDataList");
    const arr = [];

    fetch("/content/list", {
      method: "GET",
      headers: {
        "Content-Type": "application/json",
      },
    })
      .then((response) => {
        return response.json();
      })
      .then((data) => {
        data.map((item) => {
          arr.push(item);
        });
        console.log(arr);

        if (arr.length == 0) {
          return;
        } else {
          arr.map((item) => {
            <Delete key={item.id} item={item} />;
          });
        }
      });
  };

  return (
    <div>
      <span id="AllDataList"></span>
      <button type="button" onClick={GetAll}>
        Load all data
      </button>
    </div>
  );
};

export default GetAll;
