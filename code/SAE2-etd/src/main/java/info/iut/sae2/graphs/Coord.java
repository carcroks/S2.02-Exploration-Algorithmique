package main.java.info.iut.sae2.graphs;

public class Coord {
    private double x, y;
    public Coord(){
        x = y = 0.;
    }
    public Coord(double x, double y){
        this.x = x;
        this.y = y;
    }
    public double dist(Coord c){
        if (c==null)
            return -1;
        return Math.sqrt(Math.pow(this.x - c.getX(), 2) + Math.pow(this.y - c.getY(), 2));
    }
    public double getX() { return x; }
    public double getY() { return y; }
    public void setX(double x) { this.x = x; }
    public void setY(double y) { this.y = y; }
}
