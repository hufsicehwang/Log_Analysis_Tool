// host server 이름 붙여주기
let serverName = document.querySelectorAll('.dags-host-server-name');
for (let i = 0; i < serverName.length; i++) {
    let number = serverName[i].innerText;
    serverName[i].innerText = "server" + number;
}

// average time을 s, ms로 표기
let timeList = document.querySelectorAll('.time');
let timeArr = new Array();
for (let i = 0; i < timeList.length; i++) {
    timeArr.push(timeList[i].innerText);
}

for (let i = 0; i < timeList.length; i++) {
    if (parseInt(timeList[i].innerText) > 1000) {
        timeList[i].innerText = String(parseInt(timeList[i].innerText) / 1000) + "s";
    } else {
        timeList[i].innerText = String(timeList[i].innerText) + "ms";
    }

}

// count 총합, max count , max count의 name 지정
let countList = document.querySelectorAll('.count');
let sum = 0;
let max = 0;
let preMax = 0;
let maxName;
for (let i = 0; i < countList.length; i++) {
    sum += Number(countList[i].innerText);

    if (parseInt(countList[i].innerText) == max) {
        preMax = max;
    }
    if (parseInt(countList[i].innerText) > max) {
        max = parseInt(countList[i].innerText);
    }
}

for (let i = 0; i < countList.length; i++) {
    if (parseInt(countList[i].innerText) == max) {
        maxName = countList[i].parentNode.childNodes[1].innerText;
        break;
    }
}

if (preMax == max) {
    document.querySelector('.max-name').innerText = "The data are equivalent!"
} else {
    document.querySelector('.max-name').innerText = maxName;
}
document.querySelector('.max-count').innerText = max;
document.querySelector('.count-total').innerText = sum;

