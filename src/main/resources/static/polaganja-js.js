window.addEventListener('load', (event) => {
    console.log('predmeti page is fully loaded');

    const sesija = document.querySelectorAll(".td_sesija");
    const teor_prak = document.querySelectorAll(".teor_prak");
    const nacin = document.querySelectorAll(".nacin");
    const osvoeni_poeni = document.querySelectorAll(".osvoeni_poeni");
    const pol_polozen = document.querySelectorAll(".pol_polozen");

    for (i = 0; i<sesija.length; i++) {

        var temp1 = sesija[i].textContent.split("="); // втор колоквиум 2020, sesKol
        var temp2 = temp1[2].split(","); // втор колоквиум 2020

        //Sesija(id=5, opis=втор колоквиум 2020, sesKol=vtorkol, datumOd=2020-01-16, datumDo=2020-01-23)

        sesija[i].firstChild.textContent = temp2[0];
    }

    for (i = 0; i < teor_prak.length; i++) {
        if (teor_prak[i].firstChild.textContent==='t') {
            teor_prak[i].firstChild.textContent = "теорија";
        }
        else if (teor_prak[i].firstChild.textContent==='p') {
            teor_prak[i].firstChild.textContent = "практично";
        }
    }

    for (i = 0; i < nacin.length; i++) {
        if (nacin[i].firstChild.textContent==='1') {
            nacin[i].firstChild.textContent = "online";
        }
        else if (nacin[i].firstChild.textContent==='0') {
            nacin[i].firstChild.textContent = "во живо";
        }
    }

    for (i = 0; i < osvoeni_poeni.length; i++) {
        if (osvoeni_poeni[i].firstChild.textContent==0) {
            osvoeni_poeni[i].firstChild.textContent = "-";
        }
    }

    for (i = 0; i < pol_polozen.length; i++) {
        if (pol_polozen[i].firstChild.textContent==='y') {
            pol_polozen[i].innerHTML = '<i class=\'fas fa-check-circle check_icon\'></i>';
        }
        else if (pol_polozen[i].firstChild.textContent==='n') {
            pol_polozen[i].innerHTML = '<i class=\'fas fa-times-circle cross_icon\'></i>';
        }
        else if (pol_polozen[i].firstChild.textContent==='x') {
            pol_polozen[i].innerHTML = '<i class=\'far fa-circle empty_icon\'></i>';
        }

    }
});



function openNav() {
    document.getElementById("myNav").style.width = "32%";
}

function closeNav() {
    document.getElementById("myNav").style.width = "0%";
}