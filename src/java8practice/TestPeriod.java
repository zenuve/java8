package java8practice;

public class TestPeriod {
	public static void main(String []a) {
		System.out.println(findRepPattern("abcabcabc"));
	}
	
	public static String findRepPattern(String str) {
        int len = str.length();
        for(int i = 1; i <= len/2; ++i) {
            if (len % i == 0) {
                String prefix = str.substring(0, i);
                int start = i;
                boolean found = true;

                while (start < len && found) {
                    String lastPrefix = str.substring(start, start + i);
                    if (lastPrefix.equals(prefix)) {
                        start += i;
                    } else {
                        found = false;
                    }
                }

                if (start == len) {
                    System.out.println("pattern: " + prefix + " N = " + (len / prefix.length()));
                    return prefix;
                }
            }
        }
        return null;
    }
}
