package dto;

// Data Transfer Object
public class StudentDto {

    private int number;
    private String name;
    private double height;
    private String address;

    public StudentDto() {
    }

    public StudentDto(int number, String name, double height, String address) {
        this.number = number;
        this.name = name;
        this.height = height;
        this.address = address;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "StudentDto{" +
                "number=" + number +
                ", name='" + name + '\'' +
                ", height=" + height +
                ", address='" + address + '\'' +
                '}';
    }
}
