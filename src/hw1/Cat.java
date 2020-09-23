package hw1;

public class Cat implements Competitor{

    private int runLeft;
    private int jumpLeft;
    private boolean onDistance = true;

    public Cat(int runLeft, int jumpLeft) {
        if (runLeft <= 0) {
            runLeft = 50;
        }
        if (jumpLeft <=0)
        {
            jumpLeft = 50;
        }
        this.runLeft = runLeft;
        this.jumpLeft = jumpLeft;
    }

    @Override
    public void run(int length) {
        if (!onDistance){
            return;
        }
        else if (runLeft <= length)
        {
            onDistance = false;
            runLeft = 0;
            jumpLeft = 0;
            System.out.println("Кот сошел с дистанции");
            return;
        }
        runLeft -= length;
        System.out.println("Кот пробежал " + length + " метров");
    }

    @Override
    public void jump(int height) {
        if (!onDistance){
            return;
        }
        else if (jumpLeft <= height)
        {
            onDistance = false;
            runLeft = 0;
            jumpLeft = 0;
            System.out.println("Кот сошел с дистанции");
            return;
        }
        jumpLeft -= height;
        System.out.println("Кот прыгнул " + height + " метров");
    }
}
