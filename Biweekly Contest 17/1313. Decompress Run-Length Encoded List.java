class Solution {
    public int[] decompressRLElist(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < nums.length - 1; ++i) {
            for(int j = 0; 2*i < nums.length && j < nums[2*i]; ++j) {
                if((2*i) + 1 < nums.length) ans.add(nums[(2*i) + 1]);
            }
        }
        int[] ansArr = new int[ans.size()];
        for(int i = 0; i < ans.size(); ++i)
            ansArr[i] = ans.get(i);
        return ansArr;
    }
}