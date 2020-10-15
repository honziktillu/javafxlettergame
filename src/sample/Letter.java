package sample;

import javafx.scene.paint.Paint;

public class Letter {

    private double x;
    private double y;
    private double width;
    private double height;
    private String letter;
    private int status = 0;

    public Letter(double x, double y, double width, double height, String letter) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.letter = letter;
    }

    public Paint getColor() {
        switch (status) {
            case 0:
                return Paint.valueOf("GREY");
            case 1:
                return Paint.valueOf("GREEN");
            case 2:
                return Paint.valueOf("RED");
            default:
                return Paint.valueOf("WHITE");
        }
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double heigth) {
        this.height = heigth;
    }

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}
