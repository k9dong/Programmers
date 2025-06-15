class Solution {
    public int solution(int n, int w, int num) {
        int row = (num - 1) / w;
        int indexInRow = (num - 1) % w;
        int col = (row % 2 == 0) ? indexInRow : w - 1 - indexInRow;

        int count = 0;
        for (int upperRow = row + 1; ; upperRow++) {
            int startIndex = upperRow * w + 1;
            if (startIndex > n) break;

            int boxIndexInRow = (upperRow % 2 == 0) ? col : (w - 1 - col);
            int boxNum = upperRow * w + boxIndexInRow + 1;

            if (boxNum > n) break;

            count++;
        }

        return count + 1; // 자기 자신 포함
    }
}
