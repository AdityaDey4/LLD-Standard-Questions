package VendingMachine;

import VendingMachine.EnumClasses.ItemTypes;

public class Inventory {
    
    private ItemShelf inventory[] = null;

    Inventory() {
        inventory = new ItemShelf[ItemTypes.values().length];
        initialEmptyInventory();
    }

    public ItemShelf[] getItemShelfInventory() {
        return inventory;
    }

    public void setInventory(ItemShelf[] inventory) {
        this.inventory = inventory;
    }

    public void initialEmptyInventory() {
        int startCode = 101;
        for(int i=0; i<inventory.length; i++) {
            ItemShelf space = new ItemShelf();
            space.setCode(startCode);
            space.setQuantity(0);
            space.setSoldOut(true);
            startCode++;
            
            inventory[i] = space;
        }
    }

    public void addItem(int codeNumber, int quantity) throws Exception {
        for(ItemShelf itemShelf : inventory) {
            if(itemShelf.getCode() == codeNumber) {
                itemShelf.setQuantity(itemShelf.getQuantity()+quantity);
                if(itemShelf.getQuantity() > 0) itemShelf.setSoldOut(false);
            }else {
                throw new Exception("Invalid Code Number");
            }
        }
    }

    public ItemShelf getItem(int codeNumber) throws Exception {

        for (ItemShelf itemShelf : inventory) {
            if (itemShelf.getCode() == codeNumber) {

                return itemShelf;
            }
        }
        throw new Exception("Invalid Code");
    }

    public ItemTypes removeItem(int codeNumber) throws Exception {
        for(ItemShelf itemShelf : inventory) {
            if(itemShelf.getCode() == codeNumber) {
                if(itemShelf.isSoldOut()) {
                    throw new Exception("Item already sold out");
                }else {
                    itemShelf.setQuantity(itemShelf.getQuantity()-1);
                    if(itemShelf.getQuantity() == 0) itemShelf.setSoldOut(true);
                    return itemShelf.getItemType();
                }
            }
        }

        throw new Exception("Invalid Code");
    }
    
    public void updateItemSoldOut() {
        for(ItemShelf item : inventory) {
            if(item.getQuantity() > 0) item.setSoldOut(false);
        }
    }
}
