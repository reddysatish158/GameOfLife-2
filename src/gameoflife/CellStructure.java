

package gameoflife;

public class CellStructure
{
    private int x, y;
    private boolean value;
    public CellStructure(int x, int y, boolean value)
    {
        this.x = x;
        this.y = y;
        this.value = value;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public boolean isValue()
    {
        return value;
    }
    
    
    
}
