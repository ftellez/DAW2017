<%@ include file="header.html" %>

        <h1>Alta de materias</h1>
        <form action="InscripcionesServlet" method="post">
            <table>
                <tr><td class= "tdL">Clave: </td><td><input type ="text" name="claveMateria" placeholder="Ej: TC001234" required></td></tr>
                <tr><td class= "tdL">Nombre: </td><td><input type="text" name="nomMateria" required></td></tr>
                <tr><td class= "tdL">Horas de lab.: </td><td><input type="number" name="horasLabMateria" value="0"></td></tr>
            </table>
            <div>
                <input class="button" type=submit name="formType" value="Dar de alta">
            </div>
        </form>

<%@ include file="footer.jsp" %>