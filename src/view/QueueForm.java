package view;

import javax.swing.*;

public class QueueForm {
    private JLabel queueContentsLabel;

    private JTextField textField1;
    private JButton enqueueButton;
    private JPanel myPanel;
    private JButton dequeueButton;
    private JLabel frontValueLabel;
    private JLabel rearValueLabel;
    private JButton undoButton;
    private JLabel frontLabel;
    private JLabel rearLabel;

    public JLabel getFrontValueLabel() {
        return frontValueLabel;
    }

    public JLabel getRearValueLabel() {
        return rearValueLabel;
    }

    public JLabel getQueueContentsLabel() {
        return queueContentsLabel;
    }

    public JTextField getTextField1() {
        return textField1;
    }

    public JButton getEnqueueButton() {
        return enqueueButton;
    }

    public JPanel getMyPanel() {
        return myPanel;
    }

    public JButton getDequeueButton() {
        return dequeueButton;
    }

    public JButton getUndoButton() {
        return undoButton;
    }

    public JLabel getFrontLabel() {
        return frontLabel;
    }

    public JLabel getRearLabel() {
        return rearLabel;
    }

}
