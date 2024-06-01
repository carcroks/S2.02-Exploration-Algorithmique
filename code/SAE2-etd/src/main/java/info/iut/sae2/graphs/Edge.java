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
        Points that allows to create a Bézier curv for the Edge
    */
    private ArrayList<Coord> bends;
    
    public Edge(Node s, Node d){
        source = s;
        destination = d;
        bends = new ArrayList<Coord>();
    }
    
    /**
     * Gets the Source node of the Edge
     * 
     * @return source Node of the Edge
     */
    public Node getSource(){
        return source;
    }
    
    /**
     * Gets the Destination node of the Edge
     * 
     * @return destination Node of the Edge
     */
    public Node getDestination(){
        return destination;
    }
    
    /**
     * Gets the length of the Edge
     * 
     * @return length of the Edge
     */
    public Double getDistance(){
        return source.getCoord().dist(destination.getCoord());
    }
    
    @Override
    public String toString(){
        String s = ("source : " + source.toString()  +"destinaton : " + destination.toString() + "\n" + "bends : ");
        for (Coord c : bends){
            s += c.getX() + ";" + c.getY() + " , ";
        }
        s += "\n";
        return s;
    }
    
    /**
     * Gets the bends of the Edge (points for the Bézier curv
     * 
     * @return bends of the Edge
     */
    public ArrayList<Coord> getBends(){
        return bends;
    }
    
    /**
     * Sets the bends of the Edge
     * 
     * @param p bends of the Edge
     */
    public void setBends(ArrayList<Coord> p){
        bends = p;
    }
    
    /**
     * Inserts a bend at the start (index 0) of the bends ArrayList
     * 
     * @param c Coord to insert at the start of the bends
     */
    public void insertBendAtIndexZero(Coord c){
        bends.add(0, c);
    }
    
    /**
     * Empties the bends of the Edge
     */
    public void emptyBends(){
        bends = new ArrayList<Coord>();
    }
    
    
}
