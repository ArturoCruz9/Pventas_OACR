package Modelo;
import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {
    Conexion cn= new Conexion();
    Connection con ;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    public Producto buscar(String dni){
    Producto p= new Producto();
    String sql ="select * from producto where Dni="+dni;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                 p.setId(rs.getInt(1));
                 p.setNom(rs.getString(2));
                 p.setPre(rs.getDouble(3));
                 p.setSto(rs.getInt(4));
                 p.setEst(rs.getString(5));
                
            }
        } catch (Exception e) {
          
        }
          return p;
    }
    //operaciones CRUD
    public List listar(){
     String  sql ="select * from producto";
     List<Producto>lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs =ps.executeQuery();
            while(rs.next()){
                Producto p = new Producto();
                p.setId(rs.getInt(1));
                p.setNom(rs.getString(2));
                p.setPre(rs.getDouble(3));
                p.setSto(rs.getInt(4));
                p.setEst(rs.getString(5));
                lista.add(p);
            }
        } catch (Exception e) {
        }
        return lista;
    }
    
    public int agregar(Producto p){
        String sql= "insert into Producto(Id, Nombre, Precio, Stock, Estado)values(?,?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, p.getId());
            ps.setString(2, p.getNom());
            ps.setDouble(3, p.getPre());
            ps.setInt(4, p.getSto());
            ps.setString(5, p.getEst());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
    
    public Producto listarId(int id){
      Producto pr =new Producto();
      String sql = "select * from Producto where IdProducto="+id;
        try {
            con = cn.Conexion();
            ps=con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                pr.setId(rs.getInt(1));
                pr.setNom(rs.getString(2));
                pr.setPre(rs.getDouble(3));
                pr.setSto(rs.getInt(4));
                pr.setEst(rs.getString(5));
                
            
            }
        } catch (Exception e) {
        }
        return pr; 
    }
    
    public int actualizar(Producto pr){
        String sql= "update producto set Id=?, Nombre=?, Precio=?, Stock=?, Estado=? where IdProducto=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, pr.getId());
            ps.setString(2, pr.getNom());
            ps.setDouble(3, pr.getPre());
            ps.setInt(4, pr.getSto());
            ps.setString(5, pr.getEst());
            ps.executeUpdate(); 
        } catch (Exception e) {
        }
        return r;
    }
    
    public void delete(int id){
        String sql = "delete from producto where IdProducto="+id;
        try {
            con=cn.Conexion();
            ps= con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
}
