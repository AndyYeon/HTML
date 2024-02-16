function getArea(width, height){
    let area = width * height;
    return area;
}

let area1 = getArea(100, 200);

console.log(area1);

console.log(helloA()); //선언식 함수는 실행됌  **호이스팅
//console.log(helloB()); //표현식 함수는 실행되지 않음
//console.log(helloC()); //화살표 함수는 실행되지 않음 

//함수 표현식
let helloB = function(){
    return "hi";
};
//함수 선언식
function helloA(){
    return "hi";
};

//화살표 함수 
let helloC = () => 'hi';

console.log(helloB()); 
console.log(helloC()); 