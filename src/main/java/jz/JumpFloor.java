package jz;

public class JumpFloor {
    public static int jumpFloor(int target) {

        if (target == 1)
            return 1;
        if (target == 2)
            return 2;
        else return jumpFloor(target - 1) + jumpFloor(target - 2);

    }

    public static int jumpFloorD(int target) {
        if (target == 1)
            return 1;
        else if (target == 2)
            return 2;
        else if (target < 0)
            return 0;

        int ans[] = new int[target + 1];
        ans[1] = 1;
        ans[2] = 2;
        for (int i = 3; i <= target; i++) {
            ans[i] = ans[i - 1] + ans[i - 2];
        }
        return ans[target];
    }

    public static void main(String[] args) {
        System.out.println(jumpFloorD(4));
    }
}
