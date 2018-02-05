import java.util.HashMap;
import java.util.Map;

public class Test {

    public Test() {
    }

    public static void main(String[] args) {

        String input = "aaazzzzzaaabbbb";

      System.out.println( "-- "+ countCharOcc(input));

    }

    public static String compressString(String x) {
        // create a buffer
        StringBuffer buffer = new StringBuffer();
        // to hold the current alphabet
        char current = x.charAt(0);
        // to hold the current count
        int count = 1;
        // iterate through the array, counting
        for (int i = 1; i < x.length(); i++) {
            // update buffer if the letter has changed
            if (current != x.charAt(i)) {
                buffer.append(current);
                buffer.append(count);
                current = x.charAt(i);
                count = 1;
            } else {
                // increment the counter
                count++;
            }
        }
        // remember to add the last character
        buffer.append(current);
        buffer.append(count);
        // return a string
        return buffer.toString();
    }


    public static String countCharOcc(String inputStr) {
        String rtnStr = "";
        StringBuffer sb = new StringBuffer();
        Map<Character, Integer> mp = new HashMap<Character, Integer>();
        char current = inputStr.charAt(0);
        if (inputStr == null) {
            return rtnStr = "";
        } else {
            char[] inputChars = inputStr.toCharArray();
            int startCnt = 1;

            for (int i = 0; i < inputChars.length; i++) {
                if (mp.containsKey(inputChars[i])){
                    mp.put(inputChars[i], mp.get(inputChars[i])+1);

                } else {
                    mp.put(inputChars[i],1) ;


                }

            }

        }

        for (Map.Entry<Character, Integer> e : mp.entrySet()) {
            //to get key
            e.getKey();
            //and to get value
            e.getValue();
            sb.append(e.getKey());
            sb.append(e.getValue());
        }
       // System.out.println(mp);
 return rtnStr=sb.toString();
    }

}
