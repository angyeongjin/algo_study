package level3;

public class 자물쇠와열쇠 {
    public static void main(String[] args) {
        int[][] key = {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
        int[][] lock = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        System.out.println(solution(key, lock));
    }

    public static boolean solution(int[][] key, int[][] lock) {
        int n = lock.length;
        int m = key.length;
        int rotateKey[][] = new int[m][m];

        for (int i = 0; i < 4; i++) { // 네 방향으로
            for (int j = 0; j < m; j++) { // 열쇠 돌리기
                for (int k = 0; k < m; k++) {
                    rotateKey[k][m-1-j] = key[j][k];
                }
            }
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < m; k++) {
                    key[j][k] = rotateKey[j][k];
                }
            }
            for (int j = -m+1; j < n; j++) {
                for (int k = -m+1; k < n; k++) {
                    int[][] temp = new int[n][];
                    for (int l = 0; l < n; l++) {
                        temp[l] = lock[l].clone();
                    }
                    if (isInsertKey(j, k, key, temp) && isUnlock(key, temp)) return true;
                }
            }
        }
        return false;
    }

    // 키를 채운 후 모든 자물쇠의 홈이 비워져 있지 않은지 검사하는 method (= 자물쇠를 열 수 있는가)
    private static boolean isUnlock(int[][] key, int[][] lock) {
        for (int i = 0; i < lock.length; i++) {
            for (int j = 0; j < lock.length; j++) {
                if (lock[i][j] == 0) return false;
            }
        }
        return true;
    }

    // 키와 자물쇠의 홈과 돌기가 일치하여 넣을 수 있는지 검사하는 method
    private static boolean isInsertKey(int y, int x, int[][] key, int[][] lock) {
        for (int keyY = 0, lockY = y; keyY < key.length; keyY++, lockY++) {
            for (int keyX = 0, lockX = x; keyX < key.length; keyX++, lockX++) {
                if (lockY >= 0 && lockX >= 0 && lockY < lock.length && lockX < lock.length) {
                    if (key[keyY][keyX] == 1 && lock[lockY][lockX] == 0) {
                        lock[lockY][lockX] = 1;
                    } else if (key[keyY][keyX] == lock[lockY][lockX]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
