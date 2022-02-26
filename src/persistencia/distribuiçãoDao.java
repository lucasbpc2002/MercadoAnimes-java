package persistencia;

import dominio.distribuição;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class distribuiçãoDao {
	    private conexão minhaConexao ;
	    private final String RELATORIO = "select * from distribuição";
	    private final String BUSCAR = "select * from distribuição where cod_distribuição=?";
	    private final String INCLUIR = "insert into distribuição (cod_distribuição, cod_anime, cod_plataforma) values (?, ?, ?)";
	    private final String EXCLUIR_POR_ANIME = "delete from distribuição where cod_anime=?";
	    private final String EXCLUIR_POR_PLATAFORMA = "delete from distribuição where cod_plataforma=?";
	    private final String ALTERAR = "update distribuição set cod_anime=?,"
	            + "cod_plataforma=? where cod_distribuição=?";
	    
	    public distribuiçãoDao() {
	    	minhaConexao= new conexão();
	    }
	    public ArrayList<distribuição> relatorio(){
	        ArrayList<distribuição> lista = new ArrayList<>();
	        try{
	            minhaConexao.conectar();
	            Statement instrucao = minhaConexao.getconexão().createStatement();
	            ResultSet rs = instrucao.executeQuery(RELATORIO);
	            while(rs.next()){
	            	distribuição distribuição = new distribuição (rs.getInt("cod_distribuição"),rs.getInt("cod_anime"), 
	                                    rs.getInt("cod_plataforma"));
	                lista.add(distribuição);
	            }
	            minhaConexao.desconectar();
	        }catch(SQLException e){
	            System.out.println("Erro no relatorio: "+e.getMessage());
	        }
	        return lista;
	    }
	    public distribuição buscar(int cod_distribuicao){
	    	distribuição distribuição = null;
	        try{
	            minhaConexao.conectar();
	            PreparedStatement instrucao = 
	                    minhaConexao.getconexão().prepareStatement(BUSCAR);
	            instrucao.setInt(1, cod_distribuicao);
	            ResultSet rs = instrucao.executeQuery();
	            if(rs.next()){
	            	distribuição = new distribuição(rs.getInt("cod_distribuição"),rs.getInt("cod_anime"),
	                        rs.getInt("cod_plataforma"));
	            }
	            minhaConexao.desconectar();
	        }catch(SQLException e){
	            System.out.println("Erro na busca: "+e.getMessage());
	        }
	        return distribuição;
	    }
	    
	    public void inclusao(distribuição distribuição){
	        try{
	            minhaConexao.conectar();
	            PreparedStatement instrucao = 
	                    minhaConexao.getconexão().prepareStatement(INCLUIR);
	            instrucao.setInt(1, distribuição.getCod_distribuicao());
	            instrucao.setInt(2, distribuição.getCod_a());
	            instrucao.setInt(3, distribuição.getCod_p());
	            instrucao.execute();
	            minhaConexao.desconectar();
	        }catch(Exception e){
	            System.out.println("Erro na inclusão: "+e.getMessage());
	        }
	    }
	     
	    public void excluirPorAnime(int cod_anime){
	        try{
	            minhaConexao.conectar();
	            PreparedStatement instrucao = 
	                    minhaConexao.getconexão().prepareStatement(EXCLUIR_POR_ANIME);
	            instrucao.setInt(1, cod_anime);
	            instrucao.execute();
	            minhaConexao.desconectar();
	        }catch(Exception e){
	            System.out.println("Erro na exclusão: "+e.getMessage());
	        }
	    }
	    public void excluir_Por_Plataforma(int cod_plataforma){
	        try{
	            minhaConexao.conectar();
	            PreparedStatement instrucao = 
	                    minhaConexao.getconexão().prepareStatement(EXCLUIR_POR_PLATAFORMA);
	            instrucao.setInt(1, cod_plataforma);
	            instrucao.execute();
	            minhaConexao.desconectar();
	        }catch(Exception e){
	            System.out.println("Erro na exclusão: "+e.getMessage());
	        }
	    }
	    
	    public void alteracao(distribuição d, int cod_distribuicaoAntigo){
	        try{
	            minhaConexao.conectar();
	            PreparedStatement instrucao = 
	                    minhaConexao.getconexão().prepareStatement(ALTERAR);
	            instrucao.setInt(1, d.getCod_a());
	            instrucao.setInt(2, d.getCod_p());
	            instrucao.setInt(3, cod_distribuicaoAntigo);
	            instrucao.execute();
	            minhaConexao.desconectar();
	        }catch(Exception e){
	            System.out.println("Erro na alteração: "+e.getMessage());
	        }
	    }    
}
