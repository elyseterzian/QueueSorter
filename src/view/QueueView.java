package view;

import javax.swing.*;

public class QueueView extends JFrame {

    public QueueForm form;

    //constructor, sets up the JFrame
    public QueueView (){
        this.form = new QueueForm();

        JPanel content = form.getMyPanel();

        this.setContentPane(content);

        this.setTitle("Queue GUI");

        this.pack();

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
}
