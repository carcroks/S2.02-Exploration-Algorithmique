/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.info.iut.sae2.graphs;

import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 * @author allegal
 */
public class Edge {
    
    private Node source;
    private Node destination;
    
    /*
        Ensemble des points sauf source et destination pour dessiner l'arrête sour forme de courbe de Bézier
    */
    private ArrayList<Coord> bends;
    
    public Edge(Node s, Node d){
        source = s;
        destination = d;
        bends = new ArrayList<Coord>();
    }
    
    public Node getSource(){
        return source;
    }
    
    public Node getDestination(){
        return destination;
    }
    
    public Double getDistance(){
        return source.getCoord().dist(destination.getCoord());
    }
    
    @Override
    public String toString(){
        String s = ("source : " + source.toString() + "\n" +"destinaton : " + destination.toString() + "\n" + "bends : ");
        for (Coord c : bends){
            s += c.getX() + ";" + c.getY() + " , ";
        }
        s += "\n";
        return s;
    }
    
    public ArrayList<Coord> getBends(){
        return bends;
    }
    
    public void setBends(ArrayList<Coord> p){
        bends = p;
    }
    
    public void insertBendAtIndexZero(Coord c){
        bends.add(0, c);
    }
    
    
}
