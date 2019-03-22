package contactBook.action;


import contactBook.Manager;
import contactBook.model.PhoneData;
import contactBook.model.PhoneUInfo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddEvent implements ActionListener {
    JTextField name;
    JTextField phone;
    JTextField year;
    JTextArea text;
    PhoneData data;
    boolean isAdded;

    public AddEvent(JTextField nameField, JTextField phoneField, JTextField yearField, JTextArea textArea){
        name = nameField;
        phone = phoneField;
        year = yearField;
        text = textArea;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Manager manager = Manager.createManagerInst();
        if (year.getText().equals("") == false){
            try {
                Integer.parseInt(year.getText());
                data = new PhoneUInfo(name.getText(),phone.getText(), Integer.parseInt(year.getText()));
                isAdded = manager.infoStorage.add(data);
            } catch (NumberFormatException ex) {
                text.append("Not correct year\n");
            }

        } else {
            data = new PhoneData(name.getText(),phone.getText());
            isAdded = manager.infoStorage.add(data);
        }

        if(isAdded) {
            text.append("Update Completed.\n");
        } else {
            text.append("Update Failed: info already exist.\n");
        }
    }

}
