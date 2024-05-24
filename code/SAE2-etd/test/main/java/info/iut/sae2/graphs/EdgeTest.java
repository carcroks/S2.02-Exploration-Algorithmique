/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package main.java.info.iut.sae2.graphs;

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
public class EdgeTest {
    
    public EdgeTest() {
    }
    
    Node n1 = new Node(new Coord(1,1));
    Node n2 = new Node(new Coord(2,2));
    Edge e = new Edge(n1,n2);

    /**
     * Test of getSource method, of class Edge.
     */
    @Test
    public void testGetSource() {
        System.out.println("getSource");
        assert(e.getSource().equals(n1));
    }

    /**
     * Test of getDestination method, of class Edge.
     */
    @Test
    public void testGetDestination() {
        System.out.println("getDestination");
        assert(e.getDestination().equals(n2));
    }

    /**
     * Test of toString method, of class Edge.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        assert(e.toString().equals("source : X : 1.0  Y : 1.0\ndestinaton :X : 2.0  Y : 2.0\n"));
    }
    
}
