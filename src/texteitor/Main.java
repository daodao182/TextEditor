package texteitor;

public class Main {
    TextEditor textEditor;
    Topbar topbar;

    public Main(TextEditor textEditor,Topbar topbar) {
        this.textEditor = textEditor;
        this.topbar=topbar;
        textEditor.setJMenuBar(topbar);
    }

    public static void main(String[] args) {
//        new TextEditor();
        new Main(new TextEditor(),new Topbar());
    }


}


