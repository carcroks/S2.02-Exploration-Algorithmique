/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.info.iut.sae2.graphs;

import java.util.HashSet;

/**
 *
 * @author allegal
 */
public class Edge {
    
    private Node source;
    private Node destination;
    
    /*
        Ensemble des points sauf source et destination pour dessiner l'arrête sour forme de croube de Bézier
    */
    private HashSet<Coord> points;
    
    public Edge(Node s, Node d){
        source = s;
        destination = d;
        points = new HashSet<Coord>();
    }
    
    public Node getSource(){
        return source;
    }
    
    public Node getDestination(){
        return destination;
    }
    
    @Override
    public String toString(){
        return ("source : " + source.toString() + "\n" +"destinaton :" + destination.toString() + "\n");
    }
    
}
