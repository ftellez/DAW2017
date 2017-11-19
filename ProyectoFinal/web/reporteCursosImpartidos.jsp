<%@ include file="header.html" %>

    <h1>Reporte de cursos</h1>
    <p>Introduzca la información del profesor solicitada</p>
    <table>
        <tr><td class= "tdL">Nómina: </td><td><input type="text" class="textBox" name="nomProfe" required></td></tr>
    </table>
    <div>
        <input class="button" type=submit name="formType" value="Generar reporte">
    </div>

<%@ include file="footer.jsp" %>