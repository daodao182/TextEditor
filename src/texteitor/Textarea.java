package texteitor;

import javax.swing.*;
import java.awt.*;

public class Textarea extends TextEditor{
    JTextArea textArea;



    Textarea(){

        textArea=new JTextArea();
        textArea.setText("asdafwef");
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setFont(new Font("copperplate",Font.PLAIN,20));


    }
}
