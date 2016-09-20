package sorting.insertion;
/*
 * ���ַ��������򣨰����ַ��ҵ�����λ�ò��룩

����1������˼�룺���ַ����������˼���ֱ�Ӳ���һ����ֻ���Һ��ʵĲ���λ�õķ�ʽ��ͬ�������ǰ����ַ��ҵ����ʵ�λ�ã����Լ��ٱȽϵĴ�����
   2������

������Ȼ�����ַ���������Ҳ���ȶ��ġ�

�������ֲ�������ıȽϴ�����������¼�ĳ�ʼ״̬�޹أ��������ڼ�¼�ĸ�������n�ϴ�ʱ����ֱ�Ӳ�����������Ƚϴ����ٵöࡣ������ֱ�Ӳ����������С�Ƚϴ�����
       �㷨���ƶ�������ֱ�Ӳ��������㷨����ͬ��������Ϊn2/2����õ����Ϊn��ƽ���ƶ�����ΪO(n2)��
 */

public class Binary {
	public static void main(String[] args) {
        int[] a={49,38,65,97,176,213,227,49,78,34,12,164,11,18,1};
        System.out.println("Before sorting: ");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
        //���ֲ�������
        sort(a);
        System.out.println();
        System.out.println("After sorting: ");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
    }

    private static void sort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int temp = a[i];
            int left = 0;
            int right = i-1;
            int mid = 0;
            while(left<=right){
                mid = (left+right)/2;
                if(temp<a[mid]){
                    right = mid-1;
                }else{
                    left = mid+1;
                }
            }
            for (int j = i-1; j >= left; j--) {
                a[j+1] = a[j];
            }
            if(left != i){
                a[left] = temp;
            }
        }
    }
}
