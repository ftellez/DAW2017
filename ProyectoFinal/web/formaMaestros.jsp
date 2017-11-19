
<%@page import="Maestros.Maestro"%>
<%@ include file="header.html" %>
    <%
        // Codigo para la forma de modificar, obtine los datos del maestro cuando se busca en la DB
        Maestro profe = (Maestro)request.getAttribute("datosMaestro");
        String nominaProfe, nomProfe, telProfe, emailProfe;
        String cursosProfe;
        if (profe == null){
            nominaProfe = nomProfe = telProfe = emailProfe = cursosProfe = "";
        }
        else{
            nominaProfe = profe.getNomina();
            nomProfe = profe.getNombre();
            telProfe = profe.getTelefono();
            emailProfe = profe.getEmail();
            cursosProfe = profe.getCursos();
        }
        
        // Despliega mensaje en caso de error
        String msg = (String)request.getAttribute("message");
        if (msg == null)
            msg = "";
        
        // Codigo que modifica la forma dinamicamente segun el tipo de atributo
        String estatus = (String)request.getAttribute("editarDatos");
        String WelcomeMsg = "";
        if (estatus != null){
            switch (estatus){
                case "agregar":
                    WelcomeMsg = "Alta de maestros";
                    break;
                case "modificar":
                    WelcomeMsg = "Modificar maestro";
                    break;
                case "eliminar":
                    WelcomeMsg = "Eliminar maestro";
                    break;
                default:
                    WelcomeMsg = "";
                    break;
            }
        }
    %>
        <h1><%=WelcomeMsg%></h1>
        <p id="msgLoginError"><%=msg%></p>
        <form action="InscripcionesServlet" method="post">
            <table>
                <tr><td class= "tdL">Nomina: </td><td><input type ="text" class="textBox" name="nominaProfe" value="<%=nominaProfe %>" placeholder="Ej: L00123456" required></td>
                    <% if (estatus == "modificar"){
                        request.getSession().setAttribute("buscar", "Profe");
                    %>
                        <td><input class="searchButton" type=submit name="formType" value="Buscar"></td>
                    <%
                        } 
                    %>
                </tr>
            <% 
                if (estatus != "eliminar"){ %>    
                <tr><td class= "tdL">Nombre completo: </td><td><input type="text" class="textBox" name="nomProfe" value="<%=nomProfe %>" <% if (estatus != "modificar"){ %> required<%} %>></td></tr>
                <tr><td class= "tdL">Telefono: </td><td><input type="tel" class="telBox" name="telProfe" value="<%=telProfe %>"  placeholder="Lada + num" pattern="[0-9]{10}"></td></tr>
                <tr><td class= "tdL">Correo electronico: </td><td><input type="email" class="mailBox" name="mailProfe" value="<%=emailProfe %>"  placeholder="usuario@itesm.mx" <% if (estatus != "modificar"){ %> required<%} %>></td></tr>
                <tr><td class= "tdL">Numero de cursos: </td><td><input type="text" class="numBox" name="cantCursosProfe"  value="<%=cursosProfe %>" ></td></tr>
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
                        request.getSession().setAttribute("solicitud", "modificarProfe");
                        //request.setAttribute("solicitud", "modificarProfe");
                        %>
                            <input class="button" type=submit name="formType" value="Modificar">
                        <%
                    }
                    else if (estatus == "eliminar"){
                        request.getSession().setAttribute("solicitud", "eliminarProfe");
                        //request.setAttribute("solicitud", "eliminarProfe");
                        %>
                            <input class="button" type=submit name="formType" value="Eliminar">
                        <%
                    }
                
                %>
            </div>
        </form>

<%@ include file="footer.jsp" %>