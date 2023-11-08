let isStarted = false;


let auth = () => {

    if(isStarted === false){
        // 타이머가 작동중이 아닐때
        isStarted = true;
        document.getElementById('button').disabled = false;
        const token = String ( Math.floor ( Math.random() * 1000000 ) ).padStart(6, "0");
        document.getElementById('target').innerText = token
        
        // let time = 180;
        let time = 5; // 5초로 테스트
        let timer;

        timer = setInterval(function(){
            if(time >= 0){
                let min = Math.floor( time / 60 );
                let sec = String(time % 60).padStart(2, "0")
                document.getElementById('timer').innerText = (min + ":" + sec)
                time = time - 1;
            } else {
                document.getElementById('timer').innerText = "시간초과"
                document.getElementById('button').disabled = true;
                isStarted = false;
                console.log("타이머 종료")
                clearInterval(timer) // setInterval을 종료시키는 함수
            }
        }, 1000)
    
    }else{
        // 타이머가 작동중일때
    }


}



// let time = 180;

// setInterval(function(){
//     if(time >=0) {
//         let min = Math.floor( time / 60 );
//         let sec = String(time % 60).padStart(2, "0")
//         console.log(min + ":" + sec)
//         time = time - 1;
//     }
// }, 1000)