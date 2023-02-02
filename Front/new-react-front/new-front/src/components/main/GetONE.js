const GetONE = () => {
  const getOne = () => {
    const one = document.getElementById('rValue');
        let arr = [];

        fetch('/content/list' , {
            method: 'GET',
            headers: {
              'Content-Type': 'application/json',
            },
          })
          .then( (response) => {
              return response.json();
          })
          .then((data) => {
                data.map((item)=>{
                    arr.push(item.id);
                });
                let id = Math.floor(Math.random() * arr.length);
                fetch('/content/one/'+ arr[id] , {
                    method: 'GET',
                    headers: {
                      'Content-Type': 'application/json',
                    },
                  })
                  .then( (response) => {
                      return response.json();
                  })
                  .then((data) => {
                      one.value = data.word;
                  });
          });
  }

    return (
        <div>
          Get Random Value : <input type="text" id="rValue" disabled />
          <button type="button" onClick={getOne}>
            Load one data
          </button>
        </div>
    );
};

export default GetONE;