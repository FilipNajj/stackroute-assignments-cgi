async function GetData() {
   await fetch('https://jsonplaceholder.typicode.com/users')
        .then(res => res.json())
        .then((data) => console.log(data))
        .catch((err) => console.log(err));

    console.log('Task Completed');
}

GetData();