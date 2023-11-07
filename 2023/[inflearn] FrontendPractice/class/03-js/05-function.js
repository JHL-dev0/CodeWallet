function send1() {
    const token = String ( Math.floor ( Math.random() * 1000000 ) ).padStart(6, "0");
    document.getElementById('target').innerText = token

}

const send2 = () => {
    const token = String ( Math.floor ( Math.random() * 1000000 ) ).padStart(6, "0");
    document.getElementById('target').innerText = token
    document.getElementById('target').style.color = '#' + token;
}


