package pl.paul.lista;

public class Books {
    private String name;

    public static final Books[] books = {
            new Books("The Painted Man"),
            new Books("Game of Thrones"),
            new Books("Joyland")
    };

    private Books(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public String toString() {
        return this.name;
    }
}
