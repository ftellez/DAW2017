<!DOCTYPE html>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 TRANSITIONAL//EN">
<%@ include file="header.html" %>

        <form action="InscripcionesServlet" method="post">
            <%
                String userName = (String)request.getAttribute("existe");
                String msg = "";
                if (userName == "no"){
                    msg = "Usuario o contrasena equivocados, vuelva a intentarlo.";
                }
            %>
            <h1>Inicia sesión</h1>
            <p id="msgLoginError"><%=msg %></p>
            <table>
                <tr><td class= "tdL">Usuario: </td><td><input type="text" class="textBox" name="user" placeholder="Ej: L00123456" required></td></tr>
                <tr><td class= "tdL">Contraseña: </td><td><input type="password" class="textBox" name="password" required></td></tr>
            </table>
            <div>
                <input class="button" type=submit name="formType" value="Login"><br>
            </div>
        </form>
        
<%@ include file="footer.jsp" %>