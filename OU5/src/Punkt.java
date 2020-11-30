public class Punkt {

    private String name;
    private int x, y;

    public Punkt(String name, int x, int y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }

    public  Punkt(Punkt punkt)
    {
        this.x = punkt.x;
        this.y = punkt.y;

        this.name = new String(punkt.name);
    }

    public String getNamn() {
        return name;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public  void setX(int x){
        this.x = x;
    }

    public  void setY(int y){
        this.y = y;
    }


    public double avstand(Punkt punkt) {

        int dX = Math.abs(this.x - punkt.x);
        int dY = Math.abs(this.y - punkt.y);

        return  Math.sqrt(dX * dX + dY*dY);
    }

    public String toString()
    {
        return "( " + name + " " + x + " " + y + " )";
    }
}
