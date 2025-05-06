package entity;

import java.io.Serializable;

public class ThueBaoTronGoi extends ThueBao implements Serializable {


    public ThueBaoTronGoi(String hoTen, String diaChi, String soDienThoai) {
        super(hoTen, diaChi, soDienThoai);
    }

    @Override
    public long tinhCuoc() {
        return 350000;
    }
}
