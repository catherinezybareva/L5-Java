// Декоратор для подсчета количества мяуканий
class MeowCounter implements Meowable {
    private final Meowable meowable; // Исходный мяукающий объект
    private static int meowCount = 0;

    public MeowCounter(Meowable meowable) {
        this.meowable = meowable;
    }

    public void meow() {
        meowable.meow();
        meowCount++;
    }

    public static int getMeowCount() {
        return meowCount;
    }

    public static void resetCount() {
        meowCount = 0;
    }
}