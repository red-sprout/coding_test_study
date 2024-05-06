# 준비
- Node.js 다운로드
- VS code 다운로드
- Code Runner 익스텐션 다운로드

# 폴더 생성
- 폴더 안에 `example.txt` 파일과 `js` 파일 생성

# 작성 법
- 테스트 코드 작성시 readFileSync 경로를 `readFileSync('example.txt')`로 변경하여 작성
- 제출할 때는 `readFileSync('/dev/stdin')`으로 수정하여 제출

# 예시
## 백준 1000번 A + B
```javascript
const fs = require('fs');
const inputData = fs.readFileSync('/dev/stdin') // Buffer 객체 생성
                    .toString() // 문자열 치환
                    .trimEnd() // 문자열 끝 개행문자 제거
                    .split(' ') // 나누는 기준
                    .map(value => +value);

const [a, b] = inputData;

console.log(a + b);
```

# 입력 예시
## N개의 정수를 한 줄로 입력 받았을 경우
```javascript
const fs = require('fs');
const input = fs.readFileSync('/dev/stdin')
                .toString()
                .trimEnd()
                .split(' ');
```
## N개의 정수를 한 줄로 입력 받아 List에 저장할 경우
```javascript
const fs = require('fs');
const input = fs.readFileSync('/dev/stdin')
                .toString()
                .trimEnd()
                .split(' ')
                ,map(Number); // 내부의 문자열을 number 타입으로 변환시킴.
```
## N개의 정수를 여러 줄로 입력 받아 List에 저장할 경우
```javascript
const fs = require('fs');
const input = fs.readFileSync('/dev/stdin')
                .toString()
                .trimEnd()
                .split('\n');
```
## N개의 정수를 여러 줄로 입력 받아 이차원 배열에 저장할 경우
```javascript
const fs = require('fs');
const input = fs.readFileSync('/dev/stdin')
                .toString()
                .trimEnd()
                .split('\n')
                .map((row) => row.split(' ').map(Number)); 
                // 공백으로 주어진 문자열을 쪼개어 배열 생성
```
# 출처
- https://velog.io/@bomida/JS-%EC%BD%94%EB%94%A9-%ED%85%8C%EC%8A%A4%ED%8A%B8-%EC%A4%80%EB%B9%84-%EC%BD%94%ED%85%8C-%ED%99%98%EA%B2%BD-%EC%84%B8%ED%8C%85
- https://velog.io/@rookieand/Node.js-%EC%BD%94%EB%94%A9-%ED%85%8C%EC%8A%A4%ED%8A%B8-%EC%9E%85%EB%A0%A5