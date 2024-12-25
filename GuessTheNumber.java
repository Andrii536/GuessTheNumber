import java.util.Scanner; // Импорт класса Scanner для ввода данных от пользователя

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Создание объекта Scanner для считывания пользовательского ввода
        boolean playAgain = true; // Флаг для проверки, хочет ли игрок сыграть еще раз

        // Основной цикл игры
        while (playAgain) {
            // Генерация случайного числа в диапазоне от 1 до 100
            int secretNumber = (int) (Math.random() * 100) + 1; // Math.random() генерирует число от 0 до 100
            int attempts = 0; // Счетчик количества попыток
            boolean guessed = false; // Флаг для указания, было ли число угадано

            // Приветственное сообщение и правила игры
            System.out.println("Добро пожаловать в игру 'Угадай число'!");
            System.out.println("Я загадал число от 1 до 100. Попробуй его угадать!");

            // Основной цикл угадывания: продолжается, пока число не будет угадано
            while (!guessed) { // Условие цикла: выполняется, пока guessed == false
                System.out.print("Введите ваше предположение: "); // Запрос числа у пользователя
                int playerGuess = scanner.nextInt(); // Чтение введенного числа от игрока
                attempts++; // Увеличение счетчика попыток

                // Проверка, совпадает ли введенное число с загаданным
                if (playerGuess == secretNumber) {
                    // Если число угадано, выводится поздравление и количество попыток
                    System.out.println("Поздравляю! Вы угадали число за " + attempts + " попыток.");
                    guessed = true; // Установка флага в true для выхода из цикла
                } else if (playerGuess < secretNumber) { 
                    // Если введенное число меньше загаданного
                    System.out.println("Загаданное число больше. Попробуйте еще раз."); // Подсказка для игрока
                } else { 
                    // Если введенное число больше загаданного
                    System.out.println("Загаданное число меньше. Попробуйте еще раз."); // Подсказка для игрока
                }
            }

            // Запрос у игрока, хочет ли он сыграть еще раз
            System.out.print("Хотите сыграть еще раз? (yes/no): ");
            String response = scanner.next(); // Чтение ответа пользователя
            if (response.equalsIgnoreCase("no")) {
                playAgain = false; // Выход из цикла, если игрок не хочет продолжать
                System.out.println("Спасибо за игру!");
            }
        }

        // Закрытие сканера для предотвращения утечки ресурсов
        scanner.close(); 
    }
}
