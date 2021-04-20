import java.awt.Color;
/**
 * Quarter size image plus Red, Green and Blue tinted images
 * 
 * @author Robert James Tallafer
 * @version 1.0
 */
public class Warhol extends Filter
{
    /**
     * Constructor for objects of class RedTint.
     * @param name The name of the filter.
     */
    public Warhol(String name)
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
        OFImage redImage = image;
        OFImage blueImage = image;
        OFImage greenImage = image;
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                Color pixel = image.getPixel(x, y);
                image.setPixel(x/4,y/4,pixel);
            }
        }
        
        for(int y = 0; y < height/4; y++) {
            for(int x = 0; x < width/4; x++) {
                Color col = redImage.getPixel(x,y);
                int pixel = redImage.getRGB(x,y);
                redImage.setPixel(x+(width/4),y,col);
                Color color = new Color(pixel, true);
                int red = color.getRed();
                int green = color.getGreen();
                int blue = color.getBlue();
                
                if(red+40<=255){
                    red += 40;
                }
                
                Color redder = new Color(red, green, blue);
                
                redImage.setRGB(x+(width/4),y,redder.getRGB());
            }
        }
        for(int y = 0; y < height/4; y++) {
            for(int x = 0; x < width/4; x++) {
                Color col = greenImage.getPixel(x,y);
                greenImage.setPixel(x,y+(height/4),col);
                int pixel = greenImage.getRGB(x,y);
                Color color = new Color(pixel, true);
                int red = color.getRed();
                int green = color.getGreen();
                int blue = color.getBlue();
                
                if(green+40<=255){
                    green += 40;
                }
                
                Color greener = new Color(red, green, blue);
                
                greenImage.setRGB(x,y+(height/4),greener.getRGB());
            }
        }
        for(int y = 0; y < height/4; y++) {
            for(int x = 0; x < width/4; x++) {
                Color col = blueImage.getPixel(x,y);
                blueImage.setPixel(x+(width/4),y+(height/4),col);
                int pixel = blueImage.getRGB(x,y);
                Color color = new Color(pixel, true);
                int red = color.getRed();
                int green = color.getGreen();
                int blue = color.getBlue();
                
                if(blue+40<=255){
                    blue += 40;
                }
                
                Color bluer = new Color(red, green, blue);
                
                blueImage.setRGB(x+(width/4),y+(height/4),bluer.getRGB());
            }
        }
        
    }
}