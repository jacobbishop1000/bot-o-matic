public class Task {

    private String description;
    private int eta;

    public Task(String description, int eta){
        this.description=description;
        this.eta=eta;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getEta() {
        return eta;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }
}
