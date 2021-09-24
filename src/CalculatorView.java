import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CalculatorView extends JFrame {

    JFrame f;
    // create a textfield
    JTextField l;
    JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, ba, bs, bd, bm, be, beq, beq1;

    public CalculatorView()
    {
        f = new JFrame();
        f.setSize(200, 200);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().setBackground(new Color(128,125,240));
        // create a textfield
        l = new JTextField(16);

        // set the textfield to non editable
        l.setEditable(false);

        // create number buttons and some operators

        // create number buttons
        b0 = new JButton("0");
        b1 = new JButton("1");
        b2 = new JButton("2");
        b3 = new JButton("3");
        b4 = new JButton("4");
        b5 = new JButton("5");
        b6 = new JButton("6");
        b7 = new JButton("7");
        b8 = new JButton("8");
        b9 = new JButton("9");

        // equals button
        beq1 = new JButton("=");

        // create operator buttons
        ba = new JButton("+");
        bs = new JButton("-");
        bd = new JButton("/");
        bm = new JButton("*");
        beq = new JButton("C");

        // create . button
        be = new JButton(".");

        // create a panel
        JPanel p = new JPanel();
        p.setBackground(new Color(128,125,240));

        // add elements to panel
        p.add(l);
        p.add(ba);
        p.add(b1);
        p.add(b2);
        p.add(b3);
        p.add(bs);
        p.add(b4);
        p.add(b5);
        p.add(b6);
        p.add(bm);
        p.add(b7);
        p.add(b8);
        p.add(b9);
        p.add(bd);
        p.add(be);
        p.add(b0);
        p.add(beq);
        p.add(beq1);

        // set Background of panel
        p.setBackground(new Color(128,125,240));

        // add panel to frame
        f.add(p);

        f.setSize(200, 220);
        //f.setVisible(true);
    }

    public void addListenertoButtons(ActionListener c)
    {
        // add action listeners
        this.bm.addActionListener(c);
        this.bd.addActionListener(c);
        this.bs.addActionListener(c);
        this.ba.addActionListener(c);
        this.b9.addActionListener(c);
        this.b8.addActionListener(c);
        this.b7.addActionListener(c);
        this.b6.addActionListener(c);
        this.b5.addActionListener(c);
        this.b4.addActionListener(c);
        this.b3.addActionListener(c);
        this.b2.addActionListener(c);
        this.b1.addActionListener(c);
        this.b0.addActionListener(c);
        this.be.addActionListener(c);
        this.beq.addActionListener(c);
        this.beq1.addActionListener(c);
    }

    public JFrame getF() {
        return f;
    }

    public void setF(JFrame f) {
        this.f = f;
    }

    public JTextField getL() {
        return l;
    }

    public void setLabel(String s) {
        this.l.setText(s);
    }
}
