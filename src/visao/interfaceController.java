package visao;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Scanner;

import dominio.*;
import persistencia.*;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

public class interfaceController {
	private ObservableList<manga> mangas = FXCollections.observableArrayList();
	private ObservableList<anime> animes = FXCollections.observableArrayList();
	private ObservableList<plataforma> plataformas = FXCollections.observableArrayList();
	private ObservableList<sistema> sistemas = FXCollections.observableArrayList();
    @FXML
    private Tab manga;

    @FXML
    private Tab cadastrar_manga;

    @FXML
    private StackPane stkcadastro_m2;

    @FXML
    private Button bntoutrocadastro_m;

    @FXML
    private StackPane stkcadastro_m1;

    @FXML
    private TextField tfcad_codm;

    @FXML
    private TextField tfcad_nomem;

    @FXML
    private TextField tfcad_nome_autor;

    @FXML
    private TextField tfcad_data_pub;

    @FXML
    private TextField tfcad_distribuidora;

    @FXML
    private Button bntfimcad_m;

    @FXML
    private Tab buscar_manga;

    @FXML
    private StackPane stkalt_m;

    @FXML
    private Button bntfimalt_m;

    @FXML
    private TextField altnome_manga;

    @FXML
    private TextField altnome_autor;

    @FXML
    private TextField altdistribuidora;

    @FXML
    private TextField altdata_pub;

    @FXML
    private StackPane stkbae_m1;

    @FXML
    private TextField tfbusc_cod_m;

    @FXML
    private Text errobusc_m;

    @FXML
    private Button bntbusc_m;

    @FXML
    private Button bntexc_m;

    @FXML
    private Button bntalt_m;

    @FXML
    private Text excfim_m;

    @FXML
    private StackPane stkbusca_m;

    @FXML
    private Button voltarbusc_m;

    @FXML
    private TableView<manga> tabv_m1;

    @FXML
    private TableColumn<manga,Integer> tabc_cod_m1;

    @FXML
    private TableColumn<manga,String> tabc_nome_m1;

    @FXML
    private TableColumn<manga,String> tabc_nome_autor1;

    @FXML
    private TableColumn<manga,String> tabc_distribuidora1;

    @FXML
    private TableColumn<manga,Integer> tabc_data_pub1;

    @FXML
    private Tab relatorio_manga;

    @FXML
    private StackPane stkrelatorio_m2;

    @FXML
    private TableView<manga> tabv_m2;

    @FXML
    private TableColumn<manga,Integer> tabc_cod_m2;
    
    @FXML
    private TableColumn<manga,String> tabc_nome_m2;
    
    @FXML
    private TableColumn<manga,String> tabc_nome_autor2;

    @FXML
    private TableColumn<manga,String> tabc_distribuidora2;

    @FXML
    private TableColumn<manga,Integer> tabc_data_pub2;

    @FXML
    private StackPane stkrelatorio_m1;

    @FXML
    private Button bntrelatorio_m;

    @FXML
    private Tab anime;

    @FXML
    private Tab cadastrar_manga1;

    @FXML
    private StackPane stkcadastro_a2;

    @FXML
    private TextField tfcad_coda;

    @FXML
    private TextField tfcad_nomea;

    @FXML
    private TextField tfcad_genero;

    @FXML
    private TextField tfcad_n_eps;

    @FXML
    private Button bntfimcad_a;

    @FXML
    private StackPane stkcadastro_a1;

    @FXML
    private Button bntoutrocadastro_a;

    @FXML
    private Tab btn_bae_a;

    @FXML
    private StackPane stkalt_m1;

    @FXML
    private Button bntfimalt_a;

    @FXML
    private TextField altgenero;

    @FXML
    private TextField altn_eps;

    @FXML
    private TextField altnome_anime;

    @FXML
    private StackPane stkbae_a;

    @FXML
    private TextField tfbaecod_a;

    @FXML
    private Text errobusc_a;

    @FXML
    private Button bntbusc_a;

    @FXML
    private Button bntexc_a;

    @FXML
    private Button bntalt_a;

    @FXML
    private Text excfim_a;

    @FXML
    private StackPane stkbusc_a;

    @FXML
    private Button voltabusc_a;

    @FXML
    private TableView<anime> tabv_a1;

    @FXML
    private TableColumn<anime, Integer> tabc_cod_a1;

    @FXML
    private TableColumn<anime, String> tabc_nome_a1;

    @FXML
    private TableColumn<anime, String> tabc_genero1;

    @FXML
    private TableColumn<anime, Integer> tabc_n_eps1;

    @FXML
    private Tab relatorio_manga1;

    @FXML
    private StackPane stkrelatorio_a2;

    @FXML
    private TableView<anime> tabv_a2;

    @FXML
    private TableColumn<anime, Integer> tabc_cod_a2;

    @FXML
    private TableColumn<anime, String> tabc_nome_a2;

    @FXML
    private TableColumn<anime, String> tabc_genero2;

    @FXML
    private TableColumn<anime, Integer> tabc_n_eps2;

    @FXML
    private StackPane stkrelatorio_a1;

    @FXML
    private Button bntrelatorio_a;

    @FXML
    private Tab plataforma;

    @FXML
    private Tab cadastrar_plataforma;

    @FXML
    private StackPane stkcadastro_p1;

    @FXML
    private TextField tfcad_codp;

