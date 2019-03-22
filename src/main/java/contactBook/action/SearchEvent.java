package contactBook.action;

import contactBook.Manager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchEvent implements ActionListener {
    private JTextField textField;
    private JTextArea textArea;

    public SearchEvent(JTextField field, JTextArea area){
        textArea = area;
        textField = field;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String name = textField.getText();
        Manager manager= Manager.createManagerInst();
        String srchResult = manager.surchData(name);
        if(srchResult == null) {
            textArea.append("Search Failed: info does not exist.\n");
        }
        else {
            textArea.append("Search Completed:\n");
            textArea.append(srchResult);
            textArea.append("\n");
        }
    }
}
