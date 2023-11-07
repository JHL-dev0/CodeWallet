
let time = 10

// 10초에서 0초까지만 출력하는 코드를 작성하세요.
setInterval(function(){
    if(time >=0){
        console.log(time)
        time = time -1
    }
},1000)

// 10
// 9
// 8
// 7
// 6
// 5
// 4
// 3
// 2
// 1
// 0


