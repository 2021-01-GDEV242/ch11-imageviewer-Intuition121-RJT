import java.awt.Color;
/**
 * Converts the image into grayscale where the white represents green
 * 
 * @author Robert James Tallafer
 * @version 1.0
 */
public class GreenFilter extends Filter
{
    /**
     * Constructor for objects of class Green Filter.
     * @param name The name of the filter.
     */
    public GreenFilter(String name)
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
                int green = (pixel.getGreen());
                if(green >= 180) {
                    image.setPixel(x, y, Color.white);
                }
                else if(green >= 90) {
                    image.setPixel(x, y, Color.gray);
                }
                else if(green >= 40) {
                    image.setPixel(x, y, grayer);
                }
                else if(green == 0) {
                    image.setPixel(x, y, Color.BLACK);
                }
            }
        }
    }
}

