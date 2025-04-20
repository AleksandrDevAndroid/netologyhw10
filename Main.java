import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        chekingPassword();
        PasswordChecker checker = new PasswordChecker();
        checker.setMinLength(5);
        checker.verify("pass");
    }

    static public void chekingPassword() {
        PasswordChecker passwordChecker = new PasswordChecker();
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        while (flag) {

            System.out.print("Введите мин. длину пароля:\n");
            int inputLength = Integer.parseInt(sc.nextLine());
            passwordChecker.setMinLength(inputLength);
            System.out.print("Введите макс. допустимое количество повторений символа подряд:\n");
            int inputMaxRepeat = Integer.parseInt(sc.nextLine());
            passwordChecker.setMaxRepeats(inputMaxRepeat);
            System.out.println("Введите пароль или end");
            String inputPassword = sc.nextLine();

            if (inputPassword.equalsIgnoreCase("end")) {
                break;
            }
            if (passwordChecker.verify(inputPassword) == false) {
                System.out.println("Не подходит!");
            } else System.out.println("Подходит!");

        }
    }
}
