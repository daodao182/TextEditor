package texteitor;


import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        TextEditor editor=new TextEditor();
        Textarea area=new Textarea();
        Topbar bar=new Topbar(editor,area);
        editor.setVisible(true);
    }

}


