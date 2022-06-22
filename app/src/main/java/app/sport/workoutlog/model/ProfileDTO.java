package app.sport.workoutlog.model;

public class ProfileDTO {
    private String name;
    private String sportkind;
    private  String nextLesson;
    private String groupName;
    private String abonement_time;
    private String price;

    public String getName() {
        return name;
    }

    public String getSportkind() {
        return sportkind;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSportkind(String sportkind) {
        this.sportkind = sportkind;
    }

    public String getNextLesson() {
        return nextLesson;
    }

    public void setNextLesson(String nextLesson) {
        this.nextLesson = nextLesson;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getAbonement_time() {
        return abonement_time;
    }

    public void setAbonement_time(String abonement_time) {
        this.abonement_time = abonement_time;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
