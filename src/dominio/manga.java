package dominio;


public class manga {
	private int cod_m; // codigo do manga -chave primaria
	private int data_pub; // ano de publicação
	private String nome_m; // nome do manga 
	private String nome_autor; // nome do autor 
	private String distribuidora; // nome da distribuidora
	public manga(){
	}
	
	public manga(int cod_m, int data_pub, String nome_m, String nome_autor, String distribuidora) {
		this.cod_m = cod_m;
		this.data_pub = data_pub;
		this.nome_m = nome_m;
		this.nome_autor = nome_autor;
		this. distribuidora= distribuidora;
	}
	
	public int getCod_m() {
		return cod_m;
	}
	
	public void setCod_m(int cod_m) {
		this.cod_m = cod_m;
	}

	public int getData_pub() {
		return data_pub;
	}
	
	public void setData_pub(int data_pub) {
		this.data_pub= data_pub;
	}
	
	public String getNome_m() {
		return nome_m;
	}
	
	public void setNome_m(String nome_m) {
		this.nome_m = nome_m;
	}
	public String getNome_autor() {
		return nome_autor;
	}
	
	public void setNome_autor(String nome_autor) {
		this.nome_autor = nome_autor;
	}
	
	public String getDistribuidora() {
		return distribuidora;
	}
	
	public void setDistribuidora(String distribuidora) {
		this.distribuidora = distribuidora;
	}
}
