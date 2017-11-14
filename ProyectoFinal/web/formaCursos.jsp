<%@ include file="header.html" %>
    <%
        String estatus = (String)request.getAttribute("editarDatos");
    %>
    <h1>Programacion de cursos</h1>
        <form action="InscripcionesServlet" method="post">
            <table id="growTable">
                <tr><td class= "tdL">Clave: </td><td><input type ="text" class="textBox" name="claveCurso" placeholder="Ej: TC001234" required></td></tr>
                <tr><td class= "tdL">Grupo: </td><td><input type="number" class="numBox" name="grupoCurso" required><% if (estatus == "modificar"){ %><button class="searchButton">Buscar</button><%} %></td></tr>
            <%
                if (estatus != "eliminar"){ %>
                <tr><td class= "tdL">Horario: </td>
                    <td>
                        <select class="menuSelect" name="horaCurso">
                            <option value="0">7/3</option>
                            <option value="1">8+/3</option>
                            <option value="2">10/3</option>
                            <option value="3">11+/3</option>
                            <option value="4">13/3</option>
                            <option value="5">14+/3</option>
                            <option value="6">16/3</option>
                            <option value="7">18/6</option>
                        </select>
                        <select class="menuSelect" name="diaCurso">
                            <option value="0">Lu/Ju</option>
                            <option value="1">Ma/Vi</option>
                            <option value="2">Mi</option>
                        </select>
                    </td>
                </tr>
                <tr><td class= "tdL">Horario lab: </td>
                    <td>
                        <select class="menuSelect" name="horaLaboCurso">
                            <option value="0">7/3</option>
                            <option value="1">8+/3</option>
                            <option value="2">10/3</option>
                            <option value="3">11+/3</option>
                            <option value="4">13/3</option>
                            <option value="5">14+/3</option>
                            <option value="6">16/3</option>
                            <option value="7">18/6</option>
                        </select> 
                        <select class="menuSelect" name="diaLaboCurso">
                            <option value="0">Lu/Ju</option>
                            <option value="1">Ma/Vi</option>
                            <option value="2">Mi</option>
                        </select>
                    </td>
                </tr>
                <tr><td class= "tdL">Salon: </td>
                    <td>
                        <select class="menuSelect" name="edificioCurso">
                            <option value="0">A1</option>
                            <option value="1">A2</option>
                            <option value="2">A3</option>
                            <option value="3">A4</option>
                            <option value="4">CB</option>
                            <option value="5">A6</option>
                            <option value="6">A7</option>
                        </select>
                        <input type="number" class="numBox" name="numSalonCurso" placeholder="Ejem: 101" <% if (estatus != "modificar"){ %> required<%} %>>
                    </td>
                </tr>
                <tr><td id="tdL" class= "tdL">Profesor: </td><td><input type="text" class="textBox" name="nomProfeCurso" <% if (estatus != "modificar"){ %> required<%} %>></td><td><button onclick = agregarProfe() class="addButton">Agregar</button></td></tr>
                <tr><td id="tdL" class= "tdL">Responsabilidad (%): </td><td><input type="number" class="numBox" name="nomProfeCurso" min="0" max="100" <% if (estatus != "modificar"){ %> required<%} %>></td></tr>
                <tr><td class= "tdL">Ingles: </td>
                    <td>
                        <select class="menuSelect" name="inglesCurso">
                            <option value="0">No</option>
                            <option value="1">Si</option>
                        </select>
                    </td>
                </tr>
                <tr><td class= "tdL">Honors: </td>
                    <td>
                        <select class="menuSelect" name="honorsCurso">
                            <option value="0">No</option>
                            <option value="1">Si</option>
                        </select>
                    </td>
                </tr>
             <%           
               }         
             %>
            </table>
            <div>
                <%  
                    if (estatus == "agregar"){
                        request.setAttribute("solicitud", "agregarCurso");
                        %>
                        <input class="button" type=submit name="formType" value="Dar de alta">
                        <%
                    }
                    else if (estatus == "modificar"){
                        request.setAttribute("solicitud", "modificarCurso");
                        %>    
                        <input class="button" type=submit name="formType" value="Modificar">
                        <%
                    }
                    else if (estatus == "eliminar"){
                        request.setAttribute("solicitud", "eliminarCurso");
                        
                        %>
                        <input class="button" type=submit name="formType" value="Eliminar">
                        <%
                    }
                
                %>
            </div>
        </form>
    
<%@ include file="footer.jsp" %>