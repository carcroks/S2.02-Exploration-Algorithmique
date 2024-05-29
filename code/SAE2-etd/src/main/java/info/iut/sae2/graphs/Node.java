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
    
    /**
     * Coordinates of the node in the graph
     */
    private Coord coord;
    
    /**
     * int, id of the node
     */
    private int id;
    
    /**
     * total number of nodes (allow you to always have new ids
     */
    private static int numberOfNodes = 0;
    
    /**
     * Constructor of the class Node
     * 
     * @param c coordinates of the node 
     */
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
    
    /**
     * gtes the coordinates of the Node
     * 
     * @return coordinates of the node
     */
    public Coord getCoord(){
        return coord;
    }
    
    /**
     * gets the id of the Node
     * 
     * @return int, id of the Node
     */
    public int getId(){
        return id;
    }
    
    /**
     * Set the coordinates of the node to new coordinates
     * 
     * @param c the new coordinates of the node
     */
    public void setCoord(Coord c){
        if (c != null)
            coord = c;
    }
    
    /**
     * Shows the X and Y coordinates of the node
     * 
     * @return 
     */
    @Override
    public String toString(){
        return("X : " + coord.getX() + "  Y : " + coord.getY()) + "\n";
    }
    
}
