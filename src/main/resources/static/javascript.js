const vnesi_polaganje_html = `<div class="second_menu" id="second_menu">

                <div>
                    <label for="predmet_polag">Предмет
                        <input type="text" id="predmet_polag" name="predmet_polag">
                    </label>
                </div>

                <div>
                    <label for="date_polag">Датум<br>
                        <input type="date" id="date_polag" name="date_polag">
                    </label>
                </div>

                <div>
                    <label for="ses_polag">Колоквиум/сесија
                        <select name="ses_polag" id="ses_polag">
                            <option value="kol_prv">прв колоквиум</option>
                            <option value="kol_vtor">втор колоквиум</option>
                            <option value="ses_jan">јануарска сесија</option>
                            <option value="ses_jun">јунска сесија</option>
                            <option value="ses_sept">септемвриска сесија</option>
                        </select>
                    </label>
                </div>

                <div class="rbt">
                    <input type="radio" id="t_polag" name="tip_polag" value="teorija">
                    <label for="t_polag">Теорија</label>
                    <input type="radio" id="z_polag" name="tip_polag" value="zadaci">
                    <label for="z_polag">Задачи</label><br>
                </div>

                <div class="rbt">
                    <input type="radio" id="onl_polag" name="nacin_polag" value="online">
                    <label for="onl_polag">Online</label>
                    <input type="radio" id="ziv_polag" name="nacin_polag" value="vozivo">
                    <label for="ziv_polag">Во живо</label><br>
                </div>

                <div>
                    <button id="vnesi_polag" onclick="vnesiPolagFunc()">Внеси полагање</button>
                </div>

            </div>`;


const vnesi_predavanje_html = `<div class="second_menu" id="second_menu">

                <div>
                    <label for="predmet_polag">Предмет
                        <input type="text" id="predmet_polag" name="predmet_polag">
                    </label>
                </div>

                <div>
                    <label for="date_polag">Одржано на датум<br>
                        <input type="date" id="date_polag" name="date_polag">
                    </label>
                </div>

                <div class="rbt rbt1">
                    <input type="radio" id="pred" name="pred_aud" value="predavanje">
                    <label for="pred">Предавање</label>
                    <input type="radio" id="aud" name="pred_aud" value="auditoriski">
                    <label for="aud">Аудиториски</label><br>
                </div>

                <div class="slider1">
                  <input type="range" id="status_predaud" name="status_predaud" min="0" max="100" value="0" step="10">
                  <label for="status_predaud">%</label>
                </div>

                <div>
                    <button id="vnesi_polag" onclick="vnesiPolagFunc()">Внеси полагање</button>
                </div>

            </div>`;


window.addEventListener('load', (event) => {
    console.log('page is fully loaded');

    const dodadiPolaganje = document.getElementById('dodadiPolaganje');
    const dodadiPredavanje = document.getElementById('dodadiPredavanje');
    const dodadiDomasno = document.getElementById('dodadiDomasno');
    const dodadiZabeleska = document.getElementById('dodadiZabeleska');

    const vnesi_polag = document.getElementById('vnesi_polag');

    // + Полагање
    dodadiPolaganje.addEventListener("click", function() {
        document.getElementById('add_menu').classList.add('invisiblemenu');
        document.getElementById('vtor_desen_content').classList.remove('invisiblemenu');

        // vo const vnesi_polaganje_html e celiot html za formata za dodavanje polaganje
        document.getElementById('vtor_desen_content').innerHTML = vnesi_polaganje_html;
    });

    // + Предавање
    dodadiPredavanje.addEventListener("click", function() {
        document.getElementById('add_menu').classList.add('invisiblemenu');
        document.getElementById('vtor_desen_content').classList.remove('invisiblemenu');

        // vo const vnesi_predavanje_html e celiot html za formata za dodavanje predavanje
        document.getElementById('vtor_desen_content').innerHTML = vnesi_predavanje_html;
    });

    // + Домашно
    dodadiDomasno.addEventListener("click", function() {
        alert('clicked domasno');
    });

    // + Забелешка
    dodadiZabeleska.addEventListener("click", function() {
        alert('clicked zabeleska');
    });
});

// click button ВНЕСИ ПОЛАГАЊЕ
function vnesiPolagFunc() {
    document.getElementById('vtor_desen_content').classList.add('invisiblemenu');
    document.getElementById('add_menu').classList.remove('invisiblemenu');
}


