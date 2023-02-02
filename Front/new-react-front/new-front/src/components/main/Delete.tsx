import React from "react";

interface item {
  key : number;
  onParentGetAll(): void;
  data: { 
    id: number;
    word : string; 
  } ;
  id: number;
  word: string;
}

interface dataID {
  target: { dataset: { id: number; } } ;
}

const Delete = (props: item) => {
  const deleteOne = (e:any) => {
    const id = e.target.dataset.id;

    fetch("/content/minus", {
      method: "DELETE",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({ id: id }),
    })
      .then((response) => {
        return response.text();
      })
      .then((data) => {
        if (data == "Fail") {
          alert(data);
        }
        console.log(data);
        props.onParentGetAll();
      });
  };

  return (
    <tr>
      <td>{props.data.id}</td>
      <td>{props.data.word}</td>
      <td>
        <button type="button" onClick={deleteOne} data-id={props.data.id}>
          삭제
        </button>
      </td>
    </tr>
  );
};

export default Delete;
