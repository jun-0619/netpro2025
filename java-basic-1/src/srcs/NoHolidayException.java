package srcs;
public class NoHolidayException extends Exception {
    public void printStackTrace(){
        super.printStackTrace();
        System.err.println("この日は平日だよ！はたらきたくないねー。エラーメッセージです。");
    }
}
