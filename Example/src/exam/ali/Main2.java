package exam.ali;

/*
    ��Ŀ������
    С����˫ʮһ����ϳ齱Ӯ����һ����è�����ⵥ�Ļ��ᣬ
    ������һ��������������V���������M���ⵥ
    ������Ʒi,���Vi,����Mi,���Si,�۸�Pi
    Ŀǰ��è���е���Ʒ��Ϊ����ˮ��(1)��ʳƷ��ˮ(2),��ױ����(3),�Ӽ�����(4)�Ĵ���
    ����ˮ��������ױ����ͬ����
    �������С���ڹ��ﳵ��������Ʒʹ���ܼ�ֵ���
    ����������
    ����:
    ��Ʒ������n,�����޶������v,�����޶�������m(����������n��)
    ��Ʒ1���,��Ʒ1����,��Ʒ1���,��Ʒ1�۸�,��Ʒ1����
    ��Ʒ2���,��Ʒ2����,��Ʒ2���,��Ʒ2�۸�,��Ʒ2����
    ��Ʒ3���,��Ʒ3����,��Ʒ3���,��Ʒ3�۸�,��Ʒ3����
    ���:
    ���ﳵ����Ʒ���ܼ�ֵ
    ���뷶��:
    3,40,30
    10,10,10,10,1
    13,10,12,11,3
    3,4,6,5,3
    �������:
    33
 */
import java.util.*;
public class Main2 {

    /* ������������������ʵ����ĿҪ��Ĺ��� **/
    /* ��Ȼ����Ҳ���Բ��������ģ����������ȫ�����Լ����뷨�� ^-^  **/
    private static int totalPrice(int categoryCount, int totalVolume, int totalWeight, int[] volume, int[] weight,
                                  int[] stock, int[] price, int[] itemType) {
        return 0;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] line = in.nextLine().split(",");
        //�ܹ���Ʒ����
        int categoryCount = Integer.valueOf(line[0]);
        //������
        int totalVolume = Integer.valueOf(line[1]);
        //�������
        int totalWeight = Integer.valueOf(line[2]);

        //��Ʒ���
        int[] volume = new int[50];
        //����
        int[] weight = new int[50];
        //����
        int[] stock = new int[50];
        //�۸�
        int[] price = new int[50];
        //����
        int[] itemType = new int[50];

        for (int i = 1; i <= categoryCount; i++) {
            line = in.nextLine().split(",");
            volume[i] = Integer.valueOf(line[0]);
            weight[i] = Integer.valueOf(line[1]);
            stock[i] = Integer.valueOf(line[2]);
            price[i] = Integer.valueOf(line[3]);
            itemType[i] = Integer.valueOf(line[4]);
        }

        in.close();

        System.out.println(totalPrice(categoryCount, totalVolume, totalWeight, volume, weight, stock, price, itemType));

    }
}
