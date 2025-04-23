import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        chekingPassword();

    }

    static public void chekingPassword() {
        PasswordChecker passwordChecker = new PasswordChecker();
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        while (flag) {

            System.out.print("Введите мин. длину пароля:\n");
            int inputLength = 0;
            inputLength = Integer.parseInt(sc.nextLine());
            if (inputLength <= 4) {
                passwordChecker.setMinLength(inputLength);
                while (true) {
                    System.out.print("Введите мин. длину пароля:\n");
                    int tryAgainInputLength = Integer.parseInt(sc.nextLine());
                    passwordChecker.setMinLength(tryAgainInputLength);
                    if (tryAgainInputLength > 4) {
                        inputLength = tryAgainInputLength;
                        break;
                    }
                }
            }
            System.out.print("Введите макс. допустимое количество повторений символа подряд:\n");
            int inputMaxRepeat = Integer.parseInt(sc.nextLine());
            if (inputMaxRepeat < 2) {
                while (true) {
                    int tryAgainMaxRepeat = 0;
                    passwordChecker.setMaxRepeats(inputMaxRepeat);
                    System.out.print("Введите макс. допустимое количество повторений символа подряд:\n");
                    tryAgainMaxRepeat = Integer.parseInt(sc.nextLine());
                    if (tryAgainMaxRepeat > 1) {
                        inputMaxRepeat = tryAgainMaxRepeat;
                        break;
                    }

                }
            }
            passwordChecker.setMaxRepeats(inputMaxRepeat);
            System.out.println("Введите пароль или end");
            String inputPassword = sc.nextLine();
            passwordChecker.setMaxRepeats(inputMaxRepeat);
            passwordChecker.setMinLength(inputLength);
            if (inputPassword.equalsIgnoreCase("end")) {
                break;
            }
            if (passwordChecker.verify(inputPassword) == false) {
                System.out.println("Не подходит!");
            } else System.out.println("Подходит!");
            break;

        }
    }
}
