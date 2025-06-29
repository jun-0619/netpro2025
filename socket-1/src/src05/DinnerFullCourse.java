package src05;

public class DinnerFullCourse {

    private Dish[] list = new Dish[5];// [0]-[4]の計5個

    public static void main(String[] args) {
		DinnerFullCourse fullcourse = new DinnerFullCourse();
		fullcourse.eatAll();
	}

    DinnerFullCourse(){
        list[0] = new Dish();
        list[0].setName("サラダ");
        list[0].setValune(1);

        list[1] = new Dish();
        list[1].setName("スープ");
        list[1].setValune(2);

        list[2] = new Dish();
        list[2].setName("ステーキ");
        list[2].setValune(3);

        list[3] = new Dish();
        list[3].setName("オムライス");
        list[3].setValune(4);

        list[4] = new Dish();
        list[4].setName("デザート");
        list[4].setValune(5);
    }

    void eatAll(){
        String str = "";
        for(Dish Dishes : list){
            str += Dishes.getName() + "=" + Dishes.getValune() + ",";
        }
        System.out.println("フルコースの内容を表示します" + str);
    }

}

