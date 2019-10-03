package testing;

public class Macaw {
	static int count(String text) {
		int num = 0; // besikartuojanciu raidziu skaicius
		for (int i = 0; i < text.length(); i++) {
			String r = String.valueOf(text.charAt(i)); // raide
				for (int j = 2; j < text.length(); j++) {
				int temp = 0; // tarpinis besikartuojanciu raidziu skaicius
					if(text.contains(r.repeat(j))) {
					if (j > temp) temp += j;
					}
				if (temp > num) num = temp;
			}
		}
		return num;
	}
	public static void main(String[] args) {

		String text = "ggiieooo kkkkggggg";
		
		System.out.println("Daugiausiai is eiles besikartuojanciu "
		+ "raidziu skaicius: "+count(text));
		
	}

}
