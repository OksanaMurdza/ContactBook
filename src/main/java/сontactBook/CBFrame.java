package сontactBook;

import сontactBook.action.AddEvent;
import сontactBook.action.DeleteEvent;
import сontactBook.action.SearchEvent;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class CBFrame extends JFrame {
    JTextField srchField = new JTextField(15);
    JButton srchBtn = new JButton("SEARCH");
    JButton addBtn = new JButton("ADD");
    JRadioButton rbtn1 = new JRadioButton("General");
    JRadioButton rbtn2 = new JRadioButton("University");
    ButtonGroup buttonGroup = new ButtonGroup();

    JLabel nameLabel = new JLabel("NAME");
    JTextField nameField = new JTextField(15);
    JLabel phoneLabel = new JLabel("PHONE NUMBER");
    JTextField phoneField = new JTextField(15);
    JLabel yearLabel = new JLabel("YEAR");
    JTextField yearField = new JTextField(15);

    JTextField delField = new JTextField(15);
    JButton delBtn = new JButton("DEL");

    JTextArea textArea = new JTextArea(10, 25);

    public CBFrame(String title){
        super(title);
        setBounds(100, 200, 330, 450);
        setSize(730,350);
        setLayout(new GridLayout(0,2,0,0));
        Border border = BorderFactory.createEtchedBorder();


        Border srchBorder = BorderFactory.createTitledBorder(border,"Search");
        JPanel srchPanel = new JPanel();
        srchPanel.setBorder(srchBorder);
        srchPanel.setLayout(new FlowLayout());
        srchPanel.add(srchField);
        srchPanel.add(srchBtn);

        Border addBorder = BorderFactory.createTitledBorder(border,"ADD");
        JPanel addPanel = new JPanel();
        addPanel.setBorder(addBorder);
        addPanel.setLayout(new FlowLayout());

        JPanel addInputPanel = new JPanel();
        addInputPanel.setLayout(new GridLayout(0,2,5,5));

        buttonGroup.add(rbtn1);
        buttonGroup.add(rbtn2);

        addPanel.add(rbtn1);
        addPanel.add(rbtn2);
        addPanel.add(addBtn);

        addInputPanel.add(nameLabel);
        addInputPanel.add(nameField);
        addInputPanel.add(phoneLabel);
        addInputPanel.add(phoneField);
        addInputPanel.add(yearLabel);
        addInputPanel.add(yearField);

        yearLabel.setVisible(false);
        yearField.setVisible(false);

        rbtn1.setSelected(true);
        addPanel.add(addInputPanel);

        rbtn1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED){
                    yearLabel.setVisible(false);
                    yearField.setVisible(false);
                    yearField.setText("");
                }
            }
        });

        rbtn2.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED){
                    yearLabel.setVisible(true);
                    yearField.setVisible(true);
                }
            }
        });

        Border deleteBorder = BorderFactory.createTitledBorder(border,"Delete");
        JPanel delPanel = new JPanel();
        delPanel.setBorder(deleteBorder);
        delPanel.setLayout(new FlowLayout());
        delPanel.add(delField);
        delPanel.add(delBtn);

        JScrollPane scrollPane = new JScrollPane(textArea);
        Border txtBorder = BorderFactory.createTitledBorder(border,"Iformation Border");
        ((TitledBorder) srchBorder).setBorder(txtBorder);

        JPanel actionPanel = new JPanel();
        actionPanel.setLayout(new BorderLayout());
        actionPanel.add(srchPanel, BorderLayout.NORTH);
        actionPanel.add(addPanel, BorderLayout.CENTER);
        actionPanel.add(delPanel, BorderLayout.SOUTH);

        add(actionPanel);
        add(scrollPane);

        srchBtn.addActionListener(new SearchEvent(srchField, textArea));
        addBtn.addActionListener(new AddEvent(nameField, phoneField, yearField, textArea));
        delBtn.addActionListener(new DeleteEvent(delField, textArea));

        setVisible(true);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

}
