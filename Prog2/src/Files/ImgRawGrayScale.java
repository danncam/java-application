package Files;
public class ImgRawGrayScale {
    
    
    private int wid, hei;
    private int [] dat;
    /*
     *  
     */

    public ImgRawGrayScale(int wid, int hei) 
    {
        this.wid = wid;
        this.hei = hei;
        this.dat = new int[wid * hei];
    }
    
    public int getIndex(int wid, int hei)
    {
        
        return getRow() * wid + getColumn();
    }

    private int getRow() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private int getColumn() {
        throw new UnsupportedOperationException("Not yet implemented");
    }
    
    public void save(String filename){
        
    }
    public void print()
    {
        
    }
}

