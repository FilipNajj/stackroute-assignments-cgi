// Functions in JavaScript
// Function Declaration
function sayHello() {
    console.log('Hello World');
}

// Function Call
sayHello();

const SayHello = () => {
    console.log('Hello Again to World');
}

SayHello();

const Sayhello = (name) => {
    console.log(`Hello ${name}`);
}

Sayhello('John');
Sayhello('James');

const Factorial = (num) => {
    let fact = 1;
    for (let i = 1; i <= num; i++) {
        fact = fact * i;
    }
    return fact;
}

let res = Factorial(7);
console.log(res);