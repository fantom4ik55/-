import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            // Запрашиваем данные у пользователя
            Scanner scanner = new Scanner(System.in, "UTF-8");

            System.out.println("Введите Фамилию Имя Отчество:");
            String lastName = scanner.nextLine();

            System.out.println("Введите дату рождения в формате dd.mm.yyyy:");
            String dateOfBirth = scanner.nextLine();

            System.out.println("Введите номер телефона:");
            long phoneNumber = scanner.nextLong();

            System.out.println("Введите пол (f - женский, m - мужской):");
            char gender = scanner.next().charAt(0);

            // Проверяем форматы данных
            if (!isValidDateFormat(dateOfBirth)) {
                throw new IllegalArgumentException("Неправильный формат даты рождения");
            }

            if (!isValidGender(gender)) {
                throw new IllegalArgumentException("Неправильный символ пола");
            }

            // Создаем файл с фамилией
            File file = new File(lastName + ".txt");
            FileWriter writer = new FileWriter(file, StandardCharsets.UTF_8);

            // Записываем данные в файл
            writer.write(lastName + " " + dateOfBirth + " " + phoneNumber + " " + gender);
            writer.close();

            System.out.println("Данные успешно сохранены в файл " + file.getName());
        } catch (IllegalArgumentException | IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isValidDateFormat(String date) {
        String regex = "\\d{2}.\\d{2}.\\d{4}";
        return date.matches(regex);
    }

    private static boolean isValidGender(char gender) {
        return gender == 'f' || gender == 'm';
    }
}
