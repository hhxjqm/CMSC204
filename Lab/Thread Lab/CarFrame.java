import javax.swing.JFrame;

public class CarFrame
{
   public static void main(String[] args)
   {
      JFrame frame = new JFrame();

      frame.setSize(300, 400);
      frame.setTitle("Cars");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      CarQueue carQueue = new CarQueue();
      
      CarPanel component = new CarPanel(0,0,1, carQueue);
      frame.add(component);
      frame.setVisible(true);
      
      CarPanel component1 = new CarPanel(80,100,2, carQueue);
      frame.add(component1);
      frame.setVisible(true);
      
      CarPanel component2 = new CarPanel(30,200,3, carQueue);
      frame.add(component2);
      
      frame.setVisible(true);
      carQueue.addToQueue();
      component.startAnimation();
      component1.startAnimation();
      component2.startAnimation();
   }
}