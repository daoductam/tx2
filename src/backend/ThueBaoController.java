package backend;

import entity.ThueBao;
import entity.ThueBaoTheoDungLuong;
import entity.ThueBaoTronGoi;

import java.io.*;
import java.util.*;

public class ThueBaoController {
    public  List<ThueBao> danhSach = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);
    private  final String FILE = "thuebao.txt";

    public void nhapThueBao() {
        System.out.println("1. Trọn gói | 2. Theo dung lượng");
        int loai;
        try {
            loai = Integer.parseInt(sc.nextLine());
            if (loai != 1 && loai != 2) {
                System.out.println("Loại thuê bao không hợp lệ! Chỉ được nhập 1 hoặc 2.");
                return; // không cho nhập tiếp, thoát khỏi hàm
            }
        } catch (NumberFormatException e) {
            System.out.println("Phải nhập số 1 hoặc 2!");
            return;
        }
        System.out.print("Họ tên: ");
        String ten = sc.nextLine();
        System.out.print("Địa chỉ: ");
        String dc = sc.nextLine();
        System.out.print("SĐT: ");
        String sdt = sc.nextLine();

        try {
            if (loai == 1) {
                danhSach.add(new ThueBaoTronGoi(ten, dc, sdt));
            } else if (loai == 2) {
                System.out.print("Số MB: ");
                int mb = Integer.parseInt(sc.nextLine());
                danhSach.add(new ThueBaoTheoDungLuong(ten, dc, sdt, mb));
            }
        } catch (Exception e) {

            System.out.println("Lỗi: " + e.getMessage());

        }
    }


    public void inDanhSach() {
        System.out.println("\n--- DANH SÁCH THUÊ BAO ---");
        danhSach.forEach(System.out::println);
    }

    public void timThueBaoMax() {
        if (danhSach.isEmpty()) {
            System.out.println("Danh sách rỗng.");
            return;
        }
        ThueBao max = Collections.max(danhSach, Comparator.comparingLong(ThueBao::tinhCuoc));
        System.out.println("Thuê bao có cước cao nhất: " + max);
    }

    public void ghiRaFile() {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE))) {
            oos.writeObject(danhSach);
            System.out.println("Đã lưu vào file");
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void docTuFile() {
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE))) {
            danhSach = (List<ThueBao>) ois.readObject();
            System.out.println("Đã đọc từ dữ liệu cũ: \n"+danhSach);
        } catch (Exception e) {
            System.out.println("Lỗi ghi file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void taoFakeData() {
        danhSach.add(new ThueBaoTronGoi("Nguyen Van A", "Hanoi", "0912345678"));
        danhSach.add(new ThueBaoTronGoi("Tran Thi B", "HCM", "0987654321"));
        danhSach.add(new ThueBaoTheoDungLuong("Le Van C", "Danang", "0901234567", 500));
        danhSach.add(new ThueBaoTheoDungLuong("Pham Thi D", "Hue", "0978123456", 1000));
        System.out.println("Đã thêm dữ liệu mẫu.");
    }

}
