package persistencia;

import dominio.plataforma;
import dominio.sistema;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class sistemaDao {
	    private conexão minhaConexao;
	    private final String RELATORIO = "select*from sistema ";
	    private final String BUSCAR = "select sis.Cod_sistema, sis.nome_adm, plat.Cod_plataforma, plat.nome_plataforma, plat.n_animes, plat.n_assinantes  from sistema sis"
	    		+ " left join supervisão sv on sv.cod_sistema=sis.Cod_sistema"
	    		+ " left join plataforma plat on sv.cod_plataforma= plat.Cod_plataforma where sis.cod_sistema=?";
	    private final String INCLUIR = "insert into sistema (cod_sistema,nome_adm) values (?, ?)";
	    private final String EXCLUIR = "delete from sistema where cod_sistema=?";
	    private final String ALTERAR = "update sistema set nome_adm=? where cod_sistema=?";
	    
	    public sistemaDao() {
	    	minhaConexao= new conexão();
	    }
	    public ArrayList<sistema> relatorio(){
	        ArrayList<sistema> lista = new ArrayList<>();
	        try{
	            minhaConexao.conectar();
	            Statement instrucao = minhaConexao.getconexão().createStatement();
	            ResultSet rs = instrucao.executeQuery(RELATORIO);
	            while(rs.next()){
	            	sistema sistema = new sistema (rs.getInt("cod_sistema"),
	                                    rs.getString("nome_adm"));
	                lista.add(sistema);
	            }
	            minhaConexao.desconectar();
	        }catch(SQLException e){
	            System.out.println("Erro no relatorio: "+e.getMessage());
	        }
	        return lista;
	    }
	    public sistema buscar(int cod_s){
	    	sistema sistema = null;
	        try{
	            minhaConexao.conectar();
	            PreparedStatement instrucao = 
	                    minhaConexao.getconexão().prepareStatement(BUSCAR);
	            instrucao.setInt(1, cod_s);
	            ResultSet rs = instrucao.executeQuery();
	            while(rs.next()){
	            	if(rs.isFirst()) {
	            	sistema = new sistema(rs.getInt("cod_sistema"),
	                        rs.getString("nome_adm"));
	            	}
	            	if(rs.getString("nome_plataforma")!=null) {
	            	sistema.getPlataformas().add( new plataforma(rs.getInt("Cod_plataforma"),rs.getInt("n_animes"),rs.getInt("n_assinantes"),
	   	                 rs.getString("nome_plataforma")));
	            	}
	            }
	            minhaConexao.desconectar();
	        }catch(SQLException e){
	            System.out.println("Erro na busca: "+e.getMessage());
	        }
	        return sistema;
	    }
	    
	    public void inclusao(sistema sistema){
	        try{
	            minhaConexao.conectar();
	            PreparedStatement instrucao = 
	                    minhaConexao.getconexão().prepareStatement(INCLUIR);
	            instrucao.setInt(1, sistema.getCod_s());
	            instrucao.setString(2, sistema.getNome_adm());
	            instrucao.execute();
	            minhaConexao.desconectar();
	        }catch(Exception e){
	            System.out.println("Erro na inclusão: "+e.getMessage());
	        }
	    }
	     
	    public void exclusao(int cod_s){
	        try{
	            minhaConexao.conectar();
	            PreparedStatement instrucao = 
	                    minhaConexao.getconexão().prepareStatement(EXCLUIR);
	            instrucao.setInt(1, cod_s);
	            instrucao.execute();
	            minhaConexao.desconectar();
	        }catch(Exception e){
	            System.out.println("Erro na exclus�o: "+e.getMessage());
	        }
	    }
	    
	    public void alteracao(sistema s, int cod_sAntigo){
	        try{
	            minhaConexao.conectar();
	            PreparedStatement instrucao = 
	                    minhaConexao.getconexão().prepareStatement(ALTERAR);
	            instrucao.setString(1, s.getNome_adm());
	            instrucao.setInt(2, cod_sAntigo);
	            instrucao.execute();
	            minhaConexao.desconectar();
	        }catch(Exception e){
	            System.out.println("Erro na alteração: "+e.getMessage());
	        }
	    }    
}
