import java.util.Scanner;

public class Cau4 {

    /**
     * Ham main cua ung dung. Day la noi chuong trinh bat dau chay
     * 
     * @param args
     */
    public static void main(String[] args) {

        // Khai báo biến scanner, đây là đối tượng được dùng để đọc các gì trị từ
        // terminal/command line
        Scanner scanner = new Scanner(System.in);

        int n;

        // Tạo một try-catch đề phòng trường hợp giá trị nhập vào không phải là số
        // nguyên
        try {

            // Đọc giá trị nhập vào từ dòng lệnh
            System.out.println("Nhap so duong n: ");
            n = scanner.nextInt();

            // Kiểm tra n có phải số nguyên dương hay không? nếu không thì báo lỗi
            if (n < 0)
                throw new Exception();

            // Tính tổng các số từ 1 đến n
            int sum = 0;
            for (int i = 0; i <= n; i++) {
                sum += i;
            }

            // Thông báo kết quả cho người dùng
            System.out.println("Tong cac so tu 1 den " + String.valueOf(n) + ": " + String.valueOf(sum));
        } catch (Exception e) {
            // Thông báo lỗi giá trị nhập vào không hợp lệ
            System.out.println("n khong phai la mot so nguyen duong");
        } finally {

            // Đóng stream đọc dữ liệu để tránh hiện tượng tràn và rò rỉ bộ nhớ
            scanner.close();
        }

    }
}