function send1() {
    const token = String ( Math.floor ( Math.random() * 1000000 ) ).padStart(6, "0");
    document.getElementById('target').innerText = token
    
    // let time = 180;
    let time = 5; // 5초로 테스트
    setInterval(function(){
        if(time == 0){
            document.getElementById('timer').innerText = "시간초과"
            document.getElementById('button').disabled = true;
        } else {
            let min = Math.floor( time / 60 );
            let sec = String(time % 60).padStart(2, "0")
            document.getElementById('timer').innerText = (min + ":" + sec)
            time = time - 1;
        }
    }, 1000)

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