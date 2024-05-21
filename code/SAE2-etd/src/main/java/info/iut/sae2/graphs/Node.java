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
    
    private HashSet<Node> neighbours;
    
    public Node(Coord c){
        coord = c;
        neighbours = new HashSet<Node>();
    }
    
    /**
    @Override
    public boolean equals(Object obj){
        if (obj == this)
            return true;
        if (obj == null)
            return false;
        Node other = (Node) obj;
        if (other.getCoord() == null && this.getCoord()==null)
            return true;
        if (this.getCoord() == null || other.getCoord() == null)
            return false;
        if (!other.getCoord().equals(this.getCoord()))
            return false;
        return true;
    }
    * */
    
    public Coord getCoord(){
        return coord;
    }
    
    public HashSet<Node> getNeighbour(){
        return neighbours;
    }
    
    public void removeNeighbour(Node n){
        neighbours.remove(n);
    }
    
    public void addNeighbour(Node n){
        if (n != null)
            neighbours.add(n);
    }
}
