package dominio;

public class anime extends abs implements produtos{
	private int cod_a; // codigo do anime - chave primaria
	private int n_episodios; // numero de episodios do anime
	private String nome_a; // nome do anime
	private String genero_a; // genero do anime
	public anime(){
		
	}
	
	public anime(int cod_a, int n_episodios, String nome_a, String genero_a) {
		this.cod_a = cod_a;
		this.n_episodios = n_episodios;
		this.nome_a = nome_a;
		this.genero_a = genero_a;
	}
	public int getCod_a() {
		return cod_a;
	}
	
	public void setCod_a(int cod_a) {
		this.cod_a = cod_a;
	}

	public int getN_episodios() {
		return n_episodios;
	}
	
	public void setN_episodios(int n_episodios) {
		this.n_episodios = n_episodios;
	}
	public String getNome_a() {
		return nome_a;
	}
	public void setNome_a(String nome_a) {
		this.nome_a = nome_a;
	}
	
	public String getGenero_a() {
		return genero_a;
	}
	
	public void setGenero_a(String genero_a) {
		this.genero_a = genero_a;
	}

	@Override
	public String getnome() {
		// TODO Auto-generated method stub
		return nome_a;
	}

	@Override
	public void representacao() {
		System.out.println("\nAnime: "+getnome()+"numero de episodios "+getN_episodios());
	}
}