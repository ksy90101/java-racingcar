# java-racingcar
자동차 경주 게임 미션

## 요구사항

- [x] 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
    - [x] 주어진 횟수는 2 ~ 10으로 제한한다.
- [x] 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- [x] 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- [x] 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- [x] 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4 이상일 경우 전진하고, 3 이하의 값이면 멈춘다.
- [x] 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.

### 필수 제약사항

- [규칙 1: 한 메서드에 오직 한 단계의 들여쓰기만 한다.](https://developerfarm.wordpress.com/2012/01/26/object_calisthenics_2/)
- [규칙 2: else 예약어를 쓰지 않는다.](https://developerfarm.wordpress.com/2012/01/27/object_calisthenics_3/)
- [규칙 3: 모든 원시값과 문자열을 포장한다.](https://developerfarm.wordpress.com/2012/01/27/object_calisthenics_4/)
- [규칙 6: 모든 엔티티를 작게 유지한다.](https://developerfarm.wordpress.com/2012/01/31/object_calisthenics_7/)
- [규칙 8: 일급 콜렉션을 쓴다.](https://developerfarm.wordpress.com/2012/02/01/object_calisthenics_/)
- [규칙 9: 게터/세터/프로퍼티를 쓰지 않는다](https://developerfarm.wordpress.com/2012/02/01/object_calisthenics_10/)
    - View에서 사용하는 getter는 제외한다.
- 테스트커버리지
    - 도메인 80% 이상으로 한다.

### 권장사항
- [규칙 4: 한 줄에 점을 하나만 찍는다.](https://developerfarm.wordpress.com/2012/01/30/object_calisthenics_5/)
- [규칙 5: 줄여쓰지 않는다(축약 금지).](https://developerfarm.wordpress.com/2012/01/30/object_calisthenics_6/)
- [규칙 7: 2개 이상의 인스턴스 변수를 가진 클래스를 쓰지 않는다.](https://developerfarm.wordpress.com/2012/01/31/object_calisthenics_8/)