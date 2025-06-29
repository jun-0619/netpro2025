package q5;

public class CalcTotalPrice {
    public static void main(String[] args) {
		Book[] books = {
			new Book(1000, true, false),
			new Book(200, true, true),
			new Book(400, false, true),
			new Book(500, false, false),
		};

		// 11700
		System.out.println(calcTotalPrice(books));
	}

	public static int calcTotalPrice(Book[] items) {
		// FIXME この関数を作りなさい
        int totalPrice = 0;
        for(int i = 0; i < items.length ; i++){
            int sumPrice = items[i].price;
            if(items[i].isPremier){
                sumPrice = sumPrice * 10;
            }
            if(items[i].isBroken){
                sumPrice = (int)(sumPrice * 0.5);
            }
            totalPrice += sumPrice;
        }
		return totalPrice;
	}

	public static class Book {
		public final int price;
		public final boolean isPremier;
		public final boolean isBroken;

		public Book(int price, boolean isPremier, boolean isBroken) {
			this.price = price;
			this.isPremier = isPremier;
			this.isBroken = isBroken;
		}
	}
}
