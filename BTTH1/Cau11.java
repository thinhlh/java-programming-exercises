import java.util.Arrays;
import java.util.Scanner;

/**
 * Câu số 11 trong bài tập thực hành số 1
 */
public class Cau11 {

    // Đối tượng đọc dữ liệu đầu vào
    private static Scanner scanner = new Scanner(System.in);

    // Hàm main để bắt đầu thực hiện chương trình. Ở Lớp này, mỗi câu a,b,c tương
    // ứng với một hàng ở dưới
    public static void main(String[] args) {
        System.out.print("Nhap chieu dai cua mang A n: ");
        int n = scanner.nextInt();

        System.out.println("Nhap mang a");
        int[] a = inputArray(n);

        System.out.println("=============================================\n");

        System.out.println("Cau a");
        int[] b = taoMangRandom();
        System.out.println("=============================================\n");

        System.out.println("Cau b");
        System.out.println("Mang random vua duoc tao: ");
        System.out.println(Arrays.toString(b));
        System.out.println("=============================================\n");

        System.out.println("Cau c");
        int[] c = copyArray(a);
        System.out.println("Mang c vua duoc copy tu a: ");
        System.out.println(Arrays.toString(c));
        System.out.println("=============================================\n");

        System.out.println("Cau d");
        System.out.println("Thay the 3 phan tu dau cua mang C bang 3 phan tu cuoi cua mang B");
        try {
            replace(b, c);
            System.out.println("Mang c sau khi thay the: ");
            System.out.println(Arrays.toString(c));
        } catch (Exception e) {
            System.out.println("Mang B hoac C co it hon 3 phan tu nen khong the thay the");
        }
        System.out.println("=============================================\n");

        System.out.println("Cau e");
        System.out.println("Mang c sau khi sap xep xong: ");
        sort(c);
        System.out.println(Arrays.toString(c));
        System.out.println("=============================================\n");

        System.out.println("Cau f");
        System.out.print("Nhap gia tri x can tim trong c: ");
        final int x = scanner.nextInt();
        System.out.println("X " + (contains(c, x) ? "co" : "khong") + " nam trong mang C");

    }

    /**
     * Đọc các phần tử của mảng từ độ dài đã cho
     * 
     * @param n
     * @return mảng các số nguyên
     */
    private static int[] inputArray(int n) {

        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Nhap gia tri thu " + i + ": ");
            result[i] = scanner.nextInt();
        }

        return result;
    }

    /**
     * Đọc kích thước và tạo mảng số nguyên có các giá trị bất kỳ
     * 
     * @return mảng các số nguyên có giá trị bất kỳ
     */
    private static int[] taoMangRandom() {
        System.out.print("Tao mang random co kich thuoc m: ");
        int m = scanner.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            final Double value = Math.random() * 100;
            b[i] = value.intValue();
        }

        return b;
    }

    /**
     * Tạo mảng mới dựa trên các phần tử của mảng cũ nhưng là một đối tượng khác
     * 
     * @param a
     * @return Mảng mới có giá trị và các phần tử giống mảng cũ
     */
    private static int[] copyArray(int[] a) {
        return Arrays.copyOf(a, a.length);
    }

    /**
     * Thay thế 3 phần tử đầu tiên của mảng @param destination bằng 3 phần tử cuối
     * cùng của mảng @param source
     * Báo lỗi nếu @param destination hoặc @param source có ít hơn 3 phần tử
     * 
     * @param source
     * @param destination
     * @throws Exception
     */
    private static void replace(int[] source, int[] destination) throws Exception {
        if (source.length < 3 || destination.length < 3)
            throw new Exception();
        System.arraycopy(source, source.length - 3, destination, 0, 3);
    }

    /**
     * Sắp xếp mảng được cho theo giá trị tăng dần
     * 
     * @param arr
     */
    private static void sort(int[] arr) {
        Arrays.sort(arr);
    }

    /**
     * Nhận giá trị x là giá trị cần tìm kiếm trong mảng @param arr.
     * Nếu mảng có chứa giá trị x, trả về true, không thì trả về false
     * 
     * @param arr
     * @param key
     * @return mảng @param arr có chứa giá trị @param key
     */
    private static boolean contains(int[] arr, int key) {
        final int index = Arrays.binarySearch(arr, key);
        return index >= 0;
    }
}
