package lk.ijse.gdse.springweb.springweb_intro.dto;


public class ItemDto {
    private String code;
    private String name;
    private int unitPrice;

    public ItemDto() {
    }

    public ItemDto(String code, String name, int unitPrice) {
        this.code = code;
        this.name = name;
        this.unitPrice = unitPrice;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return "ItemDto{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", unitPrice=" + unitPrice +
                '}';
    }
}
