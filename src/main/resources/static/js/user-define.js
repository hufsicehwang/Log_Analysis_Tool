let countList = document.querySelectorAll('.count');
let sum=0;
for(let i =0; i<countList.length;i++){
    sum += Number(countList[i].innerText);
}

document.querySelector('.count-total').innerText = sum;

let serverName = document.querySelectorAll('.dags-host-server-name');
for(let i =0; i<serverName.length;i++){
    let number =  serverName[i].innerText;
    serverName[i].innerText = "server"+number;
}