package racingcar.model;

public class RandomGenerator implements RandomUtil{
    RandomUtil randomUtil;

    public RandomGenerator(RandomUtil randomUtil){
        this.randomUtil = randomUtil;
    }

    public int generate(){
        return randomUtil.generate();
    }

}
