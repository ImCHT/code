package leetcode.dynamicprogram;

/**
    ��Ŀ������
    ������������ word1 �� word2��������� word1 ת���� word2 ��ʹ�õ����ٲ����� ��
    ����Զ�һ�����ʽ����������ֲ�����
    ����һ���ַ�
    ɾ��һ���ַ�
    �滻һ���ַ�
    ˼·��
    ��̬�滮
 */
public class LeetCode72 {
    public static void main(String[] args){
        System.out.println(minDistance1("aabdinitrodsadsadfas" ,"dbenz321dasda465"));
    }
    //opt���顣ʱ�临�Ӷ�O(nm)
    public static int minDistance(String word1, String word2) {
        //�������
        if(word1==null || word2==null){
            return -1;
        }
        int[][] optNums = new int[word1.length()+1][word2.length()+1];
        //�����������
        for (int i = 0; i < optNums.length; i++) {
            optNums[i][0] = i;
        }
        for (int i = 0; i < optNums[0].length; i++) {
            optNums[0][i] = i;
        }
        //����ʽ
        for (int i = 1; i < optNums.length; i++) {
            for (int j = 1; j < optNums[0].length; j++) {
                char char1 = word1.charAt(i-1);
                char char2 = word2.charAt(j-1);
                if(char1==char2){
                    optNums[i][j] = optNums[i-1][j-1];
                }else{
                    //����
                    int case1 = 1+optNums[i-1][j];
                    //ɾ��
                    int case2 = 1+optNums[i][j-1];
                    //�޸�
                    int case3 = 1+optNums[i-1][j-1];
                    optNums[i][j] = Math.min(case1,Math.min(case2,case3));
                }
            }
        }
        return optNums[word1.length()][word2.length()];
    }
    //�ݹ顣ʱ�临�Ӷ�f(n) = n2*3f(n-1)�����������⣬�е�ʱ��Ӧ�û���ѭ��
    public static int minDistance1(String word1, String word2) {
        //�������
        if(word1==null || word2==null){
            return -1;
        }
        if(word1.length()==0){
            return word2.length();
        }else if(word2.length()==0){
            return word1.length();
        }
        if(word1.charAt(word1.length()-1)==word2.charAt(word2.length()-1)){
            return minDistance1(word1.substring(0,word1.length()-1),word2.substring(0,word2.length()-1));
        }else {
            //ɾ��
            int case1 = 1+minDistance1(word1.substring(0,word1.length()-1),word2);
            //����
            int case2 = 1+minDistance1(word1,word2.substring(0,word2.length()-1));
            //ɾ��
            int case3 = 1+minDistance1(word1.substring(0,word1.length()-1),word2.substring(0,word2.length()-1));
            return Math.min(case1,Math.min(case2,case3));
        }
    }
}
