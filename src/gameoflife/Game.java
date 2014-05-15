package gameoflife;

import java.util.ArrayList;
import javax.swing.JFrame;

public class Game 
{
    private Board board, boardTemp;

    public Game() 
    {
        ArrayList<CellStructure> list = new ArrayList();
        list.add(new CellStructure(0, 1, true));
        list.add(new CellStructure(1, 2, true));
        list.add(new CellStructure(2, 0, true));
        list.add(new CellStructure(2, 1, true));
        list.add(new CellStructure(2, 2, true));
        board = new Board(list);
        boardTemp = new Board(board);
    }
    
    public void enableTableCell(int x, int y)
    {
        board.setTablica(x, y, true);
    }
    
    public void nextStep() 
    {
         boardTemp = new Board(board);
         for(int i = 0; i < board.getTablica_length(); i++)
         {
             for(int j = 0; j < board.getTablica_length(); j++)
             {
                 if(!board.isAlive(i, j))
                 {
                     if(board.neigtboursCount(i, j) == 3)
                     {
                         boardTemp.setTablica(i, j, true);
                     }
                     
                 }
                 else
                 {
                     if((board.neigtboursCount(i, j) == 1 || (board.neigtboursCount(i, j) == 0)) || board.neigtboursCount(i, j) > 3)
                        boardTemp.setTablica(i, j, false);
                 }
             }
         }
         board.setTablica(boardTemp.getTablica());
    }
    
    public boolean getTableCell(int x, int y)
    {
        return board.isAlive(x, y);
    }
    
    public int  getTablicaLength()
    {
        return board.getTablica_length();
    }
    
    public void wypisz()
    {
        for(int i = 0; i < board.getTablica_length(); i++)
        {
            for(int j = 0; j < board.getTablica_length(); j++)
            {
                if(board.isAlive(i, j))
                    System.out.print("O ");
                else
                    System.out.print("X ");
            }
            System.out.print("\n");
        }
        System.out.println("*******************************");
        
        for(int i = 0; i < board.getTablica_length(); i++)
        {
            for(int j = 0; j < board.getTablica_length(); j++)
            {
                System.out.print(board.neigtboursCount(i, j) + " ");
            }
            System.out.print("\n");
        }
        System.out.println("_____________________________________");
    }

    public static void main(String[] args) throws InterruptedException
    {
        Game gra = new Game();
        JFrame okno = new JFrame("Game of Life");
        okno.setSize(500, 500);
        okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        GameOfLifeGUI gui = new GameOfLifeGUI(gra);
        okno.add(gui);
        okno.setVisible(true);        
    }

    

}
