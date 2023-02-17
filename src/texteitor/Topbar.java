package texteitor;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Topbar extends JFrame  {
    JMenuBar mb;

    public Topbar(){

        JMenuBar mb=new JMenuBar();
        JMenu m1=new JMenu("File");
        JMenuItem item4=new JMenuItem("open");
        JMenuItem item5=new JMenuItem("save");
        JMenuItem item6=new JMenuItem("print");
//        item4.addActionListener(this );
//        item5.addActionListener(this );
//        item6.addActionListener(this );
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                System.out.println("hwello");
//
//            }

        m1.add(item4);
        m1.add(item5);
        m1.add(item6);
        mb.add(m1);
        JMenu m2=new JMenu("Edit");
        JMenuItem item1=new JMenuItem("cut");
        JMenuItem item2=new JMenuItem("copy");
        JMenuItem item3=new JMenuItem("paste");
//        item1.addActionListener(this );
//        item2.addActionListener(this );
//        item3.addActionListener(this );

        m2.add(item1);
        m2.add(item2);
        m2.add(item3);
        mb.add(m2);
        this.setSize(800,400);
        this.setJMenuBar(mb);
        this.setVisible(true);

    }


}
