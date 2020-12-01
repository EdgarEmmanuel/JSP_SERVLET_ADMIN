package helper;

public class VerifyNumAccount {
	
	
	public static int getTheAccount(String num) {
		int val=0;
		String first_two = num.charAt(0)+""+num.charAt(1);
		switch(first_two) {
				case "CC":
					val=1;
					break;
				case "CE":
					val=2;
					break;
				case "CB":
					val=3;
					break;
				default:
					val=0;
					break;
		}
		return val;
	}
	
	
	
	

}
