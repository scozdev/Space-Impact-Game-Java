package Logic;

public class Lazer {

    private int y;
    private int x;

    private long lazer_creating_time = System.currentTimeMillis();

    public Lazer(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public long getLazer_creating_time() {
        return lazer_creating_time;
    }

    public void setLazer_creating_time(long lazer_creating_time) {
        this.lazer_creating_time = lazer_creating_time;
    }

}
