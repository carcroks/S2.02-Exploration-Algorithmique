/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package main.java.info.iut.sae2.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author allegal
 */
public class GraphTest {
    
    public GraphTest() {
    }
    
    
    @Test
    public void testAddNode_noArgs(){
        Graph g = new Graph();
        assert(g.getNodes().size() == 0);
        g.addNode();
        g.addNode();
        assert(g.getNodes().size() == 2);
    }

    /**
     * Test of addNode method, of class Graph.
     */
    @Test
    public void testAddNode_Node() {
        System.out.println("addNode");
        Node n1 = new Node(new Coord(1,1));
        Node n2 = new Node(new Coord(2,2));
        Graph g = new Graph();
        assert(g.getNodes().size() == 0);
        g.addNode(n1);
        g.addNode(n2);
        assert(g.getNodes().size() == 2);
        assert(g.getNodes().contains(n1));
        assert(g.getNodes().contains(n2));
    }

    /**
     * Test of addEdge method, of class Graph.
     */
    @Test
    public void testAddEdge_Edge() {
        System.out.println("addEdge");
        Node n1 = new Node(new Coord(1,1));
        Node n2 = new Node(new Coord(2,2));
        Node n3 = new Node(new Coord(0,0));
        Graph g = new Graph();
        Edge e1 = new Edge(n1,n2);
        Edge e2 = new Edge(n2,n1);
        Edge e3 = new Edge(n1,n3);
        g.addEdge(e1);
        g.addEdge(e2);
        g.addEdge(e3);
        assert(g.existEdge(n1, n2, true));
        assert(g.existEdge(n2, n1, true));
        assert(!g.existEdge(n3, n2, true)); 
    }

    /**
     * Test of addEdge method, of class Graph.
     */
    @Test
    public void testAddEdge_Node_Node() {
        System.out.println("addEdge");
        Node n1 = new Node(new Coord(1,1));
        Node n2 = new Node(new Coord(2,2));
        Node n3 = new Node(new Coord(0,0));
        Graph g = new Graph();
        g.addEdge(n1,n2);
        g.addEdge(n2,n1);
        g.addEdge(n1,n3);
        assert(g.existEdge(n1, n2, true));
        assert(g.existEdge(n2, n1, true));
        assert(!g.existEdge(n3, n2, true));        
    }

    /**
     * Test of delNode method, of class Graph.
     */
    @Test
    public void testDelNode() {
        System.out.println("delNode");
        Node n1 = new Node(new Coord(1,1));
        Node n2 = new Node(new Coord(2,2));
        Node n3 = new Node(new Coord(0,0));
        Graph g = new Graph();
        Edge e1 = new Edge(n1,n2);
        Edge e2 = new Edge(n2,n1);
        Edge e3 = new Edge(n1,n3);
        g.addEdge(e1);
        g.addEdge(e2);
        g.addEdge(e3);
        g.delNode(n2);
        assert(2 == g.numberOfNodes());
        assert(1 == g.numberOfEdges());
        assert(!n1.getNeighbour().contains(n2));
        assert(!n1.getSucessor().contains(n2));
        assert(!n1.getPredecessor().contains(n2));
    }

    /**
     * Test of delEdge method, of class Graph.
     */
    @Test
    public void testDelEdge() {
        System.out.println("delEdge");
        Node n1 = new Node(new Coord(1,1));
        Node n2 = new Node(new Coord(2,2));
        Node n3 = new Node(new Coord(0,0));
        Graph g = new Graph();
        Edge e1 = new Edge(n1,n2);
        Edge e2 = new Edge(n2,n1);
        Edge e3 = new Edge(n2,n3);
        g.addEdge(e1);
        g.addEdge(e2);
        g.addEdge(e3);
        g.delEdge(e3);
        assert(2 == g.numberOfEdges());
        assert(g.getNeighbors(n2).size() == 1);
    }

    /**
     * Test of numberOfNodes method, of class Graph.
     */
    @Test
    public void testNumberOfNodes() {
        System.out.println("numberOfNodes");
        Node n1 = new Node(new Coord(1,1));
        Node n2 = new Node(new Coord(2,2));
        Node n3 = new Node(new Coord(0,0));
        Graph g = new Graph();
        g.addNode(n1);
        g.addNode(n2);
        g.addNode(n3);
        assert(3 == g.numberOfNodes());
        Node n4 = new Node(new Coord(4,4));
        g.addNode(n4);
        assert(4 == g.numberOfNodes());
    }

