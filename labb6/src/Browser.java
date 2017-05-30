import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.html.*;
import javax.swing.text.*;
import java.awt.event.KeyEvent;
import java.util.Scanner;
import javax.swing.text.html.HTMLDocument.Iterator;
import javax.swing.table.DefaultTableModel;

/**
 * Created by user on 2017-05-18.
 */
public class Browser extends JFrame {

    JTable table;
    JScrollPane links, view;
    Webreader editor;
    JTextField text;
    HTMLDocument doc;
    Links l;
    String[][] linkMat;




    Browser(){
        l = new Links();
        doc = new HTMLDocument();
        table = new JTable(50,2);
        links = new JScrollPane(table);
        editor = new Webreader();
        view = new JScrollPane(editor);
        text = new JTextField();
        editor.setEditable(false);

        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        add(text, BorderLayout.NORTH);
        add(links, BorderLayout.EAST);
        add(view, BorderLayout.CENTER);
        setVisible(true);



        text.addKeyListener(new KeyListener() {
            @Override

            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == KeyEvent.VK_ENTER){
                    String url = text.getText();
                    openConnection(url);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        text.setFocusable(true);



    }

    private void openConnection(String url){

        String content = null;
        URLConnection connection = null;

        try {
            connection =  new URL(url).openConnection();
            InputStream in = connection.getInputStream();

            Scanner scanner = new Scanner(in);
            scanner.useDelimiter("\\Z");
            content = scanner.next();
            editor.setText(content);


        }catch ( Exception ex ) {
            dialogError();
            return;
        }


        linkMat = l.getLinks(url);
        changeTable();

    }

    private void changeTable(){
        String[] s = {"Links", "Description"};
        table.setModel(new DefaultTableModel(linkMat, s));
    }

    private void createDoc(InputStream in){

        try{
            InputStreamReader reader = new InputStreamReader(in);

            while(reader.ready()){
                System.out.println("ready");
                doc.putProperty("IgnoreCharsetDirective", Boolean.TRUE);
                new HTMLEditorKit().read(reader,doc, 0);
                readLinks();
            }
        } catch (IOException e){
            System.out.println(e.toString());
        } catch (BadLocationException e){
            System.out.println(e.toString());
        }


    }

    private void readLinks(){
        System.out.println("HEJ");
        for (HTMLDocument.Iterator iterator = doc.getIterator(HTML.Tag.A); iterator
                .isValid(); iterator.next()) {
            System.out.println("HJEJSAD");
            System.out.println(iterator.getAttributes());
        }
    }



    private void dialogError(){

        JOptionPane.showMessageDialog(this, "Invalid URL");

    }




    public static void main(String[] args) {
        Browser b = new Browser();
    }



}

