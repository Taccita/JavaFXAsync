package javafxasync;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ListChangeListener;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

public class GridPaneController implements Initializable {
    @FXML private TextField pathId;
    @FXML private TextField endId;
    @FXML private ProgressBar barId;
    @FXML private ListView<String> listId;
    public static Task<Void>task;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        JavaFXAsync.items.addListener((ListChangeListener) obj -> listId.setItems(obj.getList()));
    } 
    
    @FXML
    protected void btnFindClick(ActionEvent event) {
        String path=pathId.getText();
        String end =endId.getText();
        task= new FindTask(JavaFXAsync.items, path, end);
        barId.setProgress(task.getProgress());
       JavaFXAsync.items.clear();
        //barId.setProgress(-1);
		//код для выполнения асинхронной задачи
        Thread thread=new Thread(task);
        thread.setDaemon(true);
        thread.start();


        //barId.setProgress(1);
    }
    
    @FXML
    protected void btnCancelClick(ActionEvent event) {
        if (task!=null){  task.cancel(true);
        System.out.println("Try to Cancel!");}
    }
}
