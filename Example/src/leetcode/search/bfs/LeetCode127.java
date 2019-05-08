package leetcode.search.bfs;

import java.util.*;

/*
    题目描述：
    给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
    每次转换只能改变一个字母。
    转换过程中的中间单词必须是字典中的单词。
    思路：
    广度优先搜索
 */
public class LeetCode127 {
    public static void main(String[] args){
        String beginword = "hit";
        String endword = "cog";
        String[] words = {"hot","dot","dog","lot","log","cog"};
        List<String> wordList = new ArrayList<>(Arrays.asList(words));
        System.out.println(ladderLength(beginword,endword,wordList));
    }
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new LinkedList<>();
        boolean[] marked = new boolean[wordList.size()];
        int layerNum = 0;
        queue.offer(beginWord);
        while (!queue.isEmpty()){
            layerNum++;
            int size = queue.size();
            //每层的节点进行处理
            while (size-->0){
                String node = queue.poll();
                for (int i = 0; i < wordList.size(); i++) {
                    if (node.equals(endWord)) {
                        return layerNum;
                    } else if (marked[i] || !changeable(node,wordList.get(i))){
                        continue;
                    } else {
                        queue.offer(wordList.get(i));
                        marked[i] = true;
                    }
                }
            }
        }
        return 0;
    }
    private static boolean changeable(String beginword,String wordlist){
        int num = 0;
        for (int i = 0; i < beginword.length(); i++) {
            if (beginword.charAt(i)!=wordlist.charAt(i)){
                num++;
                if (num>=2){
                    return false;
                }
            }
        }
        return true;
    }
}
