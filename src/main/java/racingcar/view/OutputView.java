package racingcar.view;

import racingcar.domain.Car;
import java.util.ArrayList;

public class OutputView {
    public void printRacing(Car[] carList) {
        for(int i = 0; i < carList.length; i++) {
            System.out.println(carList[i].getCarName() + " : " +
                    "-".repeat(carList[i].getDistance()));
        }
        System.out.println();
    }

    public void printWinner(ArrayList<String> winnerList) {
        String winners = "";
        for(String str : winnerList){
            winners += (str + ", ");
        }
        winners = winners.substring(0, winners.length() - 2) + "가 최종 우승했습니다.";
        System.out.println(winners);
    }
}
