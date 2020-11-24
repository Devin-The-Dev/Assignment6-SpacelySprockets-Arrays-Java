package assignment6devinudy;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Assignment6DevinUdy
{

    public static void main(String[] args)
    {

        int sNum, quantity, i;
        int partNumber[];
        InputFile sprocketorders;
        
        partNumber = new int[50];
        sprocketorders = new InputFile("NovemberOrders.txt");
        i = 0;

//        Window Pane
        
        JFrame jf;
        JTextArea jta;
        JScrollPane jsp;

        //the following instantiates the two objects
        jf = new JFrame();
        jta = new JTextArea();
        // now the text area is sent to the scroll pane
        jsp = new JScrollPane(jta);

        // change the size and position of the window
        jf.setSize(300, 550);
        jf.setLocation(400, 250);

        //make the X box of the window stop the program
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // add the scroll pane to the JFrame instead of the text area
        jf.add(jsp);

        jf.setVisible(true);

//        End Window pane details
        
        jta.append("SPACELY SPROCKETS\n");
        jta.append("Taking Sprockets into the future\n");
        jta.append("\n");
        jta.append("Sales Summary Report\n");
        jta.append("\n");
        jta.append("Sprocket Number   |   Total Quantity Sold\n");
        jta.append("_______________________________________\n");

        while (!sprocketorders.eof())
        {

            sNum = sprocketorders.readInt();
            quantity = sprocketorders.readInt();

            partNumber[sNum - 1] += quantity;
        }
        
        while (i < 50) {
            jta.append("Part " + (i + 1) + ":\t\t" + partNumber[i] + "\n");
            jta.append("----------------------------------" + "\n");
            i++;
        }
    }

}
