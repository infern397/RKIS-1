import java.util.Scanner;

/**
 * Класс для ввода в консоль
 */
public class Input {

  /**
   * Метод для ввода и проверки вводимых значений типа int
   *
   * @return Значение int
   */
  public static int intInput() {
    int num;
    Scanner in = new Scanner(System.in);
    while (!in.hasNextInt()) {
      System.err.println("Некорректный ввод");
      in.next();
    }
    num = in.nextInt();
    return num;
  }
  /**
   * Метод для ввода и проверки вводимых значений типа int
   *
   * @return Значение int
   */
  public static int naturalIntInput() {
    int num;
    Scanner in = new Scanner(System.in);
    while (!in.hasNextInt()) {
      System.err.println("Некорректный ввод");
      in.next();
    }
    num = in.nextInt();
    return num;
  }


  /**
   * Метод для ввода строки и проверки на пустоту
   *
   * @return строка
   */
  public static String stringInput() {
    String string;
    Scanner in = new Scanner(System.in);
    do {
      string = in.nextLine();
      if (string.length() == 0) {
        System.err.println("Строка не может быть пустой");
      }
    }
    while (string.length() == 0);

    return string;
  }
}