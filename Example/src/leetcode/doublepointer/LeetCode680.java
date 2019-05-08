package leetcode.doublepointer;

/*
    ע��㣺
    Ҫע������ӣ������������
    ��Ŀ������
    ����һ���ǿ��ַ��� s�����ɾ��һ���ַ����ж��Ƿ��ܳ�Ϊ�����ַ�����
    �Ľ���
    ɾ���ַ������Ըı�,���Եģ��ݹ�+������
    ˼·��
    1. ����ָ�룬���϶Աȣ����Ƿ���ȣ���һ�����������ʱ�����ҷֱ�ƫ��һλ���ԣ����Ƿ���ȣ��ڶ��β������false
       ������left>=right����true������û�п����������
    2. �ݹ���������û�����
 */
public class LeetCode680 {
    public static void main(String[] args){
        System.out.println(validPalindrome("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"));
    }
    public static boolean validPalindrome(String s){
        return validPalindromeTime(s,1);
    }
    public static boolean validPalindromeTime(String s,int time) {
        if(s==null){
            return false;
        }
        int left = 0;
        int right = s.length()-1;
        while (left < right){
            if(s.charAt(left)==s.charAt(right)){
                left++;
                right--;
//                System.out.println(s.substring(left,right+1));
            }else if(time>0){
                return validPalindromeTime(s.substring(left+1,right+1),time-1) || validPalindromeTime(s.substring(left,right),time-1);
                //�������һ��
//                if(s.charAt(left+1)==s.charAt(right)){
//                    left++;
//                    times--;
//                }else if(s.charAt(left)==s.charAt(right-1)){    //�ұ�����һ��
//                    right--;
//                    times--;
//                }else{//���Ҷ�û��ƥ���
//                    return false;
                }else {
                return false;
            }
        }
        return true;
    }
}
