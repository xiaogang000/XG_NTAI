package application;

public class RandomString {
    public static String getRString(int length) {
        String alphabetsInUpperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String alphabetsInLowerCase = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String allCharacters = alphabetsInLowerCase + alphabetsInUpperCase + numbers;
        StringBuffer randomString = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int randomIndex = (int)(Math.random() * allCharacters.length());
            randomString.append(allCharacters.charAt(randomIndex));
        }
        return randomString.toString();
    }
}
