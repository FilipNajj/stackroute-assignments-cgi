// window.alert('Hello World');
// window.confirm('Do you want to continue');

// document.write('Welcome to HTML & JavaScript')
function AddHeading() {
    const heading = document.createElement('h1');
    heading.innerHTML = 'Welcome to DOM';
    heading.style.color = 'Red';
    document.getElementById('container').appendChild(heading);
}

fetch('https://jsonplaceholder.typicode.com/users')
    .then(res => res.json())
    .then(data => {
        data.map(item => {
            const li = document.createElement('li');
            li.innerHTML = item.name;
            li.className = 'list-group-item';
            document.getElementById('userlist').appendChild(li);
        });
    });

fetch('https://jsonplaceholder.typicode.com/users')
    .then(res => res.json())
    .then(data => {
        data.map(item => {
            const row = document.createElement('tr');
            row.innerHTML = `<td>${item.id}</td><td>${item.name}</td><td>${item.email}</td><td>${item.company.name}</td><td>${item.phone}</td>`
            document.getElementById('usertable').appendChild(row);
        });
    });