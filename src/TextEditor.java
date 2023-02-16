import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextEditor extends JFrame implements ActionListener {


    public TextEditor(){
        this.setTitle("baobao's editor");
        this.setBackground(Color.blue);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800,400);
        this.setLayout(new FlowLayout());
        this.setLocationRelativeTo(null);

        JMenuBar mb=new JMenuBar();
        JMenu m1=new JMenu("Edit");
        mb.add(m1);
        this.setJMenuBar(mb);

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
    public static void main(String[] args) {
        new TextEditor();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}


