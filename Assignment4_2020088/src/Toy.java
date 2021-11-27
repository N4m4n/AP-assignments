public class Toy {
    private String name;
    private boolean hasQues;
    public Toy(String name) {
        this.name = name;
        this.hasQues = false;
    }

    public Toy(String name, boolean a) {
        this.name = name;
        this.hasQues = a;
    }

    public String getName() {
        return this.name;
    }

    public boolean hasques() {
        return this.hasQues;
    }
}
