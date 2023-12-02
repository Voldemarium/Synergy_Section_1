package theme_5_interface.task_39;

public class CodeRusToMorse implements Decoder {
    char[] rusLow;

    String[] morse = new String[]{".-", "-...", ".--", "--.", "-..", ".", "...-", "--..",
                                  "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.",
                                  ".-.", "...", "-", "..--", "..-.", "....", "-.-.", "---.",
                                  "----", "--.-", "--.--", "-.--", "-..-", "..-..", "..--", ".-.-"};

    public CodeRusToMorse() {
        this.rusLow = getFillingArrayOfChars(new char[32], 'а', 'я');
    }

    @Override
    public String encode(String source) {
        String sourceLow = source.toLowerCase();
        char[] chars = sourceLow.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
             if (chars[i] >= 'а' && chars[i] <= 'я') {
                for (int j = 0; j < rusLow.length; j++) {
                    if (chars[i] == rusLow[j]) {
                        stringBuilder.append(morse[j]);
                        if (i < chars.length - 1) {
                            stringBuilder.append(" ");
                        }
                        break;
                    }
                }
            } else {
                throw new RuntimeException(chars[i] + " - this is not russian letter!");
            }
        }
        return stringBuilder.toString();
    }

    @Override
    public String decode(String encoded) {
        String[] encodedArray = encoded.split(" ");
        char[] chars = new char[encodedArray.length];
       for (int i = 0; i < encodedArray.length; i++) {
           boolean res = false;
            for (int j = 0; j < morse.length; j++) {
                if (encodedArray[i].equals(morse[j])) {
                    chars[i] = rusLow[j];
                    res = true;
                    break;
                }
            }
            if (!res) {
                throw new RuntimeException(chars[i] + " - this is not morse symbol!");
            }
        }
        return String.valueOf(chars);
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
