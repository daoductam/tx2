package entity;

import java.io.Serializable;

public abstract class ThueBao implements Serializable {
    private String hoTen;
    private String diaChi;
    private String soDienThoai;

    public ThueBao(String hoTen, String diaChi, String soDienThoai) {
        if (hoTen==null || hoTen.trim().isEmpty()) {
            throw new IllegalArgumentException("Tên Khách hàng không được trống");
        }
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
    }

    public abstract long tinhCuoc();

    @Override
    public String toString() {
        return hoTen + " - " + diaChi + " - " + soDienThoai + " - Cước: " + tinhCuoc() + "\n";
    }
}
