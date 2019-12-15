class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i < 10; ++i) {
            queue.add(i);
        }
        
        while(!queue.isEmpty()) {
            int current = queue.poll();
            if(low <= current && current <= high) {
                result.add(current);
            } else if(current > high) {
                continue;
            }
            int lastDigit = current % 10;
            if(lastDigit != 9) {int next = current* 10 + (lastDigit + 1);
            queue.add(next);
            }
        }
        return result;
    }
    
}