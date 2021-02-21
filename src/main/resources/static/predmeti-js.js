window.addEventListener('load', (event) => {
    console.log('predmeti page is fully loaded');

    const zadolzitelni = document.querySelectorAll(".td_zadolzitelen");
    const ocenki = document.querySelectorAll(".td_ocenka");
    const polozen = document.querySelectorAll(".td_polozen");

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

    for (i = 0; i<polozen.length; i++) {
        if (polozen[i].firstChild.textContent==='1') {
            polozen[i].innerHTML = '<i class=\'fas fa-check-circle check_icon\'></i>';
        }
        else if (polozen[i].firstChild.textContent==='0') {
            polozen[i].innerHTML = '<i class=\'fas fa-times-circle cross_icon\'></i>';
        }
    }

});

function openNav() {
    document.getElementById("myNav").style.width = "32%";
}

function closeNav() {
    document.getElementById("myNav").style.width = "0%";
}