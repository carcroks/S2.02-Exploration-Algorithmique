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
    
    private HashSet<Node> neighbours;
    private HashSet<Node> sucessors;
    private HashSet<Node> predecessors;
    
    public Node(Coord c){
        coord = c;
        neighbours = new HashSet<Node>();
        sucessors = new HashSet<Node>();
        predecessors = new HashSet<Node>();
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
    
    public HashSet<Node> getSucessor(){
        return sucessors;
    }
    
    public void removeSucessor(Node n){
        sucessors.remove(n);
    }
    
    public void addSucessor(Node n){
        if (n != null)
            sucessors.add(n);
    }
    
    public HashSet<Node> getPredecessor(){
        return predecessors;
    }
    
    public void removePredecessor(Node n){
        predecessors.remove(n);
    }
    
    public void addPredecessor(Node n){
        if (n != null)
            predecessors.add(n);
    }
    
    public int getId(){
        return id;
    }
    
    public void setCoord(Coord c){
        if (c == null)
            coord = c;
    }
    
}
