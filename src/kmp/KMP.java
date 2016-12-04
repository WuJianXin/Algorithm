package kmp;


public class KMP {
	
	private Integer[] get_next(String str){
		
		int i=0;
		int j=-1;
		Integer[] array=new Integer[str.length()];
		array[0]=0;
		while(i<str.length()-1){
			if( j==-1 || j==0 || str.charAt(i)==str.charAt(j) ){  //判断每个字符是否相等
				i++;
				j++;
				array[i]=j;
			}else{
				j=array[j];           //两字符不相等 ，j的值回溯
			}
		}
		return array;
	}
	
	/**
	 * 返回第一个匹配的串的首字母下标，从0开始
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
				j=next[j];          //不匹配，退回合适位置重新匹配
			}
		}
		
		if(j==small.length()){
			return i-small.length();
		}else{
			return -1;
		}
	}
	
	public static void main(String[] args) {
		KMP kmp=new KMP();
//		String s1="ababaaaba";  //[0, 0, 1, 1, 2, 3, 1, 1, 2]
//		Integer[] array = kmp.get_next(s1); 
//		System.out.println(Arrays.toString(array));  
	    //            012345678 
		String big=  "aaadbbbdcc";
		String small=      "bdc";
		int index = kmp.get_index(big,small);
		System.out.println(index);          //6
	}
	
}
