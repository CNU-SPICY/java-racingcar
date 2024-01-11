package racingcar.domain;

public class RacingCar {

    private String name;
    private int status;
    private String bar;

    public RacingCar() {
    }

    public RacingCar(String name) {
        this.name = name;
        this.bar = "";
        this.status = 0;
    }


    public String getName() {
        return name;
    }

    public String getBar() {
        return bar;
    }

    public int getStatus() {
        return status;
    }

    public void increaseStatus() {
        this.status++;
    }

    public void increaseCurrentCarBar() {
        bar += "-";
    }

}