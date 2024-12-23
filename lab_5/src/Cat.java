// Класс Кот, который реализует интерфейс Meowable
class Cat implements Meowable {
    private final String name;

    public Cat(String name) {
        this.name = name;
    }

    public void meow() {
        System.out.println(name + ": мяу!");
    }

    public String toString() {
        return "кот: " + name;
    }
}