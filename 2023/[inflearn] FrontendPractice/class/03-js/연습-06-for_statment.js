// 실습 1
let persons = [
    {name : "철수", age : 17},
    {name : "영희", age : 22},
    {name : "도우너", age : 5},
    {name : "그루트", age : 65},
    {name : "도비", age : 3}
  ]

for (let count = 0; count < persons.length; count++) {
  if (persons[count].age >= 19) {
      console.log("성인입니다")
  } else {
      console.log("미성년자입니다")
  }
}
  
// >> 미성년자입니다
// >> 성인입니다
// >> 미성년자입니다
// >> 성인입니다
// >> 미성년자입니다

for (let count = 0; count < persons.length; count++) {
  if (persons[count].age >= 19) {
      console.log(persons[count].name + "님은 성인입니다")
  } else {
      console.log(persons[count].name + "님은 미성년자입니다")
  }
}
  
// >> 철수님은 미성년자입니다
// >> 영희님은 성인입니다
// >> 도우너님은 미성년자입니다
// >> 그루트님은 성인입니다
// >> 도비님은 미성년자입니다


// 실습 2
const fruits = [
  { number : 1, title : "레드향" },
  { number : 2, title : "샤인머스켓" },
  { number : 3, title : "산청딸기" },
  { number : 4, title : "한라봉" },
  { number : 5, title : "사과" },
  { number : 6, title : "애플망고" },
  { number : 7, title : "딸기" },
  { number : 8, title : "천혜향" },
  { number : 9, title : "과일선물세트" },
  { number : 10, title : "귤" },
]

for (let i = 0; i < fruits.length; i++) {
  console.log(fruits[i].number + " " + fruits[i].title);
}
// >> 1 레드향
// >> 2 샤인머스켓
// >> 3 산청딸기
// >> 4 한라봉
// >> 5 사과
// >> 6 애플망고
// >> 7 딸기
// >> 8 천혜향
// >> 9 과일선물세트
// >> 10 귤

// 템플릿 문자열
for (let i = 0; i < fruits.length; i++) {
  console.log(`${fruits[i].number} ${fruits[i].title}`);
}
// >> 1 레드향
// >> 2 샤인머스켓
// >> 3 산청딸기
// >> 4 한라봉
// >> 5 사과
// >> 6 애플망고
// >> 7 딸기
// >> 8 천혜향
// >> 9 과일선물세트
// >> 10 귤