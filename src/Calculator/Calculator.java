

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Calculator;

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
import java.util.List;

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
    int c;

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
        ActionListener clear = new ClearAction();
        ActionListener clear1 = new Clear();
        

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
        addButton("c", clear);

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
        addButton("<-",clear1); 
        add(panel, BorderLayout.CENTER);
    }

    private void addButton(String label, ActionListener listener) {
        JButton button = new JButton(label);
        button.addActionListener(listener);
        panel.add(button);
    }

    

    private class InsertAction implements ActionListener  {

        public void actionPerformed(ActionEvent event) {
            String input = event.getActionCommand();
            if(display.getText()=="ERROR")
            {
            display.setText("");
            }
            if (start) {
                display.setText(input);
                start = false;
            } else {
                display.setText(display.getText() + input);
                fullexpression = display.getText();
            }
        }
    }
    
    public class ClearAction implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
          //  cal1.removeAll(cal1);
            display.setText("");
        }
    
    }
    public class Clear implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
           String clipped  = display.getText().substring(0,display.getText().length()-1);
           //substring(0,display.getText().length()-1);
            display.setText(clipped);
          //x  display.setText(display.);
        }
    
    }

    public class CommandAction implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            System.out.println("the entire expression is " + fullexpression);
            fullexpression = fullexpression + "=";
            createstack(cal1, fullexpression);
            createstack(validation, fullexpression);
            validation();    
            display.setText("");
            if(finalcalculation(cal1)==null)
            {
            display.setText("ERROR");
            }
            else
            {
            display.setText(getnext(finalcalculation(cal1), 0));
                    cal1.removeAll(cal1);
      
             }
                    }

        private void validation() {
        if(fullexpression.length()<4)
            {
            display.setText("Error");
            }
          //  else  if(cal)
         
            
        }
    }

