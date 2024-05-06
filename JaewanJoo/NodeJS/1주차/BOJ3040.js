const fs = require("fs");
const input = fs.readFileSync("example.txt")
                .toString()
                .trim()
                .split("\n")
                .map(Number);
const sum = input.reduce((p, n) => p + n, 0);
let first = 0;
let second = 1;

for(let i = 0; i < 8; i++) {
    for(let j = i + 1; j < 9; j++) {
        if(sum - input[i] - input[j] === 100) {
            first = i;
            second = j;
            break;
        }
    }
}

console.log(input.filter((num, index, target) =>
    target.indexOf(num) !== first && target.indexOf(num) !== second
).join("\n"));