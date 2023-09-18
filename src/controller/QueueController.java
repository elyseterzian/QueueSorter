package controller;

import model.QueueModel;
import view.QueueView;

import javax.swing.*;
import java.awt.*;
import java.util.Stack;

public class QueueController {

    private QueueModel<Integer> model;

    private QueueView view;

    private Stack <QueueModel<Integer>> undoStack = new Stack<>();



    //constructor
    public QueueController(QueueModel<Integer> model, QueueView view){
        this.model = model;
        this.view = view;

        //adding action listener to enqueue button
        view.form.getEnqueueButton().addActionListener(e -> {
            //create variable for text entered in the text field
            String text = view.form.getTextField1().getText();

            //if the user enters no input, notifies them to do so
            if (text.isEmpty()){
                JOptionPane.showMessageDialog(view, "Please enter input.");
                return;
            }
            //if input is not a valid number, notify user
            if (!isValidNumber(text)){
                JOptionPane.showMessageDialog(view, "Input must be a valid integer.");
                return;
            }
            //parsing text string as an int and storing it into variable
            int x = Integer.parseInt(text);

            //make a copy of the queueModel and push it on to the stack
            QueueModel<Integer> copy = makeCopy(model);
            undoStack.push(copy);

            //add element to end of the queue
            model.enqueue(x);

            //Update view to display new queue
            view.form.getQueueContentsLabel().setText(model.toString());
            view.form.getFrontValueLabel().setText(model.peekFront()+"");
            view.form.getRearValueLabel().setText(model.peekRear()+"");



        });
        //adding action listener to dequeue button
        view.form.getDequeueButton().addActionListener(e -> {
            //make copy of current queueModel and push on stack
            QueueModel<Integer> copy = makeCopy(model);
            undoStack.push(copy);

            //Remove front element from queue
            model.dequeue();

            //Update view to display new queue
            view.form.getQueueContentsLabel().setText(model.toString());
            view.form.getFrontValueLabel().setText(model.peekFront()+ "");
            view.form.getRearValueLabel().setText(model.peekRear()+ "");

        });

        //Add action listener to undo button
        view.form.getUndoButton().addActionListener(e -> {
            //Pop previous queue from undo stack
            if (!undoStack.isEmpty()) {
                QueueModel<Integer> newModel = undoStack.pop();

                //clear current queue model
                model.clear();

                //copy elements from previous model to current one
                for (int element : newModel.getWrappedQueue()){
                    model.enqueue(element);
                }

                //Updated view to display new queue
                view.form.getQueueContentsLabel().setText(model.toString());
                view.form.getFrontValueLabel().setText(model.peekFront() + "");
                view.form.getRearValueLabel().setText(model.peekRear() + "");

            } else {
                //if stack is empty, display message to user
                JOptionPane.showMessageDialog(view, "There is nothing to undo.");
            }
        });



    }

    /**
     * Method that makes a copy of the given QueueModel object
     * @param model object to copy
     * @return new model object, same state as the original
     */
    public static QueueModel<Integer> makeCopy (QueueModel<Integer> model){
        return new QueueModel<>(model);
    }

    /**
     * Checks if the given string is a valid integer
     * @param text string to check
     * @return
     */
    public static boolean isValidNumber(String text){
        try {
            int t = Integer.parseInt(text);
            return true;
        }catch (NumberFormatException n){
            return false;
        }
    }


}
