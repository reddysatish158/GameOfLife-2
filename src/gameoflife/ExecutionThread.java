/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameoflife;


/**
 *
 * @author mateu_000
 */
public class ExecutionThread implements Runnable
{

    private Game game;
    private GameOfLifeGUI gui;
    private boolean shouldWork;

    public ExecutionThread(Game game, GameOfLifeGUI gui, boolean value)
    {
        this.game = game;
        this.gui = gui;
        shouldWork = value;
    }

    @Override
    public void run()
    {
        while(shouldWork)
        {
            try
            {
                Thread.sleep(200);
            }
            catch (InterruptedException ex)
            {
                System.out.println(ex.toString());
            }
            game.nextStep();
            gui.repaint();
            System.out.println(shouldWork);
        }
    }
    public void setShouldWork(boolean x)
    {
        shouldWork = x;
    }

}
