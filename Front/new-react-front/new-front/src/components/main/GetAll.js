import { useState, useImperativeHandle, forwardRef } from "react";
import ItemTable from "./ItemTable";

const GetAll = (props, ref) => {
  const [arr, setArr] = useState([{ id: 0, word: "미반영" }]);

  useImperativeHandle(ref, () => ({
    GetAll,
  }));

  const GetAll = () => {
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
        if (data.length === 0) {
          return;
        } else {
          setArr(data, ...arr);
        }
      });
  };

  return (
    <div>
      <button type="button" onClick={GetAll}>
        Load All Data
      </button>
      <ItemTable items={arr} onGetAll={GetAll} />
    </div>
  );
};

export default forwardRef(GetAll);
