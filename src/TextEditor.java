import javax.swing.*;
import java.awt.*;

public class TextEditor extends JFrame {


    public static void main(String[] args) {
        JFrame f=new JFrame("Editor");
        JMenuBar mb=new JMenuBar();
        JMenu m1=new JMenu("Edit");
        JMenu m2=new JMenu("Close");
        mb.add(m1);
        mb.add(m2);

        JPanel p=new JPanel();
        p.setBackground(Color.pink);
        p.add(mb);
        f.add(p);
        f.setSize(400,400);
        f.setJMenuBar(mb);
        f.setVisible(true);
    }

}


