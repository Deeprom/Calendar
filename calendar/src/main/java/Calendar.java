import java.util.ArrayList;

public class Calendar {

    public ArrayList<Remind> list;
    public Calendar()
    {
        list = new ArrayList<Remind>();
    }
    public void addRemind(String date,String title,String detail)
    {
        list.add(new Remind(date,title,detail));
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
        this.getList().get(this.findIndex(title)).setDetail(detail);
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
//        System.out.println(a);
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
