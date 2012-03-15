package ProjectB;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Borjo
 */

public class Login extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            String username;
            String password;
            
            javax.servlet.http.HttpSession sesion = request.getSession();
            String email = ((String) sesion.getAttribute("email"));
            
            username=request.getParameter("username");
            password=request.getParameter("password");
            String error=null;
            
        response.setContentType("text/html;charset=UTF-8");
        
         if(checkErrors.isNull(username) || checkErrors.isNull(password))
            error="Ha dejado algun campo vacio.";
        else{
            try{
                if(checkErrors.autentify(username, password)){
                    javax.servlet.http.HttpSession session;
                    session =request.getSession(true);
                    session.setAttribute("username",username);
                    session.setAttribute("password",password);
                    session.setAttribute("email",email);
                    session.setAttribute("firstName","null");
                    session.setAttribute("lastName","null");
                    session.setAttribute("lastName2","null");
                    session.setAttribute("city","null");
                    session.setAttribute("country","null");
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
        }
        else{
            out.println("Clave correcta por favor espere...");

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
