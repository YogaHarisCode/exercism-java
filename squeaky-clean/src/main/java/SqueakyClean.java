class SqueakyClean {
    static String clean(String identifier) {
        StringBuilder stringBuilder = new StringBuilder();
        boolean upperMode = false;

        for (char ch : identifier.toCharArray()) {
            // Task 1: Ganti spasi dengan underscore
            if (ch == ' ') {
                stringBuilder.append('_');
                continue;
            }

            // Task 3: Konversi leetspeak dilakukan lebih dulu
            // agar bisa diperlakukan sebagai huruf pada tahap selanjutnya
            char current = switch (ch) {
                case '4' -> 'a';
                case '3' -> 'e';
                case '0' -> 'o';
                case '1' -> 'l';
                case '7' -> 't';
                default -> ch;
            };

            // Task 2: Deteksi kebab-case
            if (current == '-') {
                upperMode = true;
                continue;
            }

            // Task 4: Filter hanya huruf dan underscore
            if (Character.isLetter(current) || current == '_') {
                if (upperMode) {
                    stringBuilder.append(Character.toUpperCase(current));
                    upperMode = false; // Matikan toggle setelah dipakai
                } else {
                    stringBuilder.append(current);
                }
            }
        }

        return stringBuilder.toString();
    }
}