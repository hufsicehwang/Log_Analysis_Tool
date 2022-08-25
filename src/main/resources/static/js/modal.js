var modals = document.getElementsByClassName("modal");
var btns = document.getElementsByClassName("btn");
var spanes = document.getElementsByClassName("close");
var funcs = [];

function Modal(num) {
  return function() {
    btns[num].onclick =  function() {
        modals[num].style.display = "block";
    };

    spanes[num].onclick = function() {
        modals[num].style.display = "none";
    };
  };
}

for(var i = 0; i < btns.length; i++) {
  funcs[i] = Modal(i);
}

for(var j = 0; j < btns.length; j++) {
  funcs[j]();
}

window.onclick = function(event) {
  if (event.target.className == "modal") {
      event.target.style.display = "none";
  }
};