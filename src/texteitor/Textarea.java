package texteitor;

import javax.swing.*;
import java.awt.*;

public class Textarea extends JTextArea{

    Textarea(){

        this.setLineWrap(true);
        this.setWrapStyleWord(true);
        this.setFont(new Font("copperplate",Font.PLAIN,20));



    }

}
