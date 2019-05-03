package com.mobile.rogue;

import com.badlogic.gdx.graphics.Texture;

import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.math.Rectangle;

public class Player {
    private int x,y,largura,altura,telaX,telaY,hp,mana,lado,passo;
    private Texture img,bonecoD1,bonecoD2,bonecoE1,bonecoE2,bonecoE3,bonecoD3;
    private boolean vivo,pulando,caindo,pexou;


    public Player(int x, int y, int largura, int altura) {
        this.x = x;
        this.y = y;
        this.largura = largura;
        this.altura = altura;
        this.hp = 1000;
        this.vivo = true;
    }



    // metodos get e set

    public Rectangle getBounds(){
        return new Rectangle();
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

    public void setImg(Texture img) {
        this.img = img;
    }

    public Texture getBonecoD1() {
        return bonecoD1;
    }

    public void setBonecoD1(Texture bonecoD1) {
        this.bonecoD1 = bonecoD1;
    }

    public Texture getBonecoD2() {
        return bonecoD2;
    }

    public void setBonecoD2(Texture bonecoD2) {
        this.bonecoD2 = bonecoD2;
    }

    public Texture getBonecoE1() {
        return bonecoE1;
    }

    public void setBonecoE1(Texture bonecoE1) {
        this.bonecoE1 = bonecoE1;
    }

    public Texture getBonecoE2() {
        return bonecoE2;
    }

    public void setBonecoE2(Texture bonecoE2) {
        this.bonecoE2 = bonecoE2;
    }

    public Texture getBonecoE3() {
        return bonecoE3;
    }

    public void setBonecoE3(Texture bonecoE3) {
        this.bonecoE3 = bonecoE3;
    }

    public Texture getBonecoD3() {
        return bonecoD3;
    }

    public void setBonecoD3(Texture bonecoD3) {
        this.bonecoD3 = bonecoD3;
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
