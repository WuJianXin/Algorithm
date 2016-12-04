package kmp;



/**
 * 改进版kmp
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
			if( i==-1 || i==0 || str.charAt(j)==str.charAt(i) ){  //判断每个字符是否相等
				j++;
				i++;
				
				/**
				 * 改进的地方，如果当前字符和前一个字符相同的话，
				 * 则当前的next值为前一个字符的next值
				 */
				if(str.charAt(j)!=str.charAt(i)){   
					array[j]=i;
				}else{
					array[j]=array[i];
				}
			}else{
				i=array[i];           //两字符不相等 ，j的值回溯
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
