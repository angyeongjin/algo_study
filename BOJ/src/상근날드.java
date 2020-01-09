import java.util.Scanner;

public class 상근날드 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int minHam = Integer.MAX_VALUE;
		int minDrink = Integer.MAX_VALUE; 
		
		for (int i = 0; i < 3; i++) {
			int ham = s.nextInt();
			if (minHam > ham)
				minHam = ham;
		}
		
		for (int i = 0; i < 2; i++) {
			int drink = s.nextInt();
			if (minDrink > drink)
				minDrink = drink;
		}
		
		int set = (minHam + minDrink) - 50;
		System.out.println(set);
	}
}
