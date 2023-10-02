package Modelo;
import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author ARTURO CRUZ
 */
public class ClienteDAO {
    Conexion cn= new Conexion();
    Connection con ;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    
    public Cliente buscar(String dni){
    Cliente c= new Cliente();
    String sql ="select * from cliente where Dni="+dni;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                 c.setId(rs.getInt(1));
                 c.setDni(rs.getString(2));
                 c.setNom(rs.getString(3));
                 c.setDir(rs.getString(4));
                 c.setEst(rs.getString(5));
                
            }
        } catch (Exception e) {
          
        }
          return c;
    }
    //operaciones CRUD
    public List listar(){
     String  sql ="select * from cliente";
     List<Cliente>lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs =ps.executeQuery();
            while(rs.next()){
                Cliente c = new Cliente();
                c.setId(rs.getInt(1));
                c.setDni(rs.getString(2));
                c.setDir(rs.getString(3));
                c.setNom(rs.getString(4));
                c.setEst(rs.getString(5));
                lista.add(c);
            }
        } catch (Exception e) {
        }
        return lista;
    }
    
    public int agregar(Cliente c){
        String sql= "insert into Cliente(Id, Dni, Direccion, Nombres, Estado)values(?,?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, c.getId());
            ps.setString(2, c.getDni());
            ps.setString(3, c.getDir());
            ps.setString(4, c.getNom());
            ps.setString(5, c.getEst());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
    
    public Cliente listarId(int id){
      Cliente cl =new Cliente();
      String sql = "select * from Cliente where IdCliente="+id;
        try {
            con = cn.Conexion();
            ps=con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                cl.setId(rs.getInt(2));
                cl.setDni(rs.getString(3));
                cl.setDir(rs.getString(4));
                cl.setNom(rs.getString(5));
                cl.setEst(rs.getString(6));
                
            
            }
        } catch (Exception e) {
        }
        return cl; 
    }
    
    public int actualizar(Cliente cli){
        String sql= "update cliente set Id=?, Dni=?, Direccion=?, Nombre=?, Estado=? where IdCliente=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, cli.getId());
            ps.setString(2, cli.getDni());
            ps.setString(3, cli.getDir());
            ps.setString(4, cli.getNom());
            ps.setString(5, cli.getEst());
            ps.executeUpdate(); 
        } catch (Exception e) {
        }
        return r;
    }
    
    public void delete(int id){
        String sql = "delete from cliente where IdCliente="+id;
        try {
            con=cn.Conexion();
            ps= con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
}
