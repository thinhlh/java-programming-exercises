import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Câu số 9 trong bài tập thực hành số 1
 */
public class Cau9 {
    // Hàm main để bắt đầu thực hiện chương trình. Ở Lớp này, mỗi câu a,b,c tương
    // ứng với một hàng ở dưới
    public static void main(String[] args) {

        // Khai báo đối tượng đọc dữ liệu từ dòng lệnh
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap vao 2 chuoi x va y: ");

        // Đọc chuỗi x
        System.out.print("x: ");
        String x = scanner.nextLine();

        // Đọc chuỗi y
        System.out.print("y: ");
        String y = scanner.nextLine();

        System.out.println("=============================================\n");

        System.out.println("Cau a");
        chieuDaiHaiChuoi(x, y);
        System.out.println("=============================================\n");

        System.out.println("Cau b");
        System.out.println("Ba ky tu dau tien cua chuoi x: " + baKyTuDauTienCuaChuoi(x));
        System.out.println("=============================================\n");

        System.out.println("Cau c");
        System.out.println("Ba ky tu cuoi cung cua chuoi y: " + baKyTuCuoiCungCuaChuoi(y));
        System.out.println("=============================================\n");

        System.out.println("Cau d");
        try {
            System.out.println("Ky tu thu 6 cua chuoi x: " + kyTuThuSauCuaChuoi(x));
        } catch (Exception e) {
            System.out.println("Chuoi x khong co ky tu thu 6");
        }
        System.out.println("=============================================\n");

        System.out.println("Cau e");
        System.out.println(
                "Chuoi duoc gop tu 3 ky tu dau tien cua chuoi x va 3 ky tu cuoi cung cua chuoi y: " + noiChuoi(x, y));
        System.out.println("=============================================\n");

        System.out.println("Cau f");
        System.out.println("Chuoi x va y co bang nhau hay khong? " + (bangNhau(x, y) ? "Co" : "Khong"));
        System.out.println("=============================================\n");

        System.out.println("Cau g");
        System.out.println("Chuoi x va y co bang nhau hay khong ( khong quan tam hoa thuong) ? "
                + (bangNhauIgnoreCase(x, y) ? "Co" : "Khong"));
        System.out.println("=============================================\n");

        System.out.println("Cau h");
        System.out.println("Chuoi y co nam trong chuoi x khong? Vi tri nao? "
                + (contains(y, x) >= 0 ? "Co o vi tri: " + contains(y, x) : "Khong"));
        System.out.println("=============================================\n");

        System.out.println("Cau i");
        final Set<Integer> containsIndexes = containsIndexes(y, x);
        System.out.println("Tat ca cac vi tri ma chuoi y nam trong chuoi x: " + (containsIndexes.isEmpty() ? "Khong co"
                : containsIndexes.toString()));
        System.out.println("=============================================\n");

        // Đóng stream đọc dữ liệu
        scanner.close();
    }

    /**
     * Câu a: Tính độ dài hai chuỗi x và y
     * 
     * @param x
     * @param y
     */
    private static void chieuDaiHaiChuoi(String x, String y) {
        System.out.println("Chuoi x co chieu dai: " + x.length());
        System.out.println("Chuoi y co chieu dai: " + y.length());
    }

    /**
     * Câu b: Lấy ba ký tự đầu tiên của mỗi chuỗi
     * Nếu chiều dài của chuỗi ít hơn 3 ký tự, ta in thẳng chuõi ra màn hình
     * 
     * @param x
     * @param y
     * @return Ba ký tự đầu tiên của chuỗi
     */
    private static String baKyTuDauTienCuaChuoi(String x) {

        return x.length() <= 3 ? x : x.substring(0, 3);
    }

    /**
     * Lấy ba ký tự cuối cùng của chuỗi
     * Nếu chuỗi có ít hơn ba ký tự, ta in thẳng chuỗi ra màn hình
     * 
     * @param y
     * @return Ba ký tự cuối cùng của chuỗi
     */
    private static String baKyTuCuoiCungCuaChuoi(String y) {
        return y.length() <= 3 ? y : y.substring(y.length() - 3, y.length());
    }

    /**
     * Lấy ký tự thứ 6 của chuỗi, nếu chuỗi có ít hơn 6 ký tự, thông báo không có ký
     * tự thứ 6
     * 
     * @param x
     * @return Ký tự thứ 6 của chuỗi
     * @throws Exception
     */
    private static char kyTuThuSauCuaChuoi(String x) throws Exception {
        if (x.length() < 6) {
            throw new Exception();
        } else {
            return x.charAt(5);
        }
    }

    /**
     * Nối 3 ký tự đầu tiên của chuỗi x vào ba ký tự cuối cùng của chuỗi y
     * Nếu ít hơn 3 ký tự, ta sẽ lấy mặc định tối đa số ký tự có thể.
     * 
     * @param x
     * @param y
     * @return chuỗi được nối
     */
    private static String noiChuoi(String x, String y) {
        return baKyTuDauTienCuaChuoi(x) + baKyTuCuoiCungCuaChuoi(y);
    }

    /**
     * Sử dụng hàng equals để kiểm tra hai chuỗi có bằng nhau hay không
     * 
     * @param x
     * @param y
     * @return chuỗi a có bằng chuỗi b không
     */
    private static boolean bangNhau(String x, String y) {
        return x.equals(y);
    }

    /**
     * Kiểm tra chuỗi a có bằng chuỗi b và không quan tâm hoa thường
     * 
     * @param x
     * @param y
     * @return chuỗi a có bằng chuỗi b không quan tâm hoa thường
     */
    private static boolean bangNhauIgnoreCase(String x, String y) {
        return x.equalsIgnoreCase(y);
    }

    /**
     * Kiểm tra chuỗi match có nằm trong chuỗi container hay không
     * Nếu kết quả trả về >=0 đó là vị trí của chuỗi con
     * Nếu <0 thì chuỗi cha không chứa chuỗi con
     * 
     * @param match
     * @param container
     * @return vị trí của chuỗi con nằm trong chuỗi cha
     */
    private static int contains(String match, String container) {
        return container.indexOf(match);
    }

    /**
     * 
     * @param match
     * @param container
     * @return Tất cả các vị trí xuất hiện của chuỗi con
     * 
     *         Lặp tất cả các kỹ tự của chuỗi, với mỗi ký tự, ta tìm vị trí của
     *         chuỗi con trong chuỗi cha bắt đầu tính từ ký tự đầu tiên ở vị trí
     *         trong vòng lặp
     *         Sau đó nếu tìm được vị trí của chuỗi con, kiểm tra vị trí đã tồn tại
     *         hay chưa sau đó thêm vào mảng không trùng lặp các vj trí
     */
    private static Set<Integer> containsIndexes(String match, String container) {

        final Set<Integer> indexes = new HashSet<>();

        for (int i = 0; i < container.length() - 1; i++) {
            final Integer index = container.indexOf(match, i);
            if (index >= 0) {

                // If the index is already exists, then ignore this;
                indexes.add(index);
            }
        }

        return indexes;
    }

}
