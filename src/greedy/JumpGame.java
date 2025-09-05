package greedy;

public class JumpGame {

    public static void canReachLastIndex(int[] nums){
        boolean flg =  dfs(0, nums);
        System.out.println("recursion: "+ flg);
    }

    public static boolean dfs(int i, int[] nums){
        if(i==nums.length-1)
            return true;
        if(nums[i]==0)
            return false;
        int maxIndex = Math.min(i+nums[i], nums.length-1);
        for(int j=i+1; j<=maxIndex;j++){
            if(dfs(j,nums))
                return true;
        }
        return false;
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
        int[] nums={0,2,0,1,0};
        canReachLastIndex(nums);
        greedy(nums);
    }
}
