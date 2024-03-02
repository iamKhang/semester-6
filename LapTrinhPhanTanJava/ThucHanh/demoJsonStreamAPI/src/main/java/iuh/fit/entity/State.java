package iuh.fit.entity;

public class State {
    private long id;
    private String stateName;
    private String abbreviation;
    private String capital;
    private int statehood;

    public State() {
    }

    public State(long id, String stateName, String abbreviation, String capital, int statehood) {
        this.id = id;
        this.stateName = stateName;
        this.abbreviation = abbreviation;
        this.capital = capital;
        this.statehood = statehood;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public int getStatehood() {
        return statehood;
    }

    public void setStatehood(int statehood) {
        this.statehood = statehood;
    }

    @Override
    public String toString() {
        return String.format("%-20s%-10s%-20s%-10d", stateName, abbreviation, capital, statehood);
    }
}
