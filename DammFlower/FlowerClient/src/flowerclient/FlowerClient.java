/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flowerclient;

import java.awt.Image;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.flower.service.FlowerService;
import org.flower.service.FlowerService_Service;
import org.flower.service.IOException;

/**
 *
 * @author STD-PC
 */
public class FlowerClient {

       private static int downloadedPictures;
    
     public static void main(String[] args) {
    
        final Map<String,Image> flowers = new HashMap<String,Image>(4);
        final Map<String,Image> thumbs = new HashMap<String,Image>(4);
        
        // Show the FlowerFrame.
        final FlowerFrame frame = new FlowerFrame(flowers);
        frame.setVisible(true);
        
        // The client connects to the service with this code.
        FlowerService_Service service = new FlowerService_Service();
        final FlowerService port = service.getFlowerServicePort();
        
        Runnable[] tasks = new Runnable[4];
        
        // The web service getFlower operation
        // is called 4 times, each in a separate thread.
        // When the operation finishes the picture is shown in
        // a specific button.
        for (int i=0; i<4;i++) {
            final int index = i;
            tasks[i] = new Runnable() {
                public void run() {
                    try {
                    
                        // Call the getFlower operation
                        // on the web service:
                        Image img = port.getFlower(FlowerFrame.FLOWERS[index]);
                        System.out.println("picture downloaded: "+FlowerFrame.FLOWERS[index]);
                        
                        // Add strings to the hashmap:
                        flowers.put(FlowerFrame.FLOWERS[index],img);
                        
                        // Call the showFlower operation
                        // on the FlowerFrame:
                        frame.showFlower();
                        
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    downloadedPictures++;
                }
            };
            new Thread(tasks[i]).start();
        }
        // The web service getThumbnails operation is called
        // in a separate thread, just after the previous four threads finish.
        // When the images are downloaded, the thumbnails are shown at 
        // the bottom of the frame.
        Runnable thumbsTask = new Runnable() {
            public void run() {
                try {
                    while (downloadedPictures < 4) {                        
                        try {Thread.sleep(100);} catch (InterruptedException ex) {}
                    }
                    
                    // Call the getThumbnails operation
                    // on the web service:
                    List<Image> images = port.getThumbnails();
                    System.out.println("thumbs downloaded");
                    
                    if (images != null && images.size() == 4) {
                        for (int i=0;i<4;i++) {
                            thumbs.put(FlowerFrame.FLOWERS[i],images.get(i));
                        }
                        frame.setThumbnails(thumbs);
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }            
        };
        new Thread(thumbsTask).start();
    }

}
