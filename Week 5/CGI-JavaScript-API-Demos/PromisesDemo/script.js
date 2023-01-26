// let prm = new Promise((resolve, reject) => {
//     let isCompleted = false;
//     if (isCompleted) {
//         resolve('Task Completed');
//     } else {
//         reject('Error Occurred');
//     }
// });

// prm.then((data) => {
//     console.log(data);
// }).catch((err) => {
//     console.log(err);
// })

let items = ['Item1', 'Item2'];

const AddItem = (item) => {
    return new Promise((resolve, reject) => {
        setTimeout(() => {
            let isCompleted = true;
            items.push(item);
            if (isCompleted) {
                resolve('Task Completed');
            } else {
                reject('Error Occurred');
            }
        }, 2000);
    });
}

const GetItems = () => {
    items.map(item => console.log(item));
}

// AddItem('Item3')
//     .then((data) => {
//         console.log(data);
//         GetItems();
//     })
//     .catch((err) => console.log(err));
async function RunTasks() {
    await AddItem('Item3');
    GetItems();
}

RunTasks();