    /**
     * Test of numberOfEdges method, of class Graph.
     */
    @Test
    public void testNumberOfEdges() {
        System.out.println("numberOfEdges");
        Node n1 = new Node(new Coord(1,1));
        Node n2 = new Node(new Coord(2,2));
        Node n3 = new Node(new Coord(0,0));
        Graph g = new Graph();
        Edge e1 = new Edge(n1,n2);
        Edge e2 = new Edge(n2,n1);
        Edge e3 = new Edge(n2,n3);
        g.addEdge(e1);
        g.addEdge(e2);
        g.addEdge(e3);
        int expResult = 3;
        int result = g.numberOfEdges();
        assert(result == expResult);
        Edge e4 = new Edge(n2,n3);
        g.addEdge(e4);
        assert(4 == g.numberOfEdges());
    }

    /**
     * Test of getNeighbors method, of class Graph.
     */
    @Test
    public void testGetNeighbors() {
        System.out.println("getNeighbors");
        Node n1 = new Node(new Coord(1,1));
        Node n2 = new Node(new Coord(2,2));
        Node n3 = new Node(new Coord(0,0));
        Graph g = new Graph();
        Edge e1 = new Edge(n1,n2);
        Edge e2 = new Edge(n2,n1);
        Edge e3 = new Edge(n2,n3);
        Edge e4 = new Edge(n3,n1);
        g.addEdge(e1);
        g.addEdge(e2);
        g.addEdge(e3);
        g.addEdge(e4);
        ArrayList<Node> expResult1 = new ArrayList<>(Arrays.asList(n1,n3));
        ArrayList<Node> result1 = g.getNeighbors(n2);
        ArrayList<Node> expResult2 = new ArrayList<>(Arrays.asList(n2, n3));
        ArrayList<Node> result2 = g.getNeighbors(n1);
        assertArrayEquals(expResult1.toArray(), result1.toArray());
        assertArrayEquals(expResult2.toArray(), result2.toArray());
    }

    /**
     * Test of getSuccesors method, of class Graph.
     */
    @Test
    public void testGetSuccesors() {
        System.out.println("getSuccesors");
        Node n1 = new Node(new Coord(1,1));
        Node n2 = new Node(new Coord(2,2));
        Node n3 = new Node(new Coord(0,0));
        Graph g = new Graph();
        Edge e1 = new Edge(n1,n2);
        Edge e2 = new Edge(n2,n1);
        Edge e3 = new Edge(n2,n3);
        g.addEdge(e1);
        g.addEdge(e2);
        g.addEdge(e3);
        ArrayList<Node> expResult1 = new ArrayList<>(Arrays.asList(n1,n3));
        ArrayList<Node> result1 = g.getSuccesors(n2);
        ArrayList<Node> expResult2 = new ArrayList<>(Arrays.asList(n2));
        ArrayList<Node> result2 = g.getSuccesors(n1);
        assertArrayEquals(expResult1.toArray(), result1.toArray());
        assertArrayEquals(expResult2.toArray(), result2.toArray());
    }

    /**
     * Test of getPredecessors method, of class Graph.
     */
    @Test
    public void testGetPredecessors() {
        System.out.println("getPredecessors");
        Node n1 = new Node(new Coord(1,1));
        Node n2 = new Node(new Coord(2,2));
        Node n3 = new Node(new Coord(0,0));
        Graph g = new Graph();
        Edge e1 = new Edge(n1,n2);
        Edge e2 = new Edge(n2,n1);
        Edge e3 = new Edge(n3,n2);
        g.addEdge(e1);
        g.addEdge(e2);
        g.addEdge(e3);
        ArrayList<Node> expResult1 = new ArrayList<>(Arrays.asList(n1,n3));
        ArrayList<Node> result1 = g.getPredecessors(n2);
        ArrayList<Node> expResult2 = new ArrayList<>(Arrays.asList(n2));
        ArrayList<Node> result2 = g.getPredecessors(n1);
        assertArrayEquals(expResult1.toArray(), result1.toArray());
        assertArrayEquals(expResult2.toArray(), result2.toArray());
    }