    @FXML
    private TextField tfcad_nome_p;

    @FXML
    private TextField tfcad_n_assinantes;

    @FXML
    private TextField tfcad_n_animes;

    @FXML
    private Button bntfimcad_p;

    @FXML
    private StackPane stkcadastro_p2;

    @FXML
    private Button bntoutrocadastro_p;

    @FXML
    private Tab bae_plataforma;

    @FXML
    private StackPane stkalt_p;

    @FXML
    private Button bntfimalt_p;

    @FXML
    private TextField altassinantes_p;

    @FXML
    private TextField altn_animes_p;

    @FXML
    private TextField altnome_plat;

    @FXML
    private StackPane stkbae_p;

    @FXML
    private TextField tfbae_cod_p;

    @FXML
    private Text errobusc_p;

    @FXML
    private Text excfim_p;

    @FXML
    private Button bntbusc_p;

    @FXML
    private Button bntalt_p;

    @FXML
    private Button bntexc_p;

    @FXML
    private StackPane stkbuscar_p;

    @FXML
    private TableView<plataforma> tabv_plat;

    @FXML
    private TableColumn<plataforma, Integer> tabc_cod_p1;

    @FXML
    private TableColumn<plataforma, String> tabc_nome_p1;

    @FXML
    private TableColumn<plataforma, Integer> tabc_assinantes_p1;

    @FXML
    private TableColumn<plataforma, Integer> tabc_n_animes_p1;
    
    @FXML
    private TableView<anime> tabv_ap1;

    @FXML
    private TableColumn<anime, Integer> tabc_cod_ap1;

    @FXML
    private TableColumn<anime, String> tabc_nome_ap1;

    @FXML
    private TableColumn<anime,String> tabc_genero_ap1;

    @FXML
    private TableColumn<anime, Integer> tabc_n_eps_ap1;

    @FXML
    private Button voltabusc_p;

    @FXML
    private Tab relatorio_plataforma;

    @FXML
    private StackPane stkrelatorio_p2;
    
    @FXML
    private TableView<plataforma> tabv_p2;

    @FXML
    private TableColumn<plataforma, Integer> tabc_cod_p2;

    @FXML
    private TableColumn<plataforma, String> tabc_nome_p2;

    @FXML
    private TableColumn<plataforma, Integer> tabc_assinantes_p2;

    @FXML
    private TableColumn<plataforma, Integer> tabc_n_animes_p2;

    @FXML
    private StackPane stkrelatorio_p1;

    @FXML
    private Button bntrelatorio_p;
    
    @FXML
    private Tab cadastrar_dis;

    @FXML
    private StackPane stkcadastro_d;

    @FXML
    private TextField tfcad_cod_distribuição;

    @FXML
    private Text errocad_p1;

    @FXML
    private TextField tfcad_cod_platdis;

    @FXML
    private TextField tfcad_cod_animedis;

    @FXML
    private Button bntfimcad_dist;

    @FXML
    private StackPane stkcadastro_distribu;

    @FXML
    private Button bntoutrocadastro_p1;

    @FXML
    private Tab cadastrar_manga2;

    @FXML
    private StackPane stkoutro_cadastro_s;

    @FXML
    private Button bntoutrocadastro_s;

    @FXML
    private StackPane stkcadastro_s;

    @FXML
    private TextField tfcad_cods;
    
    @FXML
    private TextField tfcad_nome_adm;

    @FXML
    private Button bntfimcad_s;

    @FXML
    private Tab buscar_sistema;

    @FXML
    private StackPane stkalt_s;

    @FXML
    private Button bntfimalt_s;

    @FXML
    private TextField altnome_adm;

    @FXML
    private StackPane stkbae_s;

    @FXML
    private TextField tfbae_cod_s;

    @FXML
    private Text errobusc_s;
    
    @FXML
    private Text errocad_m;
    
    @FXML
    private Text errocad_a1;
    
    @FXML
    private Text errocad_p;
    
    @FXML
    private Text errocad_s;

    @FXML
    private Button bntbusc_s;

    @FXML
    private Button bntexc_s;

    @FXML
    private Button bntalt_s;

    @FXML
    private Text excfim_s;

    @FXML
    private StackPane stkbusca_s;

    @FXML
    private Button voltarbusc_s;

    @FXML
    private TableView<sistema> tabv_s;

    @FXML
    private TableColumn<sistema,Integer> tabc_cod_s1;

    @FXML
    private TableColumn<sistema, String> tabc_nome_adm_s1;
    
    @FXML
    private TableView<plataforma> tabv_ps1;

    @FXML
    private TableColumn<plataforma, Integer> tabc_cod_ps1;

    @FXML
    private TableColumn<plataforma, String> tabc_nome_ps1;

    @FXML
    private TableColumn<plataforma, Integer> tabc_assinantes_ps1;

    @FXML
    private TableColumn<plataforma, Integer> tabc_n_animes_ps1;

    @FXML
    private Tab relatorio_manga2;

    @FXML
    private StackPane stkrelatorio_s2;

    @FXML
    private TableView<sistema> tabv_s1;

    @FXML
    private TableColumn<sistema, Integer> tabc_cod_s2;

    @FXML
    private TableColumn<sistema, String> tabc_nome_adm_s;

    @FXML
    private StackPane stkrelatorio_s1;

    @FXML
    private Button bntrelatorio_s;
    
