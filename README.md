# Design Pattern Practice - Creational & Structural Patterns

## Overview
- 이번 과제는 디자인 패턴 일부를 구현해보는 연습을 목표로 합니다.
  - 주어진 skeleton 프로젝트를 올바르게 완성하여 test 함수를 통과하면 됩니다.
  - test 함수는 프로젝트에서 test 폴더에서 각 문제별 Test 클래스에서 찾을 수 있고, test_01 부터 test_10 까지 총 10개의 함수가 있습니다.
  - 각각 10점씩 모든 test 함수를 다 통과하면 총 100점이 부여됩니다.

### 주의사항
- skeleton 프로젝트는 IntelliJ IDE + openjdk-20 + JUnit 5.8.1 에서 작성되었습니다.
- test 폴더 내 클래스들은 채점에 쓰이기 때문에 절대로 추가 및 수정하시면 안됩니다.
  - 별도 테스트가 필요하면 PlayGround 클래스를 이용하거나 별도의 프로젝트를 활용하세요.
  - Test가 제대로 수행되지 않는다면 채점이 되지 않을 수 있습니다.
- 기본 및 제공된 라이브러리 외 외부 라이브러리 사용을 금지 합니다 (코드만 작성하면 됨).
- 제출 시 구분을 위하여 test 폴더의 info 패키지에서 Information 클래스를 완성하세요.
  - 구체적으로 info 메소드에서 여러분의 id (학번)와 name (이름)을 입력하고 테스트 후 통과가 되면 됩니다.
  - 학번 및 이름이 확인 안되면 채점이 안될 수 있습니다.

## Problem 1. Singleton Pattern
- SimpleLogger 클래스는 logging을 위한 간단한 클래스이다. SimpleLogger 클래스가 multi-thread에 안전하면서 singleton으로 동작될 수 있도록 SimpleLogger 클래스를 완성하시오.
- src/problem1/SimpleLogger에 기본적인 기능은 구현이 이미 되어 있다.
  - `log(level, message)`: 주어진 level이 클래스에 설정된 level 보다 높거나 같으면 message를 logging한다 (fileWriter로 출력 및 logs list에 추가).
  - `setHandler(ps)`: 출력할 stream을 설정한다.
  - `clear()`: logs list를 비운다.
  - `getNumLogs()`: 현재까지 logs list에 저장된 log message 수를 반환한다.

- test/problem1/Test 클래스의 테스트가 올바르게 수행될 수 있도록 SimpleLogger 코드를 작성한다.
  - test_01은 singleton으로 기본 기능이 올바르게 동작하는지 테스트 한다.
  - test_02는 multi-threads 세팅에서 올바르게 동작하는지 테스트 한다.


## Problem 2. Abstract Factory Pattern
1. 자동차 부품 (Car Parts)를 제조사에 맞게 생성하는 추상 팩토리를 위해 필요한 클래스들을 구현한다. 아래 클래스 다이어그램을 참고하여 problem2 패키지 내의 클래스들을 완성하시오.
   - HyundaiDoor, HyundaiRoof, HyundaiWheel, HyundaiFactory 클래스의 구현을 완성하면 된다. 나머지 클래스들은 그대로 활용한다.
   - HyundaiDoor에서 생성자 구현시 부모 클래스의 생성자를 호출하면서 CompanyName의 HYUNDAI로 설정해준다. HyundaiRoof, HyundaiWheel도 마찬가지로 구현한다.
- 구현 후 test/problem2/Test의 test_03으로 구현이 올바르게 되었는지 테스트한다.

<img width="475" alt="image" src="https://github.com/siyeonSon/siyeonSon/assets/87802191/933d02e1-f0fc-4692-b004-f7e0876735b9">

2. Tesla 자동차 부품을 위해 클래스를 추가해 위 추상 팩토리 패턴을 확장하시오.  
   - door/TeslaDoor, roof/TeslaRoof, wheel/TeslaWheel, factory/TeslaPartsFactory 로 클래스를 추가하고 구현하시오.
   - 클래스 이름이 다르면 테스트시 실패가 되니 패키지와 클래스 이름을 정확하게 지켜야 한다.
- 구현 후 test/problem2/Test의 test_04로 구현이 올바르게 되었는지 테스트한다.


## Problem 3. Builder Pattern
- Problem 2에서 작성한 factory를 통해 생성한 부품을 조합하여 자동차 (Car) 생성하려고 한다. 이 때 Builder pattern을 적용하여 car 객체를 생성하기 위한 클래스들을 구현하시오.
  - problem3 패키지에서 Car와 CarBuilder 클래스의 구현을 완성하면 된다 (추가 메소드가 필요하면 자유스럽게 추가한다).

- Builder 인터페이스에 대한 설명은 다음과 같다.
  - `addDoors(numDoors)`: numDoors 수 만큼 Door 객체를 factory에서 생성해서 추가한다. Door는 여러개 가질 수 있으며 list에 저장된다.
  - `addWheels(numWheels)`: numWheels 수 만큼 Wheel 객체를 factory에서 생성해서 추가한다. Wheel은 여러개 가질 수 있으며 list에 저장된다.  
  - `setRoof()`: factory에서 Roof 하나를 생성해서 추가한다. Roof는 한개만 가진다.
  - `setColor(color)`: color를 설정한다.
  - `getCar()`: car 객체를 반환한다.
  - `reset()`: car 객체를 새로 만든다.

- 구현의 테스트는 test/problem3/Test의 test_05, test_06으로 할 수 있다.


## Problem 4. Proxy and Decorator Patterns
- Problem 3에서 구현한 CarBuilder의 기능을 확장을 하려고 하는데, 이 때 모종의 이유로 CarBuilder의 코드를 수정할 수 없다고 가정하자. 아래 사항을 참고하여 problem4 패키지내 클래스를 완성하시오.
  - 추가 기능을 확장하기 위해서는 CarBuilder를 기준으로 Proxy pattern을 활용해 확장한다.
  - 최종 생성될 자동차가 올바른 값을 가지고 있는지 체크하는 Checking Proxy와 자동차 생성이 완료가 되면 log를 남기는 Logging Proxy를 구현한다.
  - 이때 각 Proxy가 Decorator pattern에 맞추어 조합될 수 있어야 한다.

- `CheckingBuilderProxyDecorator`: 아래 조건에 맞추어 유효하지 않은 경우 getCar()에서 null을 반환하게 한다. 유효한 경우 생성된 Car 객체를 반환한다.
  - Door 수가 4개 미만이거나 6개 초과인 경우 유효하지 않다.
  - Wheel 수가 2개 미만이거나 10개 초과인 경우 유효하지 않다.
  - Wheel 수가 홀수인 경우 유효하지 않다.
  - Roof 수가 1개가 아닌 경우 유효하지 않다.
- `LoggingBuilderProxyDecorator`: Problem 1에서 구현한 SimpleLogger를 이용해서 getCar()로 Car 객체를 반환하기 전에 log를 남긴다.
  - level은 INFO로 message는 “Building a car is completed!”로 한다.

- Decorator pattern에서 Component에 해당하는 interface는 Builder, ConcreteComponent는 CarBuilder로 둔다. CarBuilder가 기본 행동을 담당한다.
  - Base Decorator는 BaseBuilderProxyDecorator이다.

- 구현의 테스트는 test/problem4/Test를 통해서 수행한다.
  - test_07은 Checking Proxy, test_08은 Logging Proxy를 테스트한다.
  - test_09와 test_10은 Decorator pattern을 테스트 한다. 
