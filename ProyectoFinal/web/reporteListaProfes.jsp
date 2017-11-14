<%@ include file="header.html" %>

    <h1>Lista de profesores</h1>
    <table>
        <tr><td class= "tdL">Hora: </td>
            <td>
                <select name="hora">
                    <option value="0">7/3</option>
                    <option value="1">8+/3</option>
                    <option value="2">10/3</option>
                    <option value="3">11+/3</option>
                    <option value="4">13/3</option>
                    <option value="5">14+/3</option>
                    <option value="6">16/3</option>
                    <option value="7">18/6</option>
                </select>
                <select name="dia">
                        <option value="0">Lu/Ju</option>
                        <option value="1">Ma/Vi</option>
                    <option value="2">Mi</option>
                </select>
            </td>
        </tr>
        <tr><td class= "tdL">Tipo de búsqueda: </td>
            <td>
                <select name="busqueda">
                    <option value="0">Disponible a esa hora</option>
                    <option value="1">Ocupado en esa hora</option>
                </select> 
            </td>
        </tr>
    </table>
    <div>
        <input class="button" type=submit name="formType" value="Generar reporte">
    </div>

<%@ include file="footer.jsp" %>