public List<String> finalcalculation(List<String> cal)  {
        List<String> tempvalue = new ArrayList<String>();
        List<String> tempvalue1 = new ArrayList<String>();
        String value;
        int c = 0;
        int temp = cal.size();
        int i = 0;
        int j = 0;
        int one = 0;
        int zero = 0;
        Boolean te = true;
        int tempval = 0;
        System.out.println("new list created ");

        int k = i;

        i = 0;
        while (i < cal.size()) {
            value = cal.get(i);
            while (k < cal.size()) {
                value = cal.get(k);
                System.out.println("the value is " + value + " and the position is " + k);
                System.out.println("it is working properly");
                k++;
            }
            try
            {
            if (value == null || value == "=") {
                i++;
            } else if (operatorchecker("(", cal)) {
                System.out.println("there are brackets present and the current temp value " + tempval + "and its position " + j);
                j = i;
                te = true;
                while (te) {
                    if (cal.get(j).equals("(")) {
                       
                        if(bracketchecker(cal)==false)
                       {
                         return null;  
                       }
                       String prev = getprevious(cal, dpos - 1);
                       String next = getnext(cal, dpos + 1);
                        // validation is wrong
                      if(prev==")"||next==")"||next=="*"||next=="+"||next=="-"||next=="/"||next=="^")
                       {
                       return null;
                       }
                        if (tempval == 0) {
                            one = j;
                            System.out.println("value saved");
                        }
                        tempval++;
                        System.out.println("opening braces found and the tempvalue is " + tempval + "its position " + j);
                        j++;

                    } else if (cal.get(j).equals(")")) {
                         String prev = getprevious(cal, dpos - 1);
                       String next = getnext(cal, dpos + 1);
                      
                        if(prev=="("||prev=="*"||prev=="+"||prev=="-"||prev=="/"||prev=="^"||next=="(")
                        {
                        return null;
                        }
                        tempval--;
                        System.out.println("closing braces found and the tempvalue is  " + tempval + "its position" + j);

                        if (tempval == 0) {
                            zero = j;
                            te = false;
                        }
                        j++;
                    } else {
                        System.out.println("value or an operator found the position is  " + j + " the value is" + cal.get(j));
                        j++;
                    }

                }
                // one =j;
                // System.out.println("the size of the list is "+cal.size());
                System.out.println("the start and end position of the sub list" + (one + 1) + (zero - 1));
                c = one + 1;
                int q = 0;
                while (q < tempvalue.size()) {
//                    if(cal.get(d)==")")
//                    tempval--;
                    tempvalue.set(q, null);
                    q++;
                }
                while (c <= zero - 1) {
                    if (c != zero) {
                        tempvalue.add(cal.get(c));
                        c++;

                    } else {
                        tempvalue.add("=");
                        c++;

                    }
                }
                tempvalue1 = finalcalculation(tempvalue);
                String temp2 = getnext(tempvalue1, 0);
                k = 0;
                while (k < tempvalue.size()) {
                    value = tempvalue.get(k);

                    System.out.println("the value is " + value + " and the position is " + k);
                    k++;

                }
                k = 0;
                while (k < cal.size()) {
                    value = cal.get(k);
                    System.out.println("the value is " + value + " and the position is " + k);
                    k++;
                }
                System.out.println("the value inserted is " + temp2);
                int d = one + 1;
                while (d <= zero) {
                    cal.set(d, null);
                    d++;
                }
                k = 0;
                cal.set(one, temp2);
                while (k < cal.size()) {
                    value = cal.get(k);
                    System.out.println("the value is " + value + " and the position is " + k);
                    k++;
                }

                i++;
            } else if (operatorchecker("^", cal)) {
                String prev = getprevious(cal, dpos - 1);
                String next = getnext(cal, dpos + 1);
                if(prev=="("||prev=="*"||prev=="+"||prev=="-"||prev=="/"||prev=="^"||next==")"||next=="*"||next=="+"||next=="-"||next=="/"||next=="^")
                {
                return null;
                }
                    System.out.println("the previous and the next values are"
                        + prev + "\t" + next);
                Double d = pow(Double.valueOf(prev), Integer.parseInt(next));
                cal.set(dpos, String.valueOf(d));
                System.out.println("the inserted value is " + cal.get(dpos));
                cal.set(getprevious(dpos - 1, cal), null);
                cal.set(getnext(dpos + 1, cal), null);
                i++;
            } else if (operatorchecker("$", cal)) {
                String next = getnext(cal, dpos + 1);
                System.out.println("the next values are"
                        + "\t" + next);
                Double d = sqrt(Double.parseDouble(next));
                cal.set(dpos, String.valueOf(d));
                System.out.println("the inserted value is " + cal.get(dpos));
                cal.set((dpos + 1), null);
                i++;
            } else if (operatorchecker("/", cal)) {
                String prev = getprevious(cal, dpos - 1);
                String next = getnext(cal, dpos + 1);
                if(prev=="("||prev=="*"||prev=="+"||prev=="-"||prev=="/"||prev=="^"||next==")"||next=="*"||next=="+"||next=="-"||next=="/"||next=="^")
                {
                return null;
                }
                System.out.println("the previous and the next values are"
                        + prev + "\t" + next);
                Double d = Double.valueOf(prev) / Double.valueOf(next);
                cal.set(dpos, String.valueOf(d));
                System.out.println("the inserted value is " + cal.get(dpos));
                cal.set(getprevious(dpos - 1, cal), null);
                cal.set(getnext(dpos + 1, cal), null);
                i++;
            } else if (operatorchecker("*", cal)) {
                String prev = getprevious(cal, dpos - 1);
                String next = getnext(cal, dpos + 1);
                if(prev=="("||prev=="*"||prev=="+"||prev=="-"||prev=="/"||prev=="^"||next==")"||next=="*"||next=="+"||next=="-"||next=="/"||next=="^")
                {
                return null;
                }
                System.out.println("the previous and the next values are"
                        + prev + "\t" + next);
                Double d = Double.valueOf(prev) * Double.valueOf(next);
                cal.set(dpos, String.valueOf(d));
                System.out.println("the inserted value is " + cal.get(dpos));
                cal.set(getprevious(dpos - 1, cal), null);
                cal.set(getnext(dpos + 1, cal), null);
                i++;
            } else if (operatorchecker("+", cal)) {

                String prev = getprevious(cal, dpos - 1);
                String next = getnext(cal, dpos + 1);
                if(prev=="("||prev=="*"||prev=="+"||prev=="-"||prev=="/"||prev=="^"||next==")"||next=="*"||next=="+"||next=="-"||next=="/"||next=="^")
                {
                return null;
                }
                System.out.println("the previous and the next values are"
                        + prev + "\t" + next);
                Double d = Double.valueOf(prev) + Double.valueOf(next);
                cal.set(dpos, String.valueOf(d));
                System.out.println("the inserted value is " + cal.get(dpos));
                cal.set(getprevious(dpos - 1, cal), null);
                cal.set(getnext(dpos + 1, cal), null);
                i++;
            } else if (operatorchecker("-", cal)) {
                String prev = getprevious(cal, dpos - 1);
                String next = getnext(cal, dpos + 1);
                if(prev=="("||prev=="*"||prev=="+"||prev=="-"||prev=="/"||prev=="^"||next==")"||next=="*"||next=="+"||next=="-"||next=="/"||next=="^")
                {
                return null;
                }
                System.out.println("the previous and the next values are"
                        + prev + "\t" + next);
                Double d = Double.valueOf(prev) - Double.valueOf(next);
                cal.set(dpos, String.valueOf(d));
                System.out.println("the inserted value is " + cal.get(dpos));
                cal.set(getprevious(dpos - 1, cal), null);
                cal.set(getnext(dpos + 1, cal), null);
                i++;
            } else {
                i++;
            }
            // }
            // }
        }
            catch(Exception e)
                {
                    display.setText("ERRROR");
                    return null;
                }
        }
        
        // display.setText("");
        System.out.println("the size of the array list is " + cal.size());
        //   display.setText(getnext(cal, 0));
        return cal;
    }


