package theme_5_interface.task_39;

public class CodeRusToEng implements Decoder {
    char[] rusUpper;
    char[] rusLow;

    char[] latinUpper = new char[]{'A', '5', 'B', '1', 'D', 'E', 'Z', '3', 'N', 'N', 'K', 'L', 'M', 'H', 'O', 'U',
            'P', 'C', 'T', 'Y', 'F', 'X', 'V', '4', 'W', 'W', '6', 'J', '6', '3', '0', '9'};
    char[] latinLow = new char[]{'a', '5', 'b', 'r', 'd', 'e', 'z', '3', 'n', 'n', 'k', 'l', 'm', 'h', 'o', 'u',
            'p', 'c', 't', 'y', 'f', 'x', 'v', '4', 'w', 'w', '6', 'j', '6', '3', '0', '9'};

    public CodeRusToEng() {
        this.rusUpper = getFillingArrayOfChars(new char[32], 'А', 'Я');
        this.rusLow = getFillingArrayOfChars(new char[32], 'а', 'я');
    }

    @Override
    public String encode(String source) {
        char[] chars = source.toCharArray();
        char[] newChars = new char[chars.length];
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 'А' && chars[i] <= 'Я') {
                for (int j = 0; j < rusUpper.length; j++) {
                    if (chars[i] == rusUpper[j]) {
                        newChars[i] = latinUpper[j];
                        break;
                    }
                }
            } else if (chars[i] >= 'а' && chars[i] <= 'я') {
                for (int j = 0; j < rusLow.length; j++) {
                    if (chars[i] == rusLow[j]) {
                        newChars[i] = latinLow[j];
                        break;
                    }
                }
            } else {
                throw new RuntimeException(chars[i] + " - this is not russian letter!");
            }
        }
        return String.valueOf(newChars);
    }

    @Override
    public String decode(String encoded) {
        char[] chars = encoded.toCharArray();
        char[] newChars = new char[chars.length];
        for (int i = 0; i < chars.length; i++) {
            boolean res = false;
            for (int j = 0; j < latinUpper.length; j++) {
                if (chars[i] == latinUpper[j]) {
                    newChars[i] = rusUpper[j];
                    res = true;
                    break;
                }
            }
            if (res) {
                continue;
            }
            for (int j = 0; j < latinLow.length; j++) {
                if (chars[i] == latinLow[j]) {
                    newChars[i] = rusLow[j];
                    res = true;
                    break;
                }
            }
            if (!res) {
                throw new RuntimeException(chars[i] + " - this is not encoder letter!");
            }
        }
        return String.valueOf(newChars);
    }


    public static char[] getFillingArrayOfChars(char[] alphabet, char startChar, char endChar) {
        for (int i = 0; i < alphabet.length; i++) {
            if (startChar <= endChar) {
                alphabet[i] = startChar;
                startChar++;
            } else {
                break;
            }
        }
        return alphabet;
    }
}
