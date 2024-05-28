/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package main.java.info.iut.sae2.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
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
public class NodeTest {
    
    public NodeTest() {
    }

    Coord c = new Coord(0,0);
    Node n1 = new Node(c);
    Node n12 = new Node(c);
    Node n2 = new Node(new Coord(2,2));
    Node n3 = new Node(new Coord(3,3));
    
    Graph g = new Graph();
    
    /**
     * Test of hashCode method, of class Node.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        assert(n1 != n12);
        assert(n1 != n2);
    }

    /**
     * Test of equals method, of class Node.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        assert(!n1.equals(n12));
        assert(!n1.equals(n2));
    }

    /**
     * Test of getCoord method, of class Node.
     */
    @Test
    public void testGetCoord() {
        System.out.println("getCoord");
        assert(n1.getCoord().equals(c));
    }

    /**
     * Test of setCoord method, of class Node.
     */
    @Test
    public void testSetCoord() {
        n2.setCoord(c);
        assert(n2.getCoord().equals(c));
    }

    /**
     * Test of toString method, of class Node.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        System.out.println(n1);
        System.out.println("X : 0.0  Y : 0.0");
        assert(n1.toString().equals("X : 0.0  Y : 0.0"));
    }
    
}
