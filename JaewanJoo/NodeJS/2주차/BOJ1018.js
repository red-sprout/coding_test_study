const fs = require('fs');
const input = fs.readFileSync('example.txt')
                .toString()
                .trim()
                .split('\n')
const [line, ...arr] = input.map((el) => el.trim());
const [n, m] = line.split(" ").map(Number);

let startB = n * m;
let startW = n * m;
for(let i = 0; i <= n - 8; i++) {
    for(let j = 0; j <= m - 8; j++) {
        let tmpB = 0;
        let tmpW = 0;
        for(let k = 0; k < 8; k++) {
            for(let l = 0; l < 8; l++) {
                if((k + l) % 2 == 0) {
                    if(arr[i + k][j + l] == 'B') tmpW++;
                    else tmpB++;
                } else {
                    if(arr[i + k][j + l] == 'W') tmpW++;
                    else tmpB++;
                }
            }
        }
        startB = Math.min(startB, tmpB);
        startW = Math.min(startW, tmpW);
    }
}

console.log(Math.min(startB, startW));