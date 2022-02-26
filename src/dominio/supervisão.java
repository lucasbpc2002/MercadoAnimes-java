package dominio;

import java.util.ArrayList;

public class supervisão {
	ArrayList<plataforma> plataforma = new ArrayList<>();
	ArrayList<sistema> sistema = new ArrayList<>();
	private int cod_supervisão; // codigo para supervisão - chave primaria
	private int cod_p; // codigo da plataforma
	private int cod_s; // codigo do sistema

	public supervisão() {
	}

	public supervisão(int cod_supervisão, int cod_p, int cod_s) {
		this.cod_supervisão = cod_supervisão;
		this.cod_p = cod_p;
		this.cod_s = cod_s;
	}
	public ArrayList<plataforma> getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(ArrayList<plataforma> plataforma) {
		this.plataforma = plataforma;
	}
	public ArrayList<sistema> getSistema() {
		return sistema;
	}

	public void setSistema(ArrayList<sistema> sistema) {
		this.sistema = sistema;
	}

	public int getCod_supervisão() {
		return cod_supervisão;
	}

	public void setCod_supervisão(int cod_supervisão) {
		this.cod_supervisão = cod_supervisão;
	}

	public int getCod_p() {
		return cod_p;
	}

	public void setCod_p(int cod_p) {
		this.cod_p = cod_p;
	}

	public int getCod_s() {
		return cod_s;
	}

	public void setCod_s(int cod_s) {
		this.cod_s = cod_s;
	}

}
