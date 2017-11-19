<%@page import="Salones.Salones"%>
<%@ include file="header.html" %>
    <%
        // Codigo para la forma de modificar, obtine los datos del salon cuando se busca en la DB
        Salones salon = (Salones)request.getAttribute("datosSalon");
        String numSalon, capacidad, departamento;
        char[] aula = {' ', ' ', ' '};
        char edif = ' ';
        if (salon == null){
            numSalon = capacidad = departamento = "";
        }
        else{
            char[] aulaTemp = salon.getSalonNum().toCharArray();
            numSalon = salon.getSalonNum();
            capacidad = salon.getSalonCap();
            departamento = salon.getSalonAdmin();
            edif  = aulaTemp[0];
            aula[0] = aulaTemp[1];
            aula[1] = aulaTemp[2];
            aula[2] = aulaTemp[3];
        }
        
        // Despliega mensaje en caso de error
        String errMsg = (String)request.getAttribute("message");
        if (errMsg == null)
            errMsg = "";
        
        // Codigo que modifica la forma dinamicamente segun el tipo de atributo
        String estatus = (String)request.getAttribute("editarDatos");
        String msg = "";
        String WelcomeMsg = "";
        switch (estatus){
            case "agregar":
                msg = "Alta de salones";
                WelcomeMsg = "Introduzca los datos solicitados";
                break;
            case "modificar":
                msg = "Modificar salon";
                WelcomeMsg = "Introduzca el edificio y aula y presione buscar para validar";
                break;
            case "eliminar":
                msg = "Eliminar salon";
                WelcomeMsg = "Introduzca los datos del salon a eliminar";
                break;
            default:
                break;
        }
    %>
        <h1><%=msg %></h1>
        <p><%=WelcomeMsg %></p>
        <p id="msgLoginError"><%=errMsg%></p>
        <form action="InscripcionesServlet" method="post">
            <table>
                <tr><td class= "tdL">Numero de salon: </td>
                    <td>
                        <select class="menuSelect" name="edificioSalon">
                            <option value="0" <%if (edif == '0'){%> selected <%}%> ></option>
                            <option value="1" <%if (edif == '1'){%> selected <%}%> >A1</option>
                            <option value="2" <%if (edif == '2'){%> selected <%}%> >A2</option>
                            <option value="3" <%if (edif == '3'){%> selected <%}%> >A3</option>
                            <option value="4" <%if (edif == '4'){%> selected <%}%> >A4</option>
                            <option value="5" <%if (edif == '5'){%> selected <%}%> >CB</option>
                            <option value="6" <%if (edif == '6'){%> selected <%}%> >A6</option>
                            <option value="7" <%if (edif == '7'){%> selected <%}%> >A7</option>
                            <option value="8" <%if (edif == '8'){%> selected <%}%> >CIAP</option>
                        </select>
                        <input class="numBox" type="number" name="numSalon" value="<%=aula %>" placeholder="Ejem: 101" required>
                        <% if (estatus == "modificar"){
                            request.getSession().setAttribute("buscar", "Salon");
                        %>
                            <td><input class="searchButton" type=submit name="formType" value="Buscar"></td>
                        <%
                            } 
                        %>
                    </td>
                </tr>
            <%
                if (estatus != "eliminar"){ %>
                <tr><td class= "tdL">Capacidad: </td><td><input class="numBox" type="number" name="capacidadSalon" value="<%=capacidad %>" <% if (estatus != "modificar"){ %> required<%} %>></td></tr>
                <tr><td class= "tdL">Departamento: </td>
                    <td>
                        <select class="menuSelect" name="adminSalon">
                            <option value="CS" <%if (departamento.equals("CS")){%> selected <%}%> >CS</option>
                            <option value="Escolar" <%if (departamento.equals("Escolar")){%> selected <%}%> >Escolar</option>
                            <option value="Otro" <%if (departamento.equals("Otro")){%> selected <%}%> >Otro</option>
                        </select>
                    </td></tr>
                <% }
            %>
            </table>
            <div>
                <%
                    if (estatus == "agregar"){
                        request.getSession().setAttribute("solicitud", "agregarSalon");
                    %>
                        <input class="button" type=submit name="formType" value="Dar de alta">
                    <%
                    }
                    else if (estatus == "modificar"){
                        request.getSession().setAttribute("solicitud", "modificarSalon");
                    %>
                        <input class="button" type=submit name="formType" value="Modificar">
                    <%
                    }
                    
                    else if (estatus == "eliminar"){
                        request.getSession().setAttribute("solicitud", "eliminarSalon");
                    %>
                        <input class="button" type=submit name="formType" value="Eliminar">
                    <%
                    }
                %>      
            </div>
        </form>

<%@ include file="footer.jsp" %>