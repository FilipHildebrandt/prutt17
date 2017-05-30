/**
 * Created by user on 2017-05-19.
 */
import javax.swing.text.BadLocationException;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTMLDocument;
import java.io.*;
import java.net.*;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.AttributeSet;

public class Links {

    public String[][] getLinks(String url) {
        String[][] mat = new String[50][2];

        HTMLDocument doc = new HTMLDocument();

        try {
            //String webpage = "http://www.nada.kth.se/~henrik";
            InputStream in = new URL(url).openConnection().getInputStream();
            InputStreamReader reader = new InputStreamReader(in);
            while (reader.ready()) {
                doc.putProperty("IgnoreCharsetDirective", Boolean.TRUE);
                new HTMLEditorKit().read(reader, doc, 0);
            }

        } catch (MalformedURLException e) {
            System.out.println("Bad url");
        } catch (IOException e) {
            System.out.println(e.toString());
        } catch (BadLocationException e) {
            System.out.println(e.toString());
        }
        int count = 0;
        for (HTMLDocument.Iterator iterator = doc.getIterator(HTML.Tag.A); iterator
                .isValid(); iterator.next()) {
            AttributeSet attributes = iterator.getAttributes();
            String srcString = (String) attributes.getAttribute(HTML.Attribute.HREF);

            if (count == 49){
                break;
            }

            try {
                String val = doc.getText(iterator.getStartOffset(), iterator.getEndOffset() - iterator.getStartOffset());

                mat[count][0] = srcString;
                mat[count][1] = val;

            } catch (BadLocationException e) {
                System.out.println("hej");
            }
            count ++;
        }

        return mat;
    }


    public static void main(String[] args) {

        Links l = new Links();
        System.out.println(l.getLinks("http://www.nada.kth.se/~snilsson"));

    }
}
