import controller.QueueController;
import model.QueueModel;
import view.QueueView;

public class App {
    public static void main(String[] args) {
        QueueModel<Integer> model = new QueueModel<>();

        QueueView view = new QueueView();

        QueueController controller = new QueueController(model, view);

        view.setVisible(true);

    }
}
