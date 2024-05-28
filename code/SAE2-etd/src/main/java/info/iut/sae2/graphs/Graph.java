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
    
    private HashSet<Node> nodes;
    
    private HashSet<Edge> edges;
    
    public Graph(){
        nodes= new HashSet<Node>();
        edges = new HashSet<Edge>();
    }
    
    @Override
    public Node addNode(){
        Node n = new Node(new Coord(0,0));
        nodes.add(n);
        return n;
    }
    
    @Override
    public Node addNode(Node n){
        if (n==null)
            return null;
        nodes.add(n);
        return n;
    }
    
    @Override
    public Edge addEdge(Edge e){
        if (e==null || e.getSource() == null || e.getDestination() == null)
            return null;
        if (!nodes.contains(e.getSource()))
            nodes.add(e.getSource());
        if(!nodes.contains(e.getDestination()))
            nodes.add(e.getDestination());
        edges.add(e);
        e.getSource().addNeighbour(e.getDestination());
        e.getDestination().addNeighbour(e.getSource());
        e.getSource().addSucessor(e.getDestination());
        e.getDestination().addPredecessor(e.getSource());
        return e;
    }
    
    @Override
    public Edge addEdge(Node src, Node tgt){
        if (src == null || tgt == null)
            return null;
        if (!nodes.contains(src))
            nodes.add(src);
        if(!nodes.contains(tgt))
            nodes.add(tgt);
        Edge e = new Edge(src,tgt);
        edges.add(e);
        src.addNeighbour(tgt);
        tgt.addNeighbour(src);
        src.addSucessor(tgt);
        tgt.addPredecessor(src);
        return e;
    }
    
    @Override
    public void delNode(Node n){
        if (n != null)
        {
            HashSet<Edge> toDelete = new HashSet<>();
            for (Edge e : edges){
                if (e.getSource() == n){
                    e.getDestination().removePredecessor(n);
                    e.getDestination().removeNeighbour(n);
                    toDelete.add(e);
                }
                else if (e.getDestination() == n){
                    e.getSource().removeSucessor(n);
                    e.getSource().removeNeighbour(n);
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
            e.getSource().removeNeighbour(e.getDestination());
            e.getDestination().removeNeighbour(e.getSource());
            e.getSource().removeSucessor(e.getDestination());
            e.getDestination().removePredecessor(e.getSource());         
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
        if (n == null)
            return null;
        return new ArrayList<>(n.getSucessor());
    }
    
    @Override
    public ArrayList<Node> getPredecessors(Node n){
        if (n == null)
            return null;
        return new ArrayList<>(n.getPredecessor());
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
        return (n.getPredecessor().size());
    }
    
    @Override
    public int outDegree(Node n){
        if (n == null)
            return -1;
        return (n.getSucessor().size());
    }
    
    @Override
    public int degree(Node n){
        if (n == null)
            return -1;
        return n.getNeighbour().size();
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
            else if (n.getCoord().getX()>maxx)
                maxx = n.getCoord().getX();
            if (n.getCoord().getY()<miny)
                miny = n.getCoord().getY();
            else if (n.getCoord().getY()>maxy)
                maxy = n.getCoord().getY();
        }
        return new ArrayList<>(Arrays.asList(new Coord(minx, miny), new Coord(maxx, maxy)));
    }
    
    @Override
    public Graph getMinimumSpanningTree(){
        if (this.numberOfNodes() == 0)
            return null;
        Graph res = new Graph();
        for (Node n: nodes)
            res.addNode(n);
        HashSet<Node> isTreated = new HashSet<>();
        isTreated.add((Node)nodes.toArray()[0]);
        for (int i = 0 ; i<nodes.size()-1; i++){
            Double minWeight = Double.MAX_VALUE;
            Edge minEdge = null;
            for (Edge e : edges){
                if (isTreated.contains(e.getSource()) != isTreated.contains(e.getDestination())){
                    Double weight = e.getDistance();
                    if (weight < minWeight){
                        minWeight = weight;
                        minEdge = e;
                    }
                }
            }
            res.addEdge(minEdge);
            if (!isTreated.contains(minEdge.getSource()))
                isTreated.add(minEdge.getSource());
            else
                isTreated.add(minEdge.getDestination());
        }
        return res;
    }
    
    @Override
    public void bundle(){
        Graph g = getMinimumSpanningTree();
        for (Edge e : edges){
            HashMap<Node, Node> predecessorMap = new HashMap<>();
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
                    System.out.println(actualNode.getNeighbour().size()); 
                    for (Node n: g.getNeighbors(actualNode)){
                        if (!predecessorMap.containsKey(n));{
                            toCheck.add(n);
                            predecessorMap.put(n, actualNode);
                        }
                    }
                }
            }
            System.out.println("a");
            Node predecessor = predecessorMap.get(actualNode);
            while (!predecessor.equals(e.getSource())){
                e.insertBendAtIndexZero(predecessor.getCoord());
                predecessor = predecessorMap.get(predecessor);
            }
            System.out.println("b");
            System.out.println(e);
        }
        System.out.println("c");
    }
    
    

    
    
}
