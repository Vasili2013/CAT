package ru.vasili.se;

class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public boolean decreaseFood(int n) {
        int difference = food - n;
        if (difference < 0) return false;
        food -= n;
        return true;
    }

    public void info() {
        System.out.println("Миска: " + food);
    }

    public void addFood(int food) {
        System.out.println("=====================================\nДобавляем еду: " + food);
        this.food += food;
    }
}

public class Cat {
    private String name;
    private int appetite;
    private boolean satiety;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.satiety = true;
    }
    public void info() {
        System.out.println(name + " Хочет кушать " + appetite + ".\n" + name + " кушает.");
        String isHungry = !satiety ? " наелся" : " остается голодным,т.к. в тарелке мало еды.";
        System.out.println(name + isHungry);
    }
    public void eat(Plate p) {
        if (satiety == true && p.decreaseFood(appetite) == true) {
            satiety = false;
        }
        System.out.println("=====================================");
    }
}
class Main {
    public static void main(String[] args) {
        Cat[] arrCats = new Cat[5];
        arrCats[0] = new Cat("Барсик", 10);
        arrCats[1] = new Cat("Мурзик", 20);
        arrCats[2] = new Cat("Рыжик", 25);
        arrCats[3] = new Cat("Оникс", 20);
        arrCats[4] = new Cat("Черныш", 30);
        Plate p = new Plate(100);

        for (Cat cat : arrCats) {
            cat.eat(p);
            p.info();
        }
        p.info();
        p.addFood(100);
        p.info();
    }
}