    /**
     * Test of getInOutEdges method, of class Graph.
     */
    @Test
    public void testGetInOutEdges() {
        System.out.println("getInOutEdges");
        Node n1 = new Node(new Coord(1,1));
        Node n2 = new Node(new Coord(2,2));
        Node n3 = new Node(new Coord(0,0));
        Graph g = new Graph();
        Edge e1 = new Edge(n1,n2);
        Edge e2 = new Edge(n2,n1);
        Edge e3 = new Edge(n3,n2);
        g.addEdge(e1);
        g.addEdge(e2);
        g.addEdge(e3);
        ArrayList<Edge> expResult1 = new ArrayList<>(Arrays.asList(e3,e1,e2));
        ArrayList<Edge> result1 = g.getInOutEdges(n2);
        ArrayList<Edge> expResult2 = new ArrayList<>(Arrays.asList(e1,e2));
        ArrayList<Edge> result2 = g.getInOutEdges(n1);
        assertArrayEquals(expResult1.toArray(), result1.toArray());
        assertArrayEquals(expResult2.toArray(), result2.toArray());
    }

    /**
     * Test of getInEdges method, of class Graph.
     */
    @Test
    public void testGetInEdges() {
        System.out.println("getInEdges");
        Node n1 = new Node(new Coord(1,1));
        Node n2 = new Node(new Coord(2,2));
        Node n3 = new Node(new Coord(0,0));
        Graph g = new Graph();
        Edge e1 = new Edge(n1,n2);
        Edge e2 = new Edge(n2,n1);
        Edge e3 = new Edge(n3,n2);
        g.addEdge(e1);
        g.addEdge(e2);
        g.addEdge(e3);
        ArrayList<Edge> expResult1 = new ArrayList<>(Arrays.asList(e3,e1));
        ArrayList<Edge> result1 = g.getInEdges(n2);
        ArrayList<Edge> expResult2 = new ArrayList<>(Arrays.asList(e2));
        ArrayList<Edge> result2 = g.getInEdges(n1);
        assertArrayEquals(expResult1.toArray(), result1.toArray());
        assertArrayEquals(expResult2.toArray(), result2.toArray());
    }

    /**
     * Test of getOutEdges method, of class Graph.
     */
    @Test
    public void testGetOutEdges() {
        System.out.println("getOutEdges");
        Node n1 = new Node(new Coord(1,1));
        Node n2 = new Node(new Coord(2,2));
        Node n3 = new Node(new Coord(0,0));
        Graph g = new Graph();
        Edge e1 = new Edge(n1,n2);
        Edge e2 = new Edge(n2,n1);
        Edge e3 = new Edge(n2,n3);
        g.addEdge(e1);
        g.addEdge(e2);
        g.addEdge(e3);
        ArrayList<Edge> expResult1 = new ArrayList<>(Arrays.asList(e3,e2));
        ArrayList<Edge> result1 = g.getOutEdges(n2);
        ArrayList<Edge> expResult2 = new ArrayList<>(Arrays.asList(e1));
        ArrayList<Edge> result2 = g.getOutEdges(n1);
        assertArrayEquals(expResult1.toArray(), result1.toArray());
        assertArrayEquals(expResult2.toArray(), result2.toArray());
    }

    /**
     * Test of getNodes method, of class Graph.
     */
    @Test
    public void testGetNodes() {
        System.out.println("getNodes");
        Node n1 = new Node(new Coord(1,1));
        Node n2 = new Node(new Coord(2,2));
        Node n3 = new Node(new Coord(0,0));
        Graph g = new Graph();
        g.addNode(n1);
        g.addNode(n2);
        g.addNode(n3);
        ArrayList<Node> expResult = new ArrayList<>(Arrays.asList(n1,n2,n3));
        ArrayList<Node> result = g.getNodes();
        assertArrayEquals(expResult.toArray(), result.toArray());
    }

    /**
     * Test of getEdges method, of class Graph.
     */
    @Test
    public void testGetEdges() {
        System.out.println("getEdges");
        Node n1 = new Node(new Coord(1,1));
        Node n2 = new Node(new Coord(2,2));
        Node n3 = new Node(new Coord(0,0));
        Graph g = new Graph();
        Edge e1 = new Edge(n1,n2);
        Edge e2 = new Edge(n2,n3);
        g.addEdge(e1);
        g.addEdge(e2);
        ArrayList<Edge> expResult = new ArrayList<>(Arrays.asList(e1,e2));
        ArrayList<Edge> result = g.getEdges();
        assertArrayEquals(expResult.toArray(), result.toArray());
    }

