
### Global Dependency 설치
```
npm install -g babel-cli nodemon cross-env
```
babel-cli: 콘솔 환경에서 babel 을 사용 할 수 있게 해줍니다 (ES6 transpile)
nodemon: development 환경에서 파일이 수정 될 때마다 서버를 재시작해줍니다
cross-env: 윈도우 / 리눅스 / OSX 에서 환경변수값을 설정합니다.

### Local Dependency 설치
```
npm install --save express body-parser  
```
express: Nodejs 웹 프레임워크
body-parser: JSON 형태의 데이터를 HTTP 요청에서 파싱 할 때 사용됩니다


### 스크립트 수정
"build" : "babel server --out-dir build --presets=es2015 && webpack",

npm run build 하며 서버사이드 스크립트르러 build 폴더에 transpile하여
저장하고 webpack을 통하여 클라이언트 코드를 build 합니다.
