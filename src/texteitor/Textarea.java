package texteitor;

import javax.swing.*;
import java.awt.*;

public class Textarea extends JTextArea{




    Textarea(){


        this.setText("asdafwef");
        this.setLineWrap(true);
        this.setWrapStyleWord(true);
        this.setFont(new Font("copperplate",Font.PLAIN,20));
        JScrollPane scrollPane=new JScrollPane(this);
        scrollPane.setPreferredSize(new Dimension(750,350));
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);


    }
}
