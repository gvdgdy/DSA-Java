import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubStrwithoutRptChar {


    public static void main(String[] args) {

        String s = "abcabcbb";

        LongestSubStrwithoutRptChar l1 = new LongestSubStrwithoutRptChar();

        /*int ln = l1.usingHashSet(s);
        System.out.println(ln);*/

        int ln1 = l1.usingHashMap(s);
        System.out.println(ln1);

    }

    public int usingHashSet(String s)
    {
        Set<Character> s1= new HashSet<>();

        int left = 0;
        int maxlength = 0;

       for(int right = 0; right < s.length(); right++)
       {
           while (s1.contains(s.charAt(right)))
           {
               s1.remove(s.charAt(left));
               left++;
           }
           s1.add(s.charAt(right));
           maxlength = Math.max(maxlength,right-left+1);
       }
        return  maxlength;
    }

    /*Optimized*/
    public int usingHashMap(String s1)
    {
        Map<Character,Integer> map1 = new HashMap<>();

        int left=0;
        int maxLength = 0;

        for(int right = 0; right < s1.length(); right++)
        {
            char ch = s1.charAt((right));

            if(map1.containsKey(ch))
            {
                left = Math.max(left, map1.get(ch) + 1);
            }
            map1.put(ch, right);
            maxLength = Math.max(maxLength,right - left + 1);
        }

        return  maxLength;

    }

}



