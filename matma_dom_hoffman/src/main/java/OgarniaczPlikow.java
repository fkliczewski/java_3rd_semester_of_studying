import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class OgarniaczPlikow {
    public static void zapiszDoPlikuTekst(String text, String path) throws IOException {

        DataOutputStream out = null;

        try {
            out = new DataOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream(path)));

            out.writeUTF(text);
            out.flush();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        finally {
            if (out!=null) out.close();
        }

    }

    public static void zapiszDoPlikuBinarnie(String text, String path) throws IOException {

        List<Short> shorts = new ArrayList<>();
        int tem = (int) Math.ceil((double)text.length() / 5);
        if(text.length()<6) {
            Short.parseShort(text);
        }
        else{
            for (int i = 0; i<tem; i++){
                int temp = i*5+5;
                if(temp>text.length()) temp=text.length();
                shorts.add(Short.parseShort(text.substring(i*5, temp)));
            }
        }

        DataOutputStream out = null;

        try {
            out = new DataOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream(path)));

            for (short s:shorts ) {
                out.writeShort(s);
            }


            out.flush();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        finally {
            if (out!=null) out.close();
        }

    }

    public static String odczytajZPliku(String path) throws IOException {

        DataInputStream in = null;
        String str = null;
        try {
            in = new DataInputStream(
                    new BufferedInputStream(
                            new FileInputStream(path)));

            str = in.readUTF();
            //System.out.println(str);
        }
        catch (IOException e){
            e.printStackTrace();
        }
        finally {
            if (in!=null) in.close();

        }
        return str;
    }
}
