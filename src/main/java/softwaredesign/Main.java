package softwaredesign;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.IOException;

class GradientPanel extends JPanel{

    public static int VERTICAL = 0;
    public static int HORIZONTAL = 1;
    public static int DIAGONAL_DOWN = 2;
    public static int DIAGONAL_UP = 3;

    private Color color1, color2;
    private int direction;



    public GradientPanel() {
        super();
        color1 = Color.black;
        color2 = Color.white;
    }

    public GradientPanel(Color color1, Color color2) {
        super();
        this.color1 = color1;
        this.color2 = color2;
    }

    public GradientPanel(Color color1, Color color2, int direction) {
        super();
        this.color1 = color1;
        this.color2 = color2;
        this.direction = direction;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D graphics2d = (Graphics2D) g;
        graphics2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

        GradientPaint gradientPaint;

        if(direction == HORIZONTAL)
            gradientPaint = new GradientPaint(0, getHeight() / 2, color1, getWidth(), getHeight() / 2, color2);

        else if(direction == DIAGONAL_DOWN)
            gradientPaint = new GradientPaint(0, getHeight(), color1, getWidth(), 0, color2);

        else if(direction == DIAGONAL_UP)
            gradientPaint = new GradientPaint(0, 0, color1, getWidth(), getHeight(), color2);

        else
            gradientPaint = new GradientPaint(0, 0, color1, 0, getHeight(), color2);

        graphics2d.setPaint(gradientPaint);
        graphics2d.fillRect(0, 0, getWidth(), getHeight());
    }


    public Color getColor1() {
        return color1;
    }
    public void setColor1(Color color1) {
        this.color1 = color1;
    }
    public Color getColor2() {
        return color2;
    }
    public void setColor2(Color color2) {
        this.color2 = color2;
    }
    public int getDirection() {
        return direction;
    }
    public void setDirection(int direction) {
        this.direction = direction;
    }


}
class AppConstants {
    static final int WIDTH = 550;
    static final int HEIGHT = 800;
}
class MyFrame extends JFrame implements ActionListener {
    JButton playButton;
    JButton feedButton;
    JButton sleepButton;
    JButton cleanButton;
    MyFrame() throws IOException {
        JLabel tittle = new JLabel();
        ImageIcon tittlePNG = new ImageIcon("src/main/java/softwaredesign/tittleGroup8.png");
        Image image1 = tittlePNG.getImage();
        Image scaledImg1 = image1.getScaledInstance(400, 71, Image.SCALE_SMOOTH);
        tittlePNG = new ImageIcon(scaledImg1);
        tittle.setIcon(tittlePNG);


        tittle.setHorizontalAlignment(JLabel.CENTER);
        tittle.setVerticalAlignment(JLabel.CENTER);

        JLabel pet = new JLabel();
        ImageIcon dog = new ImageIcon("src/main/java/softwaredesign/dog.png");
        Image image = dog.getImage();
        Image scaledImg = image.getScaledInstance(350, 350, Image.SCALE_SMOOTH);
        dog = new ImageIcon(scaledImg);
        pet.setIcon(dog);


        playButton = new JButton();
        playButton.setBounds(30,30,100,100);
        playButton.addActionListener(this);
        playButton.setText("Play");
        playButton.setFocusable(false);
        playButton.setBackground(new Color(0xBEE0F8));
        playButton.setBorder(BorderFactory.createCompoundBorder());

        feedButton = new JButton();
        feedButton.setBounds(160,30,100,100);
        feedButton.addActionListener(this);
        feedButton.setText("Feed");
        feedButton.setFocusable(false);
        feedButton.setBackground(new Color(0xBEE0F8));
        feedButton.setBorder(BorderFactory.createCompoundBorder());

        sleepButton = new JButton();
        sleepButton.setBounds(290,30,100,100);
        sleepButton.addActionListener(this);
        sleepButton.setText("Sleep");
        sleepButton.setFocusable(false);
        sleepButton.setBackground(new Color(0xBEE0F8));
        sleepButton.setBorder(BorderFactory.createCompoundBorder());


        cleanButton = new JButton();
        cleanButton.setBounds(420,30,100,100);
        cleanButton.addActionListener(this);
        cleanButton.setText("Clean");
        cleanButton.setFocusable(false);
        cleanButton.setBackground(new Color(0xBEE0F8));
        cleanButton.setBorder(BorderFactory.createCompoundBorder());


        GradientPanel tittlePanel = new GradientPanel(new Color(0xBEE0F8), new Color(0xBEE0F8));
        tittlePanel.setBounds(0,0,AppConstants.WIDTH, 100);
        tittlePanel.setLayout(new BorderLayout());
        tittlePanel.add(tittle);

        JProgressBar hungerBar = new JProgressBar();
        hungerBar.setMaximum(100);
        hungerBar.setMinimum(0);
        hungerBar.setValue(100);
        hungerBar.setBounds(85,0,180,20);
        hungerBar.setStringPainted(true);

        JProgressBar energyBar = new JProgressBar();
        energyBar.setMaximum(100);
        energyBar.setMinimum(0);
        energyBar.setValue(100);
        energyBar.setBounds(285,0,180,20);
        energyBar.setStringPainted(true);

        JProgressBar moodBar = new JProgressBar();
        moodBar.setMaximum(100);
        moodBar.setMinimum(0);
        moodBar.setValue(100);
        moodBar.setBounds(85,40,180,20);
        moodBar.setStringPainted(true);

        JProgressBar cleanlinessBar = new JProgressBar();
        cleanlinessBar.setMaximum(100);
        cleanlinessBar.setMinimum(0);
        cleanlinessBar.setValue(100);
        cleanlinessBar.setBounds(285,40,180,20);
        cleanlinessBar.setStringPainted(true);

        GradientPanel vitalsPanel = new GradientPanel(new Color(0xBEE0F8), new Color(0xC1C8E4));
        vitalsPanel.setBounds(0,100,AppConstants.WIDTH, 100);
        vitalsPanel.setLayout(null);
        vitalsPanel.add(hungerBar);
        vitalsPanel.add(cleanlinessBar);
        vitalsPanel.add(moodBar);
        vitalsPanel.add(energyBar);

        GradientPanel petPanel = new GradientPanel(new Color(0xC1C8E4), new Color(0x8860D0));
        petPanel.setBounds(0,200,AppConstants.WIDTH, 400);
        petPanel.add(pet);

        GradientPanel actionsPanel = new GradientPanel(new Color(0x8860D0), new Color(0x8860D0));
        actionsPanel.setLayout(null);
        actionsPanel.setBounds(0,600,AppConstants.WIDTH, 200);
        actionsPanel.add(playButton);
        actionsPanel.add(feedButton);
        actionsPanel.add(sleepButton);
        actionsPanel.add(cleanButton);

        this.setTitle("MyTamagotchi");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(AppConstants.WIDTH, AppConstants.HEIGHT);
        this.setLayout(null);
        this.setVisible(true);
        this.setResizable(false);

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
    public static void main (String[] args) throws IOException {
        System.out.println("Welcome to Software Design");
        MyFrame TamagotchiFrame = new MyFrame();

    }
}
