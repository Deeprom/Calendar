public class Remind {

    public String date;
    public String title;
    public String detail;
    public int id;
    public Remind(int id, String date, String title)
    {
        this.id = id;
        this.date = date;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public String getDate() {

        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
