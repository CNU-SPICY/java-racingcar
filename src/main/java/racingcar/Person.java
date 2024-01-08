package racingcar;

public class Person {
    private String name;
    private int score;

    Person(String name, int score){
        this.name = name;
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(int score) {
        if (score < 0) score = 0;
        this.score = score;
    }
}
