package softwaredesign;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class AppConstants {
    static final int WIDTH = 550;
    static final int HEIGHT = 800;
}
class MyFrame extends JFrame implements ActionListener {
    JButton playButton;
    JButton feedButton;
    JButton sleepButton;
    MyFrame(){
        JLabel tittle = new JLabel("MyTamagotchi");
        tittle.setHorizontalTextPosition(JLabel.CENTER);
        tittle.setVerticalTextPosition(JLabel.TOP);
        tittle.setFont(new Font("MV Boli", Font.PLAIN,30));
        tittle.setHorizontalAlignment(JLabel.CENTER);
        tittle.setVerticalAlignment(JLabel.TOP);
        tittle.setBounds(AppConstants.WIDTH/2,AppConstants.HEIGHT/2,200, 100);

        JLabel pet = new JLabel();
        ImageIcon dog = new ImageIcon("dog.png");
        pet.setIcon(dog);


        playButton = new JButton();
        playButton.setBounds(0,0,100,100);
        playButton.addActionListener(this);
        playButton.setText("Play");
        playButton.setFocusable(false);
        playButton.setBackground(new Color(0x3ED7FF));
        playButton.setBorder(BorderFactory.createCompoundBorder());

        feedButton = new JButton();
        feedButton.setBounds(0,0,100,100);
        feedButton.addActionListener(this);
        feedButton.setText("Feed");
        feedButton.setFocusable(false);
        feedButton.setBackground(new Color(0x3ED7FF));
        feedButton.setBorder(BorderFactory.createCompoundBorder());

        sleepButton = new JButton();
        sleepButton.setBounds(0,0,100,100);
        sleepButton.addActionListener(this);
        sleepButton.setText("Sleep");
        sleepButton.setFocusable(false);
        sleepButton.setBackground(new Color(0x3ED7FF));
        sleepButton.setBorder(BorderFactory.createCompoundBorder());

        JPanel tittlePanel = new JPanel();
        tittlePanel.setBackground(new Color(0x3ED7FF));
        tittlePanel.setBounds(0,0,AppConstants.WIDTH, 100);
        tittlePanel.setLayout(new BorderLayout());
        tittlePanel.add(tittle);

        JPanel vitalsPanel = new JPanel();
        vitalsPanel.setBackground(new Color(0x9BFF97));
        vitalsPanel.setBounds(0,100,AppConstants.WIDTH, 100);

        JPanel petPanel = new JPanel();
        petPanel.setBackground(new Color(0x3CA8FF));
        petPanel.setBounds(0,200,AppConstants.WIDTH, 400);
        petPanel.add(pet);



        JPanel actionsPanel = new JPanel();
        actionsPanel.setBackground(new Color(0x0D1F2A));
        actionsPanel.setBounds(0,600,AppConstants.WIDTH, 200);
        actionsPanel.add(playButton);
        actionsPanel.add(feedButton);
        actionsPanel.add(sleepButton);

        this.setTitle("MyTamagotchi");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(AppConstants.WIDTH, AppConstants.HEIGHT);
        this.setLayout(null);
        this.setVisible(true);

//        ImageIcon iconLogo = new ImageIcon("iconLogo.jpg");
//        this.setIconImage(iconLogo.getImage());
        this.getContentPane().setBackground(new Color(0xA6EEFF));

        this.add(tittlePanel);
        this.add(vitalsPanel);
        this.add(petPanel);
        this.add(actionsPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == playButton) {
            System.out.println("play");
        }
    }
}

public class Main {
    public static void main (String[] args){
        System.out.println("Welcome to Software Design");
        MyFrame TamagotchiFrame = new MyFrame();

    }
}
