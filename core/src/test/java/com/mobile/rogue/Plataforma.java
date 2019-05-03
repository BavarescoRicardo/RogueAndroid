package com.mobile.rogue;

import com.badlogic.gdx.graphics.Texture;

public class Plataforma {
    private int x,y,largura,altura;
    private int telaX,telaY;
    private Texture img,img1,img2,img3,img4,img5;

    public Plataforma(int x, int y, int largura, int altura) {
        this.x = x;
        this.y = y;
        this.largura = largura;
        this.altura = altura;
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

    public Texture getImg() {
        return img;
    }

    public void setImg(Texture img) {
        this.img = img;
    }

    public Texture getImg1() {
        return img1;
    }

    public void setImg1(Texture img1) {
        this.img1 = img1;
    }

    public Texture getImg2() {
        return img2;
    }

    public void setImg2(Texture img2) {
        this.img2 = img2;
    }

    public Texture getImg3() {
        return img3;
    }

    public void setImg3(Texture img3) {
        this.img3 = img3;
    }

    public Texture getImg4() {
        return img4;
    }

    public void setImg4(Texture img4) {
        this.img4 = img4;
    }

    public Texture getImg5() {
        return img5;
    }

    public void setImg5(Texture img5) {
        this.img5 = img5;
    }
}
