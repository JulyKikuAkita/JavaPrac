import java.util.ArrayList;
import java.util.List;


public class Card {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Card test=new Card();
		test.Card("29 3 3 12 52");
	}
	//9:50
	public void Card(String input){
		if(input==null||input.length()==0){
			System.out.println("NO");
			return;
		}
		
		String[] process=input.split(" ");
		if(process.length!=5){
			System.out.println("NO");
			return;
		}
		
		int[] nums=new int[5];

		for(int i=0;i<process.length;i++){
			nums[i]=Integer.parseInt(process[i]);
			if(nums[i]>52||nums[i]<1){
				System.out.println("NO");
				return;
			}
		}
		
		boolean [] visited=new boolean[5];
		if(helper(nums,visited,0, 0,new ArrayList())){
			System.out.println("YES");
		}else{
			System.out.println("NO");
		}
	}

	
	public boolean helper(int[] nums, boolean[] visited,int index, int sum, ArrayList item){
		//1,2,3 =1+helper(2,3)
		if(index==5){
			if(sum==42){	
				System.out.println(item);
				return true;
			}else{
				return false;
			}
		}
		
		for(int i=0;i<nums.length;i++){
			if(visited[i]==false){
				visited[i]=true;
				item.add(nums[i]);
				if(helper(nums,visited, index+1,sum+nums[i],item)) return true;
				if(helper(nums,visited, index+1,sum-nums[i],item)) return true;
				if(helper(nums,visited, index+1,sum*nums[i],item)) return true;
				
				item.remove(item.size()-1);
				visited[i]=false;
				
			}
		}
		return false;
	}
}
