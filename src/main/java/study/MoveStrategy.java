package study;

@FunctionalInterface
public interface MoveStrategy {
    boolean isMovable();
    //FunctionalInterface 추상메서드가 하나인 인터페이스를 뜻하고
    //이를 이용해서 객체를 함수처럼 보이게 한다.

}
