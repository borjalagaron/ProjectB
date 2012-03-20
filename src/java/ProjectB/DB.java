package ProjectB;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Borjo
 */

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

public final class DB {
    private MysqlDataSource datasource;
    private java.sql.Connection connection;
    private java.sql.Statement st;
    private java.sql.ResultSet cdr;
    
    public DB()throws ClassNotFoundException,java.sql.SQLException{
       // String controlador = "sun.jdbc.odbc.JdbcOdbcDriver";
        //Class.forName(controlador);
        connect(); // conectar con la fuente de datos
    }    
    
    public void connect(){
        datasource = new MysqlDataSource();
        datasource.setUser("root");             //Nombre user database
        datasource.setPassword("");             //Password user database
        datasource.setDatabaseName("projectb"); //Nombre database
        datasource.setServerName("localhost");  //Nombre Server
        try {
            connection=datasource.getConnection();
            st=connection.createStatement();
        } catch (SQLException ex) {
        }
    }
//    public void connect() throws java.sql.SQLException
//    {
//        String URLdb = "jdbc:mysql://localhost:3306/projectb";
//        String usuario = "root";
//        String pass = "";
//        connection = java.sql.DriverManager.getConnection(URLdb, usuario, pass);
//        // Crear una sentencia SQL
//        st = connection.createStatement();
//    }
    public void closeConnection() throws java.sql.SQLException{
        if (cdr != null){
            cdr.close();
            cdr=null;
        }
        if (st != null) 
            st.close();
        if (connection != null) 
            connection.close();
    }

    /**
     * Devuelve un resultSet con todos los nicks que existen
     * @return ResultSet Nicks
     * @throws java.sql.SQLException
     */
    public java.sql.ResultSet usernames() throws java.sql.SQLException{
        cdr = st.executeQuery("SELECT username FROM user");
        return cdr;
    }
    /**
     * Devuelve un resultSet con todos los correos que existen
     * @return ResultSet Correos
     * @throws java.sql.SQLException
     */
    public java.sql.ResultSet emails() throws java.sql.SQLException{
        cdr = st.executeQuery("SELECT email FROM user");
        return cdr;
    }

    /**
     * pasa el nick del usuario y le devuelve su codigo de usuario
     * @param String nick
     * @return ResultSet Codigo de usuario
     * @throws java.sql.SQLException
     */
    public java.sql.ResultSet searchIDUSERbyUSERNAME(String username) throws java.sql.SQLException{
        cdr=st.executeQuery("select iduser from user where username='"+username+"'");
        return cdr;
    }
    public java.sql.ResultSet searchbyUSERNAME(String username) throws java.sql.SQLException{
        cdr=st.executeQuery("select * from user where username='"+username+"'");
        return cdr;
    }
    
    public java.sql.ResultSet searchPASSWORDbyUSERNAME(String username) throws java.sql.SQLException{ 
        cdr = st.executeQuery("SELECT password FROM user where username='"+username+"'");
        return cdr; }
    
    public java.sql.ResultSet searchEMAILbyUSERNAME(String username) throws java.sql.SQLException{ 
        cdr = st.executeQuery("SELECT email FROM user where username='"+username+"'");
        return cdr; }
    
    public java.sql.ResultSet searchFIRSTNAMEbyUSERNAME(String username) throws java.sql.SQLException{ 
        cdr = st.executeQuery("SELECT firstName FROM user where username='"+username+"'");
        return cdr; }
    
    public java.sql.ResultSet searchLASTNAMEbyUSERNAME(String username) throws java.sql.SQLException{ 
        cdr = st.executeQuery("SELECT lastName FROM user where username='"+username+"'");
        return cdr; }
    public java.sql.ResultSet searchLASTNAME2byUSERNAME(String username) throws java.sql.SQLException{ 
        cdr = st.executeQuery("SELECT lastName2 FROM user where username='"+username+"'");
        return cdr; }
    
   public java.sql.ResultSet searchCITYbyUSERNAME(String username) throws java.sql.SQLException{ 
        cdr = st.executeQuery("SELECT city FROM user where username='"+username+"'");
        return cdr; }
   public java.sql.ResultSet searchCOUNTRYbyUSERNAME(String username) throws java.sql.SQLException{ 
        cdr = st.executeQuery("SELECT password FROM user where username='"+username+"'");
        return cdr; }

    public void modPassword(String username,String password) throws SQLException{
        st.executeUpdate("update user set password='"+password+"' where username='"+username+"'");
    }

    public void modEmail(String username,String email) throws SQLException{
        st.executeUpdate("update user set email='"+email+"' where username='"+username+"'");
    }

    public ResultSet subjectsJAVA() throws SQLException{
                cdr = st.executeQuery("SELECT subjectname FROM subject where course_idcourse='1'");
        return cdr;
    }
    
    public ResultSet subjectsPLSQL() throws SQLException{
                cdr = st.executeQuery("SELECT subjectname FROM subject where course_idcourse='2'");
        return cdr;
    }
    

    public void createUser(
            String username,String password,String email) throws SQLException{
                st.executeUpdate("insert into user (username,password,email) values('"+username+"','"+password+"','"+email+"')");                    
    }

}