public String getnext(List<String> cal, int i) {
        while (i <= cal.size()) {
            if (cal.get(i) != null && cal.get(i) != "=") {
                nextpos = i;
                return cal.get(i);
            }
            i++;
        }
        return null;
    }

    public int getnext(int i, List<String> cal) {
        while (i <= cal.size()) {
            if (cal.get(i) != null && cal.get(i) != "=") {
                nextpos = i;
                return i;
            }
            i++;
        }
        return 0;
    }

    public String getprevious(List<String> cal, int i) {
        while (i >= 0) {
            if (cal.get(i) != null && cal.get(i) != "=") {
                prevpos = i;
                return cal.get(i);
            }
            i--;
        }
        return null;
    }

    public int getprevious(int i, List<String> cal) {
        while (i >= 0) {
            if (cal.get(i) != null && cal.get(i) != "=") {
                prevpos = i;
                return i;
            }
            i--;
        }
        return 0;
    }

    public Boolean operatorchecker(String operator, List<String> cal) {
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

    public int operatorchecker(String operator, int position, List<String> cal) {
        int j = position;
        while (j < cal.size()) {
            if (cal.get(j) == null) {
                j++;
            } else if (cal.get(j).equals(operator)) {

                return j;
            } else {
                j++;
            }

        }
        return -1;
    }

    public Boolean operatorchecker1(String operator, int position, List<String> cal) {
        int j = position;
        while (j < cal.size()) {
            if (cal.get(j) == null) {
                j++;
            } else if (cal.get(j).equals(operator)) {

                return true;
            } else {
                j++;
            }

        }
        return false;
    }
    public Boolean bracketchecker(List<String> cal)
    {
        for(int i = 0; i<cal.size();i++)
        {
        if(cal.get(i)=="(")
        {
        Openingbrackets++;
        }
        if(cal.get(i)==")")
        {
        Closingbrackets++;  
        }
        }
        if(Closingbrackets==Openingbrackets)
        return true;
        else
        return false;
        
            
    }

    public void createstack(List<String> cal1, String fullexpression) {
        fullexpressionLength = fullexpression.length();
        int i = 0;
        System.out.println("the size of expression" + fullexpressionLength);
        while (i < fullexpressionLength) {
            charat = fullexpression.charAt(i);
            if (charat == '(') {
                cal1.add(String.valueOf(charat));
                i++;
            } else if (charat == '+' || charat == '-' || charat == '*'
                    || charat == '/' || charat == '=' || charat == ')' || charat == '^') {

                if (concat != "") {
                    cal1.add(concat);
                }
                cal1.add(String.valueOf(charat));
                concat = "";
                i++;
            } else {
                concat = concat + String.valueOf(charat);
                i++;
            }
        }

    }

    private int Openingbrackets=0;
    private int Closingbrackets=0;
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
    private int prevpos;
    private int nextpos;
    private List<String> cal1 = new ArrayList<String>();
    private List<String> validation = new ArrayList<String>();
    Boolean endbracketchecker;
    private int check;
}
