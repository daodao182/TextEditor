package texteitor;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.Scanner;


public class Topbar extends JMenuBar implements ActionListener {
    private TextEditor editor;

    private JTextArea area;
    private JMenu m1, m2;
    private JMenuItem item1, item2, item3, item4, item5, item6, item7, item8, item9;


    Topbar(TextEditor editor,Textarea area) {
        this.editor = editor;
        this.area=area;

        JScrollPane scrollPane=new JScrollPane(this.area);
        scrollPane.setPreferredSize(new Dimension(750,350));
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        m1 = new JMenu("File");
        item4 = new JMenuItem("open");
        item5 = new JMenuItem("save");
        item6 = new JMenuItem("print");
        item8 = new JMenuItem("exit");
        item4.addActionListener((ActionListener) this);
        item5.addActionListener((ActionListener) this);
        item6.addActionListener((ActionListener) this);
        item8.addActionListener((ActionListener) this);
        m1.add(item4);
        m1.add(item5);
        m1.add(item6);
        m1.add(item8);
        this.add(m1);
        m2 = new JMenu("Edit");
        item1 = new JMenuItem("cut");
        item2 = new JMenuItem("copy");
        item3 = new JMenuItem("paste");
        item7 = new JMenuItem("highlight");
        item9 = new JMenuItem("search");
        item1.addActionListener((ActionListener) this);
        item2.addActionListener((ActionListener) this);
        item3.addActionListener(this);
        item7.addActionListener(this);
        item9.addActionListener(this);
        m2.add(item1);
        m2.add(item2);
        m2.add(item3);
        m2.add(item7);
        m2.add(item9);
        this.add(m2);
        this.editor.setJMenuBar(this);
        this.editor.add(scrollPane);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == item1) {
            area.cut();
        } else if (e.getSource() == item2){
            area.copy();
        } else if (e.getSource() == item3) {
            area.paste();
        } else if (e.getSource() == item4) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File("."));
            FileNameExtensionFilter filter = new FileNameExtensionFilter("text file", "txt");
            fileChooser.setFileFilter(filter);
            int response = fileChooser.showOpenDialog(null);
            if (response == JFileChooser.APPROVE_OPTION) {
                File file;
                file = new File(fileChooser.getSelectedFile().getPath());
                Scanner fillIn = null;
                try {
                    fillIn = new Scanner(file);
                    if (file.isFile()) {
                        while (fillIn.hasNextLine()) {
                            String line = fillIn.nextLine() + "\n";
                            area.append(line);
                        }

                    }
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                } finally {
                    fillIn.close();
                }
            }
        } else if (e.getSource() == item5) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File("."));
            int response = fileChooser.showSaveDialog(null);
            if (response == JFileChooser.APPROVE_OPTION) {
                File file;
                PrintWriter writer = null;
                file = new File(fileChooser.getSelectedFile().getPath());
                try {
                    writer = new PrintWriter(file);
                    writer.println(area.getText());
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                } finally {
                    writer.close();
                }

            }

        } else if (e.getSource() == item6){
            try {
                area.print();
            } catch (PrinterException ex) {
                ex.printStackTrace();
            }
        } else if(e.getSource()==item7){

            Highlighter highlighter=area.getHighlighter();
            Highlighter.HighlightPainter painter=new DefaultHighlighter.DefaultHighlightPainter(Color.pink);
            highlighter.removeAllHighlights();
            String text=area.getText();
            String field=area.getSelectedText();
            try {
                int start=text.indexOf(field);
                int end=start+field.length();
                highlighter.addHighlight(start, end, painter);
            } catch (BadLocationException ex) {
                ex.printStackTrace();
            }

        } else if(e.getSource()==item8) {
            System.exit(0);
        } else if(e.getSource()==item9){
            String search = JOptionPane.showInputDialog("Find What?");
            Highlighter.HighlightPainter painter = new DefaultHighlighter.DefaultHighlightPainter(Color.orange);
            int a=area.getText().toLowerCase(Locale.ROOT).indexOf(search);
            int b= a+search.length();
            area.getHighlighter().removeAllHighlights();
            try {
                area.getHighlighter().addHighlight(a,b,painter);
            } catch (BadLocationException ex) {
                ex.printStackTrace();
            }

        }
    }
}
