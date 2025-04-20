public class PasswordChecker {
    private Integer setMinLength;
    private Integer setMaxRepeats;

    public void setMinLength(int setMinLength) {
        if (setMinLength > 4) {
            this.setMinLength = setMinLength;
        } else if (setMinLength <= 0) {
            throw new IllegalArgumentException("Минимальная длина должна быть положительной.");
        }
    }

    public void setMaxRepeats(int setMaxRepeats) {
        if (setMaxRepeats > 1) {
            this.setMaxRepeats = setMaxRepeats;
        } else if (setMaxRepeats <= 0) {
            throw new IllegalArgumentException("Максимальное количество повторений должно быть положительным.");
        } else System.out.println("Число максимально допустимого количества повторений должно быть больше 1.");
    }


    public boolean verify(String password) {
        if (setMinLength == null || setMaxRepeats == null) {
            throw new IllegalStateException("Требуется задать setMinLength и setMaxRepeats перед проверкой пароля.");
        }
        if (password == null || password.length() < setMinLength) {
            return false;
        }

        int maxRepeats = setMaxRepeats;
        int currentRepeats = 0;

        for (int i = 1; i < password.length(); i++) {
            if (password.charAt(i) == password.charAt(i - 1)) {
                currentRepeats++;
                if (currentRepeats > maxRepeats) {
                    return false;
                }
            }
        }
        return true;
    }
}