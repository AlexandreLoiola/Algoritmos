package BinarySearch;

public class BinarySearch {
    private Integer[] sortedArray;

    public BinarySearch() {
        this.sortedArray = new Integer[]{
                2, 5, 7, 12, 14, 19, 23, 25, 28, 32, 36, 40, 44, 48, 52, 56, 60, 64, 68, 72, 76, 80, 84, 88, 92, 96,
                100, 105, 110, 115, 120, 125, 130, 135, 140, 145, 150, 155, 160, 165, 170, 175, 180, 185, 190, 195,
                200, 205, 210, 215, 220, 227, 230, 235, 240, 245, 250, 255, 260, 265, 270, 275, 280, 285, 293, 295,
                300, 305, 310, 315, 320, 325, 330, 335, 340, 345, 350, 355, 360, 365, 372, 375, 380, 385, 390, 396,
                400, 405, 410, 415, 420, 425, 430, 435, 440, 445, 450, 455, 460, 465
        };
    }

    int search(int target) {
       int left = 0;
       int right = sortedArray.length - 1;

       while (left <= right){
           int middle = left + (right - left) / 2;

           if (sortedArray[middle] == target) {
               return middle;
           }

           if (sortedArray[middle] < target) {
              left = middle + 1;
           } else  {
               right = middle - 1;
           }
       }
       throw new RuntimeException(String.format("O elemento '%d' não está no array", target));
    }

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        int target = 405;

        int targetIndex = binarySearch.search(target);
        System.out.printf("O elemento %d está na posição %d%n", target, targetIndex);
    }
}
