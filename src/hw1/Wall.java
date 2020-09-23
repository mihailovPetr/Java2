package hw1;

public class Wall implements Obstacle{

    int height;

    public Wall(int height) {
        if (height <=0){
            height = 20;
        }
        this.height = height;
    }

    @Override
    public void passObstacle(Competitor competitor) {
        competitor.jump(height);
    }
}
