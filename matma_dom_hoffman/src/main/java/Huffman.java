import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Huffman{
    public static void createTree() throws IOException {
        String text = OgarniaczPlikow.odczytajZPliku("wejscie.dat");

        if(text == null || text.length()==0){
            return;
        }
        HashMap<Character, Integer> characters = new HashMap<>();
        String kolejnosc = "";
        //pobieramy ile jest znaków w konkretnym słowie i dajemy to do hashmapy
        for (char character: text.toCharArray()) {
            if(!characters.containsKey(character)){
                characters.put(character, 1);
                kolejnosc += character;
            }
            else{
                characters.put(character, characters.get(character)+1);
            }
        }
        //zrobiłem swoją "kolejke" bo nie wiem jak działa ta w javie
        MojaKolejka kolejka = new MojaKolejka();

        //wstawiam wszystkie znaki do kolejki, tylko zapisane jako węzły (by moc potem im dodac dzieci/rodziców)
        for (char e: kolejnosc.toCharArray())
        {
            kolejka.get().add(new Wezel(characters.get(e), e));
        }
        //sortuje na start by było dobrze jak zaczniemy
        kolejka.sort();


        //pobieram rozmiar by wiedziec ile razy to powtorzyc, i potem tworze nowy "nadrzędny" węzeł itd itd, az dotre do korzenia
        int kolejkaSize = kolejka.get().size();
        for(int i=0; i<kolejkaSize-1;i++){
            Wezel left = kolejka.wyciagnijNajwyzszy();
            Wezel right = kolejka.wyciagnijNajwyzszy();
            int suma = left.getNumber() + right.getNumber();
            kolejka.get().add(new Wezel(suma, null, left, right));
            kolejka.sort();
        }

        //wyciągam korzen by moc po nim potem odczytac kod dla każdego znaku
        Wezel korzen = kolejka.get().get(0);

        HashMap<Character, String> mapaKodow = new HashMap<>();

        //pętla wraz z 2 metodami rekurencyjnymi służy do utworzenia kodu dla każdej litery
        for (var c:characters.keySet()) {
            Wezel temp = korzen;
            String kod = "";
                kod=sprawdzLewy(temp, c, kod);
            if(kod==null) {
                kod="";
                kod=sprawdzPrawy(temp, c, kod);
            }
            mapaKodow.put(c, kod);
        }

        String codedMessage = "";

        //zmiana tekstu na zakodowany
        for (char c:text.toCharArray()) {
            codedMessage = codedMessage + mapaKodow.get(c);
        }

        //wypisanie obu tekstów
        System.out.println("Wiadomość: "+ text);

        System.out.println("Wiadomość po zakodowaniu: "+ codedMessage);

        //zapis wiadomości do pliku
        OgarniaczPlikow.zapiszDoPlikuBinarnie(codedMessage, "wyjscie.dat");



    }
    public static String sprawdzLewy(Wezel wezel, Character c, String kod){
        if(wezel.getLeft()!=null){
            kod = kod + "0";

            if(wezel.getLeft().getName()!=null && wezel.getLeft().getName()==c){
                return kod;
            }
            else{
                if(sprawdzLewy(wezel.getLeft(), c, kod)!=null) return sprawdzLewy(wezel.getLeft(), c, kod);
                if(sprawdzPrawy(wezel.getLeft(), c, kod)!=null) return sprawdzPrawy(wezel.getLeft(), c, kod);
            }
        }
        return null;

    }
    public static String sprawdzPrawy(Wezel wezel, Character c, String kod){
        if(wezel.getRight()!=null){
            kod = kod + "1";
            if(wezel.getRight().getName()!= null && wezel.getRight().getName()==c){
                return kod;
            }
            else{
                if(sprawdzLewy(wezel.getRight(), c, kod)!=null) return sprawdzLewy(wezel.getRight(), c, kod);
                if(sprawdzPrawy(wezel.getRight(), c, kod)!=null) return sprawdzPrawy(wezel.getRight(), c, kod);
            }
        }
        return null;

    }
}
