package com.mobile.rogue;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class Inimigo1 {
        private int x,y,largura,altura,telaX,telaY,hp,mana,lado,passo,direcao;
        private Texture img,bonecoD1,bonecoD2,bonecoE1,bonecoE2,bonecoE3,bonecoD3;
        private boolean vivo,pulando,caindo,pexou,visivel;
        private Move move;

        public Inimigo1(int x, int y, int largura, int altura) {
            this.x = x*5;
            this.y = y*15;
            this.largura = largura;
            this.altura = altura;

            move = new Move();
            move.start();

            this.direcao = 1;
            this.vivo = true;
            this.hp = 100;
            this.mana = 100;
            this.pulando = false;
            this.caindo = true;

            this.bonecoE1 = new Texture("magoE1.png");
            // incluir demais texturas


            img = bonecoE1;
        }

        // metodos get e set

        public Rectangle getBounds(){
            return new Rectangle(x,y,largura/2,altura/4);
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

        // metodos e classe para movimentar o personagem



        public void anda(int lado){

        }

        public void levaDado(int dano){
            this.hp -= dano;
        }

        public void desce(){
            y -= altura/10;
        }

private class Move extends Thread{

    @Override
    public void run(){
        while(vivo){

            anda(lado);

            if (caindo){
                desce();
            }

            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


}
