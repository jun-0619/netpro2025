package q7;

public class RepeatChecker {
    public static void main(String[] args) {
        System.out.println("* isTripleLength");
        System.out.println(isTripleLength("123")); // true
        System.out.println(isTripleLength("ab.cd")); // false

        System.out.println("\n* isTripleRepeat");
        System.out.println(isTripleRepeat("WordWordWord")); // true
        System.out.println(isTripleRepeat("...")); // true
        System.out.println(isTripleRepeat("WordWordWord.")); // false
        System.out.println(isTripleRepeat("ABCABCAbc")); // false

        System.out.println("\n* isSemiTripleRepeat");
        System.out.println(isSemiTripleRepeat("ABC.ABc.abc.")); // true
        System.out.println(isSemiTripleRepeat("AbcAbc")); // false
    }

    public static boolean isTripleLength(String text) {
        // TODO: text の長さが 3 の倍数であれば true を返す
        if(text.length() % 3 == 0 ){
            return true;
        }else{
            return false;
        }
    }

    public static boolean isTripleRepeat(String text) {
        // TODO: text が任意の文字列 3回 の繰り返しになっていたら true を返す
        String text1 = text.substring(0, text.length()/3);
        String text2 = text.substring(text.length()/3, text.length() * 2/3);
        String text3 = text.substring(text.length() * 2/3, text.length());
        if(text1.equals(text2) && text2.equals(text3)){
            return true;
        }else{
            return false;
        }
    }

    public static boolean isSemiTripleRepeat(String text) {
        // TODO: text が 大小文字を区別せず 任意の文字列 3回 の繰り返しになっていたら true を返す
        String text1 = text.substring(0, text.length()/3);
        String text2 = text.substring(text.length()/3, text.length() * 2/3);
        String text3 = text.substring(text.length() * 2/3, text.length());
        if(text1.equalsIgnoreCase(text2) && text2.equalsIgnoreCase(text3)){
            return true;
        }else{
            return false;
        }
    }
}
