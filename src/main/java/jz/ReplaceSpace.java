package jz;

public class ReplaceSpace {
    public String replaceSpace(String s) {
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                cnt++;
            }
        }
        StringBuilder sb = new StringBuilder(s.length() + cnt * 2);
        String replace = "%20";
        for(int i =0;i<s.length();i++){
            if(s.charAt(i)==' '){
                sb.append(replace);
            }
            else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
