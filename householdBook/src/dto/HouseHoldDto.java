package dto;

public class HouseHoldDto {

    private String monthly;
    private String income;
    private String outlay;
    private String memo;

    public HouseHoldDto() {
    }

    public HouseHoldDto(String monthly, String income, String outlay, String memo) {
        this.monthly = monthly;
        this.income = income;
        this.outlay = outlay;
        this.memo = memo;
    }

    public String getMonthly() {
        return monthly;
    }

    public void setMonthly(String monthly) {
        this.monthly = monthly;
    }

    public String getIncome() {
        return income;
    }

    public void setIncome(String income) {
        this.income = income;
    }

    public String getOutlay() {
        return outlay;
    }

    public void setOutlay(String outlay) {
        this.outlay = outlay;
    }

    public String getMemo() {
        return memo;
    }

    public void setMeomo(String memo) {
        this.memo = memo;
    }

    @Override
    public String toString() {
        return "HouseHoldDto{" +
                "monthly='" + monthly + '\'' +
                ", income=" + income +
                ", outlay=" + outlay +
                ", memo='" + memo + '\'' +
                '}';
    }
}
