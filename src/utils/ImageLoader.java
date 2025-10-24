package utils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ImageLoader {

    public static BufferedImage load(String path) {
        try {
            
            return ImageIO.read(ImageLoader.class.getResource(path));
         
        } 
        
        
        catch (IOException | IllegalArgumentException e) {
        	
            System.err.println("❌ Không tìm thấy ảnh: " + path);
            e.printStackTrace();
            return null;
        }
    }
}
