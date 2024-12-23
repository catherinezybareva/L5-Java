// Класс Funs с методом для вызова мяуканья у всех объектов
class Funs {
    public static void meowsCare(Meowable... meowables) {
        for (Meowable meowable : meowables) {
            for (int i = 0; i < 5; i++) { // Мяукаем 5 раз
                meowable.meow();
            }
        }
    }
}