package Model;

public class Size {
    private int id;
    private int eu;
    private int uk;
    private int us;
    private int cm;
    private String inch;

    public Size() {
    }

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

    public void setId(int id) {
        this.id = id;
    }

    public int getEu() {
        return eu;
    }

    public void setEu(int eu) {
        this.eu = eu;
    }

    public int getUk() {
        return uk;
    }

    public void setUk(int uk) {
        this.uk = uk;
    }

    public int getUs() {
        return us;
    }

    public void setUs(int us) {
        this.us = us;
    }

    public int getCm() {
        return cm;
    }

    public void setCm(int cm) {
        this.cm = cm;
    }

    public String getInch() {
        return inch;
    }

    public void setInch(String inch) {
        this.inch = inch;
    }
}
