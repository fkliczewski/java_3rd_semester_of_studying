import java.io.IOException;

public class main {
    public static void main(String[] args) throws IOException {
        //tu prosze podać słowo do znalezienia
        String text = "kajak";
        OgarniaczPlikow.zapiszDoPlikuTekst(text, "wejscie.dat");
        Huffman.createTree();
    }
}
