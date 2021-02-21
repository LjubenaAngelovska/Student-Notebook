window.addEventListener('load', (event) => {
    console.log('predmeti page is fully loaded');

    const sesija = document.querySelectorAll(".td_sesija");
    const teor_prak = document.querySelectorAll(".teor_prak");
    const nacin = document.querySelectorAll(".nacin");
    const osvoeni_poeni = document.querySelectorAll(".osvoeni_poeni");
    const pol_polozen = document.querySelectorAll(".pol_polozen");

    for (i = 0; i < sesija.length; i++) {
        if (sesija[i].firstChild.textContent==="zimskiprv") {
            sesija[i].firstChild.textContent = "прв колоквиум";
        }
        else if (sesija[i].firstChild.textContent==="zimskivtor") {
            sesija[i].firstChild.textContent = "втор колоквиум";
        }
        else if (sesija[i].firstChild.textContent==="letenprv") {
            sesija[i].firstChild.textContent = "прв колоквиум";
        }
        else if (sesija[i].firstChild.textContent==="letenvtor") {
            sesija[i].firstChild.textContent = "втор колоквиум";
        }
        else if (sesija[i].firstChild.textContent==="januarska") {
            sesija[i].firstChild.textContent = "јануарска сесија";
        }
        else if (sesija[i].firstChild.textContent==="junska") {
            sesija[i].firstChild.textContent = "јунска сесија";
        }
        else if (sesija[i].firstChild.textContent==="septemvriska") {
            sesija[i].firstChild.textContent = "септемвриска сесија";
        }
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