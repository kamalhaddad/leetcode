class Solution {
    public int maximum69Number (int num) {
        List<Integer> list = new ArrayList<>();
        int initNum = num;
        while(num != 0) {
            list.add(0, num % 10);
            num /= 10;
        }
        for(int i = 0; i < list.size(); ++i) {
            if(list.get(i) == 6) {
                list.set(i, 9);
                break;
            }
        }
        int ans = 0;
        for(int x : list) {
            ans = ans * 10 + x;
        }
        return  ans;
    }
}