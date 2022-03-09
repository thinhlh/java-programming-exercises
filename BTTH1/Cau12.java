import java.util.Scanner;

/**
 * Câu số 11 trong bài tập thực hành số 1
 */
public class Cau12 {
    /**
     * Ham main cua ung dung. Day la noi chuong trinh bat dau chay
     * Tạo mảng hai chiều như sau và xuất ra màn hình
     * 1
     * 1 1
     * 1 2 1
     * 1 3 3 1
     * 1 4 6 4 1
     * 1 5 10 10 5 1
     * 1 6 15 20 15 6 1
     * 
     * @param args
     */
    public static void main(String[] args) {

        // Tao mảng hai chiều 7x7 có các phần tử giống với đề bài
        int[][] a = {
                { 1 },
                { 1, 1 },
                { 1, 2, 1 },
                { 1, 3, 3, 1 },
                { 1, 4, 6, 4, 1 },
                { 1, 5, 10, 10, 5, 1 },
                { 1, 6, 15, 20, 15, 6, 1 }
        };

        print2DArray(a);
    }

    /**
     * Lặp qua các mảng 1 chiều là phần tử của mảng hai chiều. Với mỗi mảng con 1
     * chiều, ta lại tiếp tục lặp qua các phần tử của chúng và in ra giá trị. Cứ mỗi
     * kết thúc một
     * phần tử ta thêm khoảng trắng vào để tạo ngăn cách.
     * 
     * Khi đã lặp xong hết tất cả các phần tử của mảng con một chiều, ta tiến hành
     * xuống dòng và lặp hết các phần tử của mảng con một chiều đến hết.
     * 
     * @param a
     */
    private static void print2DArray(int[][] a) {
        for (int m = 0; m < a.length; m++) {
            for (int n = 0; n < a[m].length; n++) {
                System.out.print(a[m][n] + " ");
            }
            System.out.println("");
        }
    }
}
