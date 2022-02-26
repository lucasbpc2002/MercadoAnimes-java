package persistencia;

import dominio.anime;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class animeDao {
	    private conexão minhaConexao;
	    private final String RELATORIO = "select * from anime";
	    private final String BUSCAR = "select * from anime where Cod_anime= ?";
	    private final String INCLUIR = "insert into anime (Cod_anime, n_episodios, nome_anime,genero) values (?, ?, ?,?)";
	    private final String EXCLUIR = "delete from anime where Cod_anime=?";
	    private final String ALTERAR = "update anime set  n_episodios=?,nome_anime=?, "
	            + "genero=? where Cod_anime=?";
	    
	    public animeDao() {
	    	minhaConexao= new conexão();
	    }
	    public ArrayList<anime> relatorio(){
	        ArrayList<anime> lista = new ArrayList<>();
	        try{	        	
	        	minhaConexao.conectar();
	            Statement instrucao = minhaConexao.getconexão().createStatement();
	            ResultSet rs = instrucao.executeQuery(RELATORIO);
	            while(rs.next()){
	            	anime anime = new anime (rs.getInt("cod_anime"),rs.getInt("n_episodios"), rs.getString("nome_anime"),
	                                    rs.getString("genero"));
	                lista.add(anime);
	            }
	            minhaConexao.desconectar();
	        }catch(SQLException e){
	            System.out.println("Erro no relatorio: "+e.getMessage());
	        }
	        return lista;
	    }
	    
	    public anime buscar(int cod_a){
	    	anime anime = null;
	        try{
	            minhaConexao.conectar();
	            PreparedStatement instrucao = 
	                    minhaConexao.getconexão().prepareStatement(BUSCAR);
	            instrucao.setInt(1, cod_a);
	            ResultSet rs = instrucao.executeQuery();
	            if(rs.next()){
	            	anime = new anime(rs.getInt("Cod_anime"),rs.getInt("n_episodios"),rs.getString("nome_anime"),
	                        rs.getString("genero"));
	            }
	            minhaConexao.desconectar();
	        }catch(SQLException e){
	            System.out.println("Erro na busca: "+e.getMessage());
	        }
	        return anime;
	    }
	    
	    public void inclusao(anime anime){
	        try{
	            minhaConexao.conectar();
	            PreparedStatement instrucao = 
	                    minhaConexao.getconexão().prepareStatement(INCLUIR);
	            instrucao.setInt(1, anime.getCod_a());
	            instrucao.setInt(2, anime.getN_episodios());
	            instrucao.setString(3, anime.getnome());
	            instrucao.setString(4, anime.getGenero_a());
	            instrucao.execute();
	            minhaConexao.desconectar();
	        }catch(Exception e){
	            System.out.println("Erro na inclusão: "+e.getMessage());
	        }
	    }
	     
	    public void exclusao(int cod_a){
	        try{
	            minhaConexao.conectar();
	            PreparedStatement instrucao = 
	                    minhaConexao.getconexão().prepareStatement(EXCLUIR);
	            instrucao.setInt(1, cod_a);
	            instrucao.execute();
	            minhaConexao.desconectar();
	        }catch(Exception e){
	            System.out.println("Erro na exclusão: "+e.getMessage());
	        }
	    }
	    
	    public void alteracao(anime a, int cod_aAntigo){
	        try{
	            minhaConexao.conectar();
	            PreparedStatement instrucao = 
	                    minhaConexao.getconexão().prepareStatement(ALTERAR);
	            instrucao.setInt(1, a.getN_episodios());
	            instrucao.setString(2, a.getnome());
	            instrucao.setString(3, a.getGenero_a());
	            instrucao.setInt(4, cod_aAntigo);
	            instrucao.execute();
	            minhaConexao.desconectar();
	        }catch(Exception e){
	            System.out.println("Erro na alteração: "+e.getMessage());
	        }
	    }    
}
