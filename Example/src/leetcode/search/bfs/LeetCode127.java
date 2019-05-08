package leetcode.search.bfs;

import java.util.*;

/*
    ��Ŀ������
    �����������ʣ�beginWord �� endWord����һ���ֵ䣬�ҵ��� beginWord �� endWord �����ת�����еĳ��ȡ�ת������ѭ���¹���
    ÿ��ת��ֻ�ܸı�һ����ĸ��
    ת�������е��м䵥�ʱ������ֵ��еĵ��ʡ�
    ˼·��
    �����������
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
            //ÿ��Ľڵ���д���
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
