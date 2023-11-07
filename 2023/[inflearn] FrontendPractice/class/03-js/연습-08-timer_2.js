let time = 180;

setInterval(function(){
    if(time >=0) {
        let min = Math.floor( time / 60 );
        let sec = String(time % 60).padStart(2, "0")
        console.log(min + ":" + sec)
        time = time - 1;
    }
}, 1000)

// 3:00
// 2:58
// 2:59
// 2:57
// 2:56
// ...
// 0:00