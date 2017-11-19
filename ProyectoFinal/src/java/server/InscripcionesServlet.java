/*
 * Clase: InscripcionesServlet
 *
 * Version: 1.0
 *
 * Fecha: 10/nov/17
 *
 * Copyright
 */
package server;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
//import beans.usuario;
import Login.LoginAux;
import Maestros.Maestro;
import Maestros.MaestrosAux;
import Salones.Salones;
import Salones.SalonesAux;
import Testing.Test;

/*
 * Comentarios de documentacion de una clase o interface
 *
 */
public class InscripcionesServlet extends HttpServlet {
    
    protected void doPost(HttpServletRequest request, 
                          HttpServletResponse response) 
                          throws ServletException, IOException
    {
        String determinarForma = request.getParameter("formType");
        String url = "/MainMenu.jsp";
        
        switch (determinarForma){
            case "Login":
                String usuario = request.getParameter("user");
                String contra = request.getParameter("password");
                LoginAux log = new LoginAux(usuario, contra);
                
                if (log.getAuth()){
                    request.setAttribute("user", usuario);
                    url = "/MainMenu.jsp";
                }
                else{
                    request.setAttribute("existe", "no");
                    url = "/login.jsp";
                }
                              
                break;
            
            /************************************************
            *
            * Esta seccion corresponde a la forma MAESTROS
            *
            * ***********************************************/
            case "Agregar Maestro":
                request.setAttribute("editarDatos", "agregar");
                url = "/formaMaestros.jsp";
                break;
                
            case "Modificar Maestro":
                request.setAttribute("editarDatos", "modificar");
                url = "/formaMaestros.jsp";
                break;
                
            case "Eliminar Maestro":
                request.setAttribute("editarDatos", "eliminar");
                url = "/formaMaestros.jsp";
                break;
            
            /************************************************
            *
            * Esta seccion corresponde a la forma SALONES
            *
            * ***********************************************/
            case "Agregar salon":
                request.setAttribute("editarDatos", "agregar");
                url = "/formaSalones.jsp";
                break;
                
            case "Modificar salon":
                request.setAttribute("editarDatos", "modificar");
                url = "/formaSalones.jsp";
                break;
                
            case "Eliminar salon":
                request.setAttribute("editarDatos", "eliminar");
                url = "/formaSalones.jsp";
                break;
             
            /************************************************
            *
            * Esta seccion corresponde a la forma Grupos
            *
            * ***********************************************/
            case "Agregar Grupo":
                request.setAttribute("editarDatos", "agregar");
                url = "/formaCursos.jsp";
                break;
            
            case "Modificar Grupo":
                request.setAttribute("editarDatos", "modificar");
                url = "/formaCursos.jsp";
                break;
                
            case "Eliminar Grupo":
                request.setAttribute("editarDatos", "eliminar");
                url = "/formaCursos.jsp";
                break;
            
            /************************************************
            *
            * Esta seccion corresponde a las solicitudes Dar de alta
            *
            * ***********************************************/
            case "Dar de alta":
                String sourceAlta = (String)request.getSession().getAttribute("solicitud");
                //Test.infoBox(sourceAlta, "Agregar profe case");
                switch (sourceAlta) {
                    case "agregarProfe":
                        /* Aqui van queries */
                        //Test.infoBox("Entre a agregar profe", "Agregar profe case: ");
                        String nomina = (String)request.getParameter("nominaProfe");
                        String nomProfe = (String)request.getParameter("nomProfe");
                        String tel = (String)request.getParameter("telProfe");
                        String mail = (String)request.getParameter("mailProfe");
                        String curso = (String)request.getParameter("cantCursosProfe");
                        Maestro maestro = new Maestro(nomina,nomProfe,tel,mail,curso);
                        MaestrosAux mAux = new MaestrosAux();
                        boolean seAgregoProf = mAux.addMaestroToDB(maestro);
                        if (seAgregoProf){
                            url = "/MainMenu.jsp";
                            String msg = "Si se pudo agregar el profe!";
                            request.setAttribute("message", msg);
                            //mAux.infoBox(msg, Boolean.toString(seAgrego));
                        } else {
                            url = "/formaMaestros.jsp";
                            String msg = "No se pudo agregar, ya existe el maestro";
                            request.setAttribute("message", msg);
                            request.setAttribute("editarDatos", "agregar");
                            //mAux.infoBox(msg, Boolean.toString(seAgrego));
                        }
                        break;
                    case "agregarSalon":
                        /* Aqui van queries */
                        String edificio = (String)request.getParameter("edificioSalon");
                        String aula = (String)request.getParameter("numSalon");
                        String numSalon = edificio + aula;
                        String capacidad = (String)request.getParameter("capacidadSalon");
                        String dep = (String)request.getParameter("adminSalon");
                        Salones salon = new Salones(numSalon, capacidad, dep);
                        SalonesAux salAux = new SalonesAux();
                        boolean seAgregoSal = salAux.addSalonToDB(salon);
                        if (seAgregoSal){
                            url = "/MainMenu.jsp";
                            String msg = "Si se puedo agregar el salon!";
                            request.setAttribute("message", msg);
                        } else {
                            url = "/formaSalones.jsp";
                            String msg = "No se puedo agregar, ya existe el salon";
                            request.setAttribute("message", msg);
                            request.setAttribute("editarDatos", "agregar");
                        }
                        break;
                    case "agregarCurso":
                        /* Aqui van queries */
                        break;
                    default:
                        break;
                }
                break;
                
            /************************************************
            *
            * Esta seccion corresponde a las solicitudes modificar
            *
            * ***********************************************/
            case "Modificar":
                String sourceModificar = (String)request.getSession().getAttribute("solicitud");
                switch (sourceModificar) {
                    case "modificarProfe":
                        /* Aqui van queries */
                        String nomina = (String)request.getParameter("nominaProfe");
                        String nomProfe = (String)request.getParameter("nomProfe");
                        String tel = (String)request.getParameter("telProfe");
                        String mail = (String)request.getParameter("mailProfe");
                        String curso = (String)request.getParameter("cantCursosProfe");
                        Maestro maestro = new Maestro(nomina,nomProfe,tel,mail,curso);
                        MaestrosAux mAux = new MaestrosAux();
                        boolean seModificoProfe = mAux.modMaestroFromDB(maestro);
                        if (seModificoProfe){
                            url = "/MainMenu.jsp";
                            String msg = "Si se pudo modificar el profe!";
                            request.setAttribute("message", msg);
                        }
                        else{
                            url = "/formaMaestros.jsp";
                            String msg = "No se pudo modificar el profe, no existe!!";
                            request.setAttribute("message", msg);
                            request.setAttribute("editarDatos", "modificar");             
                        }
                        break;
                        
                    case "modificarSalon":
                        /* Aqui van queries */
                        String edificio = (String)request.getParameter("edificioSalon");
                        String aula = (String)request.getParameter("numSalon");
                        String numAula = edificio + aula;
                        String capacidad = (String)request.getParameter("capacidadSalon");
                        String admin = (String)request.getParameter("adminSalon");
                        Salones salon = new Salones(numAula, capacidad, admin);
                        SalonesAux salAux = new SalonesAux();
                        boolean seModificoSalon = salAux.modSalonFromDB(salon);
                        if (seModificoSalon){
                            url = "/MainMenu.jsp";
                            String msg = "Si se pudo modificar el salon!";
                            request.setAttribute("message", msg);
                        }
                        else {
                            url = "/formaSalones.jsp";
                            String msg = "No se pudo modificar el salon, no hay, no existe!!";
                            request.setAttribute("message", msg);
                            request.setAttribute("editarDatos", "modificar");
                        }
                        break;
                        
                    case "modificarCurso":
                        /* Aqui van queries */
                        break;
                    
                    default:
                        break;
                }
                break; 
            /************************************************
            *
            * Esta seccion corresponde a las solicitudes eliminar
            *
            * ***********************************************/
            case "Eliminar":
                String sourceEliminar = (String)request.getSession().getAttribute("solicitud");
                switch (sourceEliminar) {
                    case "eliminarProfe":
                        /* Aqui van queries */
                        String nomina = (String)request.getParameter("nominaProfe");
                        Maestro maestro = new Maestro();
                        maestro.setNomina(nomina);
                        
                        MaestrosAux mAux = new MaestrosAux();
                        boolean seElimino = mAux.deleteMaestroFromDB(maestro);
                        if (seElimino){
                            url = "/MainMenu.jsp";
                            String msg = "Si se pudo eliminar!";
                            request.setAttribute("message", msg);
                        }
                        else{
                            url = "/formaMaestros.jsp";
                            String msg = "No se pudo eliminar";
                            request.setAttribute("message", msg);
                            request.setAttribute("editarDatos", "eliminar");             
                        }
                        break;
                    case "eliminarSalon":
                        /* Aqui van queries */
                        String edificio = (String)request.getParameter("edificioSalon");
                        String aula = (String)request.getParameter("numSalon");
                        String numSalon = edificio + aula;
                        Salones salon = new Salones();
                        salon.setSalonNum(numSalon);
                        
                        SalonesAux salAux = new SalonesAux();
                        boolean seEliminoSalon = salAux.deleteSalonFromDB(salon);
                        if (seEliminoSalon){
                            url = "/MainMenu.jsp";
                            String msg = "Se elimino el salon";
                            request.setAttribute("message", msg);
                        }
                        else{
                            url = "/formaSalones.jsp";
                            String msg = "No se pudo eliminar el salon, no existe!!";
                            request.setAttribute("message", msg);
                            request.setAttribute("editarDatos", "eliminar");
                        }
                        break; 
                    case "eliminarCurso":
                        /* Aqui van queries */
                        break;
                    default:
                        break;
                }
                break;
            /************************************************
            *
            * Esta seccion es la de reportes
            *
            * ***********************************************/
            case "Buscar":
                String tipo = (String)request.getSession().getAttribute("buscar");
                switch(tipo){
                    case "Profe":     
                        String nomina = (String)request.getParameter("nominaProfe");
                        MaestrosAux profeAux = new MaestrosAux();
                        Maestro profe = profeAux.getMaestroFromDB(nomina);
                        if (profe != null){
                            request.setAttribute("datosMaestro", profe);
                        }
                        else{
                            String msg = "Profesor no encontrado";
                            profe = new Maestro();
                            profe.setNomina(nomina);
                            request.setAttribute("datosMaestro", profe);
                            request.setAttribute("message", msg);
                        }
                        request.setAttribute("editarDatos", "modificar");
                        url = "/formaMaestros.jsp";
                        break;
                    case "Salon":
                        String edificio = (String)request.getParameter("edificioSalon");
                        String aula = (String)request.getParameter("numSalon");
                        String numSalon = edificio + aula;
                        SalonesAux salAux = new SalonesAux();
                        Salones salon = salAux.getSalonFromDB(numSalon);
                        if (salon != null){
                            request.setAttribute("datosSalon", salon);
                            
                        }
                        else {
                            String msg = "Salon no encontrado";
                            salon = new Salones();
                            salon.setSalonNum(numSalon);
                            request.setAttribute("datosSalon", salon);
                            request.setAttribute("message", msg);
                        }
                        request.setAttribute("editarDatos", "modificar");
                        url = "/formaSalones.jsp";
                        break;
                        
                    case "Grupo":
                        break;
                    default:
                        //Test.infoBox("No detecte nada", "Case default profe");
                        url = "/formaMaestros.jsp";
                        break;
                }
                break;
            /************************************************
            *
            * Esta seccion es la de reportes
            *
            * ***********************************************/
            case "Cursos impartidos":
                url = "/reporteCursosImpartidos.jsp";
                break;
            
            case "Lista de grupos":
                url = "/reporteListaGrupos.jsp";
                break;
                
            case "Lista de salones":
                url = "/reporteListaSalones.jsp";
                break;
                
            case "Lista de profesores":
                url = "/reporteListaProfes.jsp";
                break;
                
            case "Lista de cursos":
                url = "/reporteListaGrupos.jsp";
                break;
            
            /************************************************
            *
            * Esta seccion es la DEFAULT
            *
            * ***********************************************/
            default:
                url = "/MainMenu.jsp";
                break;
        }
        
        // forward request and response to the view
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }

}