import java.util.List;

class Customer {
    public void order(String menuName, Menu menu, Barista barista){
        MenuItem menuItem = menu.choose(menuName);
        Coffee coffee = barista.makeCoffee(menuItem);
    }
}

class MenuItem {
    private String name;
    private int price;

    public MenuItem(String name, int price){
        this.name = name;
        this.price = price;
    }

    public int cost() {
        return price;
    }

    public String getName() {
        return name;
    }
}

class Menu {
    private List<MenuItem> items;

    public Menu(List<MenuItem> items){
        this.items = items;
    }

    public MenuItem choose(String name){
        for (MenuItem each : items) {
            if(each.getName().equals(name)){
                return each;
            }
        }
        return null;
    }
}

class Barista{
    public Coffee makeCoffee(MenuItem menuitem){
        Coffee coffee = new Coffee(menuitem);
        return coffee;
    }
}
class Coffee{
    private String name;
    private int price;
    public Coffee (MenuItem menuitem){
        this.name = menuitem.getName();
        this.price = menuitem.cost();
    }
}