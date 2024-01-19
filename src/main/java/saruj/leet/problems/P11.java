package saruj.leet.problems;

public class P11 {
    /**
     * Container With Most Water
     * @param args
     */
    public static void main(String[]args) {
        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        int[] height2 = new int[]{1,6,3,1,1,1};
        P11 p = new P11();
        System.out.println(p.maxArea(height));
    }

    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int surface = surf(left, right, height);
        while(left < right-1) {
            if(height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
            surface = Math.max(surface, surf(left, right, height));
        }
        return surface;
    }

    private int surf(int left, int right, int[] height) {
        int a = Math.min(height[left], height[right]);
        return (right - left) * a ;
    }

    public int maxArea_wrong(int[] height) {
        int left = 0;
        int right = 1;
        final int limit = height.length-1;
        int surface = surf(left, right, height);
        while(right < limit) {
            right++;
            int newSurface1 = surf(left, right, height);
            surface = Math.max(surface, newSurface1);
            int newSurface2 = surf(right-1, right, height);
            if(newSurface2 > surface) {
                surface = newSurface2;
                left = right-1;
            }
        }
        return surface;
    }


}
