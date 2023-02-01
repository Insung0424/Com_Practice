const Delete = (props) => {
  const deleteOne = (e) => {
    const id = e.dataset.id;

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
        //   GetAll();
      });
  };

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
        <tr>
          <td>{props.item.id}</td>
          <td>{props.item.word}</td>
          <td>
            <button type="button" onClick={deleteOne} data-id={props.item.id}>
              삭제
            </button>
          </td>
        </tr>
      </tbody>
    </table>
  );
};

export default Delete;
