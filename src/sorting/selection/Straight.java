package sorting.selection;

/*
 * �򵥵�ѡ������
����1������˼�룺��Ҫ�����һ�����У�ѡ����С��һ�������һ��λ�õ���������Ȼ����ʣ�µ�������������С����ڶ���λ�õ������������ѭ���������ڶ����������һ�����Ƚ�Ϊֹ��
   2������

������ѡ�������ǲ��ȶ�������

����ʱ�临�Ӷȣ�T(n)=O(n2)��
 */
public class Straight {
	public static void main(String[] args) {
        int[] a={49,38,65,97,76,13,27,49,78,34,12,64,1,8};
        System.out.println("Before sorting: ");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
        //�򵥵�ѡ������
        for (int i = 0; i < a.length; i++) {
            int min = a[i];
            int n=i; //��С��������
            for(int j=i+1;j<a.length;j++){
                if(a[j]<min){  //�ҳ���С����
                    min = a[j];
                    n = j;
                }
            }
            a[n] = a[i];
            a[i] = min;
            
        }
        System.out.println();
        System.out.println("After sorting: ");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
    }
}