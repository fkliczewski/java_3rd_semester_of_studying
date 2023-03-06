import java.util.ArrayList;
import java.util.List;

//tutaj jest moja kolejka zrobiona na podstawie array listy
public class MojaKolejka{
    List<Wezel> list = new ArrayList<>();

    public MojaKolejka(List<Wezel> list) {
        this.list = list;
    }
    public MojaKolejka(){}

    public List<Wezel> get() {
        return list;
    }
    public void sort(){
        for (int i=list.size(); i>=0;i--) {
            try {
                if (list.get(i).getNumber() > list.get(2 * i + 1).getNumber()) {
                    Wezel temp = list.get(i);
                    list.set(i, list.get(2 * i + 1));
                    list.set(2 * i + 1, temp);
                } else if (list.get(i).getNumber() > list.get(2 * i + 2).getNumber()) {
                    Wezel temp = list.get(i);
                    list.set(i, list.get(2 * i + 2));
                    list.set(2 * i + 2, temp);
                }
            }
            catch (IndexOutOfBoundsException ex){

            }
        }
    }
    public Wezel wyciagnijNajwyzszy(){
        Wezel najw = list.get(0);
        Wezel temp = list.remove(list.size()-1);
        if(list.size()>0){
            list.set(0, temp);
        }
        sort();
        return najw;
    }
}
