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
public class Node {
    
    private Coord coord;
    
    private int id;
    
    private static int numberOfNodes = 0;
    
    
    public Node(Coord c){
        coord = c;
        numberOfNodes++;
        id = numberOfNodes;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Node other = (Node) obj;
        return this.id == other.id;
    }
    
    public Coord getCoord(){
        return coord;
    }
    
    public int getId(){
        return id;
    }
    
    public void setCoord(Coord c){
        if (c != null)
            coord = c;
    }
    
    @Override
    public String toString(){
        return("X : " + coord.getX() + "  Y : " + coord.getY());
    }
    
}
