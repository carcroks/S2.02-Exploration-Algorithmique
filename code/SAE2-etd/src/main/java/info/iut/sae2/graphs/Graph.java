/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.info.iut.sae2.graphs;

import java.awt.GridBagConstraints;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 *
 * @author allegal
 */
public class Graph implements IGraph{
    
    /**
     * Nodes of the graph
     */
    private HashSet<Node> nodes;
    
    /**
     * Edges of the graph
     */
    private HashSet<Edge> edges;
    
    /**
     * Neighbors of each Node of the graph
     * Key is the Node, and value is the neighbouring nodes of the key
     */
    private HashMap<Node, HashSet<Node>> Neighbors;
    
    /**
     * Predecessors of each Node of the graph
     * Key is the Node, and value is the neighbouring nodes of the key
     */
    private HashMap<Node, HashSet<Node>> Sucessors;
    
    /**
     * Sucessors of each Node of the graph
     * Key is the Node, and value is the neighbouring nodes of the key
     */
    private HashMap<Node, HashSet<Node>> Predecessors;
    
    /**
     * in and out edges of each Node of the graph
     * Key is the Node, and value is the in and out edges of the key
     * (used in Prim algorithm to only check the edges of the nodes that are already checked)
     */
    private HashMap<Node, HashSet<Edge>> neighbouringEdges;
    
    public Graph(){
        nodes= new HashSet<>();
        edges = new HashSet<>();
        Neighbors = new HashMap<>();
        Sucessors = new HashMap<>();
        Predecessors = new HashMap<>();
        
        neighbouringEdges = new HashMap<>();
    }
    
    @Override
    public Node addNode(){
        Node n = new Node(new Coord(0,0));
        nodes.add(n);
        Neighbors.put(n, new HashSet<>());
        Sucessors.put(n, new HashSet<>());
        Predecessors.put(n, new HashSet<>());
        neighbouringEdges.put(n, new HashSet<>());
        return n;
    }
    
    @Override
    public Node addNode(Node n){
        if (n==null)
            return null;
        nodes.add(n);
        Neighbors.put(n, new HashSet<>());
        Sucessors.put(n, new HashSet<>());
        Predecessors.put(n, new HashSet<>());
        neighbouringEdges.put(n, new HashSet<>());
        return n;
    }
    
    @Override
    public Edge addEdge(Edge e){
        if (e==null || e.getSource() == null || e.getDestination() == null)
            return null;
        if (!nodes.contains(e.getSource()))
            addNode(e.getSource());
        if(!nodes.contains(e.getDestination()))
            addNode(e.getDestination());
        edges.add(e);
        Neighbors.get(e.getSource()).add(e.getDestination());
        Neighbors.get(e.getDestination()).add(e.getSource());
        Sucessors.get(e.getSource()).add(e.getDestination());
        Predecessors.get(e.getDestination()).add(e.getSource());
        
        neighbouringEdges.get(e.getSource()).add(e);
        neighbouringEdges.get(e.getDestination()).add(e);
        return e;
    }
    
    @Override
    public Edge addEdge(Node src, Node tgt){
        if (src == null || tgt == null)
            return null;
        if (!nodes.contains(src))
            addNode(src);
        if(!nodes.contains(tgt))
            addNode(tgt);
        Edge e = new Edge(src,tgt);
        edges.add(e);
        Neighbors.get(src).add(tgt);
        Neighbors.get(tgt).add(src);
        Sucessors.get(src).add(tgt);
        Predecessors.get(tgt).add(src);
        
        neighbouringEdges.get(e.getSource()).add(e);
        neighbouringEdges.get(e.getDestination()).add(e);
        return e;
    }
    
    @Override
    public void delNode(Node n){
        if (n != null)
        {
            HashSet<Edge> toDelete = new HashSet<>();
            for (Edge e : edges){
                if (e.getSource() == n){
                    Predecessors.get(e.getDestination()).remove(n);
                    Neighbors.get(e.getDestination()).remove(n);
                    neighbouringEdges.get(e.getDestination()).remove(e);
                    toDelete.add(e);
                }
                else if (e.getDestination() == n){
                    Sucessors.get(e.getSource()).remove(n);
                    Neighbors.get(e.getSource()).remove(n);
                    neighbouringEdges.get(e.getSource()).remove(e);
                    toDelete.add(e);
                }
            }
            edges.removeAll(toDelete);
            nodes.remove(n);
        }
    }
    
