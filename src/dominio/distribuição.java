package dominio;

import java.util.ArrayList;

public class distribuição {
    ArrayList<anime> anime = new ArrayList<>();
	ArrayList<plataforma> plataforma = new ArrayList<>();
	private int cod_distribuicao; // codigo da distirbuição - chave primaria
	private int cod_a; // codigo do anime
	private int cod_p; // codigo da plataforma
	public distribuição(){
	}
	public distribuição(int cod_distribuicao, int cod_a, int cod_p) {
		this.cod_distribuicao = cod_distribuicao;
		this.cod_p = cod_p;
		this.cod_a= cod_a;
	}
	
	public ArrayList<anime> getAnime() {
		return anime;
	}

	public void setAnime(ArrayList<anime> anime) {
		this.anime = anime;
	}

	public ArrayList<plataforma> getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(ArrayList<plataforma> plataforma) {
		this.plataforma = plataforma;
	}

	public int getCod_distribuicao() {
		return cod_distribuicao;
	}
	
	public void setCod_distribuicao(int cod_distribuicao) {
		this.cod_distribuicao= cod_distribuicao;
	}
	
	public int getCod_p() {
		return cod_p;
	}
	
	public void setCod_p(int cod_p) {
		this.cod_p = cod_p;
	}

	public int getCod_a() {
		return cod_a;
	}
	
	public void setCod_a(int cod_a) {
		this.cod_a= cod_a;
	}

}
