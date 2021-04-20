import java.awt.Color;
/**
 * Converts the image into grayscale where the white represents blue
 * 
 * @author Robert James Tallafer
 * @version 1.0
 */
public class BlueFilter extends Filter
{
    /**
     * Constructor for objects of class Blue Filter.
     * @param name The name of the filter.
     */
    public BlueFilter(String name)
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
        Color white = new Color (255,255,255);
        Color gray = new Color (100,100,100);
        Color grayer = new Color (50,50,50);
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                Color pixel = image.getPixel(x, y);
                int blue = (pixel.getBlue());
                if(blue >= 180) {
                    image.setPixel(x, y, Color.white);
                }
                else if(blue >= 90) {
                    image.setPixel(x, y, Color.gray);
                }
                else if(blue >= 40) {
                    image.setPixel(x, y, grayer);
                }
                else if(blue == 0) {
                    image.setPixel(x, y, Color.BLACK);
                }
            }
        }
    }
}

