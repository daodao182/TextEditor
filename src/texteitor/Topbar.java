package texteitor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Topbar extends JMenuBar implements ActionListener{

    private JMenu m1,m2;
    private JMenuItem item1,item2,item3,item4,item5,item6,item7,item8,item9;


    Topbar(){

        m1=new JMenu("File");
        item4=new JMenuItem("open");
        item5=new JMenuItem("save");
        item6=new JMenuItem("print");
        item8=new JMenuItem("exit");
        item4.addActionListener((ActionListener) this);
        item5.addActionListener((ActionListener) this);
        item6.addActionListener((ActionListener) this);
        item8.addActionListener((ActionListener) this);
        m1.add(item4);
        m1.add(item5);
        m1.add(item6);
        m1.add(item8);
        this.add(m1);
        m2=new JMenu("Edit");
        item1=new JMenuItem("cut");
        item2=new JMenuItem("copy");
        item3=new JMenuItem("paste");
        item7=new JMenuItem("highlight");
        item9=new JMenuItem("search");
        item1.addActionListener((ActionListener) this);
        item2.addActionListener((ActionListener) this);
        item3.addActionListener(this );
        item7.addActionListener(this);
        item9.addActionListener(this);
        m2.add(item1);
        m2.add(item2);
        m2.add(item3);
        m2.add(item7);
        m2.add(item9);
        this.add(m2);



    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==item8){
            System.exit(0);
        }
    }
}
