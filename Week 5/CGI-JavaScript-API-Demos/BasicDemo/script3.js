let arr = [10, 20, 30, 40, 50];

// let sum = 0;
// for (i = 0; i < arr.length; i++) {
//     sum = sum + arr[i];
// }

let sum = arr.reduce(function (prevValue, currValue) {
    return prevValue + currValue;
})

console.log(sum);


let arr2 = [10, 20, [30, 40, 50], [60, 70], [80]];
let result = arr2.reduce(function (prevValue, currValue) {
    return prevValue.concat(currValue);
}, []);

console.log(result);