import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;



public class Controller {

    @FXML
    protected Button buttonEdit;

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



    Calendar calendar;
    public Controller()
    {
        calendar = new Calendar();
    }

    @FXML
    public void clickBtnRemove()
    {
        this.calendar.deletePoint(this.comboBoxRemind.getValue());
        String li="";
        for (int i=0;i<this.calendar.getList().size();i++)
        {
            li += this.calendar.getList().get(i).getTitle()+"\n";
        }
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
    @FXML
    public void clickBtnSave() {
        String detail = this.textAreaDetail.getText();
        String title = this.textFieldTitle.getText();
        String date = this.datePicker.getValue()+"";
        if (!this.calendar.isSame(title))
        {
            this.calendar.addRemind(date,title,detail);
            if (this.calendar.getList().size()==0)
            {
                this.textAreaRemind.setText(title + "  -----" + date + "\n");
            }
            else {
                this.textAreaRemind.setText(this.textAreaRemind.getText() + "\n" + title + "  -----" + date);
            }
            this.comboBoxRemind.getItems().add(title);
            this.clearField();
            this.alertWindow("Save Complete");
        }
        else
        {
            this.calendar.modify(date,title,detail);
            this.alertWindow("Modify Complete");

        }


    }
    @FXML
    public void clickBtnEdit() {
        Remind re = this.calendar.getList().get(this.calendar.findIndex(this.comboBoxRemind.getValue()));
        this.textAreaDetail.setText(re.getDetail());
        this.textFieldTitle.setText(re.getTitle());
    }

}