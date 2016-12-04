package kmp;

import java.util.Arrays;

public class KMP {
	
	private Integer[] get_next(String str){
		
		int i=0;
		int j=-1;
		Integer[] array=new Integer[str.length()];
		array[0]=0;
		while(i<str.length()-1){
			if( j==-1 || j==0 || str.charAt(i)==str.charAt(j) ){  //�ж�ÿ���ַ��Ƿ����
				i++;
				j++;
				array[i]=j;
			}else{
				j=array[j];           //���ַ������ ��j��ֵ����
			}
		}
		return array;
	}
	
	private int get_index(String big,String small,int pos){
		int i=pos;
		int j=-1;
		Integer[] next = get_next(small);
		while(i<big.length() && j<small.length()){
			if(j==-1 || j==0 || big.charAt(i)==small.charAt(j)){
				i++;
				j++;
			}else{
				j=next[j];          //��ƥ�䣬�˻غ���λ������ƥ��
			}
		}
		
		if(j==small.length()){
			return i-small.length();
		}else{
			return 0;
		}
	}
	
	public static void main(String[] args) {
		KMP kmp=new KMP();
//		String s1="ababaaaba";  //[0, 0, 1, 1, 2, 3, 1, 1, 2]
//		Integer[] array = kmp.get_next(s1); 
//		System.out.println(Arrays.toString(array));  
	
		String big="aaababafcbabaaaba";
		String small="cbabaaaba";
		int index = kmp.get_index(big,small,7);
		System.out.println(index);
	}
	
}
