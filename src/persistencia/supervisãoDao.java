package persistencia;

import dominio.supervisão;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class supervisãoDao {
	    private conexão minhaConexao;
	    private final String RELATORIO = "select * from supervisão";
	    private final String BUSCAR = "select * from supervisão where cod_supervisão=?";
	    private final String INCLUIR = "insert into supervisão (cod_supervisão, cod_plataforma, cod_sistema) values (?, ?, ?)";
	    private final String EXCLUIR_POR_SISTEMA = "delete from distribuição where cod_sistema=?";
	    private final String EXCLUIR_POR_PLATAFORMA = "delete from distribuição where cod_plataforma=?";
	    private final String ALTERAR = "update supervisão set cod_plataforma=?,"
	            + "cod_sistema=? where cod_supervisão=?";
	    
	    public supervisãoDao() {
	    	minhaConexao= new conexão();
	    }
	    public ArrayList<supervisão> relatorio(){
	        ArrayList<supervisão> lista = new ArrayList<>();
	        try{
	            minhaConexao.conectar();
	            Statement instrucao = minhaConexao.getconexão().createStatement();
	            ResultSet rs = instrucao.executeQuery(RELATORIO);
	            while(rs.next()){
	            	supervisão supervisão = new supervisão (rs.getInt("cod_supervisão"),rs.getInt("cod_plataforma"), 
	                                    rs.getInt("cod_sistema"));
	                lista.add(supervisão);
	            }
	            minhaConexao.desconectar();
	        }catch(SQLException e){
	            System.out.println("Erro no relatorio: "+e.getMessage());
	        }
	        return lista;
	    }
	    public supervisão buscar(int cod_supervisão){
	    	supervisão supervisão = null;
	        try{
	            minhaConexao.conectar();
	            PreparedStatement instrucao = 
	                    minhaConexao.getconexão().prepareStatement(BUSCAR);
	            instrucao.setInt(1, cod_supervisão);
	            ResultSet rs = instrucao.executeQuery();
	            if(rs.next()){
	            	supervisão  = new supervisão(rs.getInt("cod_supervisão"),rs.getInt("cod_plataforma"),
	                        rs.getInt("cod_sistema"));
	            }
	            minhaConexao.desconectar();
	        }catch(SQLException e){
	            System.out.println("Erro na busca: "+e.getMessage());
	        }
	        return supervisão;
	    }
	    
	    public void inclusao(supervisão supervisão){
	        try{
	            minhaConexao.conectar();
	            PreparedStatement instrucao = 
	                    minhaConexao.getconexão().prepareStatement(INCLUIR);
	            instrucao.setInt(1, supervisão.getCod_supervisão());
	            instrucao.setInt(2, supervisão.getCod_p());
	            instrucao.setInt(3, supervisão.getCod_s());
	            instrucao.execute();
	            minhaConexao.desconectar();
	        }catch(Exception e){
	            System.out.println("Erro na inclusão: "+e.getMessage());
	        }
	    }
	     
	    public void excluir_Por_Sistema(int cod_sistema){
	        try{
	            minhaConexao.conectar();
	            PreparedStatement instrucao = 
	                    minhaConexao.getconexão().prepareStatement(EXCLUIR_POR_SISTEMA);
	            instrucao.setInt(1, cod_sistema);
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
	    
	    public void alteracao(supervisão sv, int cod_supervisãoAntigo){
	        try{
	            minhaConexao.conectar();
	            PreparedStatement instrucao = 
	                    minhaConexao.getconexão().prepareStatement(ALTERAR);
	            instrucao.setInt(1, sv.getCod_p());
	            instrucao.setInt(2, sv.getCod_s());
	            instrucao.setInt(3, cod_supervisãoAntigo);
	            instrucao.execute();
	            minhaConexao.desconectar();
	        }catch(Exception e){
	            System.out.println("Erro na alteração: "+e.getMessage());
	        }
	    }    
}
