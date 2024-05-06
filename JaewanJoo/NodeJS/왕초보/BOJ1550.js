const fs = require('fs');
const input = fs.readFileSync('example.txt')
                .toString()
                .trimEnd();

const a = parseInt(input, 16);
console.log(a);