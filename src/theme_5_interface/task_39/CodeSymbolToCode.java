package theme_5_interface.task_39;

public class CodeSymbolToCode implements Decoder {

    @Override
    public String encode(String source) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < source.length(); i++) {
                stringBuilder.append((int) source.charAt(i));
                if (i < source.length() - 1) {
                    stringBuilder.append(" ");
                }
        }
        return stringBuilder.toString();
    }

    @Override
    public String decode(String encoded) {
        String[] encodedArray = encoded.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : encodedArray) {
            int charCode = Integer.parseInt(s);
            if (charCode < 0 || charCode > 65536) {
                throw new RuntimeException(s + " - this is not char!");
            }
            stringBuilder.append((char)charCode);
        }
        return stringBuilder.toString();
    }
}
