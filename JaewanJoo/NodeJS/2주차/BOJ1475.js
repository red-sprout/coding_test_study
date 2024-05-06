const fs = require('fs');
const input = fs.readFileSync('example.txt')
                .toString()
                .trim();

let arr = [];
for(let i = 0; i < 10; i++) {
    arr[i] = 0;
}

for(let i of input) {
    let idx = parseInt(i);
    if(idx === 6) {
        arr[6] > arr[9] ? arr[9]++ : arr[6]++;
    } else if(idx === 9) {
        arr[6] < arr[9] ? arr[6]++ : arr[9]++;
    } else {
        arr[idx]++
    }
}

console.log(Math.max(...arr));