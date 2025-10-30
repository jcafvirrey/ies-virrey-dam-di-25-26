public class Course {
    private int id;
    private String title;
    private int hours;
    private String modality; // "ONLINE" | "PRESENTIAL"

    public Course(int id, String title, int hours, String modality) {
        this.id = id;
        this.title = title;
        this.hours = hours;
        this.modality = modality;
    }

    public Course(String title, int hours, String modality) {
        this(0, title, hours, modality);
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public int getHours() { return hours; }
    public String getModality() { return modality; }

    public void setId(int id) { this.id = id; }
    public void setTitle(String title) { this.title = title; }
    public void setHours(int hours) { this.hours = hours; }
    public void setModality(String modality) { this.modality = modality; }

    @Override
    public String toString() {
        return "Course{id=" + id + ", title='" + title + '\'' +
                ", hours=" + hours + ", modality=" + modality + '}';
    }
}
