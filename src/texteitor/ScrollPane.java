package texteitor;

import javax.swing.*;
import java.awt.*;

public class ScrollPane extends JScrollPane {
    private JTextArea area;

    ScrollPane(JTextArea area){

        area.setLineWrap(true);
        area.setWrapStyleWord(true);
        area.setFont(new Font("copperplate",Font.PLAIN,220));
        this.area=area;
        this.setPreferredSize(new Dimension(750,350));
        this.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

   }



}
