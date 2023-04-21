package pg.eti.project;

import javax.swing.*;

public class MyRadioButton extends JRadioButton {

    public MyRadioButton(String s)
    {
        super(s, false);
        this.setFocusable(false);
    }
}