    /**
     * Test of source method, of class Graph.
     */
    @Test
    public void testSource() {
        System.out.println("source");
        Node n1 = new Node(new Coord(1,1));
        Node n2 = new Node(new Coord(2,2));
        Graph g = new Graph();
        Edge e = new Edge(n1,n2);
        g.addEdge(e);
        assertEquals(n1, g.source(e));
    }

    /**
     * Test of target method, of class Graph.
     */
    @Test
    public void testTarget() {
        System.out.println("target");
        Node n1 = new Node(new Coord(1,1));
        Node n2 = new Node(new Coord(2,2));
        Graph g = new Graph();
        Edge e = new Edge(n1,n2);
        g.addEdge(e);
        assertEquals(n2, g.target(e));
    }

    /**
     * Test of inDegree method, of class Graph.
     */
    @Test
    public void testInDegree() {
        System.out.println("inDegree");
        Node n1 = new Node(new Coord(1,1));
        Node n2 = new Node(new Coord(2,2));
        Node n3 = new Node(new Coord(0,0));
        Graph g = new Graph();
        g.addEdge(n1,n2);
        g.addEdge(n2,n3);
        g.addEdge(n3,n2);
        assert(2 == g.inDegree(n2));
        assert(1 == g.inDegree(n3));
    }

    /**
     * Test of outDegree method, of class Graph.
     */
    @Test
    public void testOutDegree() {
        System.out.println("Outdegree");
        Node n1 = new Node(new Coord(1,1));
        Node n2 = new Node(new Coord(2,2));
        Node n3 = new Node(new Coord(0,0));
        Graph g = new Graph();
        g.addEdge(n1,n2);
        g.addEdge(n2,n3);
        g.addEdge(n2,n1);
        assert(2 == g.outDegree(n2));
        assert(1 == g.outDegree(n1));
    }

    /**
     * Test of degree method, of class Graph.
     */
    @Test
    public void testDegree() {
        System.out.println("degree");
        Node n1 = new Node(new Coord(1,1));
        Node n2 = new Node(new Coord(2,2));
        Node n3 = new Node(new Coord(0,0));
        Graph g = new Graph();
        g.addEdge(n1,n2);
        g.addEdge(n2,n3);
        assert(2 == g.degree(n2));
        assert(1 == g.degree(n1));
    }

    /**
     * Test of existEdge method, of class Graph.
     */
    @Test
    public void testExistEdge() {
        System.out.println("existEdge");
        Node src = new Node(new Coord(1,1));      
        Node tgt = new Node(new Coord(2,2));
        Node n = new Node(new Coord(0,0));
        Graph g = new Graph();
        g.addEdge(src, tgt);
        assertEquals(true, g.existEdge(src, tgt, false));
        assertEquals(false, g.existEdge(n, tgt, false));       
    }

    /**
     * Test of getEdge method, of class Graph.
     */
    @Test
    public void testGetEdge() {
        System.out.println("getEdge");
        Node src = null;
        Node tgt = null;
        boolean oriented = false;
        Graph instance = new Graph();
        Edge expResult = null;
        Edge result = instance.getEdge(src, tgt, oriented);
        assertEquals(expResult, result);
    }

    /**
     * Test of getNodePosition method, of class Graph.
     */
    @Test
    public void testGetNodePosition() {
        System.out.println("getNodePosition");
        Node n = new Node(new Coord(1,1));
        Graph g = new Graph();
        g.addNode(n);
        Coord expResult = new Coord(1,1);
        Coord result = g.getNodePosition(n);
        assert(expResult.getX() ==  result.getX() && expResult.getY() == result.getY());
    }

    /**
     * Test of getEdgePosition method, of class Graph.
     */
    @Test
    public void testGetEdgePosition() {
        System.out.println("getEdgePosition");
        Coord c1 = new Coord(3,3);
        Coord c2 = new Coord(4,4);
        
        Node n1 = new Node(new Coord(0,0));
        Node n2 = new Node(new Coord(1,1));
        Edge e = new Edge(n1,n2);
        Graph g = new Graph();
        g.addEdge(e);
        e.setBends(new ArrayList<>(Arrays.asList(c1,c2)));
        ArrayList<Coord> expResult = new ArrayList<>(Arrays.asList(n1.getCoord(),n2.getCoord()));
        ArrayList<Coord> result = g.getEdgePosition(e);
        assertEquals(expResult, result);
    }

