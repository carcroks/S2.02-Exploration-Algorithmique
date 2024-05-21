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
public class Graph implements IGraph{
    
    HashSet<Node> nodes;
    
    HashSet<Edge> edges;
    
    public Graph(){
        nodes= new HashSet<Node>();
        edges = new HashSet<Edge>();
    }
    
    public Node addNode(){
        
    }
    
    public Node addNode(Node n){
        if (n==null)
            return null;
        nodes.add(n);
        return n;
    }
    
    public Edge addEdge(Edge e){
        if (e==null)
            return null;
        edges.add(e);
        return e;
    }
    
    public Edge addEdge(Node src, Node tgt){
        if (src == null || tgt == null)
            return null;
        Edge e = new Edge(src,tgt);
        edges.add(e);
        return e;
    }
    
    public void delNode(Node n){
        if (n != null)
        {
            for (Node node : nodes){
                if (node.getNeighbour().contains(n))
                    node.removeNeighbour(n);
            }
            nodes.remove(n);
        }
    }
    
    public void delEdge(Edge e){
        if (e != null)
        {
            e.getSource().removeNeighbour(e.getDestination());
            e.getDestination().removeNeighbour(e.getSource());
            
            edges.remove(e);
        }
    }
    
    public int numberOfNodes(){
        return nodes.size();
    }
    
    public int numberOfEdges(){
        return edges.size();
    }
    
    public ArrayList<Node> getNeighbors(Node n){
        
    }

    
    
}
