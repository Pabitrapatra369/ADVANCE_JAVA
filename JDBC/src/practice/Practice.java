package practice;

public class Practice {
	public static boolean isBoolean() {
		Integer s1 = 5;

		String s3 = Integer.toBinaryString(s1);

		System.out.println(s3);
		char[] s4 = s3.toCharArray();
		for (int i = 0, j = s4.length - 1; i <= j; i++,j--) {
			if (s4[i] == s4[j])
				continue;
			else
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
     System.out.println(isBoolean());
	}
}
