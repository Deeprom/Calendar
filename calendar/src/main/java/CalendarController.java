import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;


public class CalendarController {

    @FXML
    public ComboBox comboBoxMenu;
    @FXML
    public TextField textFieldSearch;
    @FXML
    protected Button buttonEdit;
    @FXML
    protected Button buttonRefresh;
    @FXML
    protected Button buttonSave;
    @FXML
    protected DatePicker datePicker;
    @FXML
    protected TextArea textAreaDetail;
    @FXML
    protected TextArea textAreaRemind;
    @FXML
    protected TextField textFieldTitle;
    @FXML
    protected ComboBox<String> comboBoxRemind;

    private Database database;


    Calendar calendar;
    public CalendarController()
    {
        calendar = new Calendar();
        database = new Database();
//        calendar.setID(database.id);
        System.out.println(database.id+"      data");
//        calendar.addRemind("1","2","3");
        this.install();
        for (int i =0 ;i<calendar.getList().size();i++)
        {
            System.out.println(calendar.getList().get(i).getTitle());
        }
//        database.insert(calendar.id+1,"1","2","3");

    }
    public void install()
    {
//        String[] Event = database.getData().get(0);
        for (int i =0 ;i < database.getData().size();i++)
        {
            int id = Integer.parseInt(database.getData().get(i)[0]);
            String detail = database.getData().get(i)[3];
            String date = database.getData().get(i)[1];
            String title = database.getData().get(i)[2];
            calendar.addRemind(id,date,title);
//            System.out.println(this.textAreaRemind +"                 noel");
//            updateRemindUI(title,date);
        }
    }
    @FXML
    public void clickBtnRemove()
    {
        String a = this.comboBoxRemind.getValue();
//        int b=0;
        for (int i =0;i<this.calendar.getList().size();i++)
        {
            if (a == this.calendar.getList().get(i).getTitle()){
                database.delete(this.calendar.getList().get(i).getId());
//                b = ;
                break;
            }
        }


        this.calendar.deletePoint(a);
        String li="";
        for (int i=0;i<this.calendar.getList().size();i++)
        {
            li += this.calendar.getList().get(i).getTitle()+"  -----"+this.calendar.getList().get(i).getDate()+"\n";
        }
//        this.textAreaRemind.setText(this.textAreaRemind.getText() + "\n" + title + "  -----" + date);
        this.textAreaRemind.setText(li);
        this.comboBoxRemind.getItems().remove(this.comboBoxRemind.getValue().split(" ")[0]);
        this.alertWindow("Remove Complete");
    }
    public void clearField() {
        this.textFieldTitle.setText("");
        this.textAreaDetail.setText("");
    }

    public void alertWindow(String text)
    {
        Stage windo = new Stage();
        StackPane layout = new StackPane();
        layout.getChildren().add(new Label(text));
        layout.setAlignment(Pos.CENTER);
        Scene sc = new Scene(layout);
        windo.setScene(sc);
        windo.setMinWidth(180);
        windo.setMinHeight(100);
        windo.setMaxWidth(180);
        windo.setMaxHeight(100);
        windo.showAndWait();
    }
    public void updateRemindUI(String title,String date)
    {
        if (this.calendar.getList().size()==0)
        {
            this.textAreaRemind.setText(title + "  -----" + date + "\n");
        }
        else {
//            System.out.println(this.textAreaRemind);
            this.textAreaRemind.setText(this.textAreaRemind.getText() + "\n" + title + "  -----" + date);
        }
        this.comboBoxRemind.getItems().add(title);
    }
    @FXML
    public void clickBtnSave() {
        String detail = this.textAreaDetail.getText();
        String title = this.textFieldTitle.getText();
        String date = this.datePicker.getValue()+"";
        if (!this.calendar.isSame(title))
        {
            this.database.insert(calendar.id,date,title);
            this.calendar.addRemind(calendar.id,date,title);
            updateRemindUI(title,date);
//            if (this.calendar.getList().size()==0)
//            {
//                this.textAreaRemind.setText(title + "  -----" + date + "\n");
//            }
//            else {
//                this.textAreaRemind.setText(this.textAreaRemind.getText() + "\n" + title + "  -----" + date);
//            }
//            this.comboBoxRemind.getItems().add(title);
            this.clearField();
            this.alertWindow("Save Complete");
        }
        else
        {
            int a = this.calendar.findIndex(this.comboBoxRemind.getValue());
            Remind re = this.calendar.getList().get(a);
            System.out.println(detail);
            database.edit(re.getId(),detail,title,date);
            this.calendar.modify(date,title,detail);
            this.alertWindow("Modify Complete");

        }
    }
    @FXML
    public void refreshAction() {
        for (int i =0;i<calendar.getList().size();i++)
        {
            String title = calendar.getList().get(i).getTitle();
            String date = calendar.getList().get(i).getDate();

            if (!this.comboBoxRemind.getItems().contains(calendar.getList().get(i).getTitle())) {
                if (this.calendar.getList().size()==0)
                {
                    this.textAreaRemind.setText(title + "  -----" + date + "\n");
                }

                else {
//            System.out.println(this.textAreaRemind);
                    this.textAreaRemind.setText(this.textAreaRemind.getText() + "\n" + title + "  -----" + date);
                }
                this.comboBoxRemind.getItems().add(calendar.getList().get(i).getTitle());
            }
        }
//        if (this.calendar.getList().size()==0)
//        {
//            this.textAreaRemind.setText(title + "  -----" + date + "\n");
//        }
//        else {
////            System.out.println(this.textAreaRemind);
//            this.textAreaRemind.setText(this.textAreaRemind.getText() + "\n" + title + "  -----" + date);
//        }
//        this.comboBoxRemind.getItems().add(title);
    }
    @FXML
    public void clickBtnEdit() {
        int a = this.calendar.findIndex(this.comboBoxRemind.getValue());
        Remind re = this.calendar.getList().get(a);

//        this.textAreaDetail.setText(re.getDetail());
        this.textFieldTitle.setText(re.getTitle());
    }

}