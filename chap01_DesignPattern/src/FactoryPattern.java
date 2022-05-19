
abstract class Coffee {
    public abstract int getPrice();

    // 문자열로 바뀔 때 가격을 출력
    @Override
    public String toString() {
        return "Hi this coffee is " + this.getPrice();
    }
}

// 상위 클래스 (뼈대 결정)
class CoffeeFactory {
    public static Coffee getCoffee(String type, int price) {
        // 라떼면 라떼 생산, 아메면 아메 생산
        if ("Latte".equalsIgnoreCase(type)) return new Latte(price);
        else if ("Americano".equalsIgnoreCase(type)) return new Americano(price);
        else { return new DefaultCoffee(); }
    }
}

class DefaultCoffee extends Coffee {
    private int price;

    public DefaultCoffee() {
        this.price = -1;
    }

    @Override
    public int getPrice() {
        return this.price;
    }
}

// 하위 클래스 (구체적인 내용 결정)
class Latte extends Coffee {
    private int price;

    public Latte(int price) {
        this.price = price;
    }
    @Override
    public int getPrice() {
        return this.price;
    }
}

// 하위 클래스 (구체적인 내용 결정)
class Americano extends Coffee {
    private int price;

    public Americano(int price) {
        this.price = price;
    }
    @Override
    public int getPrice() {
        return this.price;
    }
}

public class FactoryPattern {
    public static void main(String[] args) {
        Coffee latte = CoffeeFactory.getCoffee("Latte", 4000);
        Coffee ame = CoffeeFactory.getCoffee("Americano", 3000);
        System.out.println("Factory latte:: " + latte); // Coffee 객체가 string으로 바뀌면서 toString 함수 호출(가격 출력)
        System.out.println("Factory americano:: " + ame); // toString 함수 호출(가격 출력)
    }
}
