package dfq.daomain;

public class Cotton {
    private int id;
    private String project;
    private String drug;
    private String date;
    private String number;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getDrug() {
        return drug;
    }

    public void setDrug(String drug) {
        this.drug = drug;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Cotton{" +
                "id=" + id +
                ", project='" + project + '\'' +
                ", drug='" + drug + '\'' +
                ", date='" + date + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
