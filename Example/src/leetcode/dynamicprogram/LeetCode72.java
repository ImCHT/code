package leetcode.dynamicprogram;

/**
    题目描述：
    给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数 。
    你可以对一个单词进行如下三种操作：
    插入一个字符
    删除一个字符
    替换一个字符
    思路：
    动态规划
 */
public class LeetCode72 {
    public static void main(String[] args){
        System.out.println(minDistance1("aabdinitrodsadsadfas" ,"dbenz321dasda465"));
    }
    //opt数组。时间复杂度O(nm)
    public static int minDistance(String word1, String word2) {
        //特殊情况
        if(word1==null || word2==null){
            return -1;
        }
        int[][] optNums = new int[word1.length()+1][word2.length()+1];
        //出口条件填充
        for (int i = 0; i < optNums.length; i++) {
            optNums[i][0] = i;
        }
        for (int i = 0; i < optNums[0].length; i++) {
            optNums[0][i] = i;
        }
        //递推式
        for (int i = 1; i < optNums.length; i++) {
            for (int j = 1; j < optNums[0].length; j++) {
                char char1 = word1.charAt(i-1);
                char char2 = word2.charAt(j-1);
                if(char1==char2){
                    optNums[i][j] = optNums[i-1][j-1];
                }else{
                    //插入
                    int case1 = 1+optNums[i-1][j];
                    //删除
                    int case2 = 1+optNums[i][j-1];
                    //修改
                    int case3 = 1+optNums[i-1][j-1];
                    optNums[i][j] = Math.min(case1,Math.min(case2,case3));
                }
            }
        }
        return optNums[word1.length()][word2.length()];
    }
    //递归。时间复杂度f(n) = n2*3f(n-1)。可能有问题，有的时候应该会死循环
    public static int minDistance1(String word1, String word2) {
        //特殊情况
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
            //删除
            int case1 = 1+minDistance1(word1.substring(0,word1.length()-1),word2);
            //插入
            int case2 = 1+minDistance1(word1,word2.substring(0,word2.length()-1));
            //删除
            int case3 = 1+minDistance1(word1.substring(0,word1.length()-1),word2.substring(0,word2.length()-1));
            return Math.min(case1,Math.min(case2,case3));
        }
    }
}
