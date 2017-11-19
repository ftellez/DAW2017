<%@ include file="header.html" %>

        <form action="InscripcionesServlet" method="post">
            <%
                String userName = (String)request.getAttribute("user");
                if (userName == null)
                    userName = "";
                
                String msg = (String)request.getAttribute("message");
                if (msg == null)
                    msg = "";
            %>
            <h1>Bienvenido al portal <%=userName %></h1>
            <p id="msgSuccess"><%=msg %></p>
            <h2>Menu de opciones</h2>
            <table>
                <tr><td>Maestros</td><td>Salones</td><td>Grupos</td></tr>
                <tr>
                    <td>   
                        <input class="button" type="submit" name="formType" value="Agregar Maestro">
                        <input class="button" type="submit" name="formType" value="Modificar Maestro">
                        <input class="button" type="submit" name="formType" value="Eliminar Maestro">     
                    </td>
                    <td>
                        <input class="button" type="submit" name="formType" value="Agregar salon">
                        <input class="button" type="submit" name="formType" value="Modificar salon">
                        <input class="button" type="submit" name="formType" value="Eliminar salon">
                    </td>
                    <td>
                        <input class="button" type="submit" name="formType" value="Agregar Grupo">
                        <input class="button" type="submit" name="formType" value="Modificar Grupo">
                        <input class="button" type="submit" name="formType" value="Eliminar Grupo">
                    </td>
                </tr>
            </table>
            <p>Reportes</p>
            <table>
                <tr>
                    <td>
                        <input class="button" type="submit" name="formType" value="Cursos impartidos">
                        <input class="button" type="submit" name="formType" value="Lista de grupos">
                        <input class="button" type="submit" name="formType" value="Lista de salones">
                        <input class="button" type="submit" name="formType" value="Lista de profesores">
                        <input class="button" type="submit" name="formType" value="Lista de cursos">
                    </td>
                </tr>
            </table>
        </form>

<%@ include file="footer.jsp" %>