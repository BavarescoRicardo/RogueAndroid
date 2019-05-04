package com.mobile.rogue;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class Plataforma {
    private int x,y,largura,altura;
    private int telaX = 0,telaY = 0;
    private Texture img;
    private boolean visivel;

    public Plataforma(int x, int y, int largura, int altura) {
        this.visivel = true;
        this.x = x;
        this.y = y;
        this.largura = largura;
        this.altura = altura;

        this.img = new Texture("bloco1.png");
    }

    public Rectangle getBounds(){
        return  new Rectangle(x+telaX,y+telaX,largura,altura);
    }

    public boolean isVisivel() {
        return visivel;
    }

    public void setVisivel(boolean visivel) {
        this.visivel = visivel;
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

}
