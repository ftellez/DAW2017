<%@ include file="header.html" %>
    <%
        String estatus = (String)request.getAttribute("editarDatos");
    %>
        <h1>Alta de salones</h1>
        <form action="InscripcionesServlet" method="post">
            <table>
                <tr><td class= "tdL">Numero de salon: </td>
                    <td>
                        <select class="menuSelect" name="edificioSalon">
                            <option value="0">A1</option>
                            <option value="1">A2</option>
                            <option value="2">A3</option>
                            <option value="3">A4</option>
                            <option value="4">CB</option>
                            <option value="5">A6</option>
                            <option value="6">A7</option>
                            <option value="7">CIAP</option>
                        </select>
                        <input class="numBox" type="number" name="numSalon" placeholder="Ejem: 101" required>
                        <% if (estatus == "modificar"){ %><td><button class="searchButton">Buscar</button></td><%} %>
                    </td>
                </tr>
            <%
                if (estatus != "eliminar"){ %>
                <tr><td class= "tdL">Capacidad: </td><td><input class="numBox" type="number" name="capacidadSalon" <% if (estatus != "modificar"){ %> required<%} %>></td></tr>
                <tr><td class= "tdL">Departamento: </td>
                    <td>
                        <select class="menuSelect" name="adminSalon">
                            <option value="0">CS</option>
                            <option value="1">Escolar</option>
                            <option value="2">Otro</option>
                        </select>
                    </td></tr>
                <% }
            %>
            </table>
            <div>
                <%
                    if (estatus == "agregar"){
                        request.setAttribute("solicitud", "agregarSalon");
                    %>
                        <input class="button" type=submit name="formType" value="Dar de alta">
                    <%
                    }
                    else if (estatus == "modificar"){
                        request.setAttribute("solicitud", "modificarSalon");
                    %>
                        <input class="button" type=submit name="formType" value="Modificar">
                    <%
                    }
                    
                    else if (estatus == "eliminar"){
                        request.setAttribute("solicitud", "eliminarSalon");
                    %>
                        <input class="button" type=submit name="formType" value="Eliminar">
                    <%
                    }
                %>      
            </div>
        </form>

<%@ include file="footer.jsp" %>