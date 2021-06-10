# 📖 상속
Starbuzz 커피 전문점을 통한 상속 이해

## 요구 사항
Starbuzz 커피 전문점은 커피와 차를 판매한다. 커피와 차를 준비하는 과정은 각각 다음과 같다.

### 커피(coffee)
- 물을 끓인다.
- 필터를 활용해 커피를 내린다.
- 컵에 붓는다.
- 설탕과 우유를 추가한다.

### 차(tea)
- 물을 끓인다.
- 차 티백을 담근다.
- 컵에 붓는다.
- 레몬을 추가한다.

## 구현하기
```java
public class Coffee {
void prepareRecipe() {
boilWater();
brewCoffeeGrinds();
pourInCup();
addSugarAndMilk();
}

    public void boilWater() {
        System.out.println("물을 끓인다.");
    }

    public void brewCoffeeGrinds() {
        System.out.println("필터를 활용해 커피를 내린다.");
    }

    public void pourInCup() {
        System.out.println("컵에 붓는다.");
    }

    public void addSugarAndMilk() {
        System.out.println("설탕과 우유를 추가한다.");
    }
}
```
```java
public class Tea {
void prepareRecipe() {
boilWater();
steepTeaBag();
pourInCup();
addLemon();
}

    public void boilWater() {
        System.out.println("물을 끓인다.");
    }

    public void steepTeaBag() {
        System.out.println("티백을 담근다.");
    }

    public void pourInCup() {
        System.out.println("컵에 붓는다.");
    }

    public void addLemon() {
        System.out.println("레몬을 추가한다.");
    }
}
```
구현한 코드를 살펴보니 중복되는 부분이 있다. 중복 코드를 제거한다. 제거하는 방법은?

## 상속을 통한 중복 코드 제거

### 클래스 다이어그램
중복 코드를 별도의 클래스로 분리한다.

자바의 extends 예약어를 활용해 별도로 분리한 클래스를 상속한다.

### 구현 코드
```java
public class CaffeineBeverage {
protected void boilWater() {
System.out.println("물을 끓인다.");
}

    protected void pourInCup() {
        System.out.println("컵에 붓는다.");
    }
}
```
```java
public class Coffee extends CaffeineBeverage {
void prepareRecipe() {
boilWater();
brewCoffeeGrinds();
pourInCup();
addSugarAndMilk();
}

    public void brewCoffeeGrinds() {
        System.out.println("필터를 활용해 커피를 내린다.");
    }

    public void addSugarAndMilk() {
        System.out.println("설탕과 우유를 추가한다.");
    }
}
```
```java
public class Tea extends CaffeineBeverage {
void prepareRecipe() {
boilWater();
steepTeaBag();
pourInCup();
addLemon();
}

    public void steepTeaBag() {
        System.out.println("티백을 담근다.");
    }

    public void addLemon() {
        System.out.println("레몬을 추가한다.");
    }
}
```

### extends
- 부모 클래스의 모든 필드와 메소드를 자식 클래스가 상속하도록 지원하는 keyword이다.
- 상속을 할 경우 멤버 필드와 메소드를 하위 클래스에서 그대로 상속하게 된다.

## 추상화
> Coffee와 Tea에서 중복되는 부분은 없을까?
> 혹시 중복되는 부분이 있다면 중복을 제거할 수 있는 방법이 있을까?

### 추상화를 통한 중복 제거
- Coffee의 brewCoffeeGrinds()와 Tea의 steepTeaBag() 메소드의 역할은?
  - 뜨거운 물을 사용해 커피나 차를 우려낸다. => brew() 메소드로 추상화
- Coffee의 addSugarAndMilk()와 Tea의 addLemon() 메소드의 역할은?
  - 커피나 차에 첨가물을 추가한다. => addCondiments() 메소드로 추상화
```java
public class Coffee extends CaffeineBeverage {
void prepareRecipe() {
boilWater();
brew();
pourInCup();
addCondiments();
}

    public void brew() {
        System.out.println("필터를 활용해 커피를 내린다.");
    }

    public void addCondiments() {
        System.out.println("설탕과 우유를 추가한다.");
    }
}
```
```java
public class Tea extends CaffeineBeverage {
void prepareRecipe() {
boilWater();
brew();
pourInCup();
addCondiments();
}

    public void brew() {
        System.out.println("티백을 담근다.");
    }

    public void addCondiments() {
        System.out.println("레몬을 추가한다.");
    }
}
```
- 메소드 이름을 같은 이름을 가지도록 구현한 결과 prepareRecipe() 메소드가 똑같다.
- prepareRecipe() 메소드를 부모 클래스인 CaffeineBeverage로 이동해 중복을 제거한다.
```java
public abstract class CaffeineBeverage {
abstract void brew();

    abstract void addCondiments();
    
    void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        addCondiments();
    }
    
    protected void boilWater() {
        System.out.println("물을 끓인다.");
    }

    protected void pourInCup() {
        System.out.println("컵에 붓는다.");
    }
}
```
```java
public class Coffee extends CaffeineBeverage {
public void brew() {
System.out.println("필터를 활용해 커피를 내린다.");
}

    public void addCondiments() {
        System.out.println("설탕과 우유를 추가한다.");
    }
}
```
```java
public class Tea extends CaffeineBeverage {
public void brew() {
System.out.println("티백을 담근다.");
}

    public void addCondiments() {
        System.out.println("레몬을 추가한다.");
    }
}
```

### abstract
- 클래스를 추상 클래스로 지정할 때 사용한다.
- 클래스를 abstract로 지정하면 new keyword를 통해 객체를 직접 생성할 수 없다.
- 메소드에 abstract를 사용할 경우 interface의 메소드와 같이 구현 부분은 없다.
- abstract로 선언한 메소드를 자식 클래스에서 반드시 구현해야 한다.

## 업캐스팅(upcasting) vs 다운캐스팅(downcasting)

### 생각해 볼거리
> 다음 각각의 정의에 대한 참과 거짓을 판단한다.

- 커피(Coffee)는 카페인 음료(CaffeineBeverage)이다.
- 카페인 음료(CaffeineBeverage)는 커피(Coffee)이다.
- 차(Tea)는 카페인 음료(CaffeineBeverage)이다.
- 카페인 음료(CaffeineBeverage)는 차(Tea)다.

### 각 정의에 따른 코드 구현
- 커피(Coffee)는 카페인 음료(CaffeineBeverage)이다.(O)
```java
CaffeineBeverage beverage = new Coffee(); (O)
```
- 카페인 음료(CaffeineBeverage)는 커피(Coffee)이다.(X)
```java
Coffee coffee = new CaffeineBeverage(); (X)
```
- 차(Tea)는 카페인 음료(CaffeineBeverage)이다.(O)
```java
CaffeineBeverage beverage = new Tea(); (O)
```
- 카페인 음료(CaffeineBeverage)는 차(Tea)다.(X)
```java
Tea tea = new CaffeineBeverage(); (X)
```

### 업캐스팅(upcasting)
- 하위 클래스를 상위 클래스로 타입을 변환하는 것을 의미한다.
```java
CaffeineBeverage beverage = new Coffee(); (O)
CaffeineBeverage beverage = new Tea(); (O)
```

### 다운캐스트(downcasting)
- 상위 클래스를 하위 클래스의 타입으로 변환하는 것을 의미한다.
```java
CaffeineBeverage beverage = new Coffee();

if (beverage  instanceof Coffee) {
Coffee coffee = (Coffee)beverage;
}
```
- instanceof - 인스턴스가 실제로 어떤 타입인지를 확인할 때 사용하는 자바 keyword