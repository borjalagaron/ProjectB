/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectB;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Borjo
 */
@WebServlet(name = "ChangePassword", urlPatterns = {"/ChangePassword"})
public class ChangePassword extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String current_password;
            String password;
            String password_confirmation;
            
            javax.servlet.http.HttpSession sesion = request.getSession();
            String username = ((String) sesion.getAttribute("username"));
            
            String email = ((String) sesion.getAttribute("email"));
            
            current_password=request.getParameter("current_password");
            password=request.getParameter("password");
            password_confirmation=request.getParameter("password_confirmation");
            String error=null;
            
        response.setContentType("text/html;charset=UTF-8");
        
         if(checkErrors.isNull(current_password) || checkErrors.isNull(password) || checkErrors.isNull(password_confirmation))
            error="Ha dejado algun campo vacio.";
        else{
            try{
                if(checkErrors.autentifyPassword(username, current_password, password, password_confirmation) ){
                    javax.servlet.http.HttpSession session;
                    session =request.getSession(true);
                    session.setAttribute("username",username);
                    session.setAttribute("password",password);
                    session.setAttribute("email",email);
                }else
                    error="Usuario incorrecto, si olvido su contraseña haga clic aqui";
            }catch(ClassNotFoundException e){
                error="Problemas en el servidor, por favor intentelo mas tarde1";
            }catch(java.sql.SQLException e){
                error="Problemas en el servidor, por favor intentelo mas tarde2";
            }
        }
         
        try{
        PrintWriter out = response.getWriter();
                
                
                
                
        out.println("" +
                "<html>" +
                "<head>" +
                "<title>Proyecto</title>" +
                "");
        if(checkErrors.isNull(error)){
            out.println("<META HTTP-EQUIV=\"Refresh\" CONTENT=\"2; URL=profile.jsp\">");
        }
        out.println(
                "</head>" +
                "<body>"
                );
        if(error!=null){
            out.println(error);
            out.println(username + current_password + password);
        }
        else{
            out.println("Cambiando clave...");

        }
        out.println("</body>" +
                "</html>" +
                " ");
        }catch(IOException e){

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
