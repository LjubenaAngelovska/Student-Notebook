/*
const vnesi_polaganje_html = `<div class="second_menu" id="second_menu">

                <div>
                    <label for="predmet_polag">Предмет
                        <input type="text" id="predmet_polag" name="predmet_polag">
                    </label>
                </div>

                <div>
                    <label for="all_predmeti">Предмет
                        <select name="all_predmeti" id="all_predmeti" class="dd">
                            <option th:each="predmet : ${predmeti}"
                                    th:text="${predmet.getPredmetFinki().getIme()}"
                                    th:value="${predmet.getId()}">
                            </option>
                        </select>
                    </label>
                </div>

                <div>
                    <label for="date_polag">Датум<br>
                        <input type="date" id="date_polag" name="date_polag">
                    </label>
                </div>

                <div>
                    <label for="ses_polag">Колоквиум/сесија
                        <select name="ses_polag" id="ses_polag" class="dd">
                            <option value="kol_prv">прв колоквиум</option>
                            <option value="kol_vtor">втор колоквиум</option>
                            <option value="ses_jan">јануарска сесија</option>
                            <option value="ses_jun">јунска сесија</option>
                            <option value="ses_sept">септемвриска сесија</option>
                        </select>
                    </label>
                </div>

                <div style="width: 6em; position: absolute">
                    <label for="tip_polag">
                        <select name="tip_polag" id="tip_polag" class="dd">
                            <option value="teorija">теорија</option>
                            <option value="prakticno">практично</option>
                        </select>
                    </label>
                </div>

                <div style="width: 6em; position: relative; left: 7em">
                    <label for="nacin_polag">
                        <select name="nacin_polag" id="nacin_polag" class="dd">
                            <option value="online">online</option>
                            <option value="vozivo">во живо</option>
                        </select>
                    </label>
                </div>

                <div class="temp2" style="position: relative">
                    <input type="checkbox" id="polozen_cb" name="polozen_cb">
                    <label for="polozen_cb">Положен</label>
                </div>

                <div class="temp2" style="position: absolute; right: 3.5em; top: 21.8em;">
                    <label for="poeni_inp">Поени</label>
                    <input type="number" step="any" id="poeni_inp" name="poeni_inp">
                </div>

                <div>
                    <button id="vnesi_polag" class="vnesi_button" onclick="vnesiPolagFunc()">Внеси полагање</button>
                </div>

            </div>
`;
*/

const vnesi_predavanje_html = `<div class="second_menu" id="second_menu">

                <div>
                    <label for="predmet_pred">Предмет
                        <input type="text" id="predmet_pred" name="predmet_pred">
                    </label>
                </div>

                <div>
                    <label for="date_pred">Одржано на датум<br>
                        <input type="date" id="date_pred" name="date_pred">
                    </label>
                </div>

                <div class="rbt rbt1">
                    <input type="radio" id="pred" name="pred_aud" value="predavanje">
                    <label for="pred">Предавање</label>
                    <input type="radio" id="aud" name="pred_aud" value="auditoriski">
                    <label for="aud">Аудиториски</label><br>
                </div>

                <div class="slider1">
                    <div class="range-slider">
                        Статус<br>
                        <input class="range-slider__range" type="range" value="0" min="0" max="100" step="10">
                        <span class="range-slider__value">0%</span>
                    </div>
                </div>

                <div>
                    <button id="vnesi_predavanje" class="vnesi_button" onclick="vnesiPredFunc()">Внеси предавање</button>
                </div>

            </div>
`;

const vnesi_domasno_html = `<div class="second_menu" id="second_menu">

                <div>
                    <label for="predmet_domasno">Предмет
                        <input type="text" id="predmet_domasno" name="predmet_domasno">
                    </label>
                </div>

                <div>
                    <label for="date_due">Due date<br>
                        <input type="date" id="date_due" name="date_due">
                    </label>
                </div>

                <div class="slider1">
                    <div class="range-slider">
                        Статус<br>
                        <input class="range-slider__range" type="range" value="0" min="0" max="100" step="10">
                        <span class="range-slider__value">0%</span>
                    </div>
                </div>

                <div>
                    <button id="vnesi_domasno" class="vnesi_button" onclick="vnesiDomasnoFunc()">Внеси домашно</button>
                </div>

            </div>
`;

