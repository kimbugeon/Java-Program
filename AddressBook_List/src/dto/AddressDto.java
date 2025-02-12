package dto;

public class AddressDto {

    private String name;
    private int number;
    private String phone;
    private String address;
    private String note;

    public AddressDto() {

    }

    public AddressDto(String name, int number, String phone, String address, String note) {
        this.name = name;
        this.number = number;
        this.phone = phone;
        this.address = address;
        this.note = note;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "AddressDto{" +
                "name='" + name + '\'' +
                ", number=" + number +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
