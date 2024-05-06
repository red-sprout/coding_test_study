const fs = require("fs");
const input = fs.readFileSync("example.txt")
                .toString()
                .trimEnd()
                .split("\n");

const first = input[0].split(" ").map(Number);
const n = first[0];
const m = first[1];

const arr = input[1].split(" ").map(Number);

let max = 0;
for(let i = 0; i < n - 2; i++) {
    for(let j = i + 1; j < n - 1; j++) {
        for(let k = j + 1; k < n; k++) {
            let tmp = arr[i] + arr[j] + arr[k];
            if(tmp <= m && tmp > max) max = tmp;
            if(max == m) break;
        }
    }
}

console.log(max);