package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame implements ActionListener {

    int windowWidth=1000;
    int windowHeight=500;
    int runningButtonWidth=80, startButtonWidth=100;
    int runningButtonHeight=80, startButtonHeight=100;
    int runningButtonX=windowWidth/2-runningButtonWidth/2;
    int runningButtonY=windowHeight/2-runningButtonHeight/2;
    int startButtonX=windowWidth/2-startButtonWidth/2;
    int startButtonY=windowHeight/2-startButtonHeight/2;

    JButton JStart,runningButton;
    int isButtonPressed=0;

    public Window() {
        setSize(windowWidth, windowHeight);
        setTitle("Złap przycisk!");
        setLayout(null);
        getContentPane().setBackground(new Color(201, 241, 154));

        JStart = new JButton("Zacznij grę!");
        JStart.setFont(new Font("Dialog", Font.ITALIC, 10));
        JStart.setBounds(startButtonX,startButtonY,startButtonWidth,startButtonHeight);
        JStart.setBackground(new Color(100, 100, 100));
        JStart.setForeground(new Color(195, 195, 195));

        runningButton = new JButton("Złap mnie!");
        runningButton.setFont(new Font("Dialog", Font.ITALIC, 10));
        runningButton.setBounds(runningButtonX,runningButtonY,runningButtonWidth,runningButtonHeight);
        runningButton.setBackground(new Color(100, 100, 100));
        runningButton.setForeground(new Color(195, 195, 195));

        add(JStart);

        runningButton.addActionListener(this);
        JStart.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object source = e.getSource();

        if(source==JStart){
            remove(JStart);
            getContentPane().setBackground(new Color(154, 241, 241));

            add(runningButton);
        }

        if(source==runningButton){
            System.out.println("pepepe");
            runningButtonX=(int)(Math.random()*(windowWidth-runningButtonX+1))+1;
            runningButtonY=(int)(Math.random()*(windowHeight-runningButtonY+1))+1;
            System.out.println(runningButtonX+" "+runningButtonY);

            runningButton.setBounds(runningButtonX,runningButtonY,runningButtonWidth,runningButtonHeight);

        }
    }
}
