package texteitor;

import javax.swing.*;
import java.awt.*;

public class Main {

    TextEditor textEditor;
    Topbar topbar;
    ScrollPane pane;


    public Main(TextEditor textEditor,Topbar topbar,ScrollPane pane) {
        this.textEditor = textEditor;
        this.topbar=topbar;
        this.pane=pane;

        textEditor.add(pane);
        textEditor.setJMenuBar(topbar);
        textEditor.setVisible(true);
    }


    public static void main(String[] args) {
//        new TextEditor();

        new Main(new TextEditor(),new Topbar(),new ScrollPane(new JTextArea()));

    }


}


