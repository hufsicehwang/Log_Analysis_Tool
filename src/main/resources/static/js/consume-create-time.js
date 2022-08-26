// consumed time, created at time 통계 최댓값, label 구하기
let countList = document.querySelectorAll('.count');
let labelList = document.querySelectorAll('.label');
let max = 0;
let maxName;

for (let i = 0; i < countList.length; i++) {
    if (parseInt(countList[i].innerText) > max) {
        max = parseInt(countList[i].innerText);
    }
}

for (let i = 0; i < countList.length; i++) {
    if (parseInt(countList[i].innerText) == max) {
        maxName = labelList[i].innerText;
        break;
    }
}

document.querySelector('.max-name').innerText = maxName;
document.querySelector('.max-count').innerText = max;