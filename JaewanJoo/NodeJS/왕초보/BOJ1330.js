const fs = require('fs');
const input = fs.readFileSync('example.txt')
                .toString()
                .trimEnd('\n')
                .split(' ')
                .map(Number);
const [a, b] = input;

if(a > b) {
    console.log(">");
} else if(a < b) {
    console.log("<");
} else {
    console.log("==");
}