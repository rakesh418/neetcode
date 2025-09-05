package greedy;

public class JumpGameII {

    public static void canReachLastIndex(int[] nums){
        int count =  dfs(0, nums);
        System.out.println("recursion: "+count);
    }

    public static int dfs(int i, int[] nums){
        if(i>=nums.length-1)
            return 0;
        if(nums[i]==0)
            return 10000;
        int maxIndex = Math.min(i+nums[i], nums.length-1);
        int res=10000;
        for(int j=i+1; j<=maxIndex;j++){
           res = Math.min(res,1+dfs(j,nums));
        }
        return res;
    }

    public static void greedy(int[] nums){
        int goal = nums.length-1;
        for(int i= nums.length-2; i>=0;i--){
            if(nums[i]+i>=goal){
                goal=i;
            }
        }
        System.out.println((goal==0)? "true": "false");
    }

    public static void main(String[] args) {
        int[] nums={1,2,0,1,0};
        canReachLastIndex(nums);
//        greedy(nums);
    }
}
