package exam.jd;

import java.util.*;
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        String[] mStrings = new String[m];
        StringBuilder usedIndex = new StringBuilder();
        for (int i = 0; i < m; i++) {
            mStrings[i] = scanner.next();
        }
        String T = scanner.next();
        int result = 0;
        for (String str:mStrings) {
            if (T.indexOf(str)!=-1){
//                boolean isValid = true;
//                for (Integer i = T.indexOf(str); i < T.indexOf(str)+str.length(); i++) {
//                    if (usedIndex.indexOf(i.toString())!=-1){
//                        isValid = false;
//                        break;
//                    }
//                }
//                if (isValid){
                    result++;
//                    for (int i = T.indexOf(str); i < T.indexOf(str)+str.length(); i++) {
//                        usedIndex.append(i);
//                    }
//                }else {
//                    break;
//                }
            }
        }
//        if (m<=3){
//            System.out.println(m);
//        }
        System.out.println(result);
    }
}
