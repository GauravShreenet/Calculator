import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyFrame implements ActionListener{

    JFrame frame;
    JTextField textfield;
    JButton[] numberBtn = new JButton[10];
    JButton[] functionBtn = new JButton[8];
    JButton addBtn, subBtn, mulBtn, divBtn;
    JButton decBtn, equBtn, delBtn, clrBtn;
    JPanel panel;

    Font myFont = new Font("Times New Roman", Font.BOLD,30);

    double num1=0,num2=0,result=0;
    char operator;
    public MyFrame() {

        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);

        textfield = new JTextField();
        textfield.setBounds(50, 25, 300, 50);
        textfield.setFont(myFont);
        frame.add(textfield);


        addBtn = new JButton("+");
        subBtn = new JButton("-");
        mulBtn = new JButton("*");
        divBtn = new JButton("/");
        decBtn = new JButton(".");
        equBtn = new JButton("=");
        delBtn = new JButton("Delete");
        clrBtn = new JButton("Clear");

        functionBtn[0] = addBtn;
        functionBtn[1] = subBtn;
        functionBtn[2] = mulBtn;
        functionBtn[3] = divBtn;
        functionBtn[4] = decBtn;
        functionBtn[5] = equBtn;
        functionBtn[6] = delBtn;
        functionBtn[7] = clrBtn;

        for (int i = 0; i < 8; i++){
            functionBtn[i].addActionListener(this);
            functionBtn[i].setFont(myFont);
            functionBtn[i].setFocusable(false);
        }

        for (int i = 0; i < 10; i++){
            numberBtn[i] = new JButton(String.valueOf(i));
            numberBtn[i].addActionListener(this);
            numberBtn[i].setFont(myFont);
            numberBtn[i].setFocusable(false);
        }

        delBtn.setBounds(50, 430, 145, 50);
        clrBtn.setBounds(205, 430, 145, 50);

        panel = new JPanel();
        panel.setBounds(50, 100, 300,300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));

        panel.add(numberBtn[1]);
        panel.add(numberBtn[2]);
        panel.add(numberBtn[3]);
        panel.add(addBtn);

        panel.add(numberBtn[4]);
        panel.add(numberBtn[5]);
        panel.add(numberBtn[6]);
        panel.add(subBtn);

        panel.add(numberBtn[7]);
        panel.add(numberBtn[8]);
        panel.add(numberBtn[9]);
        panel.add(mulBtn);
        panel.add(decBtn);
        panel.add(numberBtn[0]);
        panel.add(equBtn);
        panel.add(divBtn);

        frame.add(panel);
        frame.add(delBtn);
        frame.add(clrBtn);
        textfield.setEditable(false);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < 10; i++){
            if (e.getSource() == numberBtn[i]){
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
            }
        }

        if (e.getSource() == decBtn){
            textfield.setText(textfield.getText().concat("."));
        }

        if (e.getSource() == addBtn){
            num1 = Double.parseDouble(textfield.getText());
            operator = '+';
            textfield.setText("");
        }

        if (e.getSource() == subBtn){
            num1 = Double.parseDouble(textfield.getText());
            operator = '-';
            textfield.setText("");
        }

        if (e.getSource() == mulBtn){
            num1 = Double.parseDouble(textfield.getText());
            operator = '*';
            textfield.setText("");
        }

        if (e.getSource() == divBtn){
            num1 = Double.parseDouble(textfield.getText());
            operator = '/';
            textfield.setText("");
        }

        if (e.getSource()==equBtn){
            num2 = Double.parseDouble(textfield.getText());

            switch(operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
            }
            textfield.setText(String.valueOf(result));
            num1=result;
        }

        if (e.getSource() == clrBtn){
            textfield.setText("");
        }
        if (e.getSource() == delBtn){
            String s = textfield.getText();
            textfield.setText("");
            for (int i = 0; i<s.length() - 1; i++) {
                textfield.setText(textfield.getText() + s.charAt(i));
            }
        }
    }
}
