package VendingMachine;

import VendingMachine.EnumClasses.ItemTypes;

public class ItemShelf {
    
    private int code;
    private ItemTypes type;
    private int price;
    private int quantity;
    private boolean soldOut;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public ItemTypes getItemType() {
        return type;
    }

    public void setItemType(ItemTypes type) {
        this.type = type;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isSoldOut() {
        return soldOut;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setSoldOut(boolean soldOut) {
        this.soldOut = soldOut;
    }

}
