/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function agregarProfe(){
    var table = document.getElementById( "growTable" );
    
    var newProfe = table.insertRow(7);
    var profe = newProfe.insertCell(0);
    var nomProfe = newProfe.insertCell(1);
    
    profe.id = "tdL";
    profe.innerHTML = "Profesor: ";
    nomProfe.innerHTML = "<input type='text' class='textBox' name='nomProfeCurso' required>";
    
    var newResp = table.insertRow(8);
    var resp = newResp.insertCell(0);
    var percResp = newResp.insertCell(1);
    
    resp.id = "tdL";
    resp.innerHTML = "Responsabilidad (%): ";
    percResp.innerHTML = "<input type='number' class='numBox' name='nomProfeCurso' min='0' max='100' required>";
}
