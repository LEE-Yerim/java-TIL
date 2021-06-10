package study3;

public class Car {
    private final String name;
    private int position;

    public Car(final String name, final int position) {
        this.name = name;
        this.position = position;
    }

    public void move(int number) {
        if(number >= 4) {
            position = position + 1;
        }
    }

//    public void move(final MoveStrategy moveStrategy) {
//        if(moveStrategy.isMovable()) {
//            position = position + 1;
//        }
//    }
//    //디자인 패턴 - 전략 패턴
//    //DI - Dependency Injection 의존성 주입
//    //Car 객체는 어떤 구현체에 의존하지 않고 MoveStrategy 인터페이스에 의존하고 있다. 강한 결합 x 느슨한 결합 o
//
    public Car move(final MoveStrategy moveStrategy) {
        if(moveStrategy.isMovable()) {
            return new Car(name, position + 1);
        }
        //return new Car(name, position);
        return this;
    }
    //이제 private final int position 가능

    public int getPosition() {
        return position;
    }

    public Sting getName() {
        return name;
    }
}
