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
public class EdgeTest {
    
    public EdgeTest() {
    }
    
    Node n1 = new Node(new Coord(1,1));
    Node n2 = new Node(new Coord(2,2));
    Edge e = new Edge(n1,n2);

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

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
     * Test of getDistance method, of class Edge.
     */
    @Test
    public void testGetDistance() {
        Node n1 = new Node(new Coord(0,0));
        Node n2 = new Node(new Coord(3,4));
        Edge e1 = new Edge(n1,n2);
        assert(e1.getDistance() == 5);
    }

    /**
     * Test of getBends method, of class Edge.
     */
    @Test
    public void testGetBends() {
        Coord c1 = new Coord(2,2);
        Coord c2 = new Coord(4,4);
        Node n1 = new Node(new Coord(0,0));
        Node n2 = new Node(new Coord(3,4));
        ArrayList<Coord> bends = new ArrayList<Coord>(Arrays.asList(c1,c2));
        Edge e1 = new Edge(n1,n2);
        e1.setBends(bends);
        ArrayList<Coord> res = e1.getBends();
        assert(res == bends);
    }

    /**
     * Test of setBends method, of class Edge.
     */
    @Test
    public void testSetBends() {
        Coord c1 = new Coord(2,2);
        Coord c2 = new Coord(4,4);
        Node n1 = new Node(new Coord(0,0));
        Node n2 = new Node(new Coord(3,4));
        ArrayList<Coord> bends = new ArrayList<Coord>(Arrays.asList(c1,c2));
        Edge e1 = new Edge(n1,n2);
        e1.setBends(bends);
        ArrayList<Coord> res = e1.getBends();
        assert(res == bends);
    }

    /**
     * Test of insertBendAtIndexZero method, of class Edge.
     */
    @Test
    public void testInsertBendAtIndexZero() {
        Coord c1 = new Coord(2,2);
        Coord c2 = new Coord(4,4);
        Coord c3 = new Coord(6,6);
        Node n1 = new Node(new Coord(0,0));
        Node n2 = new Node(new Coord(3,4));
        ArrayList<Coord> bends = new ArrayList<Coord>(Arrays.asList(c1,c2));
        Edge e1 = new Edge(n1,n2);
        e1.setBends(bends);
        e1.insertBendAtIndexZero(c3);
        ArrayList<Coord> expres = new ArrayList<Coord>(Arrays.asList(c3,c1,c2));
        ArrayList<Coord> res = e1.getBends();
        assertEquals(res, expres);
        expres = new ArrayList<Coord>(Arrays.asList(c1,c2,c3));
        assertNotEquals(res, expres);
    }
    
}
