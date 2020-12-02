public class Punkt{

    private String namn;
    private int x, y;

    public Punkt(String namn, int x, int y) {
        super();
        this.namn = namn;
        this.x = x;
        this.y = y;
    }

    public Punkt(Punkt punkt) {
        this.x = punkt.x;
        this.y = punkt.y;

        this.namn = punkt.namn;
    }

    public String getNamn() {

        return namn;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setNamn(String namn) {
        this.namn = namn;
    }

    public double avstand(Punkt avstandTill) {

        int dX = Math.abs(this.x - avstandTill.x);
        int dY = Math.abs(this.y - avstandTill.y);

        return Math.sqrt(dX * dX + dY * dY);
    }

    public String toString() {
        return "(" + namn + " " + x + " " + y + ")";
    }

    public boolean equals(Punkt annan) {
        return (this.x == annan.x && this.y == annan.y && this.namn.equals(annan.namn));
    }
}