    @FXML
    private Tab cadastrar_sup1;

    @FXML
    private StackPane stkcadastro_sup;

    @FXML
    private TextField tfcad_cod_supervisão;

    @FXML
    private Text errocad_sup;

    @FXML
    private TextField tfcad_cod_platsup;

    @FXML
    private TextField tfcad_cod_sissup;

    @FXML
    private Button bntfimcad_supv1;

    @FXML
    private StackPane stkcadastro_sup2;

    @FXML
    private Button bntoutrocadastro_sup;


    int i=0;
//--------------------------manga--------------------------------
    //cadastro
    @FXML
    void cadastrar(ActionEvent event) {
    	mangaDao mDao= new mangaDao();
    	manga m = null;
    	m = mDao.buscar(Integer.parseInt(tfcad_codm.getText()));
    	if(m==null) {   
    		m= new manga();
    	m.setCod_m(Integer.parseInt(tfcad_codm.getText()));	
    	m.setNome_m(tfcad_nomem.getText());
    	m.setNome_autor(tfcad_nome_autor.getText());
    	m.setData_pub(Integer.parseInt(tfcad_data_pub.getText()));
    	m.setDistribuidora(tfcad_distribuidora.getText());
    	mDao.inclusao(m);
    	this.stkcadastro_m1.setVisible(false);
    	this.stkcadastro_m2.setVisible(true);
    	}
    	else {
    		this.errocad_m.setVisible(true);
	        errocad_m.setText("Erro!!! mangá ja cadastrado");
    	}
    }
    @FXML
    void outro_cadastro(ActionEvent event) {
    	this.stkcadastro_m2.setVisible(false);
    	this.tfcad_codm.setText("");
    	this.tfcad_nomem.setText("");
    	this.tfcad_nome_autor.setText("");
    	this.tfcad_data_pub.setText("");
    	this.tfcad_distribuidora.setText("");
    	this.errocad_m.setVisible(false);
    	this.errocad_m.setText("");
    	this.stkcadastro_m1.setVisible(true);
    }
    //alterar
    @FXML
    void alterar_manga(ActionEvent event) {//visualização dos dados que serão alterados-concluido
    	mangaDao mDao= new mangaDao();
    	manga m = new manga();
    	m = mDao.buscar(Integer.parseInt(tfbusc_cod_m.getText()));
    	if(m== null) {
    		this.errobusc_m.setVisible(true);
	    	errobusc_m.setText("Erro!!! mangá não cadastrado");
    	}
    	else {
    		this.stkbae_m1.setVisible(false);
    		altnome_manga.setText(m.getNome_m());
    		altnome_autor.setText(m.getNome_autor());
    		altdata_pub.setText(NumberFormat.getInstance().format(m.getData_pub()));
        	altdistribuidora.setText(m.getDistribuidora());
    		this.stkalt_m.setVisible(true);
    		
    	}
    }
    @FXML
    void fim_alteração_manga(ActionEvent event) {//botão responsavel pela alteração dos dados exibidos-incompleto
    	mangaDao mDao= new mangaDao();
    	manga m = new manga();
    	this.stkalt_m.setVisible(false);
    	this.errobusc_m.setVisible(false);
    	errobusc_m.setText("");
    	m.setNome_m(altnome_manga.getText());
    	m.setNome_autor(altnome_autor.getText());
    	m.setData_pub(Integer.parseInt(altdata_pub.getText()));
    	m.setDistribuidora(altdistribuidora.getText());
    	i= Integer.parseInt(tfbusc_cod_m.getText());
    	mDao.alteracao(m, i);
    	tfbusc_cod_m.setText("");
    	this.stkbae_m1.setVisible(true);
    	this.excfim_m.setVisible(true);
    	excfim_m.setText("alteração realizada");
    }
    //excluir
    @FXML
    void excluir_manga(ActionEvent event) {
    	  mangaDao mDao= new mangaDao();
		    manga m = null;
		    m = mDao.buscar(Integer.parseInt(tfbusc_cod_m.getText()));
		    if(m==null) {
		    	m= new manga();
		    	tfbusc_cod_m.setText("");
		    	this.errobusc_m.setVisible(true);
		    	errobusc_m.setText("Erro!!! mangá não cadastrado");
		    }
		    else {
		    	mDao.exclusao(Integer.parseInt(tfbusc_cod_m.getText()));
		    	tfbusc_cod_m.setText("");
		    	this.excfim_m.setVisible(true);
		    	excfim_m.setText("Exclusão realizada");
		    }
    }    
    @FXML
    void excluir_limpar_manga(Event event) {
    	this.excfim_m.setVisible(false);
    	excfim_m.setText("");
    	this.errobusc_m.setVisible(false);
    	errobusc_m.setText("");
    }
    //buscar
    @FXML
    void buscar_manga(ActionEvent event) {
    	if(!tfbusc_cod_m.getText().equals("")) { 
	        mangaDao mDao= new mangaDao();
		    manga m = new manga();
		    m = mDao.buscar(Integer.parseInt(tfbusc_cod_m.getText()));
		    if(m==null){
		    	this.errobusc_m.setVisible(true);
		        errobusc_m.setText("Erro!!! mangá não cadastrado");
		    }else{
		    	this.stkbae_m1.setVisible(false);
		        this.stkbusca_m.setVisible(true);
		        tabc_cod_m1.setCellValueFactory(new PropertyValueFactory<>("cod_m"));
		        tabc_nome_m1.setCellValueFactory(new PropertyValueFactory<>("nome_m"));
		        tabc_nome_autor1.setCellValueFactory(new PropertyValueFactory<>("nome_autor"));
		        tabc_distribuidora1.setCellValueFactory(new PropertyValueFactory<>("distribuidora"));
		        tabc_data_pub1.setCellValueFactory(new PropertyValueFactory<>("data_pub"));
		        mangas.clear();
		        mangas.addAll(m);
		        tabv_m1.setItems(mangas);
		    }
    	} else {
    		tfbusc_cod_m.requestFocus();
    	}
    }
    @FXML
    void voltarbusca_manga(ActionEvent event) {
    	this.errobusc_m.setVisible(false);
        errobusc_m.setText("");
    	this.stkbusca_m.setVisible(false);
        this.stkbae_m1.setVisible(true);
        this.tfbusc_cod_m.setText("");
        this.excfim_m.setVisible(false);
    	excfim_m.setText("");
    }
    //relatorio
    @FXML
    void relatorio_manga(Event event) {
    	mangaDao mDao =new mangaDao();
    	this.stkrelatorio_m1.setVisible(false);
        this.stkrelatorio_m2.setVisible(true);
        tabc_cod_m2.setCellValueFactory(new PropertyValueFactory<>("cod_m"));
        tabc_nome_m2.setCellValueFactory(new PropertyValueFactory<>("nome_m"));
        tabc_nome_autor2.setCellValueFactory(new PropertyValueFactory<>("nome_autor"));
        tabc_distribuidora2.setCellValueFactory(new PropertyValueFactory<>("distribuidora"));
        tabc_data_pub2.setCellValueFactory(new PropertyValueFactory<>("data_pub"));
        mangas.addAll(mDao.relatorio());
        tabv_m2.setItems(mangas);
    }
    @FXML
    void relatorio_manga_apagar(Event event) {
    	this.stkrelatorio_m2.setVisible(false);
        this.stkrelatorio_m1.setVisible(true);	
    }
    //--------------------------manga--------------------------------
    //--------------------------anime--------------------------------
    //cadastro
    @FXML
    void cadastrar_anime(ActionEvent event) {
    	animeDao aDao= new animeDao();
    	anime a = null;
    	a = aDao.buscar(Integer.parseInt(tfcad_coda.getText()));
    	if(a==null) {   
    		a= new anime();
    	a.setCod_a(Integer.parseInt(tfcad_coda.getText()));
    	a.setNome_a(tfcad_nomea.getText());
    	a.setGenero_a(tfcad_genero.getText());
    	a.setN_episodios(Integer.parseInt(tfcad_n_eps.getText()));
    	aDao.inclusao(a);
    	this.stkcadastro_a1.setVisible(false);
    	this.stkcadastro_a2.setVisible(true);
    	}
    	else {
    		this.errocad_a1.setVisible(true);
	        errocad_a1.setText("Erro!!! anime ja cadastrado");
    	}
    }
    @FXML
    void outro_cadastro_anime(ActionEvent event) {
    	this.stkcadastro_a2.setVisible(false);
    	this.tfcad_coda.setText("");
    	this.tfcad_nomea.setText("");
    	this.tfcad_genero.setText("");
    	this.tfcad_n_eps.setText("");
    	this.errocad_a1.setVisible(false);
    	this.errocad_a1.setText("");
    	this.stkcadastro_a1.setVisible(true);
    }
    //alterar
    @FXML
    void alterar_anime(ActionEvent event) {
    	animeDao aDao= new animeDao();
    	anime a = new anime();
    	a = aDao.buscar(Integer.parseInt(tfbaecod_a.getText()));
    	if(a== null) {
    		this.errobusc_a.setVisible(true);
    		errobusc_a.setText("Erro!!! anime não cadastrado");
    	}
    	else {
    		this.stkbae_a.setVisible(false);
    		altnome_anime.setText(a.getNome_a());
    		altgenero.setText(a.getGenero_a());
    		altn_eps.setText(NumberFormat.getInstance().format(a.getN_episodios()));
    		this.stkalt_m1.setVisible(true);
    	}
    }
    @FXML
    void fim_alteração_anime(ActionEvent event) {
    	animeDao aDao= new animeDao();
    	anime a = new anime();
    	this.stkalt_m1.setVisible(false);
    	this.errobusc_a.setVisible(false);
    	errobusc_a.setText("");
    	a.setNome_a(altnome_anime.getText());
    	a.setGenero_a(altgenero.getText());
    	a.setN_episodios(Integer.parseInt(altn_eps.getText()));
    	i= Integer.parseInt(tfbaecod_a.getText());
    	aDao.alteracao(a, i);
    	tfbaecod_a.setText("");
    	this.stkbae_a.setVisible(true);
    	this.excfim_a.setVisible(true);
    	excfim_a.setText("alteração realizada");
    }
    //excluir
    @FXML
    void excluir_anime(ActionEvent event) {
    	 animeDao aDao= new animeDao();
		    anime a = null;
		    distribuiçãoDao disDao =new distribuiçãoDao();
		    a = aDao.buscar(Integer.parseInt(tfbaecod_a.getText()));
		    if(a==null) {
		    	a= new anime();
		    	tfbaecod_a.setText("");
		    	this.errobusc_a.setVisible(true);
		    	errobusc_a.setText("Erro!!! anime não cadastrado");
		    }
		    else {
		    	disDao.excluirPorAnime(Integer.parseInt(tfbaecod_a.getText()));
		    	aDao.exclusao(Integer.parseInt(tfbaecod_a.getText()));
		    	tfbaecod_a.setText("");
		    	this.excfim_a.setVisible(true);
		    	excfim_a.setText("exclusão realizada");
		    }
    }
    @FXML
    void excluir_voltar_anime(Event event) {
    	this.errobusc_a.setVisible(false);
    	errobusc_a.setText("");
    	this.excfim_a.setVisible(false);
    	excfim_a.setText("");
    }
    //buscar
    @FXML
    void buscar_anime(ActionEvent event) {
    	if(!tfbaecod_a.getText().equals("")) { 
	        animeDao aDao= new animeDao();
		    anime a = new anime();
		    a =aDao.buscar(Integer.parseInt(tfbaecod_a.getText()));
		    if(a==null){
		    	this.errobusc_a.setVisible(true);
		        errobusc_a.setText("Erro!!! anime não cadastrado");
		    }else{
		    	this.stkbae_a.setVisible(false);
		        this.stkbusc_a.setVisible(true);
		        tabc_cod_a1.setCellValueFactory(new PropertyValueFactory<>("cod_a"));
		        tabc_nome_a1.setCellValueFactory(new PropertyValueFactory<>("nome_a"));
		        tabc_genero1.setCellValueFactory(new PropertyValueFactory<>("genero_a"));
		        tabc_n_eps1.setCellValueFactory(new PropertyValueFactory<>("n_episodios"));
		        animes.clear();
		        animes.addAll(a);
		        tabv_a1.setItems(animes);
		    }
    	} else {
    		tfbaecod_a.requestFocus();
    	}
    }
    @FXML
    void volta_busca_anime(ActionEvent event) {
    	this.errobusc_a.setVisible(false);
        errobusc_a.setText("");
    	this.tfbaecod_a.setText("");
    	this.stkbusc_a.setVisible(false);
        this.stkbae_a.setVisible(true);	
        this.excfim_a.setVisible(false);
    	excfim_a.setText("");
    }
    //relatorio
    @FXML
    void relatorio_anime(Event event) {
    	animeDao aDao =new animeDao();
    	this.stkrelatorio_a1.setVisible(false);
        this.stkrelatorio_a2.setVisible(true);
        tabc_cod_a2.setCellValueFactory(new PropertyValueFactory<>("cod_a"));
        tabc_nome_a2.setCellValueFactory(new PropertyValueFactory<>("nome_a"));
        tabc_genero2.setCellValueFactory(new PropertyValueFactory<>("genero_a"));
        tabc_n_eps2.setCellValueFactory(new PropertyValueFactory<>("n_episodios"));
        animes.addAll(aDao.relatorio());
        tabv_a2.setItems(animes);
    }
    @FXML
    void relatorio_anime_apagar(Event event) {
    	this.stkrelatorio_a2.setVisible(false);
        this.stkrelatorio_a1.setVisible(true);	
    }
  //--------------------------anime--------------------------------
 //---------------------------plataforma---------------------------
    //cadastro
    @FXML
    void cadastro_plataforma(ActionEvent event) {
    	plataformaDao pDao= new plataformaDao();
    	plataforma p= null;
    	p = pDao.buscar(Integer.parseInt(tfcad_codp.getText()));
    	if(p==null) {
    	p=new plataforma();
    	p.setCod_p(Integer.parseInt(tfcad_codp.getText()));
    	p.setNome_p(tfcad_nome_p.getText());
    	p.setN_assinantes(Integer.parseInt(tfcad_n_assinantes.getText()));
    	p.setN_animes(Integer.parseInt(tfcad_n_animes.getText()));
    	pDao.inclusao(p);
    	this.stkcadastro_p1.setVisible(false);
    	this.stkcadastro_p2.setVisible(true);
    	}
    	else {
    		this.errocad_p.setVisible(true);
	        errocad_p.setText("Erro!!! plataforma ja cadastrada");
    	}
    }
    @FXML
    void outro_cadastro_plataforma(ActionEvent event) {
    	this.stkcadastro_p2.setVisible(false);
    	this.tfcad_codp.setText("");
    	this.tfcad_nome_p.setText("");
    	this.tfcad_n_assinantes.setText("");
    	this.tfcad_n_animes.setText("");
    	this.errocad_p.setVisible(false);
    	this.errocad_p.setText("");
    	this.stkcadastro_p1.setVisible(true);
    }
    //alterar
    @FXML
    void alterar_plat(ActionEvent event) {
    	plataformaDao pDao= new plataformaDao();
    	plataforma p = new plataforma();
    	p = pDao.buscar(Integer.parseInt(tfbae_cod_p.getText()));
    	if(p== null) {
    		this.errobusc_p.setVisible(true);
    		errobusc_p.setText("Erro!!! plataforma não cadastrada");
    	}
    	else {
    		this.stkbae_p.setVisible(false);
    		altnome_plat.setText(p.getNome_p());
    		altassinantes_p.setText(NumberFormat.getInstance().format(p.getN_assinantes()));
    		altn_animes_p.setText(NumberFormat.getInstance().format(p.getN_animes()));
    		this.stkalt_p.setVisible(true);
    	}
    }
    @FXML
    void fim_alteração_plataforma(ActionEvent event) {
    	plataformaDao pDao= new plataformaDao();
    	plataforma p = new plataforma();
    	this.stkalt_p.setVisible(false);
    	this.errobusc_p.setVisible(false);
    	errobusc_p.setText("");
    	p.setNome_p(altnome_plat.getText());
    	p.setN_assinantes(Integer.parseInt(altassinantes_p.getText()));
    	p.setN_animes(Integer.parseInt(altn_animes_p.getText()));
    	i= Integer.parseInt(tfbae_cod_p.getText());
    	pDao.alteracao(p, i);
    	tfbae_cod_p.setText("");
    	this.stkbae_p.setVisible(true);
    	this.excfim_p.setVisible(true);
    	excfim_p.setText("alteração realizada");
    }
    //excluir
    @FXML
    void excluir_plat(ActionEvent event) {
    	 plataformaDao pDao= new plataformaDao();
		    plataforma p = null;
		    supervisãoDao svDao = new supervisãoDao();
		    distribuiçãoDao disDao= new distribuiçãoDao(); 
		    p = pDao.buscar(Integer.parseInt(tfbae_cod_p.getText()));
		    if(p==null) {
		    	p= new plataforma();
		    	tfbae_cod_p.setText("");
		    	this.errobusc_p.setVisible(true);
		    	errobusc_p.setText("Erro!!! anime não cadastrado");
		    }
		    else {
		    	disDao.excluir_Por_Plataforma(Integer.parseInt(tfbae_cod_p.getText()));
		    	svDao.excluir_Por_Plataforma(Integer.parseInt(tfbae_cod_p.getText()));
		    	pDao.exclusao(Integer.parseInt(tfbae_cod_p.getText()));
		    	tfbae_cod_p.setText("");
		    	this.excfim_p.setVisible(true);
		    	excfim_p.setText("exclusão realizada");
		    }
    }
    @FXML
    void excluir_limpar_plataforma(Event event) {
    	this.excfim_p.setVisible(false);
    	excfim_p.setText("");
    	this.errobusc_p.setVisible(false);
    	errobusc_p.setText("");
    }
    //busca
    @FXML
    void buscar_plat(ActionEvent event) {
    	if(!tfbae_cod_p.getText().equals("")) {
    		plataformaDao pDao= new plataformaDao();
		    plataforma p = new plataforma();
		    p =pDao.buscar(Integer.parseInt(tfbae_cod_p.getText()));
		    if(p==null){
		    	this.errobusc_p.setVisible(true);
		        errobusc_p.setText("Erro!!! plataforma não cadastrada");
		    }else{
		    	this.stkbae_p.setVisible(false);
		        this.stkbuscar_p.setVisible(true);
		        tabc_cod_p1.setCellValueFactory(new PropertyValueFactory<>("cod_p"));
		        tabc_nome_p1.setCellValueFactory(new PropertyValueFactory<>("nome_p"));
		        tabc_assinantes_p1.setCellValueFactory(new PropertyValueFactory<>("n_assinantes"));
		        tabc_n_animes_p1.setCellValueFactory(new PropertyValueFactory<>("n_animes"));
		        tabc_cod_ap1.setCellValueFactory(new PropertyValueFactory<>("cod_a"));
		        tabc_nome_ap1.setCellValueFactory(new PropertyValueFactory<>("nome_a"));
		        tabc_genero_ap1.setCellValueFactory(new PropertyValueFactory<>("genero_a"));
		        tabc_n_eps_ap1.setCellValueFactory(new PropertyValueFactory<>("n_episodios"));		        
		        plataformas.clear();
		        plataformas.addAll(p);
		        tabv_plat.setItems(plataformas);
		        animes.clear();
		        animes.addAll(p.getAnimes());
		        tabv_ap1.setItems(animes);
		    }
    	} else {
    		tfbae_cod_p.requestFocus();
    	}
    }
    @FXML
    void voltar_busca_plat(ActionEvent event) {
    	this.tfbae_cod_p.setText("");
    	this.errobusc_p.setVisible(false);
        errobusc_p.setText("Erro!!! plataforma não cadastrada");
    	this.stkbuscar_p.setVisible(false);
        this.stkbae_p.setVisible(true);	
        this.errobusc_p.setVisible(false);
    	errobusc_p.setText("");
    }
    //relatorio
    @FXML
    void relatorio_plat(Event event) {
    	plataformaDao pDao =new plataformaDao();
    	this.stkrelatorio_p1.setVisible(false);
        this.stkrelatorio_p2.setVisible(true);
        tabc_cod_p2.setCellValueFactory(new PropertyValueFactory<>("cod_p"));
        tabc_nome_p2.setCellValueFactory(new PropertyValueFactory<>("nome_p"));
        tabc_assinantes_p2.setCellValueFactory(new PropertyValueFactory<>("n_assinantes"));
        tabc_n_animes_p2.setCellValueFactory(new PropertyValueFactory<>("n_animes"));
        plataformas.addAll(pDao.relatorio());
        tabv_p2.setItems(plataformas);
    }
    @FXML
    void relatorio_plataforma_apagar(Event event) {
    	this.stkrelatorio_p2.setVisible(false);
        this.stkrelatorio_p1.setVisible(true);
    }
    //--------------------distribuição-------------------------------------
    //cadastro distribuição
    @FXML
    void cadastro_distribuição(ActionEvent event) {
    	distribuiçãoDao dDao= new distribuiçãoDao();
    	distribuição d= null;
    	animeDao aDao = new animeDao();
    	anime a = null;
    	plataformaDao pDao = new plataformaDao(); 
    	plataforma p=null;
    	d = dDao.buscar(Integer.parseInt(tfcad_cod_distribuição.getText()));
    	if(d==null) {
    		a =aDao.buscar(Integer.parseInt(tfcad_cod_animedis.getText()));
    		if(a!=null) {
    			p = pDao.buscar(Integer.parseInt(tfcad_cod_platdis.getText()));
    			if(p!=null) {
    	d=new distribuição();
    	d.setCod_distribuicao(Integer.parseInt(tfcad_cod_distribuição.getText()));
    	d.setCod_p(Integer.parseInt(tfcad_cod_platdis.getText()));
    	d.setCod_a(Integer.parseInt(tfcad_cod_animedis.getText()));
    	dDao.inclusao(d);
    	this.stkcadastro_d.setVisible(false);
    	this.stkcadastro_distribu.setVisible(true);
    			}else {
    				this.errocad_p1.setVisible(true);
    		        errocad_p1.setText("Erro!!! plataforma não cadastrada");
    			}
    		}else {
    			this.errocad_p1.setVisible(true);
		        errocad_p1.setText("Erro!!! anime não cadastrado");
    		}
    	}
    	
    	else {
    		this.errocad_p1.setVisible(true);
	        errocad_p1.setText("Erro!!! distribuição ja cadastrada");
    	}
    }
    @FXML
    void outro_cadastro_distribuição(ActionEvent event) {
    	this.stkcadastro_distribu.setVisible(false);
    	this.tfcad_cod_distribuição.setText("");
    	this.tfcad_cod_platdis.setText("");
    	this.tfcad_cod_animedis.setText("");
    	this.errocad_p1.setVisible(false);
    	this.errocad_p1.setVisible(false);
    	this.stkcadastro_d.setVisible(true);
    }
        //--------------------distribuição-------------------------------------
     //---------------------------plataforma-----------------------------------
    //------------------------------sistema-----------------------------------
    //cadastro
    @FXML
    void cadastrar_sistema(ActionEvent event) {
    	sistemaDao sDao= new sistemaDao();
    	sistema s=null;
    	s = sDao.buscar(Integer.parseInt(tfcad_cods.getText()));
    	if(s==null) {
    	s= new sistema();
    	s.setCod_s(Integer.parseInt(tfcad_cods.getText()));
    	s.setNome_adm(tfcad_nome_adm.getText());
    	sDao.inclusao(s);
    	this.stkcadastro_s.setVisible(false);
    	this.stkoutro_cadastro_s.setVisible(true);
    	}
    	else {
    		this.errocad_s.setVisible(true);
	        errocad_s.setText("Erro!!! sistema ja cadastrada");
    	}
    }
    @FXML
    void outro_cadastro_sistema(ActionEvent event) {
    	this.stkoutro_cadastro_s.setVisible(false);
    	this.tfcad_cods.setText("");
    	this.tfcad_nome_adm.setText("");
    	this.errocad_s.setVisible(false);
    	this.errocad_s.setText("");
    	this.stkcadastro_s.setVisible(true);
    }  
    //alterar
    @FXML
    void alterar_sistema(ActionEvent event) {
    	sistemaDao sDao= new sistemaDao();
    	sistema s = new sistema();
    	s = sDao.buscar(Integer.parseInt(tfbae_cod_s.getText()));
    	if(s== null) {
    		this.errobusc_s.setVisible(true);
    		errobusc_s.setText("Erro!!! sistema não cadastrado");
    	}
    	else {
    		this.stkbae_s.setVisible(false);
    		altnome_adm.setText(s.getNome_adm());
    		this.stkalt_s.setVisible(true);
    	}
    }
    @FXML
    void fim_alteração_sistema(ActionEvent event) {
    	sistemaDao sDao= new sistemaDao();
    	sistema s = new sistema();
    	this.stkalt_s.setVisible(false);
    	this.errobusc_s.setVisible(false);
    	errobusc_s.setText("");
    	s.setNome_adm(altnome_adm.getText());
    	i= Integer.parseInt(tfbae_cod_s.getText());
    	sDao.alteracao(s, i);
    	tfbae_cod_s.setText("");
    	this.stkbae_s.setVisible(true);
    	this.excfim_s.setVisible(true);
    	excfim_s.setText("alteração realizada");
    }
    //excluir
    @FXML
    void excluir_sistema(ActionEvent event) {
    	 sistemaDao sDao= new sistemaDao();
		    sistema s = null;
		    supervisãoDao svDao = new supervisãoDao();
		    s = sDao.buscar(Integer.parseInt(tfbae_cod_s.getText()));
		    if(s==null) {
		    	s= new sistema();
		    	tfbae_cod_s.setText("");
		    	this.errobusc_s.setVisible(true);
		    	errobusc_s.setText("Erro!!! anime não cadastrado");
		    }
		    else {
		    	svDao.excluir_Por_Sistema(Integer.parseInt(tfbae_cod_s.getText()));
		    	sDao.exclusao(Integer.parseInt(tfbae_cod_s.getText()));
		    	tfbae_cod_s.setText("");
		    	this.excfim_s.setVisible(true);
		    	excfim_s.setText("exclusão realizada");
		    }
    }
    @FXML
    void excluir_voltar_sistema(Event event) {
    	this.excfim_s.setVisible(false);
    	excfim_s.setText("");
    	this.errobusc_s.setVisible(false);
    	errobusc_s.setText("");
    }
    //busca
    @FXML
    void buscar_sistema(ActionEvent event) {
    	if(!tfbae_cod_s.getText().equals("")) { 
    		sistemaDao sDao= new sistemaDao();
		    sistema s = new sistema();
		    s =sDao.buscar(Integer.parseInt(tfbae_cod_s.getText()));
		    if(s==null){
		    	this.errobusc_s.setVisible(true);
		        errobusc_s.setText("Erro!!! sistema não cadastrado");
		    }else{
		    	this.stkbae_s.setVisible(false);
		        this.stkbusca_s.setVisible(true);
		        tabc_cod_s1.setCellValueFactory(new PropertyValueFactory<>("cod_s"));
		        tabc_nome_adm_s1.setCellValueFactory(new PropertyValueFactory<>("nome_adm"));
		        tabc_cod_ps1.setCellValueFactory(new PropertyValueFactory<>("cod_p"));
		        tabc_nome_ps1.setCellValueFactory(new PropertyValueFactory<>("nome_p"));
		        tabc_assinantes_ps1.setCellValueFactory(new PropertyValueFactory<>("n_assinantes"));
		        tabc_n_animes_ps1.setCellValueFactory(new PropertyValueFactory<>("n_animes"));
		        plataformas.clear();
		        plataformas.addAll(s.getPlataformas());
		        tabv_ps1.setItems(plataformas);
		        sistemas.clear();
		        sistemas.addAll(s);
		        tabv_s.setItems(sistemas);
		    }
    	} else {
    		tfbae_cod_s.requestFocus();
    	}
    }
    @FXML
    void voltarbusca_sistema(ActionEvent event) {
    	this.tfbae_cod_s.setText("");
    	this.errobusc_s.setVisible(false);
        errobusc_s.setText("");
    	this.stkbusca_s.setVisible(false);
        this.stkbae_s.setVisible(true);	
        this.excfim_s.setVisible(false);
    	excfim_s.setText("");

    }
    //relatorio
    @FXML
    void relatorio_sistema(Event event) {
    	sistemaDao sDao =new sistemaDao();
    	this.stkrelatorio_s1.setVisible(false);
        this.stkrelatorio_s2.setVisible(true);
        tabc_cod_s2.setCellValueFactory(new PropertyValueFactory<>("cod_s"));
        tabc_nome_adm_s.setCellValueFactory(new PropertyValueFactory<>("nome_adm"));
        sistemas.addAll(sDao.relatorio());
        tabv_s1.setItems(sistemas);
    }
    @FXML
    void relatorio_sistema_apagar(Event event) {
    	this.stkrelatorio_s2.setVisible(false);
        this.stkrelatorio_s1.setVisible(true);
    }
    //------------------------supervisão-----------------------------------
    //cadastro
    @FXML
    void cadastro_supervisão(ActionEvent event) {
    	supervisãoDao svDao= new supervisãoDao();
    	supervisão sv= null;
    	sistemaDao sDao = new sistemaDao();
    	sistema s = null;
    	plataformaDao pDao=  new plataformaDao();
    	plataforma p = null;
    	sv = svDao.buscar(Integer.parseInt(tfcad_cod_supervisão.getText()));
    	if(sv==null) {
    		s = sDao.buscar(Integer.parseInt(tfcad_cod_sissup.getText()));
    		if(s!=null) {
    			p = pDao.buscar(Integer.parseInt(tfcad_cod_platsup.getText()));
    			if(p!=null) {
    	sv=new supervisão();
    	sv.setCod_supervisão(Integer.parseInt(tfcad_cod_supervisão.getText()));
    	sv.setCod_p(Integer.parseInt(tfcad_cod_platsup.getText()));
    	sv.setCod_s(Integer.parseInt(tfcad_cod_sissup.getText()));
    	svDao.inclusao(sv);
    	this.stkcadastro_sup.setVisible(false);
    	this.stkcadastro_sup2.setVisible(true);
    			}else {
    				this.errocad_sup.setVisible(true);
    	    		errocad_sup.setText("Erro!!! plataforma não cadastrada");
    			}
    		}else {
    			this.errocad_sup.setVisible(true);
        		errocad_sup.setText("Erro!!! sistema não cadastrado");
    		}
    	}
    	else {
    		this.errocad_sup.setVisible(true);
    		errocad_sup.setText("Erro!!! supervisão ja cadastrada");
    	}
    }
    @FXML
    void outro_cadastro_supervisão(ActionEvent event) {
    	this.stkcadastro_sup2.setVisible(false);
    	this.tfcad_cod_supervisão.setText("");
    	this.tfcad_cod_platsup.setText("");
    	this.tfcad_cod_sissup.setText("");
    	this.errocad_sup.setVisible(false);
    	this.errocad_sup.setText("");
    	this.stkcadastro_sup.setVisible(true);
    }
  //------------------------supervisão-----------------------------------
  //------------------------------sistema-----------------------------------
}
