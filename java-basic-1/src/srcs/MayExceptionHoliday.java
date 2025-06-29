package srcs;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MayExceptionHoliday {
    public static void main(String[] args) {
        //↓警告出るのでコメントアウト。　実行するときはコメントアウトをリセットしてね
        //MayExceptionHoliday myE = new MayExceptionHoliday();
    }

    MayExceptionHoliday(){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        try {
            while(!line.equals("exit")){
                System.out.println("5月の何日ですか？(終了したい場合はexitと入力)");
                line = reader.readLine();
                int theDay = Integer.parseInt(line);
                System.out.println(theDay + "日ですね。");

                test(theDay);
            }
        } catch(IOException e){
            System.out.println(e);
        } catch (NoHolidayException e) {
            e.printStackTrace();
        }
    }

    void test(int theDay) throws NoHolidayException{
        if(theDay==3||theDay==4||theDay==5||theDay==6||theDay==10||
        theDay==11||theDay==17||theDay==18||theDay==24||theDay==25||theDay==31){
            System.out.println(theDay+"日はお休みです。\n");
        }else{
            throw new NoHolidayException();
        }
    }
}
