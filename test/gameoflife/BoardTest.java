/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gameoflife;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mateu_000
 */
public class BoardTest
{ 
    private Board board;
    @Before
    public void init()
    {
       ArrayList<CellStructure> list = new ArrayList();
        list.add(new CellStructure(0, 1, true));
        list.add(new CellStructure(1, 2, true));
        list.add(new CellStructure(2, 0, true));
        list.add(new CellStructure(2, 1, true));
        list.add(new CellStructure(2, 2, true));
        board = new Board(list);
        
    }
            
    public BoardTest()
    {
    }
    
    @BeforeClass
    public static void setUpClass()
    {
    }
    
    @AfterClass
    public static void tearDownClass()
    {
    }
    
    @Before
    public void setUp()
    {
    }
    
    @After
    public void tearDown()
    {
    }

    /**
     * Test of isAlive method, of class Board.
     */
    @Test
    public void testIsAlive()
    {
        System.out.println("isAlive");
        int x = 0;
        int y = 0;
        assertEquals(board.isAlive(0, 1), true);
    }

    /**
     * Test of neigtboursCount method, of class Board.
     */
    @Test
    public void testNeigtboursCount()
    {
        System.out.println("neigtboursCount");
        
        assertEquals(board.neigtboursCount(1, 0), 3);
    }
    
}
