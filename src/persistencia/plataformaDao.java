package persistencia;

import dominio.anime;
import dominio.plataforma;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class plataformaDao {
	    private conexão minhaConexao;
	    private final String RELATORIO = "select*from plataforma";
	    private final String BUSCAR = "select plat.Cod_plataforma, plat.nome_plataforma,plat.n_animes, plat.n_assinantes, ani.Cod_anime, ani.nome_anime, ani.genero, ani.n_episodios from plataforma plat "
	    		+ "left join distribuição dis on dis.cod_plataforma=plat.Cod_plataforma "
	    		+ "left join anime ani on dis.cod_anime= ani.Cod_anime where plat.Cod_plataforma=?";
	    private final String INCLUIR = "insert into plataforma (Cod_plataforma, n_animes, n_assinantes,nome_plataforma) values (?, ?, ?,?)";
	    private final String EXCLUIR = "delete from plataforma where Cod_plataforma=?";
	    private final String ALTERAR = "update plataforma set n_animes=?, n_assinantes=?, "
	            + "nome_plataforma=? where Cod_plataforma=?";
	    
	    public plataformaDao() {
	    	minhaConexao= new conexão();
	    }
	    public ArrayList<plataforma> relatorio(){
	        ArrayList<plataforma> lista = new ArrayList<>();
	        try{
	            minhaConexao.conectar();
	            Statement instrucao = minhaConexao.getconexão().createStatement();
	            ResultSet rs = instrucao.executeQuery(RELATORIO);
	            while(rs.next()){
	            	plataforma plataforma = new plataforma (rs.getInt("Cod_plataforma"),rs.getInt("n_animes"), rs.getInt("n_assinantes"),
	                                    rs.getString("nome_plataforma"));
	                lista.add(plataforma);
	            }
	            minhaConexao.desconectar();
	        }catch(SQLException e){
	            System.out.println("Erro no relatorio: "+e.getMessage());
	        }
	        return lista;
	    }
	    public plataforma buscar(int cod_p){
	    	plataforma plataforma = null;
	        try{
	            minhaConexao.conectar();
	            PreparedStatement instrucao = 
	                    minhaConexao.getconexão().prepareStatement(BUSCAR);
	            instrucao.setInt(1, cod_p);
	            ResultSet rs = instrucao.executeQuery();
	            while(rs.next()){
	            if(rs.isFirst()){
	            	plataforma = new plataforma(rs.getInt("Cod_plataforma"),rs.getInt("n_animes"),rs.getInt("n_assinantes"),
	                        rs.getString("nome_plataforma"));
	            }
	            if(rs.getString("nome_anime")!=null) {
	            plataforma.getAnimes().add(new anime(rs.getInt("Cod_anime"),rs.getInt("n_episodios"),rs.getString("nome_anime"),
	                        rs.getString("genero")));
	            }
	            }
	            minhaConexao.desconectar();
	        }catch(SQLException e){
	            System.out.println("Erro na busca: "+e.getMessage());
	        }
	        return plataforma;
	    }
	    
	    public void inclusao(plataforma plataforma){
	        try{
	            minhaConexao.conectar();
	            PreparedStatement instrucao = 
	                    minhaConexao.getconexão().prepareStatement(INCLUIR);
	            instrucao.setInt(1, plataforma.getCod_p());
	            instrucao.setInt(2, plataforma.getN_animes());
	            instrucao.setInt(3, plataforma.getN_assinantes());
	            instrucao.setString(4, plataforma.getNome_p());
	            instrucao.execute();
	            minhaConexao.desconectar();
	        }catch(Exception e){
	            System.out.println("Erro na inclusão: "+e.getMessage());
	        }
	    }
	     
	    public void exclusao(int cod_p){
	        try{
	            minhaConexao.conectar();
	            PreparedStatement instrucao = 
	                    minhaConexao.getconexão().prepareStatement(EXCLUIR);
	            instrucao.setInt(1, cod_p);
	            instrucao.execute();
	            minhaConexao.desconectar();
	        }catch(Exception e){
	            System.out.println("Erro na exclusão: "+e.getMessage());
	        }
	    }
	    
	    public void alteracao(plataforma p, int cod_pAntigo){
	        try{
	            minhaConexao.conectar();
	            PreparedStatement instrucao = 
	                    minhaConexao.getconexão().prepareStatement(ALTERAR);
	            instrucao.setInt(1, p.getN_animes());
	            instrucao.setInt(2, p.getN_assinantes());
	            instrucao.setString(3, p.getNome_p());
	            instrucao.setInt(4, cod_pAntigo);
	            instrucao.execute();
	            minhaConexao.desconectar();
	        }catch(Exception e){
	            System.out.println("Erro na alteração: "+e.getMessage());
	        }
	    }    
}
