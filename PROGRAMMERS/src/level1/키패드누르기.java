package level1;

import java.util.LinkedList;
import java.util.Queue;

public class 키패드누르기 {
    public static void main(String[] args) {
        int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand = "right";
        System.out.println(solution(numbers, hand));
    }

    public static String solution(int[] numbers, String hand) {
        String answer = "";
        int[][] pad = new int[][]{{1,2,3},{4,5,6},{7,8,9},{-1,0,-1}};
        int[] dy = {1, -1, 0, 0};
        int[] dx = {0, 0, 1, -1};
        Queue<Finger> leftQueue = new LinkedList<>();
        leftQueue.offer(new Finger(3,0));
        Queue<Finger> rightQueue = new LinkedList<>();
        rightQueue.offer(new Finger(3,2));
        for (int i = 0; i < numbers.length; i++) {
//            System.out.println(numbers[i]);
            if (numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
                answer += "L";
                leftQueue.clear();
                leftQueue.offer(new Finger(numbers[i]/3,0));
            } else if (numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
                answer += "R";
                rightQueue.clear();
                rightQueue.offer(new Finger(numbers[i]/3-1,2));
            } else {
                Finger tempLeft = leftQueue.peek();
                int leftDir = 0;
                if (pad[tempLeft.y][tempLeft.x] != numbers[i]) {
                    w:
                    while (!leftQueue.isEmpty()) {
                        int size = leftQueue.size();
                        leftDir++;
                        for (int k = 0; k < size; k++) {
                            Finger L = leftQueue.poll();
                            for (int j = 0; j < 4; j++) {
                                int ty = L.y + dy[j];
                                int tx = L.x + dx[j];
                                if (0 > ty || ty >= pad.length || 0 > tx || tx >= pad[0].length) continue;
                                if (pad[ty][tx] == numbers[i]) {
                                    leftQueue.clear();
                                    leftQueue.offer(new Finger(ty, tx));
                                    break w;
                                }
                                leftQueue.offer(new Finger(ty, tx));
                            }
                        }
                    }
                }
                Finger tempRight = rightQueue.peek();
                int rightDir = 0;
                if (pad[tempRight.y][tempRight.x] != numbers[i]) {
                    w:
                    while (!rightQueue.isEmpty()) {
                        int size = rightQueue.size();
                        rightDir++;
                        for (int k = 0; k < size; k++) {
                            Finger R = rightQueue.poll();
                            for (int j = 0; j < 4; j++) {
                                int ty = R.y + dy[j];
                                int tx = R.x + dx[j];
                                if (0 > ty || ty >= pad.length || 0 > tx || tx >= pad[0].length) continue;
                                if (pad[ty][tx] == numbers[i]) {
                                    rightQueue.clear();
                                    rightQueue.offer(new Finger(ty, tx));
                                    break w;
                                }
                                rightQueue.offer(new Finger(ty, tx));
                            }
                        }
                    }
                }
                if (leftDir == rightDir) {
                    if (hand.equals("right")) {
                        answer += "R";
                        leftQueue.clear();
                        leftQueue.offer(tempLeft);
                    } else {
                        answer += "L";
                        rightQueue.clear();
                        rightQueue.offer(tempRight);
                    }
                } else if (leftDir < rightDir){
                    answer += "L";
                    rightQueue.clear();
                    rightQueue.offer(tempRight);
                } else {
                    answer += "R";
                    leftQueue.clear();          
                    leftQueue.offer(tempLeft);
                }
//                System.out.println("leftDis:" + leftDir);
//                System.out.println("rightDis:" + rightDir);
            }
//            System.out.println(leftQueue);
//            System.out.println(rightQueue);
//            System.out.println();
        }
        return answer;
    }

    static class Finger {
        int y;
        int x;

        public Finger(int y, int x) {
            this.y = y;
            this.x = x;
        }

        @Override
        public String toString() {
            return "Finger{" +
                    "y=" + y +
                    ", x=" + x +
                    '}';
        }
    }
}
