package frontend;

import backend.ThueBaoController;

import java.util.Scanner;

public class Program {

    private static ThueBaoController thueBaoController = new ThueBaoController();

    public static void main(String[] args) {
        thueBaoController.taoFakeData();
        thueBaoController.ghiRaFile();
        thueBaoController.docTuFile(); // Y4: đọc dữ liệu nếu có
        Scanner sc = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("\n1. Nhập thuê bao\n2. In danh sách\n3. Tìm thuê bao có cước cao nhất\n" +
                        "4. Lưu \n5.Đọc file\n6.Thoát");
                int chon = Integer.parseInt(sc.nextLine());
                switch (chon) {
                    case 1 -> thueBaoController.nhapThueBao();
                    case 2 -> thueBaoController.inDanhSach();
                    case 3 -> thueBaoController.timThueBaoMax();
                    case 4 -> {
                        thueBaoController.ghiRaFile();
                    }
                    case 5 -> thueBaoController.docTuFile();
                    case 6 ->{
                        System.out.println("Thoát chương trình.");
                        return;
                    }
                    default -> System.out.println("Chọn sai!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập 1 số nguyên");
            }

        }
    }


}
