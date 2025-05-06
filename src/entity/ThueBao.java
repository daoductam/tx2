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

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    @Override
    public String toString() {
        return hoTen + " - " + diaChi + " - " + soDienThoai + " - Cước: " + tinhCuoc() + "\n";
    }
}
