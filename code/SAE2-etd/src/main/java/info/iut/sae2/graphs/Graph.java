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
    
    @Override
    public Node addNode(){
        
    }
    
    @Override
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
    
    @Override
    public Edge addEdge(Node src, Node tgt){
        if (src == null || tgt == null)
            return null;
        Edge e = new Edge(src,tgt);
        edges.add(e);
        return e;
    }
    
    @Override
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
    
    @Override
    public void delEdge(Edge e){
        if (e != null)
        {
            e.getSource().removeNeighbour(e.getDestination());
            e.getDestination().removeNeighbour(e.getSource());
            
            edges.remove(e);
        }
    }
    
    @Override
    public int numberOfNodes(){
        return nodes.size();
    }
    
    @Override
    public int numberOfEdges(){
        return edges.size();
    }
    
    @Override
    public ArrayList<Node> getNeighbors(Node n){
        if (n == null)
            return null;
        return new ArrayList<>(n.getNeighbour());
    }
    
    @Override
    public ArrayList<Node> getSuccesors(Node n){
        
    }
    
    @Override
    public ArrayList<Node> getPredecessors(Node n){
        
    }
    
    @Override
    public ArrayList<Edge> getInOutEdges(Node n){
        
    }
    
    @Override
    public ArrayList<Edge> getInEdges(Node n){
        
    }
    
    @Override
    public ArrayList<Edge> getOutEdges(Node n){
        
    }
    
    @Override
    public ArrayList<Node> getNodes(){
        
    }
    
    @Override
    public ArrayList<Edge> getEdges(){
        
    }
    
    @Override
    public Node source(Edge e){
        
    }
    
    @Override
    public Node target(Edge e){
        
    }
    
    @Override
    public int inDegree(Node n){
        
    }
    
    @Override
    public int outDegree(Node n){
        
    }
    
    @Override
    public int degree(Node n){
        
    }
    
    @Override
    public boolean existEdge(Node src, Node tgt, boolean oriented){
        
    }
    
    @Override
    public Edge getEdge(Node src, Node tgt, boolean oriented){
        
    }
    
    @Override
    public Coord getNodePosition(Node n){
        
    }
    
    @Override
    public ArrayList<Coord> getEdgePosition(Edge e){
        
    }
    
    @Override
    public void setNodePosition(Node n, Coord c){
        
    }
    
    @Override
    public void setEdgePosition(Edge e, ArrayList<Coord> bends){
        
    }
    
    @Override
    public void setAllNodesPositions(Coord c){
        
    }
    
    @Override
    public void setAllEdgesPositions(ArrayList<Coord> bends){
        
    }
    
    @Override
    public ArrayList<Coord> getBoundingBox(){
        
    }
    
    @Override
    public Graph getMinimumSpanningTree(){
        
    }
    
    @Override
    public void bundle(){
        
    }

    
    
}
