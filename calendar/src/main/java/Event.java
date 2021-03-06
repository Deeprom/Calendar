import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class Event {

    int[][] dayOfMonth = new int[][]{{31}, {29, 28}, {31}, {30}, {31}, {30}, {31}, {31}, {30}, {31}, {30}, {31}};
    Database add = new Database();

    public void submit(ArrayList array, String menu, TextField msg) {

        int day = Integer.parseInt((String) array.get(3)); //day
        int month = Integer.parseInt((String) array.get(2)); //month
        int year = Integer.parseInt((String) array.get(1)); // year
        int countmonth;

        if ((!array.isEmpty() && menu.equals(""))) {
            String date = (String) array.get(0);
            String text = new String(msg.getText());
            array.add(text);
            int id = add.getCreateID();
            System.out.println(array.get(0));
            add.insert(id, date, text);


        } else if (menu.equals("Daily")) {
            if (month != 2) {
                for (int i = day; i <= dayOfMonth[month - 1][0]; i++) {
                    String date = year + "/" + array.get(2) + "/" + i;
                    int id = add.getCreateID();
                    String text = new String(msg.getText());
                    add.insert(id, date, text);
                }
            } else {
                if ((year % 4 == 0 && (!(year % 100 == 0))) || year % 400 == 0) {
                    for (int i = day; i <= dayOfMonth[1][0]; i++) {
                        String date = year + "/" + array.get(2) + "/" + i;
                        int id = add.getCreateID();
                        String text = new String(msg.getText());
                        add.insert(id, date, text);
                    }
                } else {
                    for (int i = day; i <= dayOfMonth[1][1]; i++) {
                        String date = year + "/" + array.get(2) + "/" + i;
                        int id = add.getCreateID();
                        String text = new String(msg.getText());
                        add.insert(id, date, text);
                    }
                }
            }

        } else if (menu.equals("Weekly")) {
            for (int i = month; i <= 12; i++) { //count month
                if (i != 2) {
                    countmonth = dayOfMonth[i - 1][0];
                } else {
                    if ((year % 4 == 0 && (!(year % 100 == 0))) || year % 400 == 0) {
                        countmonth = dayOfMonth[1][0];
                    } else {
                        countmonth =dayOfMonth[1][1];
                    }
                }
                for (int j = day; j <= countmonth; j += 7) {  //week
                    if (j + 7 > countmonth) {
                        day = j + 7 - countmonth;
                        String date = array.get(1) + "/" + i + "/" + j;
                        int id = add.getCreateID();
                        String text = new String(msg.getText());
                        add.insert(id, date, text);
                        break;
                    } else if (j + 7 <= countmonth) {
                        String date = array.get(1) + "/" + i + "/" + j;
                        int id = add.getCreateID();
                        String text = new String(msg.getText());
                        add.insert(id, date, text);
                    }
                }
            }
        } else if (menu.equals("Monthly")) {
            for (int i = month; i <= 12; i++) {
                if (i == 2 && day > 29){
                    continue;
                }
                else if (i == 2 && day <= 29){
                    if ((year%4==0 && year%100!=0)||year%400==0){
                        String date = year + "/" + i + "/" + day;
                        int id = add.getCreateID();
                        String text = new String(msg.getText());
                        add.insert(id, date, text);
                    }
                    else if (day < 29){
                        String date = year + "/" + i + "/" + day;
                        int id = add.getCreateID();
                        String text = new String(msg.getText());
                        add.insert(id, date, text);
                    }
                }
                else {
                    String date = year + "/" + i + "/" + day;
                    int id = add.getCreateID();
                    String text = new String(msg.getText());
                    add.insert(id, date, text);
                }

            }
        }
    }

}
