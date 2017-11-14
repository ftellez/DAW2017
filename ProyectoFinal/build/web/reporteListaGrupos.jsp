<%@ include file="header.html" %>

    <h1>Lista de cursos disponibles por día y salón</h1>
    
    <table>
        <tr><td class= "tdL">Día: </td>
            <td>
                <select name="dia">
                    <option value="0">Lunes</option>
                    <option value="1">Martes</option>
                    <option value="2">Miércoles</option>
                    <option value="3">Jueves</option>
                    <option value="4">Viernes</option>
                </select> 
            </td>
        </tr>
        <tr><td class= "tdL">Número de salon: </td>
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
            </td>
        </tr>
    </table>
    <div>
        <input class="button" type=submit name="formType" value="Generar reporte">
    </div>
    
<%@ include file="footer.jsp" %>