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

public class TextEditor extends JFrame implements ActionListener {
    JTextArea textArea;
    JMenuBar mb;
    JMenu m1,m2;
    JMenuItem item1,item2,item3,item4,item5,item6,item7,item8,item9;



    public TextEditor(){
        this.setTitle("baobao's editor");
        this.setBackground(Color.blue);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800,400);
        this.setLayout(new FlowLayout());


        textArea=new JTextArea();
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setFont(new Font("copperplate",Font.PLAIN,20));

        JScrollPane scrollPane=new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(750,350));
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        this.add(scrollPane);

        mb=new JMenuBar();
        m1=new JMenu("File");
        item4=new JMenuItem("open");
        item5=new JMenuItem("save");
        item6=new JMenuItem("print");
        item8=new JMenuItem("exit");
        item4.addActionListener(this );
        item5.addActionListener(this );
        item6.addActionListener(this );
        item8.addActionListener(this );
        m1.add(item4);
        m1.add(item5);
        m1.add(item6);
        m1.add(item8);
        mb.add(m1);
        m2=new JMenu("Edit");
        item1=new JMenuItem("cut");
        item2=new JMenuItem("copy");
        item3=new JMenuItem("paste");
        item7=new JMenuItem("highlight");
        item9=new JMenuItem("search");
        item1.addActionListener(this);
        item2.addActionListener(this);
        item3.addActionListener(this);
        item7.addActionListener(this);
        item9.addActionListener(this);
        m2.add(item1);
        m2.add(item2);
        m2.add(item3);
        m2.add(item7);
        m2.add(item9);
        mb.add(m2);

        this.setJMenuBar(mb);

        this.setVisible(true);

    }




    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==item1){
            textArea.cut();
        }else if(e.getSource()==item2){
            textArea.copy();
        }else if(e.getSource()==item3){
            textArea.paste();
        }else if(e.getSource()==item4){
            JFileChooser fileChooser=new JFileChooser();
            fileChooser.setCurrentDirectory(new File("."));
            FileNameExtensionFilter filter=new FileNameExtensionFilter("text file","txt");
            fileChooser.setFileFilter(filter);
            int response=fileChooser.showOpenDialog(null);
            if (response==JFileChooser.APPROVE_OPTION){
                File file;
                file=new File(fileChooser.getSelectedFile().getPath());
                Scanner fillIn=null;
                try {
                    fillIn =new Scanner(file);
                    if (file.isFile()){
                        while (fillIn.hasNextLine()){
                            String line=fillIn.nextLine()+"\n";
                            textArea.append(line);
                        }

                    }
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
                finally {
                    fillIn.close();
                }
            }
        }
        else if(e.getSource()==item5){
            JFileChooser fileChooser=new JFileChooser();
            fileChooser.setCurrentDirectory(new File("."));
            int response=fileChooser.showSaveDialog(null);
            if(response==JFileChooser.APPROVE_OPTION){
                File file;
                PrintWriter writer=null;
                file=new File(fileChooser.getSelectedFile().getPath());
                try {
                    writer=new PrintWriter(file);
                    writer.println(textArea.getText());
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
                finally {
                    writer.close();
                }

            }
        }else if(e.getSource()==item6){
            try {
                textArea.print();
            } catch (PrinterException ex) {
                ex.printStackTrace();
            }
        }else if(e.getSource()==item7){

            Highlighter highlighter=textArea.getHighlighter();
            Highlighter.HighlightPainter painter=new DefaultHighlighter.DefaultHighlightPainter(Color.pink);
            highlighter.removeAllHighlights();
            String text=textArea.getText();
            String field=textArea.getSelectedText();
            try {
                int start=text.indexOf(field);
                int end=start+field.length();
                highlighter.addHighlight(start, end, painter);
            } catch (BadLocationException ex) {
                ex.printStackTrace();
            }



        }else if(e.getSource()==item8) {
            System.exit(0);
        }else if(e.getSource()==item9){
            String search = JOptionPane.showInputDialog("Find What?");
            Highlighter.HighlightPainter painter = new DefaultHighlighter.DefaultHighlightPainter(Color.orange);
            int a=textArea.getText().toLowerCase(Locale.ROOT).indexOf(search);
            int b= a+search.length();
            textArea.getHighlighter().removeAllHighlights();
            try {
                textArea.getHighlighter().addHighlight(a,b,painter);
            } catch (BadLocationException ex) {
                ex.printStackTrace();
            }

        }

    }
}


