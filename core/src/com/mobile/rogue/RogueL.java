package com.mobile.rogue;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import java.util.ArrayList;
import java.util.List;

public class RogueL extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img,fundo1;
	private int largura,altura,etapa;
	private Player player;
	private GeradorCenario geradorCenario;
	private ImageButton btn,btnDir,btnEsq,btnPulo;
	private Stage stage;
	private Texture btnFase,dir,esq,pulo;
	private List<Inimigo1> listaInimigos = new ArrayList<Inimigo1>();
	
	@Override
	public void create () {
		btnFase = new Texture("btn.png");
		dir = new Texture("btnEsq.png");
		esq = new Texture("btnDir.png");
		pulo = new Texture("btnCima.png");


		fundo1 = new Texture("fundo1.png");
		stage = new Stage(new ScreenViewport());
		largura = Gdx.graphics.getWidth()/100;
		altura = Gdx.graphics.getHeight()/100;
		batch = new SpriteBatch();
		etapa = 0;
		player = new Player(largura*5,altura*120,largura*10,altura*19);

		geraPlataformas();
		img = new Texture("bonecoE1.png");


		botoes();
		player.setY(altura*120);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.begin();
		batch.draw(fundo1,0,0,largura*110,altura*100);

		// desenha cenario
		for (Plataforma bloco : geradorCenario.getListaBloco() ){
			batch.draw(bloco.getImg(),bloco.getX()+player.getTelaX(),bloco.getY(),bloco.getLargura(),bloco.getAltura());
		}

		colisoes();


		// verificar se deve chamar novamento o metodo q cria cenarios aleatorios
		if (player.getX() > largura*90){
			geraPlataformas();
			player.setY(altura*100);
			player.setX(largura);
			player.setTelaX(0);
			etapa++;
		}


		// confere se esta na segunda etapa e desenha inimigo

		if (listaInimigos.size() > 0){
			for (int  inimigo = 0; inimigo < listaInimigos.size(); inimigo ++){
				batch.draw(listaInimigos.get(inimigo).getImg(),listaInimigos.get(inimigo).getX(),listaInimigos.get(inimigo).getY(),listaInimigos.get(inimigo).getLargura(),listaInimigos.get(inimigo).getAltura());
			}

		}



		batch.draw(player.getImg(),player.getX(),player.getY(),player.getLargura(),player.getAltura());

		batch.end();
        stage.draw();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}

	private void geraPlataformas(){
		geradorCenario = new GeradorCenario(player.getLargura(),player.getAltura(),largura,altura);

		// coloca inimigos aleatoriamente no cenario
		// esse nao deu
		 int platRand = (int) (Math.random()*geradorCenario.getListaBloco().size());

		int inimigoRandX = (int) (Math.random()*(largura*100)+largura);
		if (etapa > 0){
			listaInimigos.add(new Inimigo1(inimigoRandX,geradorCenario.getListaBloco().get(platRand).getY()+geradorCenario.getListaBloco().get(platRand).getAltura(),largura*8,altura*16));
		}
	}

	private void botoes(){


		btn = new ImageButton(
				new TextureRegionDrawable(new TextureRegion(btnFase)));
		btn.setPosition(largura*95,altura*90);
		btn.addListener(new ClickListener(){
			@Override
			public boolean touchDown(InputEvent e, float x, float y, int point, int button){


				return true;
			}
			@Override
			public void touchUp(InputEvent e,float x, float y,int point,int button){
				geraPlataformas();
				etapa++;
				player.setY(altura*80);
				// perssonagem muda de margem
			}
		});
		stage.addActor(btn);

		btnEsq = new ImageButton(
				new TextureRegionDrawable(new TextureRegion(esq)));
		btnEsq.setPosition(largura*25,altura*5);
		btnEsq.addListener(new ClickListener(){
			@Override
			public boolean touchDown(InputEvent e, float x, float y, int point, int button){
				player.setLado(2);

				return true;
			}
			@Override
			public void touchUp(InputEvent e,float x, float y,int point,int button){

				player.setLado(0);
				// perssonagem muda de margem
			}
		});
		stage.addActor(btnEsq);


		btnDir = new ImageButton(
				new TextureRegionDrawable(new TextureRegion(dir)));
		btnDir.setPosition(largura*5,altura*5);
		btnDir.addListener(new ClickListener(){
			@Override
			public boolean touchDown(InputEvent e, float x, float y, int point, int button){
				player.setLado(1);

					return true;
			}
			@Override
			public void touchUp(InputEvent e,float x, float y,int point,int button){

				player.setLado(0);
				// perssonagem muda de margem
			}
		});
		stage.addActor(btnDir);


		btnPulo = new ImageButton(
				new TextureRegionDrawable(new TextureRegion(pulo)));
		btnPulo.setPosition(largura*90,altura*15);
		btnPulo.addListener(new ClickListener(){
			@Override
			public boolean touchDown(InputEvent e, float x, float y, int point, int button){
				player.setPulando(true);
				return true;
			}
			@Override
			public void touchUp(InputEvent e,float x, float y,int point,int button){

			}
		});
		stage.addActor(btnPulo);


		Gdx.input.setInputProcessor(stage);

	}

	private void colisoes(){
		// gravidade do player

		player.setCaindo(true);

		for (int plataforma = 0; plataforma < geradorCenario.getListaBloco().size(); plataforma ++){
			if(geradorCenario.getListaBloco().get(plataforma).getBounds().overlaps(player.getBounds())){
				player.setCaindo(false);

			}
		}

		// gravidade do inimigo soma movimento da tela ao x para inimigo
		for ( int inimigo = 0 ; inimigo < listaInimigos.size(); inimigo ++){

				// mudar aqui abaixo
			 listaInimigos.get(inimigo).setTelaX(player.getTelaX());

			listaInimigos.get(inimigo).setCaindo(true);
			for (int plataforma = 0; plataforma < geradorCenario.getListaBloco().size(); plataforma ++){

				if (listaInimigos.get(inimigo).getBounds().overlaps(geradorCenario.getListaBloco().get(plataforma).getBounds()))
					listaInimigos.get(inimigo).setCaindo(false);
			}
		}

	}
}
