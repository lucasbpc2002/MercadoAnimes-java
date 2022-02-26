package dominio;

import java.util.ArrayList;

public class sistema {
	private int cod_s; // codigo do sistema
	private String nome_adm; // nome do administrador do sistema
	private ArrayList <plataforma> plataformas= new ArrayList();
	public sistema(){
	}
	
	public sistema(int cod_s, String nome_adm) {
		this.cod_s = cod_s;
		this.nome_adm = nome_adm;
	}
	
	public int getCod_s() {
		return cod_s;
	}
	
	public void setCod_s(int cod_s) {
		this.cod_s = cod_s;
	}

	public String getNome_adm() {
		return nome_adm;
	}
	
	public void setNome_adm(String nome_adm) {
		this.nome_adm = nome_adm;
	}

	public ArrayList <plataforma> getPlataformas() {
		return plataformas;
	}

	public void setPlataformas(ArrayList <plataforma> plataformas) {
		this.plataformas = plataformas;
	}
}
