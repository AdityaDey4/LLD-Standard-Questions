package ResturantSystem.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import ResturantSystem.Model.MenuItem;

public class MenuService {
    // acts as repository
    private final Map<String, MenuItem> menuByName = new ConcurrentHashMap<>();
    private final Map<String, MenuItem> menuById = new ConcurrentHashMap<>();

    public MenuItem addMenuItem(String id, String name, double price) {
        MenuItem item = new MenuItem(id, name, price);
        menuByName.put(name, item);
        menuById.put(id, item);
        return item;
    }

    public void removeMenuItemByName(String name) {
        MenuItem item = menuByName.remove(name);
        if (item != null) menuById.remove(item.getId());
    }

    public List<MenuItem> listMenu() {
        return new ArrayList<>(menuById.values());
    }

    public MenuItem getByName(String name) { return menuByName.get(name); }
    public MenuItem getById(String id) { return menuById.get(id); }
}
