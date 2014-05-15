/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameoflife;

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
public class GameTest
{
    private Board board;
    private Game game;
    
    @Before
    public void init()
    {
        game = new Game();
        board = new Board(false);
        board.setTablica(0, 0, true);
        board.setTablica(0, 1, true);
    }

    public GameTest()
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
     * Test of main method, of class Game.
     */
    @Test
    public void testMain() throws InterruptedException
    {
        System.out.println("main");
        Game game = new Game();
        game.nextStep();
        
    }

}