const vnesi_zabeleska_html = `<div class="second_menu" id="second_menu">

                <div>
                    <label for="predmet_zabeleska">Предмет
                        <input type="text" id="predmet_zabeleska" name="predmet_zabeleska">
                    </label>
                </div>

                <div>
                    <label for="zabeleska">Забелешка</label>
                    <textarea id="zabeleska" name="zabeleska" rows="10" cols="26" placeholder="..."></textarea>
                </div>

                <div>
                    <button id="vnesi_zabeleska" class="vnesi_button" onclick="vnesiZabeleskaFunc()">Внеси забелешка</button>
                </div>

            </div>
`;


window.addEventListener('load', (event) => {
    console.log('page is fully loaded');

    const dodadiPolaganje = document.getElementById('dodadiPolaganje');
    const dodadiPredavanje = document.getElementById('dodadiPredavanje');
    const dodadiDomasno = document.getElementById('dodadiDomasno');
    const dodadiZabeleska = document.getElementById('dodadiZabeleska');

    const vnesi_polag = document.getElementById('vnesi_polag');

    // + Полагање
    dodadiPolaganje.addEventListener("click", function() {
       /* document.getElementById('add_menu').classList.add('invisiblemenu');
        document.getElementById('vtor_desen_content').classList.remove('invisiblemenu');

        // vo const vnesi_polaganje_html e celiot html za formata za dodavanje polaganje
        document.getElementById('vtor_desen_content').innerHTML = vnesi_polaganje_html;*/

        document.getElementById('dodadiPolaganjeDiv').classList.remove('invisiblemenu');
        document.getElementById('dodadiPolaganjeDiv').classList.add('visiblemenu');

    });

    // + Предавање
    dodadiPredavanje.addEventListener("click", function() {
        document.getElementById('add_menu').classList.add('invisiblemenu');
        document.getElementById('vtor_desen_content').classList.remove('invisiblemenu');

        // vo const vnesi_predavanje_html e celiot html za formata za dodavanje predavanje
        document.getElementById('vtor_desen_content').innerHTML = vnesi_predavanje_html;
        rangeSlider();
    });

    // + Домашно
    dodadiDomasno.addEventListener("click", function() {
        document.getElementById('add_menu').classList.add('invisiblemenu');
        document.getElementById('vtor_desen_content').classList.remove('invisiblemenu');

        // vo const vnesi_domasno_html e celiot html za formata za dodavanje domasno
        document.getElementById('vtor_desen_content').innerHTML = vnesi_domasno_html;
        rangeSlider();
    });

    // + Забелешка
    dodadiZabeleska.addEventListener("click", function() {
        document.getElementById('add_menu').classList.add('invisiblemenu');
        document.getElementById('vtor_desen_content').classList.remove('invisiblemenu');

        // vo const vnesi_zabeleska_html e celiot html za formata za dodavanje zabeleska
        document.getElementById('vtor_desen_content').innerHTML = vnesi_zabeleska_html;
    });



});

// за сите овие евентуално ќе има и други функционалности
// треба да се координира со контролерите

// click button ВНЕСИ ПОЛАГАЊЕ
function vnesiPolagFunc() {
    document.getElementById('vtor_desen_content').classList.add('invisiblemenu');
    document.getElementById('add_menu').classList.remove('invisiblemenu');
}

// click button ВНЕСИ ПРЕДАВАЊЕ
function vnesiPredFunc() {
    document.getElementById('vtor_desen_content').classList.add('invisiblemenu');
    document.getElementById('add_menu').classList.remove('invisiblemenu');
}

// click button ВНЕСИ ДОМАШНО
function vnesiDomasnoFunc() {
    document.getElementById('vtor_desen_content').classList.add('invisiblemenu');
    document.getElementById('add_menu').classList.remove('invisiblemenu');
}

// click button ВНЕСИ ЗАБЕЛЕШКА
function vnesiZabeleskaFunc() {
    document.getElementById('vtor_desen_content').classList.add('invisiblemenu');
    document.getElementById('add_menu').classList.remove('invisiblemenu');
}

/* JavaScript za slider
     https://codepen.io/seanstopnik/pen/CeLqA
 */
function rangeSlider() {

    var slider = $('.range-slider'),
        range = $('.range-slider__range'),
        value = $('.range-slider__value');

    slider.each(function(){

        value.each(function(){
            var value = $(this).prev().attr('value');
            $(this).html(value);
        });

        range.on('input', function(){
            $(this).next(value).html(this.value + '%');
        });
    });
}
