package сontactBook.action;

import сontactBook.Manager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteEvent implements ActionListener {
    JTextArea textArea;
    JTextField textField;

    DeleteEvent(JTextField fild, JTextArea area){
        textArea = area;
        textField = fild;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String name = textField.getText();
        Manager manager = Manager.createManagerInst();
        boolean isDelete = manager.deleteData(name);
        if(isDelete){
            textArea.append("Remove Completed.\n");
        }else {
            textArea.append("Remove Failed: info does not exist.\n");
        }
    }
}
