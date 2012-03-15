package ProjectB;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
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
public class Signup extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email;
        String username;
        String password;
        String password_confirmation;

        email = request.getParameter("email");
        username = request.getParameter("username");
        password = request.getParameter("password");
        password_confirmation = request.getParameter("password_confirmation");

        String error = null;
        boolean volver = false;

        response.setContentType("text/html;charset=UTF-8");

        if (checkErrors.isNull(email) || checkErrors.isNull(username) || checkErrors.isNull(password) || checkErrors.isNull(password_confirmation)) {
            error = "Ha dejado algun campo vacio.";
        } else {
            try {
                if (checkErrors.emailExists(email)) {
                    error = "El correo electronico escrito ya existe";
                    volver = true;

                } else if (checkErrors.usernameExists(username)) {
                    error = "El Usuario ya existe";
                    volver = true;
                }

            } catch (ClassNotFoundException e) {
                error = "Problemas en el servidor, por favor intentelo mas tarde";
                volver = true;
            } catch (java.sql.SQLException e) {
                error = "Problemas en el servidor, por favor intentelo mas tarde";
                volver = true;
            }
        }

        try {
            PrintWriter out = response.getWriter();
            out.println(""
                    + "<html>"
                    + "<head>"
                    + "<title>Project B</title>"
                    + "");
            if (checkErrors.isNull(error) && !volver) {
                out.println("<META HTTP-EQUIV=\"Refresh\" CONTENT=\"2; URL=profile.jsp\">");
            }
            if (volver) {
                out.println("<META HTTP-EQUIV=\"Refresh\" CONTENT=\"2; URL=signup.jsp\">");
            }

            out.println(
                    "</head>"
                    + "<body>");
            if (error != null) {
                out.println(error);
            } else {
                out.println("Por favor espere...");
                try {
                    DB create = new DB();
                    create.connect();
                    create.createUser(username, password, email);
                    create.closeConnection();
                    javax.servlet.http.HttpSession session;
                    session = request.getSession(true);
                    session.setAttribute("username", username);
                    session.setAttribute("password", password);
                    session.setAttribute("email", email);
                    session.setAttribute("firstName","null");
                    session.setAttribute("lastName","null");
                    session.setAttribute("lastName2","null");
                    session.setAttribute("city","null");
                    session.setAttribute("country","null");
                    
                    out.println("El resgistro ha sido satisfactorio.");
                } catch (ClassNotFoundException e) {
                    error = " ERROR 5: Problemas en el servidor, por favor intentelo mas tarde.(error en drivers)";
                    out.println(error);
                } catch (java.sql.SQLException e) {
                    error = " ERROR 5:Problemas en el servidor, por favor intentelo mas tarde.(error en Sentencia)";
                    out.println(error);
                }
            }
            out.println("</body>"
                    + "</html>"
                    + " ");
        } catch (IOException e) {
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
