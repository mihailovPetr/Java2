package hw1;

public class Track implements Obstacle{

    int length;

    public Track(int length) {
        if (length <=0){
            length = 20;
        }
        this.length = length;
    }

    @Override
    public void passObstacle(Competitor competitor) {
        competitor.run(length);
    }
}
