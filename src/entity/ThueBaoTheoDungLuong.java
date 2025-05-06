package entity;

import java.io.Serializable;

public class ThueBaoTheoDungLuong extends ThueBao implements Serializable {
    private int soMB;

    public int getSoMB() {
        return soMB;
    }

    public void setSoMB(int soMB) {
        this.soMB = soMB;
    }

    public ThueBaoTheoDungLuong(String hoTen, String diaChi, String soDienThoai, int soMB) {
        super(hoTen, diaChi, soDienThoai);
        if (soMB <=0) {
            throw new IllegalArgumentException("Số MB sử dụng phải lớn hơn 0");
        }
        this.soMB = soMB;
    }

    @Override
    public long tinhCuoc() {
        return 30000 + soMB*50;
    }

    @Override
    public String toString() {
        return super.toString() + " - MB: " + soMB;
    }
}
