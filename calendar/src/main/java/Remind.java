public class Remind {



    String date;
    String title;
    String detail;
    public Remind(String date,String title,String detail)
    {
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
