class Solution {
    public int distinctEchoSubstrings(String text) {
        Set<String> answer = new HashSet<>();
        for(int length = 1; length <= text.length() / 2; ++length) {
            for(int i = 0; i + 2* length <= text.length(); ++i) {
                if(text.substring(i, i + length).equals(text.substring(i+length, i+ 2*length))) answer.add(text.substring(i, i + length));
            }
        }
        return answer.size();
    }
}