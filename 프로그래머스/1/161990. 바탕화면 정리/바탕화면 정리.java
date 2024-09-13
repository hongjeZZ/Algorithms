class Solution {
    public int[] solution(String[] wallpaper) {
        int width = wallpaper[0].length();
        int height = wallpaper.length;

        int minX = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxY = Integer.MIN_VALUE;

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (wallpaper[y].charAt(x) == '#') {
                    if (x < minX) {
                        minX = x;
                    }
                    if (x > maxX) {
                        maxX = x;
                    }
                    if (y < minY) {
                        minY = y;
                    }
                    if (y > maxY) {
                        maxY = y;
                    }
                }
            }
        }

        return new int[]{minY, minX, maxY + 1, maxX + 1};
    }
}