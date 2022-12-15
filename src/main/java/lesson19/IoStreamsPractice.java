package lesson19;

import java.io.*;

public class IoStreamsPractice {

    public static void main(String[] args) {
        /*InputStream stream = new BufferedInputStream();

        InputStreamReader isr = new InputStreamReader(stream)*/

      /*  try (OutputStreamWriter isw = new OutputStreamWriter(new PrintStream())) {

        }*/


       /* FileReader rd = new FileReader("A");

        FileWriter fr = new FileWriter("B");
        fr.write(rd.read());*/

        InputStreamReader isr = new InputStreamReader(System.in);
        OutputStreamWriter osr = new OutputStreamWriter(System.out);

        try {
            System.out.println(isr.read());
            osr.write(97);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


     /*   BufferedInputStream fis = new BufferedInputStream(System.in, 20);
        BufferedOutputStream fos = new BufferedOutputStream(System.out, 10);

        try {
            fos.write(fis.readAllBytes());
            //fsfos.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
*/
        /*DataInputStream dis = new DataInputStream();
        dis.

        fos.write(fis.readAllBytes());*/
    }
}
