package softwaredesign;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class GuessNumberScreen extends MinigameScreen{

    public GuessNumberScreen(){
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        addTitle();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
