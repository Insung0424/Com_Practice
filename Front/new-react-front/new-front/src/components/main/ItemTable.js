import React from "react";

import Delete from "./Delete";

const ItemTable = (props) => {
  return (
    <table>
      <thead>
        <tr>
          <td>ID</td>
          <td>Word</td>
          <td>button</td>
        </tr>
      </thead>
      <tbody>
        {props.items.map((item) => (
          <Delete key={Math.random()} data={item} onParentGetAll={props.onGetAll}/>
        ))}
      </tbody>
    </table>
  );
};

export default ItemTable;
