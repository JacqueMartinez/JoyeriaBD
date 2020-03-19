package FelixModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author FELIX
 */
public class Conexion {
    static  Connection conexion = null;
    public static String usuario="root";
    public static String passw="";
    public static boolean status= false;
    protected Statement pst = null;
   
    public  Connection getConexion(){
         String url="jdbc:mysql://localhost:3306/bdjoyeria";
       
        try{
            conexion = DriverManager.getConnection(url, this.usuario, this.passw);
            status= true;
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "error "+ e.getMessage(),"error de conexiones",JOptionPane.ERROR_MESSAGE);
        }
       return conexion;
     
       
    }
    
    protected ResultSet consultarHorarios(String sql){
        try {
            conexion = getConexion();
            pst = conexion.createStatement();
            ResultSet rs= pst.executeQuery(sql);
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    protected ResultSet consultarUsuarios(String sql){
        try {
            conexion = getConexion();
            pst = conexion.createStatement();
            ResultSet rs= pst.executeQuery(sql);
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
}
