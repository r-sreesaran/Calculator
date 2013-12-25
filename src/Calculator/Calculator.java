///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//
//package Calculator;
//
//
///**
// *
// * @author sree
// */
//import java.awt.BorderLayout;
//import java.awt.EventQueue;
//import java.awt.GridLayout;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import static java.lang.Math.pow;
//import static java.lang.Math.sqrt;
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//
///**
// *
// * @author sree
// */
//public class Calculator {
//
//    JButton display;
//    JPanel panel;
//    double result;
//    String lastCommand;
//
//    boolean start;
//
//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String[] args) {
//        // TODO code application logic here
//        EventQueue.invokeLater(new Runnable() {
//
//            @Override
//            public void run() {
//                CalculatorFrame frame = new CalculatorFrame();
//                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                frame.setVisible(true);
//            }
//
//        });
//    }
//
//}
//
//class CalculatorFrame extends JFrame {
//
//    public CalculatorFrame() {
//        setTitle("Calculator");
//        CalculatorPanel panel = new CalculatorPanel();
//        add(panel);
//        pack();
//    }
//}
//
//class CalculatorPanel extends JPanel {
//
//    public CalculatorPanel() {
//        setLayout(new BorderLayout());
//        result = 0;
//        lastCommand = "=";
//        start = true;
//
//        display = new JButton("0");
//        display.setEnabled(false);
//        add(display, BorderLayout.NORTH);
//        ActionListener insert = new InsertAction();
//        ActionListener command = new CommandAction();
//
//        panel = new JPanel();
//        panel.setLayout(new GridLayout(4, 4));
//
//        addButton("9", insert);
//        addButton("8", insert);
//        addButton("7", insert);
//        addButton("/", insert);
//        addButton("^", insert);
//
//        addButton("6", insert);
//        addButton("5", insert);
//        addButton("4", insert);
//        addButton("*", insert);
//        addButton("$", insert);
//
//        addButton("3", insert); 
//        addButton("2", insert);
//        addButton("1", insert);
//        addButton("-", insert);
//        addButton("(", insert);
//
//        addButton("0", insert);
//        addButton(".", insert);
//        addButton("=", command);
//        addButton("+", insert);
//        addButton(")", insert);
//
//        add(panel, BorderLayout.CENTER);
//    }
//
//    private void addButton(String label, ActionListener listener) {
//        JButton button = new JButton(label);
//        button.addActionListener(listener);
//        panel.add(button);
//    }
//
//    private class InsertAction implements ActionListener {
//
//        public void actionPerformed(ActionEvent event) {
//            String input = event.getActionCommand();
//            if (start) {
//                display.setText(input);
//                start = false;
//            } else {
//                display.setText(display.getText() + input);
//                fullexpression = display.getText();
//            }
//        }
//    }
//
//    private class CommandAction implements ActionListener {
//
//        public void actionPerformed(ActionEvent event) {
//            System.out.println("the entire expression is " + fullexpression);
//            fullexpression = fullexpression + "=";
//            createstack(cal,fullexpression);
//            display.setText("");
//            finalcalculation(cal);
//            display.setText(getnext(finalcalculation(cal), 0));
//        }
//    }
//
//    public List<String> finalcalculation(List<String> cal) {
//        String value;
//        int temp = cal.size();
//        int i = 0;
//        // while () {
//        while (i < cal.size()) {
//            value = cal.get(i);
//            System.out.println("the value is " + value);
//            System.out.println("it is working properly");
//            if (value == null) {
//                i++;
//            }
//            else if (operatorchecker("(")) {
//                
//                List<String> calsub = new ArrayList<String>();
//                 tempval =1;
//                 j=i+1;
//                while(tempval!=0)
//                {
//                if(cal.get(j).equals("("))
//                {
//                     System.out.println("the size of the increment is "+tempval+""+j);
//                tempval++; 
//                j++;
//                } 
//                else if(cal.get(j).equals(")")){      
//                   tempval--;
//                    System.out.println("the size of decrement list is "+tempval+""+j);
//              
//                    if(tempval==0)
//                    {
//                    zero = j;
//                    }
//                j++;
//                }  
//               else
//                {
//                System.out.println("the size of the increment decrement is "+tempval+""+j);
//              j++;
//                }
// 
//                }
//                System.out.println("the size of the list is "+cal.size());
//                System.out.println("the start and end position of the sub list"+(i+1)+(zero-1));
//                j=i+1;
//                while(j<=zero-1)
//                {
//                  temp.set(j,cal.get(j));
//                  j++;
//                }
//                while
//                String temp2 = getnext((ArrayList<String>)finalcalculation(cal.subList(i+1,zero-1)),0);
//                j=0;
//                while(j<=zero-i)
//                {
//                cal.set(j,null);
//                j++;
//                }
//            //   cal.set(j,temp2);
//              //List<String> calsub = new ArrayList<String>();
//              //String fullexpression1="";
//               // int d= operatorchecker(")",i);
//               // int j=i;
////                while(j<d)
////                {
////                fullexpression1 = cal.get(j)+fullexpression1;
////                cal.set(j,null);
////                j++;
////                }
//                //System.out.println("the size of the list is "+cal.size());
//                //System.out.println("the start and end position of the sub list"+(i+1)+(d-1));
//               //String temp2 = getnext((ArrayList<String>) finalcalculation(cal.subList(i+1, d-1)),0);
//               // cal.set(j,temp2);
//                //j++;
//               // while(j<d)
////                {
////                cal.set(j,null);
////                j++;
////                }
//               // final
////                createstack(calsub,fullexpression1);
////                finalcalculation(calsub);
////                String temp1 = getnext(calsub,0);
////                cal.set(i,temp1);
//                i++;
//            }
//            else if (operatorchecker("^")) {
//                String prev = getprevious(cal, dpos - 1);
//                String next = getnext(cal, dpos + 1);
//                System.out.println("the previous and the next values are"
//                        + prev + "\t" + next);
//                Double d = pow(Double.valueOf(prev),Integer.parseInt(next));
//                cal.set(dpos, String.valueOf(d));
//                System.out.println("the inserted value is " + cal.get(dpos));
//                cal.set(getprevious(dpos - 1), null);
//                cal.set(getnext(dpos + 1), null);
//                i++;
//            }else if (operatorchecker("$")) {
//                String next = getnext(cal, dpos + 1);
//                System.out.println("the next values are"
//                        +  "\t" + next);
//                Double d = sqrt(Double.parseDouble(next));
//                cal.set(dpos, String.valueOf(d));
//                System.out.println("the inserted value is " + cal.get(dpos));
//                cal.set((dpos + 1), null);
//            i++;
//            }
//            else if (operatorchecker("/")) {
//                String prev = getprevious(cal, dpos - 1);
//                String next = getnext(cal, dpos + 1);
//                System.out.println("the previous and the next values are"
//                        + prev + "\t" + next);
//                Double d = Double.valueOf(prev) / Double.valueOf(next);
//                cal.set(dpos, String.valueOf(d));
//                System.out.println("the inserted value is " + cal.get(dpos));
//                cal.set(getprevious(dpos - 1), null);
//                cal.set(getnext(dpos + 1), null);
//                i++;
//            } else if (operatorchecker("*")) {
//                String prev = getprevious(cal, dpos - 1);
//                String next = getnext(cal, dpos + 1);
//                System.out.println("the previous and the next values are"
//                        + prev + "\t" + next);
//                Double d = Double.valueOf(prev) * Double.valueOf(next);
//                cal.set(dpos, String.valueOf(d));
//                System.out.println("the inserted value is " + cal.get(dpos));
//                cal.set(getprevious(dpos - 1), null);
//                cal.set(getnext(dpos + 1), null);
//                i++;
//            }  else if (operatorchecker("+")) {
//                String prev = getprevious(cal, dpos - 1);
//                String next = getnext(cal, dpos + 1);
//                System.out.println("the previous and the next values are"
//                        + prev + "\t" + next);
//                Double d = Double.valueOf(prev) + Double.valueOf(next);
//                cal.set(dpos, String.valueOf(d));
//                System.out.println("the inserted value is " + cal.get(dpos));
//                cal.set(getprevious(dpos - 1), null);
//                cal.set(getnext(dpos + 1), null);
//                i++;
//            } else if (operatorchecker("-")) {
//                String prev = getprevious(cal, dpos - 1);
//                String next = getnext(cal, dpos + 1);
//                System.out.println("the previous and the next values are"
//                        + prev + "\t" + next);
//                Double d = Double.valueOf(prev) - Double.valueOf(next);
//                cal.set(dpos, String.valueOf(d));
//                System.out.println("the inserted value is " + cal.get(dpos));
//                cal.set(getprevious(dpos - 1), null);
//                cal.set(getnext(dpos + 1), null);
//                i++;
//            } 
//            else {
//                i++;
//            }
//            // }
//            // }
//        }
//        // display.setText("");
//        System.out.println("the size of the array list is " + cal.size());
//     //   display.setText(getnext(cal, 0));
//          return cal ;
//    }
//
//    public String getnext(List<String> cal, int i) {
//        while (i <= cal.size()) {
//            if (cal.get(i) != null && cal.get(i) != "=") {
//                nextpos = i;
//                return cal.get(i);
//            }
//            i++;
//        }
//        return null;
//    }
//
//    public int getnext(int i) {
//        while (i <= cal.size()) {
//            if (cal.get(i) != null && cal.get(i) != "=") {
//                nextpos = i;
//                return i;
//            }
//            i++;
//        }
//        return 0;
//    }
//
//    public String getprevious(List<String> cal, int i) {
//        while (i >= 0) {
//            if (cal.get(i) != null && cal.get(i) != "=") {
//                prevpos = i;
//                return cal.get(i);
//            }
//            i--;
//        }
//        return null;
//    }
//
//    public int getprevious(int i) {
//        while (i >= 0) {
//            if (cal.get(i) != null && cal.get(i) != "=") {
//                prevpos = i;
//                return i;
//            }
//            i--;
//        }
//        return 0;
//    }
//
//    public Boolean operatorchecker(String operator) {
//        int j = 0;
//        while (j < cal.size()) {
//            if (cal.get(j) == null) {
//                j++;
//            } else if (cal.get(j).equals(operator)) {
//                dpos = j;
//                return true;
//            } else {
//                j++;
//            }
//
//        }
//        return false;
//    }
//    public int operatorchecker(String operator,int position) {
//        int j = position;
//        while (j < cal.size()) {
//            if (cal.get(j) == null) {
//                j++;
//            } else if (cal.get(j).equals(operator)) {
//               
//                return j;
//            } else {
//                j++;
//            }
//
//        }
//        return -1;
//    }
// 
//
//    public void createstack(List<String> cal1,String fullexpression) {
//        fullexpressionLength = fullexpression.length();
//        
//        System.out.println("the size of expression" + fullexpressionLength);
//        while (i < fullexpressionLength) {
//            charat = fullexpression.charAt(i);
//           if(charat=='(' )
//           {
//               cal1.add(String.valueOf(charat));
//                System.out.println("the operator is " + charat);
//                       i++;
//           }
////           if(charat=='$' )
////           {
////               cal1.add(String.valueOf(charat));
////                System.out.println("the operator is " + charat);
////                       i++;
////           }
//           
//            else if (charat == '+' || charat == '-' || charat == '*'
//                    || charat == '/' || charat == '='|| charat==')'||charat=='^') {
//                
//                
//                //Boolean temp = endbracketchecker;
//                //if(charat==')')
//                //{
//                //endbracketchecker = true;
//                //}
//                //else
//                //{
//                //endbracketchecker = false;
//                //}
//                if(concat!="")
//                {
//                cal1.add(concat);
//                }
//                // if(charat!='=')
//                cal1.add(String.valueOf(charat));
//                System.out.println("the value entered is " + concat);
//                System.out.println("the operator is " + charat);
//                concat = "";
//                i++;
//            } else {
//                concat = concat + String.valueOf(charat);
//                i++;
//            }
//        }
//        System.out.println("the size of arraylist" + cal1.size());
//
//    }
//
//    private int dpos;
//    private String concat = "";
//    private char charat;
//    private JButton display;
//    private JPanel panel;
//    private double result;
//    private String lastCommand;
//    private Boolean start;
//    private String fullexpression;
//    private int fullexpressionLength;
//    private int i = 0;
//    private int prevpos;
//    private int nextpos;
//    private List<String> cal = new ArrayList<String>();
//    private List<String> temp = new ArrayList<String>();
//    Boolean endbracketchecker ;
//    private int tempval;
//    private int zero;
//    private int j;
//    private int check;
//}
//


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
            display.setText(getnext(finalcalculation(cal), 0));
        }
    }

    public List<String> finalcalculation(List<String> cal) {
         List<String> tempvalue = new ArrayList<String>();
        String value;
        int c=0;
        int temp = cal.size();
        int i = 0;
     //   int zero =0;
        System.out.println("new list created ");
        // while () {
        while (i < cal.size()) {
            value = cal.get(i);
            System.out.println("the value is " + value+"and the position is "+i);
            System.out.println("it is working properly");
            i++;
        }
        i=0;
        while (i < cal.size()) {
            value = cal.get(i);
//            System.out.println("the value is " + value);
//            System.out.println("it is working properly");
            if (value == null) {
                i++;
            }
            else if (operatorchecker("(",cal)) {

               // List<String> calsub = new ArrayList<String>();
                tempval=1;
                j=i+1;
                while(tempval!=0)
                {
                    if(cal.get(j).equals("("))
                    {  tempval++;
                        System.out.println("the size of the increment is "+tempval+" "+j);
                        j++;
                    }
                    else if(cal.get(j).equals(")")){
                        tempval--;
                        System.out.println("the size of decrement list is "+tempval+" "+j);

                        if(tempval==0)
                        {
                            zero = j;
                        }
                        j++;
                    }
                    else
                    {
                        System.out.println("the size of the increment decrement is "+tempval+" "+j);
                        j++;
                    }

                }
                System.out.println("the size of the list is "+cal.size());
                System.out.println("the start and end position of the sub list"+(i+1)+(zero-1));
                
                c=1;
                int k=0;
                while(c<=zero-i)
                {
                    if(c!=zero)
                    {
                    tempvalue.add(cal.get(c));
                    c++;

                    }
                    else
                    {
                        tempvalue.add("=");
                        c++;

                    }
                }

                String temp2 = getnext((ArrayList<String>)finalcalculation(tempvalue),0);
                int d=i+1;
                while(d<=zero)
                {
                    cal.set(d,null);
                    d++;
                }
                cal.set(i,temp2);
                //   cal.set(j,temp2);
                //List<String> calsub = new ArrayList<String>();
                //String fullexpression1="";
                // int d= operatorchecker(")",i);
                // int j=i;
//                while(j<d)
//                {
//                fullexpression1 = cal.get(j)+fullexpression1;
//                cal.set(j,null);
//                j++;
//                }
                //System.out.println("the size of the list is "+cal.size());
                //System.out.println("the start and end position of the sub list"+(i+1)+(d-1));
                //String temp2 = getnext((ArrayList<String>) finalcalculation(cal.subList(i+1, d-1)),0);
                // cal.set(j,temp2);
                //j++;
                // while(j<d)
//                {
//                cal.set(j,null);
//                j++;
//                }
                // final
//                createstack(calsub,fullexpression1);
//                finalcalculation(calsub);
//                String temp1 = getnext(calsub,0);
//                cal.set(i,temp1);
                i++;
            }
            else if (operatorchecker("^",cal)) {
                String prev = getprevious(cal, dpos - 1);
                String next = getnext(cal, dpos + 1);
                System.out.println("the previous and the next values are"
                        + prev + "\t" + next);
                Double d = pow(Double.valueOf(prev),Integer.parseInt(next));
                cal.set(dpos, String.valueOf(d));
                System.out.println("the inserted value is " + cal.get(dpos));
                cal.set(getprevious(dpos - 1,cal), null);
                cal.set(getnext(dpos + 1,cal), null);
                i++;
            }else if (operatorchecker("$",cal)) {
                String next = getnext(cal, dpos + 1);
                System.out.println("the next values are"
                        +  "\t" + next);
                Double d = sqrt(Double.parseDouble(next));
                cal.set(dpos, String.valueOf(d));
                System.out.println("the inserted value is " + cal.get(dpos));
                cal.set((dpos + 1), null);
                i++;
            }
            else if (operatorchecker("/",cal)) {
                String prev = getprevious(cal, dpos - 1);
                String next = getnext(cal, dpos + 1);
                System.out.println("the previous and the next values are"
                        + prev + "\t" + next);
                Double d = Double.valueOf(prev) / Double.valueOf(next);
                cal.set(dpos, String.valueOf(d));
                System.out.println("the inserted value is " + cal.get(dpos));
                cal.set(getprevious(dpos - 1,cal), null);
                cal.set(getnext(dpos + 1,cal), null);
                i++;
            } else if (operatorchecker("*",cal)) {
                String prev = getprevious(cal, dpos - 1);
                String next = getnext(cal, dpos + 1);
                System.out.println("the previous and the next values are"
                        + prev + "\t" + next);
                Double d = Double.valueOf(prev) * Double.valueOf(next);
                cal.set(dpos, String.valueOf(d));
                System.out.println("the inserted value is " + cal.get(dpos));
                cal.set(getprevious(dpos - 1,cal), null);
                cal.set(getnext(dpos + 1,cal), null);
                i++;
            }  else if (operatorchecker("+",cal)) {
                String prev = getprevious(cal, dpos - 1);
                String next = getnext(cal, dpos + 1);
                System.out.println("the previous and the next values are"
                        + prev + "\t" + next);
                Double d = Double.valueOf(prev) + Double.valueOf(next);
                cal.set(dpos, String.valueOf(d));
                System.out.println("the inserted value is " + cal.get(dpos));
                cal.set(getprevious(dpos - 1,cal), null);
                cal.set(getnext(dpos + 1,cal), null);
                i++;
            } else if (operatorchecker("-",cal)) {
                String prev = getprevious(cal, dpos - 1);
                String next = getnext(cal, dpos + 1);
                System.out.println("the previous and the next values are"
                        + prev + "\t" + next);
                Double d = Double.valueOf(prev) - Double.valueOf(next);
                cal.set(dpos, String.valueOf(d));
                System.out.println("the inserted value is " + cal.get(dpos));
                cal.set(getprevious(dpos - 1,cal), null);
                cal.set(getnext(dpos + 1,cal), null);
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
        //   display.setText(getnext(cal, 0));
        return cal ;
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

    public int getnext(int i,List<String> cal) {
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

    public int getprevious(int i,List<String> cal) {
        while (i >= 0) {
            if (cal.get(i) != null && cal.get(i) != "=") {
                prevpos = i;
                return i;
            }
            i--;
        }
        return 0;
    }

    public Boolean operatorchecker(String operator,List<String> cal) {
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
    public int operatorchecker(String operator,int position,List<String> cal) {
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


    public void createstack(List<String> cal1,String fullexpression) {
        fullexpressionLength = fullexpression.length();
int i=0;
        System.out.println("the size of expression" + fullexpressionLength);
        while (i < fullexpressionLength) {
            charat = fullexpression.charAt(i);
            if(charat=='(' )
            {
                cal1.add(String.valueOf(charat));
             //   System.out.println("the operator is " + charat);
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
//                System.out.println("the value entered is " + concat);
//                System.out.println("the operator is " + charat);
                concat = "";
                i++;
            } else {
                concat = concat + String.valueOf(charat);
                i++;
            }
        }
    //    System.out.println("the size of arraylist" + cal1.size());

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
  //  private int i = 0;
    private int prevpos;
    private int nextpos;
    private List<String> cal = new ArrayList<String>();
    Boolean endbracketchecker ;
    private int tempval;
    private int zero;
    private int j;
    private int check;
}

