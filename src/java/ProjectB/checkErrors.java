package ProjectB;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Borjo
 */
public class checkErrors {

    //Comprueba si el String es null
    static public boolean isNull(String aux){ 
        if(aux==null){
            return true;
        }
        else
            return false;        
    }
    
    //Comprueba que 2 Strings son iguales
    static public boolean areEqual(String aux1,String aux2){ 
        if(aux1.equals(aux2))
            return true;
        else
            return false;
    }

    //Comprueba si el correo existe en la BD
    static public boolean emailExists(String email) throws ClassNotFoundException, java.sql.SQLException {
            DB BDbuscar=new DB();
            String aux=null;
            java.sql.ResultSet rec;
            rec=BDbuscar.emails();
            while(rec.next()){
                aux=rec.getString(1);                        
                if((aux).equals(email)){
                    BDbuscar.closeConnection();
                    return true;
                }
            }
            BDbuscar.closeConnection();
            return false;
    }

    //Comprueba si el username existe en la BD
    static public boolean usernameExists(String username)throws ClassNotFoundException, java.sql.SQLException{
            DB BDbuscar=new DB();
            java.sql.ResultSet rec;
            String aux;
            BDbuscar.connect();
            rec=BDbuscar.usernames();
            while(rec.next()){
                aux=rec.getString(1);                
                if(aux.equals(username)){
                    BDbuscar.closeConnection();
                    return true;
                }
            }
            BDbuscar.closeConnection();
            return false;
    }
    static public boolean autentify(String username,String password)throws ClassNotFoundException, java.sql.SQLException{
            DB BDbuscar=new DB();
            java.sql.ResultSet rec; 
            BDbuscar.connect(); 
            rec=BDbuscar.searchPASSWORDbyUSERNAME(username);
            String auxpass; 
            if(rec.next()){
                auxpass=rec.getString(1);
            if(auxpass.equals(password)){
                BDbuscar.closeConnection();
                return true; }
            } 
            BDbuscar.closeConnection(); 
            return false;
    }
    static public boolean autentifyPassword(String username,String current_password, String password,String password_confirmation)throws ClassNotFoundException, java.sql.SQLException{
        DB BDbuscar=new DB();
            java.sql.ResultSet rec; 
            BDbuscar.connect();
        if(checkErrors.autentify(username, current_password)){
            if (password.equals(password_confirmation))
               BDbuscar.modPassword(username, password);
                BDbuscar.closeConnection();
                return true; 
            }
        else{
                return false;}
    
    }

}
