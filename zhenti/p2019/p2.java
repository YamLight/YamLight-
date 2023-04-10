package zhenti.p2019;

import java.util.HashSet;

public class p2 {
    static HashSet<String> set = new HashSet<>();
    public static void main(String[] args) {
        String s = "aaab";
        char[] c = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String t = s.substring(i,j + 1);
                if (!set.contains(t)){
                    set.add(t);
                }
            }
        }
//        for (int i = 0; i < c.length; i++) {//起点
//            for (int j = i; j < c.length; j++) {//终点
//                String res = "";
//                for (int k = i; k <= j ; k++) {
//                    res += c[k] + "";
//                }
//                if (!set.contains(res)){
//                    set.add(res);
//                }
//            }
//        }
        System.out.println(set.size());
    }
}
