// 조건문 실습 1

if(1+1 === 2) {
    console.log("정답입니다")
} else{
    console.log("틀렸습니다")
}
// VM361:2 정답입니다
// undefined

if(true) {
    console.log("정답입니다")
} else{
    console.log("틀렸습니다")
}
// VM397:2 정답입니다
// undefined

if(!true) {
    console.log("정답입니다")
} else {
    console.log("틀렸습니다")
}
// VM402:4 틀렸습니다
// undefined

if(0) {
    console.log("정답입니다")
} else {
    console.log("틀렸습니다")
}
// VM407:4 틀렸습니다
// undefined

// 조건문 실습 2
// 조건문을 활용하여 철수의 나이가 20세이상이면 "성인입니다", 
// 8세이상~19세이하면 "학생입니다", 7세이하면 "어린이입니다"를 출력하세요.
const profile = {
  name : "철수",
  age : 12,
  school : "다람쥐초등학교"
}
// undefined

if(profile.age > 20) {
  console.log("성인입니다")
} else if(profile.age >= 8){ // else if(profile.age >= 8 && profile.age <= 19){ 와 같은 의미
  console.log("학생입니다")
} else if (profile.age > 0){
  console.log("어린이입니다")
} else (
  console.log("나이를 다시 입력해주세요") // 에러 핸들링

)
// VM1378:4 학생입니다