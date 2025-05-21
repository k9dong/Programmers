class Solution {
    public String solution(String s) {
    StringBuilder sb = new StringBuilder();
    int idxInWord = 0;  // 단어 내부 인덱스

    for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        if (c == ' ') {
            sb.append(c);
            idxInWord = 0;  // 공백 만나면 카운터 리셋
        } else {
            if (idxInWord % 2 == 0) {
                sb.append(Character.toUpperCase(c));
            } else {
                sb.append(Character.toLowerCase(c));
            }
            idxInWord++;
        }
    }

    return sb.toString();
}
}