package texteitor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame implements ActionListener {
    TextEditor tE;
    Topbar bar;
    public Main(){


        TextEditor tE = new TextEditor();
        Topbar bar = new Topbar();
        tE.add(bar);
        this.add(tE);

        this.setVisible(true);
    }



    public static void main(String[] args) {

       new Main();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s=e.getActionCommand();
        if(s.equals("cut")){
            tE.textArea.cut();

        }
    }
}
