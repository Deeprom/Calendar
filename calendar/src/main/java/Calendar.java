import java.util.ArrayList;

public class Calendar {

    public ArrayList<Remind> list;
    int id=1;
    public Calendar()
    {
        list = new ArrayList<Remind>();
    }
    public void addRemind(int id,String date,String title)
    {
//        id ++;
//        System.out.println("Caledar class      id : "+this.id);
        list.add(new Remind(id,date,title));
        this.id ++;

    }
    public void deletePoint(String a)
    {
        list.remove(this.findIndex(a));
    }
    public ArrayList<Remind> getList()
    {
        return this.list;
    }

    public void modify(String date,String title ,String detail)
    {
        this.getList().get(this.findIndex(title)).setDate(date);
//        this.getList().get(this.findIndex(title)).setDetail(detail);
    }
    public void setID(int id){
        this.id =id;
    }
    public boolean isSame(String a)
    {
        for (int i=0;i<this.getList().size();i++)
        {
            if (this.getList().get(i).getTitle().equals(a))
            {
                return true;
            }
        }
        return false;
    }
    public int findIndex(String a)
    {
        int index=-99;
//        System.out.println(Event);
//        System.out.println(this.list);
        for (int i=0;i<this.list.size();i++)
        {
            if (this.list.get(i).getTitle().equals(a))
            {
                index = i;
            }
        }


        return index;
    }

}
