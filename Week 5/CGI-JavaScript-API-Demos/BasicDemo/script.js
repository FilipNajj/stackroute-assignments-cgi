console.log('Welcome to JavaScript');

// Data Types in JavaScript
// 1. Primitive Types - string, boolean, number, undefined, null
// 2. Non Primitive Types - Object, Array

// To define variables we can use keywords - let, var, const

// let num = 10;
// num = "Hello";
// console.log(num);

// const username = "John";
// username = "James";


let username = 'Peter';
let age = 30;
console.log(typeof(username));

console.log('Hey ' + username + '. Your age is ' + age);
// String interpolation syntax
console.log(`Hey ${username}. Your age is ${age}`);

// Conditional Constructs
// if..else, Switch...case

// let num = 5;
// if (num % 2 == 0) {
//     console.log('Number is even');
// } else {
//     console.log('Number is odd');
// }

// let x = 30, y = 30;
// if (x > y) {
//     console.log('X is greater');
// } else if (y > x) {
//     console.log('Y is greater');
// } else {
//     console.log('Both are equal');
// }

// let day = 3;
// switch (day) {
//     case 1: {
//         console.log('Monday');
//         break;
//     }
//     case 2: {
//         console.log('Tuesday');
//         break;
//     }
//     case 3: {
//         console.log('Wednesday');
//         break;
//     }
//     case 4: {
//         console.log('Thursday');
//         break;
//     }
//     case 5: {
//         console.log('Friday');
//         break;
//     }
//     case 6: {
//         console.log('Saturday');
//         break;
//     }
//     case 7: {
//         console.log('Sunday');
//         break;
//     }
//     default: {
//         console.log('Wrong Choice');
//     }
// }

// Iterative Constructs / Loops
// for, while, do...while

// for (let i = 10; i >= 1; i--) {
//     console.log(i);
// }

// let i = 1;
// while (i <= 10) {
//     i++;
//     console.log(i);
// }

// let i = 1;

// do {
//     console.log(i);
//     i++;
// } while (i <= 10)

let arr = [10, 20, 30, 40, 50];
console.log(arr);

let arr1 = [];
arr[0] = 10;
arr[1] = 20;
console.log(arr);

let arr2 = [10, 'Hello', true];
console.log(arr2);

// Declaring javascript object
let person = {
    firstname: 'Peter',
    lastname: 'Parker',
    age: 25,
    isMarried: false,
    showName: function () {
        console.log(`${this.firstname} ${this.lastname}`);
    }
}

console.log(person.lastname);
person.showName();

let persons = [
    { id: 1, firstname: 'Peter', lastname: 'Parker', email: 'Peter@gmail.com', age: 25 },
    { id: 2, firstname: 'Steven', lastname: 'Strange', email: 'Steven@gmail.com', age: 27 },
    { id: 3, firstname: 'James', lastname: 'Cameron', email: 'James@gmail.com', age: 21 },
    { id: 4, firstname: 'Tony', lastname: 'Stark', email: 'Tony@gmail.com', age: 28 },
]

for (let user of persons) {
    console.log(user.firstname);
}

let fruits = ['Apple', 'Banana', 'Cherry', 'Orange', 'Grapes'];
fruits.push('Papaya');
fruits.unshift('Strawberry');
console.log(fruits);

console.log(fruits.length);
fruits.splice(0, 2);
console.log('After removing');
console.log(fruits);

console.log(fruits.pop());
console.log(fruits);

fruits.splice(1, 1, "Apple");
console.log(fruits);

let result = persons.filter(item => item.age > 25);
console.log(result);

let res = persons.find(item => item.id == 1);
console.log(res);

console.log(fruits);

// Spread Operator in JavaScript
let fruits2 = ['Papaya', 'Guava', 'Kiwi'];
fruits = [...fruits, fruits2];
console.log(fruits);

let product = { name: 'Laptop', brand: 'Dell', price: 56000 };
product = { ...product, id: 1 };
console.log(product);