package gameoflife;

import java.util.ArrayList;
import java.util.Random;

public class Board implements Cloneable
{

    private final int tablica_length = 99;
    private boolean tablica[][];

    public Board()
    {
        Random random = new Random();
        tablica = new boolean[tablica_length + 1][tablica_length + 1];
        for (int i = 0; i < tablica_length; i++)
        {
            for (int j = 0; j < tablica_length; j++)
            {
                if (random.nextInt() % 2 == 0)
                {
                    tablica[i][j] = false;
                }
                else
                {
                    tablica[i][j] = true;
                }
            }
        }
    }

    public Board(Board board)
    {
        this.tablica = new boolean[this.tablica_length+1][this.tablica_length+1];
        for (int i = 0; i < this.tablica_length; i++)
        {
            for (int j = 0; j < this.tablica_length; j++)
            {
                this.tablica[i][j] = board.isAlive(i, j);
            }
        }
    }

    public Board(ArrayList<CellStructure> list)
    {
        tablica = new boolean[tablica_length + 1][tablica_length + 1];
        for (int i = 0; i < tablica_length; i++)
        {
            for (int j = 0; j < tablica_length; j++)
            {
                tablica[i][j] = false;
            }
        }
        for (int a = 0; a < list.size(); a++)
        {
            tablica[list.get(a).getX()][list.get(a).getY()] = list.get(a).isValue();
        }
    }
    
    public Board(boolean value)
    {
         tablica = new boolean[tablica_length + 1][tablica_length + 1];
        for (int i = 0; i < tablica_length; i++)
        {
            for (int j = 0; j < tablica_length; j++)
            {
                tablica[i][j] = value;
            }
        }
    }

    public boolean[][] getTablica()
    {
        return tablica;
    }

    public void setTablica(boolean[][] tablica)
    {
        this.tablica = tablica;
    }

    public void setTablica(int x, int y, boolean value)
    {
        this.tablica[x][y] = value;
    }

    public boolean isAlive(int x, int y)
    {
        return tablica[x][y];
    }

    public int neigtboursCount(int x, int y)
    {
        int result = 0;
        if (x == 0)
        {
            if (y == 0)
            {
                if (isAlive(x, y + 1))
                {
                    result++;   //Lewy górny róg
                }
                if (isAlive(x + 1, y + 1))
                {
                    result++;
                }
                if (isAlive(x + 1, y))
                {
                    result++;
                }
            }
            else
            {
                if (y == tablica_length)
                {
                    if (isAlive(x, y - 1))
                    {
                        result++; //Prawy górny róg
                    }
                    if (isAlive(x + 1, y))
                    {
                        result++;
                    }
                    if (isAlive(x + 1, y - 1))
                    {
                        result++;
                    }
                }
                else
                {
                    if (isAlive(x, y - 1))
                    {
                        result++; //Górna krawędź
                    }
                    if (isAlive(x, y + 1))
                    {
                        result++;
                    }
                    if (isAlive(x + 1, y - 1))
                    {
                        result++;
                    }
                    if (isAlive(x + 1, y))
                    {
                        result++;
                    }
                    if (isAlive(x + 1, y + 1))
                    {
                        result++;
                    }
                }
            }
        }
        else
        {
            if (x == tablica_length)   //Wszystkie przypadki dolnej krawędzi 
            {
                if (y == 0)
                {
                    if (isAlive(x - 1, y))
                    {
                        result++; //Lewy dolny róg
                    }
                    if (isAlive(x - 1, y + 1))
                    {
                        result++;
                    }
                    if (isAlive(x, y + 1))
                    {
                        result++;
                    }
                }
                else
                {
                    if (y == tablica_length)
                    {
                        if (isAlive(x, y - 1))
                        {
                            result++; //Prawy dolny róg
                        }
                        if (isAlive(x - 1, y - 1))
                        {
                            result++;
                        }
                        if (isAlive(x - 1, y))
                        {
                            result++;
                        }
                    }
                }
                if (isAlive(x - 1, y - 1))
                {
                    result++; //Cała dolna krawędź
                }
                if (isAlive(x - 1, y))
                {
                    result++;
                }
                if (isAlive(x - 1, y + 1))
                {
                    result++;
                }
                if (isAlive(x, y - 1))
                {
                    result++;
                }
                if (isAlive(x, y + 1))
                {
                    result++;
                }

            }
            else
            {
                if (y != tablica_length && y != 0)
                {
                    if (isAlive(x - 1, y - 1))
                    {
                        result++;
                    }
                    if (isAlive(x - 1, y))
                    {
                        result++;
                    }
                    if (isAlive(x - 1, y + 1))
                    {
                        result++;
                    }
                    if (isAlive(x, y - 1))
                    {
                        result++;
                    }
                    if (isAlive(x, y + 1))
                    {
                        result++;
                    }
                    if (isAlive(x + 1, y - 1))
                    {
                        result++;
                    }
                    if (isAlive(x + 1, y))
                    {
                        result++;
                    }
                    if (isAlive(x + 1, y + 1))
                    {
                        result++;
                    }
                }
                else
                {
                    if (y == 0)
                    {
                        if (isAlive(x - 1, y))
                        {
                            result++;
                        }
                        if (isAlive(x - 1, y + 1))
                        {
                            result++;
                        }
                        if (isAlive(x, y + 1))
                        {
                            result++;
                        }
                        if (isAlive(x + 1, y))
                        {
                            result++;
                        }
                        if (isAlive(x + 1, y + 1))
                        {
                            result++;
                        }
                    }
                    else
                    {
                        if (y == tablica_length)
                        {
                            if (isAlive(x - 1, y))
                            {
                                result++;
                            }
                            if (isAlive(x - 1, y - 1))
                            {
                                result++;
                            }
                            if (isAlive(x, y - 1))
                            {
                                result++;
                            }
                            if (isAlive(x + 1, y))
                            {
                                result++;
                            }
                            if (isAlive(x + 1, y - 1))
                            {
                                result++;
                            }
                        }
                    }
                }
            }
        }
        return result;
    }

    public int getTablica_length()
    {
        return tablica_length;
    }

    @Override
    public Object clone() throws CloneNotSupportedException
    {
        return super.clone();
    }
}
