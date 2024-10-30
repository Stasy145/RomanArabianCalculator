import java.util.HashMap;

public class RomanToArabianConverter {

    static HashMap<Character, Integer> romanKeyMap = new HashMap<>();

    // Статический блок инициализации
    static {
        romanKeyMap.put('I', 1);
        romanKeyMap.put('V', 5);
        romanKeyMap.put('X', 10);
        romanKeyMap.put('L', 50);
        romanKeyMap.put('C', 100);
        romanKeyMap.put('D', 500);
        romanKeyMap.put('M', 1000);
    }

    public static int romanToArabian(String romanVersion) {
        int endPoint = romanVersion.length() - 1;
        char[] romanVersionArray = romanVersion.toCharArray();
        int integerInHashMap;
        int arabianVersion = romanKeyMap.get(romanVersionArray[endPoint]);

        for (int i = endPoint - 1; i >= 0; i--) {
            integerInHashMap = romanKeyMap.get(romanVersionArray[i]);

            if (integerInHashMap < romanKeyMap.get(romanVersionArray[i + 1])) {
                arabianVersion -= integerInHashMap;
            } else {
                arabianVersion += integerInHashMap;
            }
        }
        return arabianVersion;
    }

    public static boolean isRoman(String number) {
        return romanKeyMap.containsKey(number.charAt(0));
    }
}
