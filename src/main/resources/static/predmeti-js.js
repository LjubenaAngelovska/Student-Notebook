window.addEventListener('load', (event) => {
    console.log('predmeti page is fully loaded');

    const zadolzitelni = document.querySelectorAll(".td_zadolzitelen");
    const ocenki = document.querySelectorAll(".td_ocenka");

    for (i = 0; i < zadolzitelni.length; i++) {
        if (zadolzitelni[i].firstChild.textContent==='1') {
            zadolzitelni[i].firstChild.textContent = "З";
        } else {
            zadolzitelni[i].firstChild.textContent = "И";
        }
    }

    for (i = 0; i<ocenki.length; i++) {
        if (ocenki[i].firstChild.textContent==5) {
            ocenki[i].firstChild.textContent = '-';
        }
    }


});
// click button + kaj Семестар
function dodadiSemestar() {
    alert("clicked");
}


function openNav() {
    document.getElementById("myNav").style.width = "32%";
}

function closeNav() {
    document.getElementById("myNav").style.width = "0%";
}