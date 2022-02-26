package persistencia;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
public class conexão {
	private static final String user = "root";
	private static final String senha ="ivqcd4ig";
	private static final String caminho = "jdbc:mysql://localhost:3306/Manimes";
	static Connection connection ;
	
	public Connection conectar() {
		try {
			connection = DriverManager.getConnection(caminho, user, senha);
			System.out.println("coneção efetuada");
		}
		catch(SQLException e)
		{
			e.getMessage();
		}
		return connection;
	}
	
	public void desconectar() {
		try {
			connection.close();//fecha a conexao
		} catch (SQLException ex) {
			System.err.println(ex);
			ex.printStackTrace();
		}
	}

	public Connection getconexão() {
		// TODO Auto-generated method stub
		return connection;
	}

}
