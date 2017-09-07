public class Remind {



    String date;
    String title;
    String detail;
    int id;
    public Remind(int id,String date,String title,String detail)
    {
        this.id = id;
        this.date = date;
        this.title = title;
        this.detail = detail;
    }
    public void setDetail(String detail)
    {
        this.detail=detail;
    }
    public void setDate(String date)
    {
        this.date = date;
    }
    public int getId()
    {
        return this.id;
    }
    public String getDetail()
    {
        return this.detail;
    }
    public String getDate()
    {
        return this.date;
    }
    public String getTitle()
    {
        return this.title;
    }
}
