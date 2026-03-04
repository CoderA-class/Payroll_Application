package Domain;

import java.util.List;

public class JobTitle {

    private  String title;

    private List<Position> positions;
    public JobTitle(){}


    public JobTitle(String title){
        this.title = title;

    }

    public List<Position> getPositions() {
        return positions;
    }

    public void setPositions(List<Position> positions) {
        this.positions = positions;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
