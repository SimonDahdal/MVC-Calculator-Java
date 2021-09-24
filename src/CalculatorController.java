import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorController implements ActionListener {

    private CalculatorView theView;
    private CalculatorModel theModel;

    public CalculatorController(CalculatorView theView, CalculatorModel theModel)
    {
        this.theView = theView;
        this.theModel = theModel;

        theView.addListenertoButtons(this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String s = e.getActionCommand();

        String s0 = theModel.getS0();
        String s1 = theModel.getS1();
        String s2 = theModel.getS2();

        //JTextField l = theView.getL();
        // if the value is a number
        if ((s.charAt(0) >= '0' && s.charAt(0) <= '9') || s.charAt(0) == '.')
        {
            // if operand is present then add to second no
            if (!s1.equals(""))
                s2 = s2 + s;
            else
                s0 = s0 + s;

            // set the value of text
            updateModel(s0,s1,s2);
            updateView(s0 + s1 + s2);
        }
        else if (s.charAt(0) == 'C') {
            // clear the one letter
            s0 = s1 = s2 = "";

            // set the value of text
            updateModel(s0,s1,s2);
            updateView(s0 + s1 + s2);
        }
        else if (s.charAt(0) == '=') {

            double te;

            // store the value in 1st
            if (s1.equals("+"))
                te = (Double.parseDouble(s0) + Double.parseDouble(s2));
            else if (s1.equals("-"))
                te = (Double.parseDouble(s0) - Double.parseDouble(s2));
            else if (s1.equals("/"))
                te = (Double.parseDouble(s0) / Double.parseDouble(s2));
            else
                te = (Double.parseDouble(s0) * Double.parseDouble(s2));

            // set the value of text
            //l.setText(s0 + s1 + s2 + "=" + te);

            // convert it to string
            s0 = Double.toString(te);

            s1 = s2 = "";

            updateView(s0 + s1 + s2);
            updateModel(s0,s1,s2);

        }
        else {
            // if there was no operand
            if (s1.equals("") || s2.equals(""))
                s1 = s;
                // else evaluate
            else {
                double te;

                // store the value in 1st
                if (s1.equals("+"))
                    te = (Double.parseDouble(s0) + Double.parseDouble(s2));
                else if (s1.equals("-"))
                    te = (Double.parseDouble(s0) - Double.parseDouble(s2));
                else if (s1.equals("/"))
                    te = (Double.parseDouble(s0) / Double.parseDouble(s2));
                else
                    te = (Double.parseDouble(s0) * Double.parseDouble(s2));

                // convert it to string
                s0 = Double.toString(te);

                // place the operator
                s1 = s;

                // make the operand blank
                s2 = "";

                updateModel(s0,s1,s2);
                updateView(s0 );

            }

            // set the value of text
            updateView(s0 + s1 + s2);
            updateModel(s0,s1,s2);

        }
    }

    private void updateModel(String s0, String s1, String s2)
    {
        theModel.setS0(s0);
        theModel.setS1(s1);
        theModel.setS2(s2);
    }

    private void updateView(String stext)
    {
        theView.setLabel(stext);
    }
}
