package com.mobile.rogue;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class Player {
    private int x,y,largura,altura,telaX,telaY,hp,mana,lado,passo,direcao,puloMax = 20,puloAtual = 0,ultimolado = 2;
    private Texture img,bonecoD1,bonecoD2,bonecoE1,bonecoE2,bonecoE3,bonecoD3;
    private boolean vivo,pulando,caindo,pexou,visivel;
    private Move move;
    private Pula pula;

    public Player(int x, int y, int largura, int altura) {
        this.x = x*5;
        this.y = y*15;
        this.largura = largura;
        this.altura = altura;

        // Threads
        move = new Move();
        move.start();
        //pula = new Pula();
        //pula.start();

        this.direcao = 1;
        this.telaX = 0;
        this.telaY = 0;
        this.vivo = true;
        this.hp = 100;
        this.mana = 100;
        this.pulando = false;
        this.caindo = true;
        this.lado = 0;
        this.bonecoE1 = new Texture("bonecoE1.png");
        this.bonecoE2 = new Texture("bonecoE2.png");
        this.bonecoE3 = new Texture("bonecoE3.png");
        this.bonecoD1 = new Texture("bonecoD1.png");
        this.bonecoD2 = new Texture("bonecoD2.png");
        this.bonecoD3 = new Texture("bonecoD3.png");
        // incluir demais texturas


        img = bonecoD1;
    }

    // metodos e classe para movimentar o personagem

    public void anda(int lado){
        switch (lado){
            case 2:
                x += largura/20;
                telaX -= largura/40;
                break;

            case 1:
                x -= largura/20;
                telaX += largura/40;
                break;

            default:
                break;
        }

    }

    // metodo de animacao deve trocar a img a cada 5 valores da int passo

    public void animacao(){

        if (ultimolado == 1){

            switch (passo){
                case  0:
                    this.img = bonecoE1;
                    break;

                case 5:
                    this.img = bonecoE2;
                    break;

                case 10:
                    this.img = bonecoE3;
                    break;

                default:
                    break;
            }

        }else if ( ultimolado == 2){

            switch (passo){
                case  0:
                    this.img = bonecoD1;
                    break;

                case 5:
                    this.img = bonecoD2;
                    break;

                case 10:
                    this.img = bonecoD3;
                    break;

                default:
                    break;
            }
        }

        passo ++;

        if (passo > 15)
            passo = 0;
    }

    public void desce(){
        y -= altura/10;
    }

    private class Move extends Thread{

        @Override
        public void run(){
            while(vivo){
                if (lado != 0){
                    ultimolado = lado;
                }else
                    passo = 0;
                animacao();
                anda(lado);

                if (caindo == true && pulando == false){
                    desce();
                }

                if (pulando){
                    pula();

                }

                try {
                    Thread.sleep(30);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }


    }


    public void levaDado(int dano){
        this.hp -= dano;
    }


    public void pula(){
        if (puloAtual < puloMax){
            this.y += altura/14;
            puloAtual++;
        }else {
            puloAtual = 0;
            pulando = false;
        }

    }

    private class Pula extends  Thread{

        @Override
        public void run(){
            while(vivo){
               if (pulando){
                   pula();

               }

                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }



    // metodos get e set

    public Rectangle getBounds(){

        return new Rectangle(x+(largura/4)-
                telaX,y,largura/3,altura/4);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getLargura() {
        return largura;
    }

    public void setLargura(int largura) {
        this.largura = largura;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
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

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getLado() {
        return lado;
    }

    public void setLado(int lado) {
        this.lado = lado;
    }

    public int getPasso() {
        return passo;
    }

    public void setPasso(int passo) {
        this.passo = passo;
    }

    public Texture getImg() {
        return img;
    }

    public boolean isVivo() {
        return vivo;
    }

    public void setVivo(boolean vivo) {
        this.vivo = vivo;
    }

    public boolean isPulando() {
        return pulando;
    }

    public void setPulando(boolean pulando) {
        this.pulando = pulando;
    }

    public boolean isCaindo() {
        return caindo;
    }

    public void setCaindo(boolean caindo) {
        this.caindo = caindo;
    }

    public boolean isPexou() {
        return pexou;
    }

    public void setPexou(boolean pexou) {
        this.pexou = pexou;
    }


}