    @Override
    public void delEdge(Edge e){
        if (e != null)
        {
            Neighbors.get(e.getSource()).remove(e.getDestination());
            Neighbors.get(e.getDestination()).remove(e.getSource());
            Sucessors.get(e.getSource()).remove(e.getDestination());
            Predecessors.get(e.getDestination()).remove(e.getSource());
            
            neighbouringEdges.get(e.getSource()).remove(e);
            neighbouringEdges.get(e.getDestination()).remove(e);
            
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
        return new ArrayList<>(Neighbors.get(n));
    }
    
    @Override
    public ArrayList<Node> getSuccesors(Node n){
        if (n == null)
            return null;
        return new ArrayList<>(Sucessors.get(n));
    }
    
    @Override
    public ArrayList<Node> getPredecessors(Node n){
        if (n == null)
            return null;
        return new ArrayList<>(Predecessors.get(n));
    }
    
    @Override
    public ArrayList<Edge> getInOutEdges(Node n){
        if (n == null)
            return null;
        HashSet<Edge> res = new HashSet<Edge>();
        for (Edge e : edges){
            if (e.getSource().equals(n) || e.getDestination().equals(n))
                res.add(e);
        }
        return new ArrayList<>(res);
    }
    
    @Override
    public ArrayList<Edge> getInEdges(Node n){
        if (n == null)
            return null;
        HashSet<Edge> res = new HashSet<>();
        for (Edge e : edges){
            if (e.getDestination().equals(n))
                res.add(e);
        }
        return new ArrayList<>(res);
    }
    
    @Override
    public ArrayList<Edge> getOutEdges(Node n){
        if (n == null)
            return null;
        HashSet<Edge> res = new HashSet<>();
        for (Edge e : edges){
            if (e.getSource().equals(n))
                res.add(e);
        }
        return new ArrayList<>(res);
    }
    
    @Override
    public ArrayList<Node> getNodes(){
        return new ArrayList<>(nodes);
    }
    
    @Override
    public ArrayList<Edge> getEdges(){
        return new ArrayList<>(edges);
    }
    
    @Override
    public Node source(Edge e){
        if (e == null)
            return null;
        return (e.getSource());
    }
    
    @Override
    public Node target(Edge e){
        if (e == null)
            return null;
        return (e.getDestination());
    }
    
    @Override
    public int inDegree(Node n){
        if (n == null)
            return -1;
        return (Predecessors.get(n).size());
    }
    
    @Override
    public int outDegree(Node n){
        if (n == null)
            return -1;
        return (Sucessors.get(n).size());
    }
    
    @Override
    public int degree(Node n){
        if (n == null)
            return -1;
        return (Neighbors.get(n).size());
    }
    
    @Override
    public boolean existEdge(Node src, Node tgt, boolean oriented){
        if (src == null || tgt == null)
            return false;
        for (Edge e : edges){
            if (oriented){
                if (e.getSource().equals(src) && e.getDestination().equals(tgt))
                    return true;
            }
            else{
                if (e.getSource().equals(src) && e.getDestination().equals(tgt)
                   || e.getDestination().equals(src) && e.getSource().equals(tgt))
                    return true;
            }
        }
        return false;
    }
    
    @Override
    public Edge getEdge(Node src, Node tgt, boolean oriented){
        if (src == null || tgt == null)
            return null;
        for (Edge e : edges){
            if (oriented){
                if (e.getSource().equals(src) && e.getDestination().equals(tgt))
                    return e;
            }
            else{
                if (e.getSource().equals(src) && e.getDestination().equals(tgt)
                   || e.getDestination().equals(src) && e.getSource().equals(tgt))
                    return e;
            }
        }
        return null;
    }
    
    @Override
    public Coord getNodePosition(Node n){
        if (n == null)
            return null;
        return n.getCoord();
    }
    
    @Override
    public ArrayList<Coord> getEdgePosition(Edge e){
        if (e == null)
            return null;
        return e.getBends();
    }
     
    @Override
    public void setNodePosition(Node n, Coord c){
        if (n != null && c != null){
            n.setCoord(c);
        }
    }
    
    @Override
    public void setEdgePosition(Edge e, ArrayList<Coord> bends){
        if (e != null && !bends.contains(null)){
            e.setBends(bends);
        }
    }
    
    @Override
    public void setAllNodesPositions(Coord c){
        if (c != null){
            for (Node n : nodes){
                n.setCoord(c);
            }
        }
    }
    
    @Override
    public void setAllEdgesPositions(ArrayList<Coord> bends){
        if (!bends.contains(null)){
            for (Edge e : edges){
                setEdgePosition(e, bends);
            }
        }
    }
    
    @Override
    public ArrayList<Coord> getBoundingBox(){
        double maxy = Double.MIN_VALUE;
        double miny = Double.MAX_VALUE;
        double maxx = Double.MIN_VALUE;
        double minx = Double.MAX_VALUE;
        
        for (Node n : nodes){
            if (n.getCoord().getX()<minx)
                minx = n.getCoord().getX();
            if (n.getCoord().getX()>maxx)
                maxx = n.getCoord().getX();
            if (n.getCoord().getY()<miny)
                miny = n.getCoord().getY();
            if (n.getCoord().getY()>maxy)
                maxy = n.getCoord().getY();
        }
        return new ArrayList<>(Arrays.asList(new Coord(minx, miny), new Coord(maxx, maxy)));
    }
    
    /**
     * Gets the minimum spanning tree with the Prim algorithm
     * 
     * only checks the edges of the nodes that are already checked 
     * 
     * @return 
     */
    @Override
    public Graph getMinimumSpanningTree(){
        
        if (this.numberOfNodes() == 0)
            return null;
        Graph res = new Graph();
        HashSet<Node> isTreated = new HashSet<>();
        HashSet<Node> isTreatable = new HashSet<>();
        
        isTreated.add((Node)nodes.toArray()[0]);
        isTreatable.add((Node)nodes.toArray()[0]);
        for (int i = 0 ; i<nodes.size()-1; i++){
            Double minWeight = Double.MAX_VALUE;
            Edge minEdge = null;
            HashSet<Node> toRemove = new HashSet<>();
            for (Node n : isTreatable){
                Boolean treatable = false;
                for (Edge e : neighbouringEdges.get(n)){
                    if (isTreated.contains(e.getSource()) != isTreated.contains(e.getDestination())){
                        treatable = true;
                        Double weight = e.getDistance();
                        if (weight < minWeight){
                            minWeight = weight;
                            minEdge = e;
                        }
                    }
                }
                if (!treatable)
                    toRemove.add(n);
            }
            isTreatable.removeAll(toRemove);
            res.addEdge(minEdge);
            if (!isTreated.contains(minEdge.getSource())){
                isTreated.add(minEdge.getSource());
                isTreatable.add(minEdge.getSource());
            }
            else{
                isTreated.add(minEdge.getDestination());
                isTreatable.add(minEdge.getDestination());
            }
        }
        return res;
    }
    
    /**
     * Gets the bends of each edges to create Bézier curvs
     * uses BFS (parcours en largeur)
     */
    @Override
    public void bundle(){
        Graph g = getMinimumSpanningTree();
        for (Edge e : edges){
            e.emptyBends();
            HashMap<Node, Node> predecessorMap = new HashMap<>();
            predecessorMap.put(e.getSource(), new Node(new Coord(0,0)));
            Boolean trouve = false;
            ArrayList<Node> toCheck= new ArrayList<>();
            toCheck.add(e.getSource());
            Node actualNode = null;
            while(!trouve){
                actualNode = toCheck.get(0);
                if (actualNode.equals(e.getDestination()))
                    trouve = true;
                else{
                    toCheck.remove(0);
                    for (Node n: g.getNeighbors(actualNode)){
                        if (!predecessorMap.containsKey(n)){
                            toCheck.add(n);
                            predecessorMap.put(n, actualNode);
                        }
                    }
                }
            }
            Node predecessor = predecessorMap.get(actualNode);
            while (!predecessor.equals(e.getSource())){
                e.insertBendAtIndexZero(predecessor.getCoord());
                predecessor = predecessorMap.get(predecessor);
            }    
        }
    }

    /**
     * Returns the strings for each node and each edge of the graph
     * @return 
     */
    @Override
    public String toString() {
        String s = "Here is the graph : " + this.numberOfEdges() + " edges and " + this.numberOfNodes() + "nodes \n";
        for (Node n : nodes)
            s += n.toString();
        s+= "\n\n";
        for (Edge e: edges)
            s+= e.toString() + "\n";
        return s;
    }
}