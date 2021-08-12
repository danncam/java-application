package Java;

/**
 *
 * @author Dan
 */
public class ColorConvertToCMYK {
    
    /*
     * 
     * R = 0, G = 0, B = 0
     * CMYK = 0001
     */    
    public static void main(String[] args) {
        
        float[] inputRGB = convertToCMYK(12, 255, 3);
        if(inputRGB != null)
        {
            System.out.println(toString(inputRGB));
            
        }
        else {
            System.out.println("RBG não está entre 0 e 255");
        }
        
    }
    public static float[] convertToCMYK(int r, int g, int b)
    {
        boolean isInside;
        isInside = 
                ((r >= 0 || r <= 255) &&
                (g >= 0 || g <= 255) &&
                (b >= 0 || b <= 255));
        
        if(isInside)
        {
            float[] output = new float[4];
            
            if(r == 0 && g == 0 && b == 0)
            {
                
                output[3] = 1f;
                
            }
            else
            {
                float w = max(r/255.0f, g/255.0f, b/255f);
                System.out.println(w);
                output[0] = (w - (r/255f)) / w;
                output[1] = (w - (g/255f)) / w;
                output[2] = (w - (b/255f)) / w;
                output[3] = 1f - w;
            }
            return output;
        }
        else {
            return null;
        }
        
    }

    public static String toString(float[] c)
    {
        String out = "[";
        for (int i = 0; i < c.length; i++) {
            out += c[i] + " ";
        }
        out+="]";
        return out;
    }
    private static float max(float one, float two, float three)
    {
        if(one >= two && one >= three) {
            return one;
        }
        else{
            if(two >= three ) {
                return two;
            } else{
                return three;
            }
        }
    }
}



