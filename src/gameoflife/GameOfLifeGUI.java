
package gameoflife;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JPanel;


public class GameOfLifeGUI extends JPanel implements ActionListener, MouseListener
{
    private int size;
    private Game game;
    private JButton bNextStep, bStart, bStop;
    private ExecutionThread executionThread = null;
    private Thread watek;
    public GameOfLifeGUI(Game game, int size)
    {
        this.size = size;
        setSize(size*game.getTablicaLength()+30, size*game.getTablicaLength());
        setLayout(null);
        this.game = game;
        
        bNextStep = new JButton("Next step");
        bNextStep.setBounds(20,  size*game.getTablicaLength()+30, 100, 20);
        bNextStep.addActionListener(this);
        add(bNextStep);
        
        bStart = new JButton("Start");
        bStart.setBounds(20, size*game.getTablicaLength()+10, 100, 20);
        bStart.addActionListener(this);
        add(bStart);
        
        bStop = new JButton("Stop");
        bStop.setBounds(150, size*game.getTablicaLength()+10, 100, 20);
        bStop.addActionListener(this);
        add(bStop);
        
        addMouseListener(this);
    }
    
    public void paintBlackPoint(Graphics g, int x, int y)
    {
        Graphics2D g2D = (Graphics2D) g;
        g2D.setColor(Color.BLACK);
        g2D.fillRect(x, y, size, size);
    }
    
    public void paintWhitePoint(Graphics g, int x, int y)
    {
        Graphics2D g2D = (Graphics2D) g;
        g2D.setColor(Color.WHITE);
        g2D.fillRect(x, y, size, size);
    }
    
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        for(int i = 0; i < game.getTablicaLength(); i++)
        {
            for(int j = 0; j <  game.getTablicaLength(); j++)
            {
                if(game.getTableCell(j, i))
                    paintWhitePoint(g, i*size, j*size);
                else
                    paintBlackPoint(g, i*size, j*size);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object x = e.getSource();
        int threadCounter = 0;
        if(x == bNextStep)
        {
            game.nextStep();
            //game.wypisz();
            repaint();
        }
        else if(x == bStart)
        {
            if(executionThread != null)
                executionThread.setShouldWork(true);
            else{
                executionThread = new ExecutionThread(game, this, true);
                watek = new Thread(executionThread);
                watek.start();
            }
        }
        else if( x == bStop)
        {
            if(!watek.isInterrupted())
            executionThread.setShouldWork(false);            
        }
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {
        int x = e.getX();
        int y = e.getY();
        if(x/size < 100 && y/size < 100)
        game.enableTableCell(y/size, x/size);
        repaint();
    }

    @Override
    public void mousePressed(MouseEvent e)
    {
       
    }

    @Override
    public void mouseReleased(MouseEvent e)
    {
        
    }

    @Override
    public void mouseEntered(MouseEvent e)
    {
      
    }

    @Override
    public void mouseExited(MouseEvent e)
    {
        
    }

    
}
