public class Wezel {
    private int number;
    private Character name;
    private Wezel left = null;
    private Wezel right = null;

    public Wezel(int number, Character name) {
        this.number = number;
        this.name = name;
    }

    public Wezel(int number, Character name, Wezel left, Wezel right) {
        this.number = number;
        this.name = name;
        this.left = left;
        this.right = right;
    }

    public int getNumber() {
        return number;
    }

    public Character getName() {
        return name;
    }

    public Wezel getLeft() {
        return left;
    }

    public Wezel getRight() {
        return right;
    }
}
