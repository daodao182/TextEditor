package texteitor;

import javax.swing.*;
import java.awt.*;

public class TextEditor extends JFrame  {
    JTextArea textArea;


    public TextEditor(){
        this.setTitle("baobao's editor");
        this.setBackground(Color.blue);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800,400);
        this.setLayout(new FlowLayout());

        JTextArea textArea=new JTextArea();
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setFont(new Font("copperplate",Font.PLAIN,220));

        JScrollPane scrollPane=new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(750,350));
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);


        this.add(scrollPane);
        this.setVisible(true);



    }




}


