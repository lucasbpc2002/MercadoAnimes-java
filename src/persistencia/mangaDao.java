package persistencia;

import dominio.manga;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class mangaDao {
	    private conexão minhaConexao = new conexão();
	    private final String RELATORIO = "select * from manga";
	    private final String BUSCAR = "select * from manga where Cod_manga =?";
	    private final String INCLUIR = "insert into manga (Cod_manga , datapub, nome_manga,nome_autor,distribuidora) values (?, ?, ?,?, ?)";
	    private final String EXCLUIR = "delete from manga where Cod_manga =?";
	    private final String ALTERAR = "update manga set datapub=?, nome_manga=?, nome_autor=?,"
	            + "distribuidora=? where Cod_manga =?";
	    
	    public mangaDao() {
	    	minhaConexao= new conexão();
	    }
	    public ArrayList<manga> relatorio(){
	        ArrayList<manga> lista = new ArrayList<>();
	        try{
	            minhaConexao.conectar();
	            Statement instrucao = minhaConexao.getconexão().createStatement();
	            ResultSet rs = instrucao.executeQuery(RELATORIO);
	            while(rs.next()){
	                manga manga = new manga (rs.getInt("Cod_manga"),rs.getInt("datapub"), rs.getString("nome_manga"), rs.getString("nome_autor"),
	                                    rs.getString("distribuidora"));
	                lista.add(manga);
	            }
	            minhaConexao.desconectar();
	        }catch(SQLException e){
	            System.out.println("Erro no relatorio: "+e.getMessage());
	        }
	        return lista;
	    }
	    public manga buscar(int cod_m){
	    	manga manga = null;
	        try{
	            minhaConexao.conectar();
	            PreparedStatement instrucao = 
	                    minhaConexao.getconexão().prepareStatement(BUSCAR);
	            instrucao.setInt(1, cod_m);
	            ResultSet rs = instrucao.executeQuery();
	            if(rs.next()){
	                manga = new manga(rs.getInt("Cod_manga"),rs.getInt("datapub"),rs.getString("nome_manga"),rs.getString("nome_autor"),
	                        rs.getString("distribuidora"));
	            }
	            minhaConexao.desconectar();
	        }catch(SQLException e){
	            System.out.println("Erro na busca: "+e.getMessage());
	        }
	        return manga;
	    }
	    
	    public void inclusao(manga manga){
	        try{
	            minhaConexao.conectar();
	            PreparedStatement instrucao = 
	                    minhaConexao.getconexão().prepareStatement(INCLUIR);
	            instrucao.setInt(1, manga.getCod_m());
	            instrucao.setInt(2, manga.getData_pub());
	            instrucao.setString(3, manga.getNome_m());
	            instrucao.setString(4, manga.getNome_autor());
	            instrucao.setString(5, manga.getDistribuidora());
	            instrucao.execute();
	            minhaConexao.desconectar();
	        }catch(Exception e){
	            System.out.println("Erro na inclusão: "+e.getMessage());
	        }
	    }
	     
	    public void exclusao(int cod_m){
	        try{
	            minhaConexao.conectar();
	            PreparedStatement instrucao = 
	                    minhaConexao.getconexão().prepareStatement(EXCLUIR);
	            instrucao.setInt(1, cod_m);
	            instrucao.execute();
	            minhaConexao.desconectar();
	        }catch(Exception e){
	            System.out.println("Erro na exclusão: "+e.getMessage());
	        }
	    }
	    
	    public void alteracao(manga m, int cod_mAntigo){
	        try{
	            minhaConexao.conectar();
	            PreparedStatement instrucao = 
	                    minhaConexao.getconexão().prepareStatement(ALTERAR);
	            instrucao.setInt(1, m.getData_pub());
	            instrucao.setString(2, m.getNome_m());
	            instrucao.setString(3, m.getNome_autor());
	            instrucao.setString(4, m.getDistribuidora());
	            instrucao.setInt(5, cod_mAntigo);
	            instrucao.execute();
	            minhaConexao.desconectar();
	        }catch(Exception e){
	            System.out.println("Erro na alteração: "+e.getMessage());
	        }
	    }    
}
