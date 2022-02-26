package dominio;

import java.util.ArrayList;

public class plataforma {
	private int cod_p; // codigo da plataforma - chave primaria
	private int n_animes; // numero de animes
	private int n_assinantes; // numero de assinantes
	private String nome_p; // nome da plataforma 
	private ArrayList <anime> animes= new ArrayList();
	public plataforma(){
	}
	
	public plataforma(int cod_p, int n_animes, int n_assinantes, String nome_p) {
		this.cod_p = cod_p;
		this.n_assinantes = n_assinantes;
		this.nome_p = nome_p;
		this.n_animes= n_animes;
	}
	
	public int getCod_p() {
		return cod_p;
	}
	
	public void setCod_p(int cod_p) {
		this.cod_p = cod_p;
	}

	public int getN_assinantes() {
		return n_assinantes;
	}
	
	public void setN_assinantes(int n_assinantes) {
		this.n_assinantes= n_assinantes;
	}
	public int getN_animes() {
		return n_animes;
	}
	
	public void setN_animes(int n_animes) {
		this.n_animes= n_animes;
	}
	public String getNome_p() {
		return nome_p;
	}
	
	public void setNome_p(String nome_p) {
		this.nome_p = nome_p;
	}

	public ArrayList <anime> getAnimes() {
		return animes;
	}

	public void setAnimes(ArrayList <anime> animes) {
		this.animes = animes;
	}
	
}
