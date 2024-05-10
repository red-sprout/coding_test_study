const fs = require('fs');
const input = fs.readFileSync('example.txt')
                .toString()
                .trim()
                .split('\n');
const [n, ...arr] = input.map(el => el.trim());

for(let t = 0; t < parseInt(n); t++) {
    const left = [];
    const right = [];
    for(let ele of arr[t]) {
        switch(ele) {
        case '<':
            if(left.length !== 0) right.push(left.pop());
            break;
        case '>':
            if(right.length !== 0) left.push(right.pop());
            break;
        case '-':
            if(left.length !== 0) left.pop();
            break;
        default:
            left.push(ele);
            break;
        }
    }

    let ans = "";
    while(left.length !== 0) {
        right.push(left.pop());
    }

    while(right.length !== 0) {
        ans += right.pop();
    }

    console.log(ans);
}