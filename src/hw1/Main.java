package hw1;

public class Main {
    public static void main(String[] args) {

        Competitor[] competitors = {new Human(100, 70),
                new Cat(50, 50), new Robot(200, 180),
                new Human(150, 100), new Cat(80, 40),
                new Robot(150, 100)};

        Obstacle[] obstacles = {new Track(40), new Wall(30), new Track(50),
                new Wall(20), new Track(79), new Wall(85)};

        for (int i = 0; i < obstacles.length; i++) {
            for (int j = 0; j < competitors.length; j++) {
                obstacles[i].passObstacle(competitors[j]);
            }
        }

        System.out.println(Week.Monday.getWorkingHours());
        System.out.println(Week.Sunday.getWorkingHours());
    }
}
