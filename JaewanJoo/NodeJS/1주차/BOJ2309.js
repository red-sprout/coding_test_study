const fs = require("fs");
const input = fs.readFileSync("example.txt")
                .toString()
                .trimEnd()
                .split("\n")
                .map(Number);
input.sort((a, b) => a > b ? 1 : -1);

let sum = input.reduce((p, n) => p + n, 0);
let first = 0;
let last = 8;

while(true) {
    const result = sum - input[first] - input[last];
    if(result === 100) break;

    if(result > 100) {
        first++;
    } else if(result < 100) {
        last--;
    }
}

console.log(input.filter(
        (el, index, target) => 
        target.indexOf(el) !== first && target.indexOf(el) !== last
    ).join("\n")
);