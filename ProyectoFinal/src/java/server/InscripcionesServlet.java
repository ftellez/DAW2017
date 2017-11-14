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
            * Esta seccion corresponde a las solicitudes Dar de alta, modificar y eliminar
            *
            * ***********************************************/
            case "Dar de alta":
                String sourceAlta = (String)request.getSession().getAttribute("solicitud");
                switch (sourceAlta) {
                    case "agregarProfe":
                        /* Aqui van queries */
                        String nomina = (String)request.getParameter("nominaProfe");
                        String nomProfe = (String)request.getParameter("nomProfe");
                        String tel = (String)request.getParameter("telProfe");
                        String mail = (String)request.getParameter("mailProfe");
                        String curso = (String)request.getParameter("cantCursosProfe");
                        Maestro maestro = new Maestro(nomina,nomProfe,tel,mail,Integer.parseInt(curso));
                        MaestrosAux mAux = new MaestrosAux();
                        boolean seAgrego = mAux.addMaestroToDB(maestro);
                        if (seAgrego){
                            url = "/MainMenu.jsp";
                            String msg = "Si se pudo agregar!";
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
                    case "agregarCurso":
                        /* Aqui van queries */
                        break;
                    case "agregarSalon":
                        /* Aqui van queries */
                        break;
                    default:
                        break;
                } break;           
            case "Modificar":
                String sourceModificar = (String)request.getSession().getAttribute("solicitud");
                switch (sourceModificar) {
                    case "modificarProfe":
                        /* Aqui van queries */
                        break;
                    case "modificarCurso":
                        /* Aqui van queries */
                        break;
                    case "modificarSalon":
                        /* Aqui van queries */
                        break;
                    default:
                        break;
                }break;                
            case "Eliminar":
                String sourceEliminar = (String)request.getSession().getAttribute("solicitud");
                switch (sourceEliminar) {
                    case "eliminarProfe":
                        /* Aqui van queries */
                        break;
                    case "eliminarCurso":
                        /* Aqui van queries */
                        break;
                    case "eliminarSalon":
                        /* Aqui van queries */
                        break;
                    default:
                        break;
                }break;           
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
