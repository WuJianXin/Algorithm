package kmp;



/**
 * �Ľ���kmp
 * @author Administrator
 *
 */
public class KMPImprove {
private Integer[] get_next(String str){
		
		int j=0;
		int i=-1;
		Integer[] array=new Integer[str.length()];
		array[0]=0;
		while(j<str.length()-1){
			if( i==-1 || i==0 || str.charAt(j)==str.charAt(i) ){  //�ж�ÿ���ַ��Ƿ����
				j++;
				i++;
				
				/**
				 * �Ľ��ĵط��������ǰ�ַ���ǰһ���ַ���ͬ�Ļ���
				 * ��ǰ��nextֵΪǰһ���ַ���nextֵ
				 */
				if(str.charAt(j)!=str.charAt(i)){   
					array[j]=i;
				}else{
					array[j]=array[i];
				}
			}else{
				i=array[i];           //���ַ������ ��j��ֵ����
			}
		}
		return array;
	}
	
	/**
	 * ���ص�һ��ƥ��Ĵ�������ĸ�±꣬��0��ʼ
	 * @param big
	 * @param small
	 * @return
	 */
	private int get_index(String big,String small){
		int i=0;
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
			return -1;
		}
	}
	
	public static void main(String[] args) {
		KMPImprove kmp=new KMPImprove();
//		String s1="ababaaaba";  //[0, 0, 1, 0, 1, 3, 1, 0, 1]
//		Integer[] array = kmp.get_next(s1); 
//		System.out.println(Arrays.toString(array));  
	    //          012345678
		String big="aabbccabcddrg";
		String small= "bccabc";
		int index = kmp.get_index(big,small);   //3
		System.out.println(index);
	}
}	
