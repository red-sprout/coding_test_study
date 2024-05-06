const fs = require('fs');
const input = fs.readFileSync('example.txt')
                .toString()
                .trimEnd()
                .split(' ')
                .map(Number);

const [a, b] = input;
console.log(a - b);