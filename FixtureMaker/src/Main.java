import java.util.ArrayList;
import java.util.Random;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> teams = new ArrayList<>();
        teams.add("Galatasaray");
        teams.add("Fenerbahçe");
        teams.add("Beşiktaş");
        teams.add("Başakşehir");
        teams.add("Bursaspor");
        teams.add("Trabzonspor");

        if (teams.size() % 2 != 0) {
            teams.add("Bay");
        }

        int size = teams.size();
        Random rand = new Random();

        for (int i = 0; i < size; i++) {
            int j = rand.nextInt(size);
            String temp = teams.get(i);
            teams.set(i, teams.get(j));
            teams.set(j, temp);
        }

        System.out.println("Takımlar: ");
        System.out.println(teams);
        System.out.println();
        int numWeeks = (teams.size() - 1) * 2;
        for (int week = 1; week <= numWeeks; week++) {
            System.out.println("Hafta " + week + ":");

            for (int i = 0; i < teams.size() / 2 && week <= (numWeeks / 2); i++) {
                String homeTeam = teams.get(i);
                String awayTeam = teams.get(teams.size() - 1 - i);
                System.out.println(homeTeam + " (Ev Sahibi) vs " + awayTeam);
            }

            for (int i = 0; i < teams.size() / 2 && week > (numWeeks / 2); i++) {
                String homeTeam = teams.get(teams.size() - 1 - i);
                String awayTeam = teams.get(i);
                System.out.println(homeTeam + " (Ev Sahibi) vs " + awayTeam);
            }
            teams.add(1, teams.remove(teams.size() - 1));
        }
    }
}