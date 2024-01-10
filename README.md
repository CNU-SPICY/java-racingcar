# java-racingcar

자동차 경주 미션 저장소

## 우아한테크코스 코드리뷰

- [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)

# Person class
- String name :  이름
- int score : 점수

# RacingCarApplication Method

### String getNamesFromInput(String input)
- input을 ","를 기준으로 split한 값을 반환한다.

### int getRoundFromInput(String input)
- input을 String에서 int로 반환한다. 단, 0보다 작거나 같으면 예외를 던진다.

### String getStatesFromPeople(ArrayList<Person> people)
- Person 객체의 name, score 값을 확인하여 자동차 경주 한 라운드의 상태를 반환한다.

### void updateScoreUsingRandomInt(Person person, int random)
- random 값이 4보다 크거나 같으면 Person 객체의 score에 1 더한다.

### String getWinners(ArrayList<Person> people)
- 가장 높은 score를 가진 Person 객체들의 name을 반환한다.

# test/java/racingcar/RacingCarApplicationTest.java
- main/java/racingcar/RacingCarApplication.java 의 메소드 4개의 테스트

# test/java/study/stringTest.java
- String 클래스에 대한 학습 테스트의 요구사항

# test/java/study/SetTest.java
- Set Collections 클래스에 대한 학습 테스트의 요구사항

