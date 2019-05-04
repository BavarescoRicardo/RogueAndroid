package com.mobile.rogue;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;


import java.util.ArrayList;
import java.util.List;

public class GeradorCenario {
    private int x,y,largura,altura,posX,posY,randAlt = 0,randLarg = 0;
    private int telaX,telaY,playerLarg,playerAlt;
    private Texture img;

    // substiturir array dps
    private List<Plataforma> listaBloco = new ArrayList<Plataforma>();

    public GeradorCenario(int playerLarg, int playerAlt,int l , int a) {
        this.playerLarg = playerLarg;
        this.playerAlt = playerAlt;
        this.largura = l;
        this.altura = a;

        int ocupadoL = 0,ocupadoA = 0;
        int espacoX = 0,espacoY = 0;
        randLarg = 0;

        //começo de construção do cenario
        int totalL = largura*100,totalA = altura*100;


         while (ocupadoL < 2*totalL){
            ocupadoL += playerLarg+posX+randLarg;

             posX = (int) (Math.random()*(1) +randLarg+posX);
             posY = (int) (Math.random()*(playerAlt*3)+playerAlt);


             randLarg = 0;
            randAlt = 0;

            randLarg = (int) (Math.random()*(largura*50) + (playerLarg*2) );
            randAlt = (int) (Math.random()*(altura*6) + (playerAlt/3) );


            // inserir bloco
            listaBloco.add(new Plataforma(posX,posY,randLarg,randAlt));
            ocupadoL += randLarg+posX;
            // array para blocos
            // grupo de array para cada fase um "estilo" de blocos




            // array para inimigos
         }





    }

    public List<Plataforma> getListaBloco() {
        return listaBloco;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getRandAlt() {
        return randAlt;
    }

    public void setRandAlt(int randAlt) {
        this.randAlt = randAlt;
    }

    public int getRandLarg() {
        return randLarg;
    }

    public void setRandLarg(int randLarg) {
        this.randLarg = randLarg;
    }

    public int getTelaX() {
        return telaX;
    }

    public void setTelaX(int telaX) {
        this.telaX = telaX;
    }

    public int getTelaY() {
        return telaY;
    }

    public void setTelaY(int telaY) {
        this.telaY = telaY;
    }

    public int getPlayerLarg() {
        return playerLarg;
    }

    public void setPlayerLarg(int playerLarg) {
        this.playerLarg = playerLarg;
    }

    public int getPlayerAlt() {
        return playerAlt;
    }

    public void setPlayerAlt(int playerAlt) {
        this.playerAlt = playerAlt;
    }

    public Texture getImg() {
        return img;
    }

    public void setImg(Texture img) {
        this.img = img;
    }
}