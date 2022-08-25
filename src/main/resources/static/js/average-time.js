// API type, workflow 통계시 average time 최댓갑, label 구하기
let timeMax =0;

for(let i =0; i<timeArr.length;i++){
    if(parseInt(timeArr[i])>timeMax){
        timeMax = timeArr[i];
    }
}
let timeMaxName;
for(let i =0; i<timeArr.length;i++){
    if(parseInt(timeArr[i])==timeMax){
        timeMaxName = timeList[i].parentNode.childNodes[1].innerText;
        break;
    }
}

document.querySelector('.time-max-name').innerText = timeMaxName;
document.querySelector('.time-max').innerText = (timeMax / 1000)+"s";