import java.awt.Color;
/**
 * Gives image a blue tint
 * 
 * @author Robert James Tallafer
 * @version 1.0
 */
public class BlueTint extends Filter
{
    /**
     * Constructor for objects of class BlueTint.
     * @param name The name of the filter.
     */
    public BlueTint(String name)
    {
        super(name);
    }

    /**
     * Apply this filter to an image.
     * 
     * @param  image  The image to be changed by this filter.
     */
    public void apply(OFImage image)
    {
        int height = image.getHeight();
        int width = image.getWidth();
        
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                int pixel = image.getRGB(x,y);
                Color color = new Color(pixel, true);
                int red = color.getRed();
                int green = color.getGreen();
                int blue = color.getBlue();
                
                if(blue+40<=255){
                    blue += 40;
                }
                
                Color bluer = new Color(red, green, blue);
                
                image.setRGB(x,y,bluer.getRGB());
            }
        }
    }
}