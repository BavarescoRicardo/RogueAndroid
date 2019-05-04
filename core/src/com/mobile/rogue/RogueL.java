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

public class RogueL extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	private int largura,altura;
	private Player player;
	private GeradorCenario geradorCenario;
	private ImageButton btn;
	private Stage stage;
	private Texture btnFase;
	
	@Override
	public void create () {
		btnFase = new Texture("btn.png");
		stage = new Stage(new ScreenViewport());
		largura = Gdx.graphics.getWidth()/100;
		altura = Gdx.graphics.getHeight()/100;
		batch = new SpriteBatch();

		player = new Player(largura*5,altura*90,largura*12,altura*22);

		geradorCenario = new GeradorCenario(player.getLargura(),player.getAltura(),largura,altura);
		img = new Texture("bonecoE1.png");


		botoes();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.draw();
		batch.begin();


		// desenha cenario
		for (Plataforma bloco : geradorCenario.getListaBloco() ){
			batch.draw(bloco.getImg(),bloco.getX(),bloco.getY(),bloco.getLargura(),bloco.getAltura());
		}

		// verificar se deve chamar novamento o metodo q cria cenarios aleatorios


		colisoes();


		batch.draw(player.getImg(),player.getX(),player.getY(),player.getLargura(),player.getAltura());

		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}

	private void botoes(){


		btn = new ImageButton(
				new TextureRegionDrawable(new TextureRegion(btnFase)));
		btn.setPosition(largura*9,altura*5);
		btn.addListener(new ClickListener(){
			@Override
			public boolean touchDown(InputEvent e, float x, float y, int point, int button){


				return true;
			}
			@Override
			public void touchUp(InputEvent e,float x, float y,int point,int button){
				geradorCenario = new GeradorCenario(player.getLargura(),player.getAltura(),largura,altura);
			}
		});
		stage.addActor(btn);

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

		//
	}
}
