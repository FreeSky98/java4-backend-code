import java.text.CollationKey;
import java.text.Collator;
import java.util.Arrays;
import java.util.Locale;

public class Sort {
    public static void main(String[] args) {
        String[] names ={
                "贾",
                "安",
                "周",
                "王",
                "李"
        };
//        Arrays.sort(names, Comparator.naturalOrder());
//        System.out.println(Arrays.toString(names));
        Arrays.sort(names,(str1,str2)->{
            Collator collator = Collator.getInstance(Locale.CHINESE);
            CollationKey key1 = collator.getCollationKey(str1);
            CollationKey key2 = collator.getCollationKey(str2);
            return key1.compareTo(key2);
        });
        System.out.println(Arrays.toString(names));
    }
}
