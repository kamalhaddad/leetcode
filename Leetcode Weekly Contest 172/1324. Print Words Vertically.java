class Solution {
    public List<String> printVertically(String s) {
        String[] arr = s.split(" ");
        List<String> result = new ArrayList<>();
        int[] currIndex = new int[arr.length];
        int done = 0;
        while(done < arr.length) {
            done = 0;
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < arr.length; ++i) {
                String str = arr[i];
                int indx = currIndex[i];
                if(indx > str.length() -1) {
                    sb.append(" ");
                    done++;
                } else {
                    sb.append(str.charAt(indx));
                    currIndex[i]++;
                }
            }
            String text = sb.toString();
            text = text.replaceFirst("\\s++$", "");
            if(text.length() > 0) result.add(text);
        }
        return result;

    }
}