    /**
     * Test of setNodePosition method, of class Graph.
     */
    @Test
    public void testSetNodePosition() {
        System.out.println("setNodePosition");
        Node n = new Node(new Coord(0,0));
        Coord c = new Coord(1,1);
        Graph g = new Graph();
        g.addNode(n);
        g.setNodePosition(n, c);
        System.out.println("coordonnées de n: " + n.getCoord().getX()+","+n.getCoord().getY());
        System.out.println("coordonnées de c: " + c.getX()+","+c.getY());
        assert(n.getCoord().getX() == c.getX() && n.getCoord().getY() == c.getY());
    }

    /**
     * Test of setEdgePosition method, of class Graph.
     */
    @Test
    public void testSetEdgePosition() {
        System.out.println("setEdgePosition");
        Coord c11 = new Coord(0,0);
        Coord c12 = new Coord(1,1);
        Coord c21 = new Coord(2,2);
        Coord c22 = new Coord(1,1);
        Edge e1 = new Edge(new Node(c11), new Node(c12));
        Edge e2 = new Edge(new Node(c21), new Node(c22));
        ArrayList<Coord> bends = new ArrayList<>(Arrays.asList(c21, c22));
        Graph g = new Graph();
        g.setEdgePosition(e1, bends);
        assert(e1.getSource().getCoord().getX() == c21.getX());
        assert(e1.getSource().getCoord().getY() == c21.getY());
        assert(e1.getDestination().getCoord().getX() == c22.getX());
        assert(e1.getDestination().getCoord().getY() == c22.getY());
    }

    /**
     * Test of setAllNodesPositions method, of class Graph.
     */
    @Test
    public void testSetAllNodesPositions() {
        System.out.println("setAllNodesPositions");
        Node n1 = new Node(new Coord(1,1));
        Node n2 = new Node(new Coord(2,2));
        Node n3 = new Node(new Coord(0,0));
        Graph g = new Graph();
        Coord c = new Coord(4,4);
        g.addNode(n1);
        g.addNode(n2);
        g.addNode(n3);
        g.setAllNodesPositions(c);
        assert(n1.getCoord() == c);
        assert(n2.getCoord() == c);
        assert(n3.getCoord() == c);
    }

    /**
     * Test of setAllEdgesPositions method, of class Graph.
     */
    @Test
    public void testSetAllEdgesPositions() {
        System.out.println("setAllEdgesPositions");
        Node n1 = new Node(new Coord(1,1));
        Node n2 = new Node(new Coord(2,2));
        Node n3 = new Node(new Coord(0,0));
        Graph g = new Graph();
        Coord c1 = new Coord(1,1);
        Coord c2 = new Coord(2,2);
        
        g.addNode(n1);
        g.addNode(n2);
        g.addNode(n3);
        g.addEdge(n1,n2);
        g.addEdge(n2,n3);
        g.setAllEdgesPositions(new ArrayList<>(Arrays.asList(c1, c2)));
        assert(n1.getCoord() == c1);
        assert(n2.getCoord() == c1);
        assert(n3.getCoord() == c2);
    }

    /**
     * Test of getBoundingBox method, of class Graph.
     */
    @Test
    public void testGetBoundingBox() {
        System.out.println("getBoundingBox");
        Node n1 = new Node(new Coord(0,-1));
        Node n2 = new Node(new Coord(-1,0));
        Node n3 = new Node(new Coord(1,0));
        Node n4 = new Node(new Coord(0,1));
        Graph g= new Graph();
        g.addNode(n1);
        g.addNode(n2);
        g.addNode(n3);
        g.addNode(n4);
        
        ArrayList<Coord> expResult = new ArrayList<>(Arrays.asList(new Coord(-1,-1), new Coord(1,1)));
        ArrayList<Coord> result = g.getBoundingBox();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMinimumSpanningTree method, of class Graph.
     */
    @Test
    public void testGetMinimumSpanningTree() {
        System.out.println("getMinimumSpanningTree");
        Graph instance = new Graph();
        Graph expResult = null;
        Graph result = instance.getMinimumSpanningTree();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of bundle method, of class Graph.
     */
    @Test
    public void testBundle() {
        System.out.println("bundle");
        Graph instance = new Graph();
        instance.bundle();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
