package FelixModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author FELIX
 */
public class ConsultasUsuario extends Conexion {
    
    public ResultSet obtenerU() throws ClassNotFoundException {
        return this.consultarUsuarios("SELECT id_vendedor,  nombre, apellido_paterno, apellido_materno, direccion, telefono, nivel_usuario, id_sucursal, id_horario, fecha_ingreso, detalles FROM vendedor");
    }

    public boolean guardar(UsuarioModelo umodelo) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "INSERT INTO vendedor( nombre, apellido_paterno, apellido_materno, direccion, telefono,nivel_usuario, id_sucursal, id_horario, fecha_ingreso, detalles, estado, pass) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
        try {
            ps = con.prepareStatement(sql);
            
            
            ps.setString(1, umodelo.getNombre());
            ps.setString(2, umodelo.getApellidoPaterno());
            ps.setString(3, umodelo.getApellidoMaterno());
            ps.setString(4, umodelo.getDireccion());
            ps.setString(5, umodelo.getTelefono());
            ps.setInt(6, umodelo.getNivelUsuario());
            ps.setInt(7, umodelo.getId_sucursal());
            ps.setInt(8, umodelo.getId_horario());
            ps.setString(9, umodelo.getFechaIngreso());
            ps.setString(10, umodelo.getDetalles());
            ps.setInt(11, 1);
            ps.setString(12, umodelo.getPass());

            ps.execute();
            return true;

        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }

    }

    public boolean modificarU(UsuarioModelo umodelo) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "UPDATE vendedor SET nombre=?, apellido_paterno=?, apellido_materno=?, direccion=?, telefono=?, nivel_usuario=?, id_sucursal=?, id_horario=?, fecha ingreso=?, detalles=? WHERE id_vendedor=?";
        try {
            ps = con.prepareStatement(sql);

            ps.setString(2, umodelo.getNombre());
            ps.setString(3, umodelo.getApellidoPaterno());
            ps.setString(4, umodelo.getApellidoMaterno());
            ps.setString(5, umodelo.getDireccion());
            ps.setString(6, umodelo.getTelefono());
            ps.setInt(1, umodelo.getNivelUsuario());
            ps.setInt(7, umodelo.getId_sucursal());
            ps.setInt(8, umodelo.getId_horario());
            ps.setString(9, umodelo.getFechaIngreso());
            ps.setString(10, umodelo.getDetalles());
           
            ps.execute();
            return true;

        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public boolean eliminarU(int id) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "Update vendedor Set estado=0  WHERE id_vendedor=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            ps.execute();
            return true;

        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }

    }

    public boolean buscar(UsuarioModelo umodelo) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = "SELECT * FROM vendedor WHERE nombre=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, umodelo.getNombre());

            rs = ps.executeQuery();
            if (rs.next()) {
                umodelo.setId_vendedor(Integer.parseInt(rs.getString("id")));
                umodelo.setNombre(rs.getString("nombre"));
                umodelo.setApellidoPaterno(rs.getString("apellido paterno"));
            }
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }

    }
}
