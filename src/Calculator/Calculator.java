/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package calculator;


/**
 *
 * @author sree
 */
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author sree
 */
public class Calculator {

    JButton display;
    JPanel panel;
    double result;
    String lastCommand;

    boolean start;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                CalculatorFrame frame = new CalculatorFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }

        });
    }

}

class CalculatorFrame extends JFrame {

    public CalculatorFrame() {
        setTitle("Calculator");
        CalculatorPanel panel = new CalculatorPanel();
        add(panel);
        pack();
    }
}

class CalculatorPanel extends JPanel {

    public CalculatorPanel() {
        setLayout(new BorderLayout());
        result = 0;
        lastCommand = "=";
        start = true;

        display = new JButton("0");
        display.setEnabled(false);
        add(display, BorderLayout.NORTH);
        ActionListener insert = new InsertAction();
        ActionListener command = new CommandAction();

        panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4));

        addButton("9", insert);
        addButton("8", insert);
        addButton("7", insert);
        addButton("/", insert);
        addButton("^", insert);

        addButton("6", insert);
        addButton("5", insert);
        addButton("4", insert);
        addButton("*", insert);
        addButton("$", insert);

        addButton("3", insert); 
        addButton("2", insert);
        addButton("1", insert);
        addButton("-", insert);
        addButton("(", insert);

        addButton("0", insert);
        addButton(".", insert);
        addButton("=", command);
        addButton("+", insert);
        addButton(")", insert);

        add(panel, BorderLayout.CENTER);
    }

    private void addButton(String label, ActionListener listener) {
        JButton button = new JButton(label);
        button.addActionListener(listener);
        panel.add(button);
    }

    private class InsertAction implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            String input = event.getActionCommand();
            if (start) {
                display.setText(input);
                start = false;
            } else {
                display.setText(display.getText() + input);
                fullexpression = display.getText();
            }
        }
    }

    private class CommandAction implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            System.out.println("the entire expression is " + fullexpression);
            fullexpression = fullexpression + "=";
            createstack(cal,fullexpression);
            display.setText("");
            finalcalculation(cal);

        }
    }

    public void finalcalculation(ArrayList<String> cal) {
        String value;
        int temp = cal.size();
        int i = 0;
        // while () {
        while (i < cal.size()) {
            value = cal.get(i);
            System.out.println("the value is " + value);
            System.out.println("it is working properly");
            if (value == null) {
                i++;
            }
//            else if (operatorchecker("(")) {
//              ArrayList<String> calsub = new ArrayList<String>();
//               String fullexpression1="";
//                int d= operatorcheckerpos(")");
//                int j=i;
//                while(j<d)
//                {
//                fullexpression1 = cal.get(j)+fullexpression1;
//                cal.set(j,null);
//                j++;
//                }
//                createstack(calsub,fullexpression1);
//                finalcalculation(calsub);
//                String temp1 = getnext(calsub,0);
//                cal.set(i,temp1);
//                i++;
//            }
            else if (operatorchecker("^")) {
                String prev = getprevious(cal, dpos - 1);
                String next = getnext(cal, dpos + 1);
                System.out.println("the previous and the next values are"
                        + prev + "\t" + next);
                Double d = pow(Double.valueOf(prev),Integer.parseInt(next));
                cal.set(dpos, String.valueOf(d));
                System.out.println("the inserted value is " + cal.get(dpos));
                cal.set(getprevious(dpos - 1), null);
                cal.set(getnext(dpos + 1), null);
                i++;
            }else if (operatorchecker("$")) {
                String next = getnext(cal, dpos + 1);
                System.out.println("the next values are"
                        +  "\t" + next);
                Double d = sqrt(Double.parseDouble(next));
                cal.set(dpos, String.valueOf(d));
                System.out.println("the inserted value is " + cal.get(dpos));
                cal.set((dpos + 1), null);
            i++;
            }
            else if (operatorchecker("/")) {
                String prev = getprevious(cal, dpos - 1);
                String next = getnext(cal, dpos + 1);
                System.out.println("the previous and the next values are"
                        + prev + "\t" + next);
                Double d = Double.valueOf(prev) / Double.valueOf(next);
                cal.set(dpos, String.valueOf(d));
                System.out.println("the inserted value is " + cal.get(dpos));
                cal.set(getprevious(dpos - 1), null);
                cal.set(getnext(dpos + 1), null);
                i++;
            } else if (operatorchecker("*")) {
                String prev = getprevious(cal, dpos - 1);
                String next = getnext(cal, dpos + 1);
                System.out.println("the previous and the next values are"
                        + prev + "\t" + next);
                Double d = Double.valueOf(prev) * Double.valueOf(next);
                cal.set(dpos, String.valueOf(d));
                System.out.println("the inserted value is " + cal.get(dpos));
                cal.set(getprevious(dpos - 1), null);
                cal.set(getnext(dpos + 1), null);
                i++;
            }  else if (operatorchecker("+")) {
                String prev = getprevious(cal, dpos - 1);
                String next = getnext(cal, dpos + 1);
                System.out.println("the previous and the next values are"
                        + prev + "\t" + next);
                Double d = Double.valueOf(prev) + Double.valueOf(next);
                cal.set(dpos, String.valueOf(d));
                System.out.println("the inserted value is " + cal.get(dpos));
                cal.set(getprevious(dpos - 1), null);
                cal.set(getnext(dpos + 1), null);
                i++;
            } else if (operatorchecker("-")) {
                String prev = getprevious(cal, dpos - 1);
                String next = getnext(cal, dpos + 1);
                System.out.println("the previous and the next values are"
                        + prev + "\t" + next);
                Double d = Double.valueOf(prev) - Double.valueOf(next);
                cal.set(dpos, String.valueOf(d));
                System.out.println("the inserted value is " + cal.get(dpos));
                cal.set(getprevious(dpos - 1), null);
                cal.set(getnext(dpos + 1), null);
                i++;
            } 
            else {
                i++;
            }
            // }
            // }
        }
        // display.setText("");
        System.out.println("the size of the array list is " + cal.size());
        display.setText(getnext(cal, 0));

    }

    public String getnext(ArrayList<String> cal, int i) {
        while (i <= cal.size()) {
            if (cal.get(i) != null && cal.get(i) != "=") {
                nextpos = i;
                return cal.get(i);
            }
            i++;
        }
        return null;
    }

    public int getnext(int i) {
        while (i <= cal.size()) {
            if (cal.get(i) != null && cal.get(i) != "=") {
                nextpos = i;
                return i;
            }
            i++;
        }
        return 0;
    }

    public String getprevious(ArrayList<String> cal, int i) {
        while (i >= 0) {
            if (cal.get(i) != null && cal.get(i) != "=") {
                prevpos = i;
                return cal.get(i);
            }
            i--;
        }
        return null;
    }

    public int getprevious(int i) {
        while (i >= 0) {
            if (cal.get(i) != null && cal.get(i) != "=") {
                prevpos = i;
                return i;
            }
            i--;
        }
        return 0;
    }

    public Boolean operatorchecker(String operator) {
        int j = 0;
        while (j < cal.size()) {
            if (cal.get(j) == null) {
                j++;
            } else if (cal.get(j).equals(operator)) {
                dpos = j;
                return true;
            } else {
                j++;
            }

        }
        return false;
    }
    public int operatorcheckerpos(String operator) {
        int j = 0;
        while (j < cal.size()) {
            if (cal.get(j) == null) {
                j++;
            } else if (cal.get(j).equals(operator)) {
               
                return j;
            } else {
                j++;
            }

        }
        return 0;
    }

    public void createstack(ArrayList<String> cal1,String fullexpression) {
        fullexpressionLength = fullexpression.length();
        
        System.out.println("the size of expression" + fullexpressionLength);
        while (i < fullexpressionLength) {
            charat = fullexpression.charAt(i);
           if(charat=='(' )
           {
               cal1.add(String.valueOf(charat));
                System.out.println("the operator is " + charat);
                       i++;
           }
//           if(charat=='$' )
//           {
//               cal1.add(String.valueOf(charat));
//                System.out.println("the operator is " + charat);
//                       i++;
//           }
           
            else if (charat == '+' || charat == '-' || charat == '*'
                    || charat == '/' || charat == '='|| charat==')'||charat=='^') {
                
                
                //Boolean temp = endbracketchecker;
                //if(charat==')')
                //{
                //endbracketchecker = true;
                //}
                //else
                //{
                //endbracketchecker = false;
                //}
                if(concat!="")
                {
                cal1.add(concat);
                }
                // if(charat!='=')
                cal1.add(String.valueOf(charat));
                System.out.println("the value entered is " + concat);
                System.out.println("the operator is " + charat);
                concat = "";
                i++;
            } else {
                concat = concat + String.valueOf(charat);
                i++;
            }
        }
        System.out.println("the size of arraylist" + cal1.size());

    }

    private int dpos;
    private String concat = "";
    private char charat;
    private JButton display;
    private JPanel panel;
    private double result;
    private String lastCommand;
    private Boolean start;
    private String fullexpression;
    private int fullexpressionLength;
    private int i = 0;
    private int prevpos;
    private int nextpos;
    private ArrayList<String> cal = new ArrayList<String>();
    Boolean endbracketchecker ;
}