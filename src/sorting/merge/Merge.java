package sorting.merge;

/*
 * 1������˼��:�鲢��Merge�������ǽ����������������ϣ�������ϲ���һ���µ�����������Ѵ��������з�Ϊ���ɸ������У�ÿ��������������ġ�Ȼ���ٰ����������кϲ�Ϊ�����������С�
 * 2������

�����鲢�������ȶ������򷽷���

�����鲢�����ʱ�临�Ӷ�ΪO(nlogn)��

�����ٶȽ����ڿ�������Ϊ�ȶ������㷨��һ�����ڶ��������򣬵��Ǹ����������������С�
 */
public class Merge {
	public static void main(String[] args) {
        int[] a={49,38,65,97,76,13,27,49,78,34,12,64,1,8};
        System.out.println("Before sorting: ");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
        //�鲢����
        mergeSort(a,0,a.length-1);
        System.out.println();
        System.out.println("After sorting: ");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
    }

    private static void mergeSort(int[] a, int left, int right) {
        if(left<right){
            int middle = (left+right)/2;
            //����߽��еݹ�
            mergeSort(a, left, middle);
            //���ұ߽��еݹ�
            mergeSort(a, middle+1, right);
            //�ϲ�
            merge(a,left,middle,right);
        }
    }

    private static void merge(int[] a, int left, int middle, int right) {
        int[] tmpArr = new int[a.length];
        int mid = middle+1; //�ұߵ���ʼλ��
        int tmp = left;
        int third = left;
        while(left<=middle && mid<=right){
            //������������ѡȡ��С���������м�����
            if(a[left]<=a[mid]){
                tmpArr[third++] = a[left++];
            }else{
                tmpArr[third++] = a[mid++];
            }
        }
        //��ʣ��Ĳ��ַ����м�����
        while(left<=middle){
            tmpArr[third++] = a[left++];
        }
        while(mid<=right){
            tmpArr[third++] = a[mid++];
        }
        //���м����鸴�ƻ�ԭ����
        while(tmp<=right){
            a[tmp] = tmpArr[tmp++];
        }
    }
}