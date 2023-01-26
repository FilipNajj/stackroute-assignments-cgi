function AddContact() {
    fetch('http://localhost:3000/contacts', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            firstname: document.getElementById('firstname').value,
            lastname: document.getElementById('lastname').value,
            email: document.getElementById('email').value,
            city: document.getElementById('city').value,
            phone: document.getElementById('phone').value,
        })
    }).then(res => GetContacts());
}

function GetContacts() {
    fetch('http://localhost:3000/contacts')
        .then(res => res.json())
        .then(data => {
            data.map(item => {
                const div = document.createElement('div');
                div.innerHTML = `<div class="col-md-4 mt-2">
                <div class="card">        
                <div class="card-body">
                <i onclick="DeleteContact(${item.id})" class="fa-solid fa-lg fa-trash-can mt-3 float-end text-danger"></i>
                <i onclick="GetContact(${item.id})" class="fa-solid fa-lg fa-pencil mt-3 px-3 float-end text-primary"></i>
                  <h5 class="card-title">${item.firstname} ${item.lastname}</h5>
                  <p class="card-text">${item.email}</p>
                  <p class="card-text">${item.city}</p>
                  <p class="card-text">${item.phone}</p>
                </div>
              </div>
              </div>`
                document.getElementById('contactlist').appendChild(div);
            })
        });
}

function DeleteContact(id) {
    fetch(`http://localhost:3000/contacts/${id}`, {
        method: 'DELETE'
    }).then(res => GetContacts());
}

let contactId;
function GetContact(id) {
    contactId = id;
    fetch(`http://localhost:3000/contacts/${id}`)
        .then(res => res.json())
        .then(data => {
            document.getElementById('firstname').value = data.firstname;
            document.getElementById('lastname').value = data.lastname;
            document.getElementById('email').value = data.email;
            document.getElementById('city').value = data.city;
            document.getElementById('phone').value = data.phone;
        });
}

function UpdateContact() {
    fetch(`http://localhost:3000/contacts/${contactId}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            firstname: document.getElementById('firstname').value,
            lastname: document.getElementById('lastname').value,
            email: document.getElementById('email').value,
            city: document.getElementById('city').value,
            phone: document.getElementById('phone').value,
        })
    }).then(res => GetContacts());
}


GetContacts();