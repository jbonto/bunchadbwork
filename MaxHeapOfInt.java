package tree;

public class MaxHeapOfInt {
	
	private int[] x;
	private int next;
	public MaxHeapOfInt(int initialSize){
		x = new int[initialSize];
		next = 1;
	}
	public void add(int value){
		x[next]=value;
		swim(next);
		next++;
	}
	private void swim(int k){
		while((k > 1) && (x[k]>x[k/2])){
			swap(k, k/2);
			k = k/2;
		}
	}
	private void swap(int i, int j){
		int temp = x[i];
		x[i] = x[j];
		x[j] = temp;
	}
	public int remove(){
		int result = x[1];
		x[1] = x[--next];
		
		sink(1);
		
		return x[next-1];
	}
	private void sink(int k){
		while(x[k] < Math.max(x[k*2], x[k*2+1]) && k < next){
			int biggerChildIndex = x[k*2] > x[k*2+1] ? k*2 : k*2+1;
			swap(k, biggerChildIndex);
			k = biggerChildIndex;
		}
	}
	public String toString(){
		String result = "[";
		for(int i = 0; i < next; i++){
			result+=x[i]+" ";
		}
		return result+= "]";
	}
}
