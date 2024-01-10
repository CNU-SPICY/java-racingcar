package racingcar;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCarApplication {

    private static ArrayList<Person> people;
    private static int numberOfPeople;
    private static int round;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        people = new ArrayList<>();

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String[] name = getNamesFromInput(br.readLine());

        // init
        numberOfPeople = name.length;
        for(int i=0; i<numberOfPeople; i++){
            people.add(new Person(name[i], 1));
        }

        System.out.println("시도할 횟수는 몇 회인가요?");
        round = getRoundFromInput(br.readLine());
        br.close();

        // show init states
        System.out.println(getStatesFromPeople(people));

        // racing
        for(int i=0; i<round; i++){

            // update score
            people.forEach(person -> updateScoreUsingRandomInt(person, (int) Math.round(Math.random()*10)));

            // show current states
            System.out.println(getStatesFromPeople(people));
        }

        // show winner
        System.out.println(getWinners(people) + "가 최종 우승했습니다.");

    }

    public static String getWinners(ArrayList<Person> people){
        int maxScore = 0;
        for(Person person : people){
            maxScore = Math.max(maxScore, person.getScore());
        }
        int finalMaxScore = maxScore;
        List<Person> winners = people.stream().filter(person -> person.getScore() == finalMaxScore).collect(Collectors.toList());

        StringBuilder result = new StringBuilder();
        int i;
        for (i=0; i<winners.size()-1; i++) result.append(winners.get(i).getName()).append(", ");
        result.append(winners.get(i).getName());
        return result.toString();
    }

    public static void updateScoreUsingRandomInt(Person person, int random){
        if (random < 4) return;
        person.setScore(person.getScore()+1);
    }

    public static String getStatesFromPeople(ArrayList<Person> people){
        StringBuilder result = new StringBuilder();
        for (Person person : people) result.append(person.getName()).append(" : ").append("-".repeat(Math.max(0, person.getScore()))).append("\n");
        return result.toString();
    }

    public static int getRoundFromInput(String input) throws NumberFormatException {
        int temp = Integer.parseInt(input);
        if (temp <= 0) throw new NumberFormatException();
        return temp;
    }

    public static String[] getNamesFromInput(String input){
        String[] result = input.split(",");
        return result;
    }
}
