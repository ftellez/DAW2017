<%@page import="Maestros.Maestro"%>
<%@ include file="header.html" %>
    <%
        String estatus = (String)request.getAttribute("editarDatos");
        
        String msg = (String)request.getAttribute("message");
        if (msg == null)
            msg = "";
    %>
        <h1>Alta de maestros</h1>
        <p id="msgLoginError"><%=msg%></p>
        <form action="InscripcionesServlet" method="post">
            <table>
                <tr><td class= "tdL">Nomina: </td><td><input type ="text" class="textBox" name="nominaProfe" placeholder="Ej: L00123456" required></td><% if (estatus == "modificar"){ %><td><button class="searchButton">Buscar</button></td><%} %></tr>
            <% 
                if (estatus != "eliminar"){ %>    
                <tr><td class= "tdL">Nombre completo: </td><td><input type="text" class="textBox" name="nomProfe" <% if (estatus != "modificar"){ %> required<%} %>></td></tr>
                <tr><td class= "tdL">Telefono: </td><td><input type="tel" class="telBox" name="telProfe" placeholder="Lada + num" pattern="[0-9]{10}"></td></tr>
                <tr><td class= "tdL">Correo electronico: </td><td><input type="email" class="mailBox" name="mailProfe" placeholder="usuario@itesm.mx" <% if (estatus != "modificar"){ %> required<%} %>></td></tr>
                <tr><td class= "tdL">Numero de cursos: </td><td><input type="number" class="numBox" name="cantCursosProfe" value="0"></td></tr>
            <% }
            %>
            </table>
            <div>
                <%
                    
                    
                    if (estatus == "agregar"){
                        request.getSession().setAttribute("solicitud", "agregarProfe");
                        %>
                            <input class="button" type=submit name="formType" value="Dar de alta">
                        <%
                    }
                    else if (estatus == "modificar"){
                        request.setAttribute("solicitud", "modificarProfe");
                        %>
                            <input class="button" type=submit name="formType" value="Modificar">
                        <%
                    }
                    else if (estatus == "eliminar"){
                        request.setAttribute("solicitud", "eliminarProfe");
                        %>
                            <input class="button" type=submit name="formType" value="Eliminar">
                        <%
                    }
                
                %>
            </div>
        </form>

<%@ include file="footer.jsp" %>