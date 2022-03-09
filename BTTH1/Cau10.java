import java.time.YearMonth;
import java.util.Calendar;
import java.util.Scanner;

/**
 * Câu số 10 trong bài tập thực hành số 1
 */
public class Cau10 {

    // Hàm main để bắt đầu thực hiện chương trình. Ở Lớp này, mỗi câu a,b,c tương
    // ứng với một hàng ở dưới
    private static Scanner scanner = new Scanner(System.in);
    // Hàm main để bắt đầu chương trình

    public static void main(String[] args) {

        System.out.println("Nhap ngay a");
        Calendar a = readFromInput();
        System.out.println("Nhap ngay b");
        Calendar b = readFromInput();

        System.out.println("=============================================\n");

        System.out.println("Cau a");
        final boolean compareDate = compareDate(a, b);
        System.out.println(compareDate ? "Ngay a di truoc ngay b" : "Ngay b di truoc ngay a");
        System.out.println("=============================================\n");

        System.out.println("Cau b");
        System.out.println("Ngay tiep theo cua ngay a: " + findNextDay(a).get(Calendar.DAY_OF_MONTH));
        System.out.println("=============================================\n");

        System.out.println("Cau c");
        System.out.println("Ngay truoc cua ngay a: " + findPreviousDay(a).get(Calendar.DAY_OF_MONTH));
        System.out.println("=============================================\n");

        System.out.println("Cau d");
        System.out.println("a la ngay thu " + dayOfYear(a) + " trong nam");
        System.out.println("=============================================\n");

        System.out.println("Cau e");
        System.out.println("So ngay trong thang cua ngay a " + numberOfDayInMonthOf(a));
        System.out.println("=============================================\n");

        System.out.println("Cau f");
        System.out.println("A co phai nam nhuan khong? " + (isLeapYear(a) ? "Co" : "Khong"));
        System.out.println("=============================================\n");

        // Đóng stream đọc dữ liệu để tránh hiện tượng rò rỉ bộ nhớ
        scanner.close();
    }

    /**
     * Hàm để đọc Calendar từ giá trị nhập vào
     * 
     * @return Ngày được nhập
     */
    private static Calendar readFromInput() {
        System.out.print("Nhap ngay: ");
        int day = scanner.nextInt();
        System.out.print("Nhap thang: ");
        int month = scanner.nextInt();
        System.out.print("Nhap nam: ");
        int year = scanner.nextInt();

        Calendar result = Calendar.getInstance();

        result.set(Calendar.DAY_OF_MONTH, day);
        result.set(Calendar.MONTH, month);
        result.set(Calendar.YEAR, year);

        return result;
    }

    /**
     * So sánh ngày a và ngày b
     * Trả về true nếu ngày a đến trước ngày b, trả về false nếu ngày b đến trước
     * ngày a
     * 
     * @param a
     * @param b
     * @return ngày a trước hay sau ngày b
     */
    private static boolean compareDate(Calendar a, Calendar b) {
        return a.before(b);
    }

    /**
     * Tìm ngày tiếp theo của ngày a bằng cách tăng thêm 1 đơn vị ngày
     * 
     * @param a
     * @return ngày hôm sau
     */
    private static Calendar findNextDay(Calendar a) {
        Calendar result = Calendar.getInstance();
        result.setTime(a.getTime());

        result.add(Calendar.DAY_OF_MONTH, 1);

        return result;
    }

    /**
     * Tìm ngày hôm qua của ngày a bằng cách giảm 1 đơn vị ngày
     * 
     * @param a
     * @return ngày hôm qua
     */
    private static Calendar findPreviousDay(Calendar a) {
        Calendar result = Calendar.getInstance();
        result.setTime(a.getTime());

        result.add(Calendar.DAY_OF_MONTH, -1);

        return result;
    }

    /**
     * Tìm số thứ tự của ngày a trong năm
     * 
     * @param a
     * @return thứ tự của ngày a trong năm
     */
    private static int dayOfYear(Calendar a) {
        return a.get(Calendar.DAY_OF_YEAR);

    }

    /**
     * Sử dụng object YearMonth khởi tạo từ ngày a
     * Sau đó dùng hàm đo độ dài của tháng để tính số ngày trong tháng của ngày a
     * 
     * @param a
     * @return số ngày trong tháng
     */
    private static int numberOfDayInMonthOf(Calendar a) {
        final YearMonth yearMonth = YearMonth.of(a.get(Calendar.YEAR), a.get(Calendar.MONTH) + 1);
        return yearMonth.lengthOfMonth();
    }

    /**
     * Kiểm tra xem năm của ngày a có bao nhiêu ngày. Nếu số ngày lớn 365 thì đó là
     * năm nhuận
     * Nếu số ngày <=365 thì là năm bình thường
     * 
     * @param a
     * @return a có phải năm nhuận không
     */
    private static boolean isLeapYear(Calendar a) {
        return a.getActualMaximum(Calendar.DAY_OF_YEAR) > 365;
    }
}
