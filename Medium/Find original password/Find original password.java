public static String decryptPassword(String s) {
    char[] chars = s.toCharArray();
    StringBuilder password = new StringBuilder();
    int indexOfFirstChar = 0;
    for (int i = s.length() - 1; i > 0; i--) {
        if (chars[i] == '0') {
            chars[i] = chars[indexOfFirstChar];
            chars[indexOfFirstChar] = '\0';
            indexOfFirstChar++;
        } else if (chars[i] == '*') {
            chars[i] = chars[i - 2];
            chars[i - 2] = '\0';
            i--;
        }
    }
    for (char ch : chars) {
        if (ch != '\0')
            password.append(ch);
    }
    return password.toString();
}