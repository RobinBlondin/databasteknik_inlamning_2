package Model;

public class Size {
    private final int id;
    private final int eu;
    private final int uk;
    private final int us;
    private final int cm;
    private final String inch;

    public Size(int id, int eu, int uk, int us, int cm, String inch) {
        this.id = id;
        this.eu = eu;
        this.uk = uk;
        this.us = us;
        this.cm = cm;
        this.inch = inch;
    }

    public int getId() {
        return id;
    }

    public int getEu() {
        return eu;
    }

    public int getUk() {
        return uk;
    }

    public int getUs() {
        return us;
    }

    public int getCm() {
        return cm;
    }

    public String getInch() {
        return inch;
    }
}
