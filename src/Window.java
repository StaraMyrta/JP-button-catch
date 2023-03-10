package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

/**
 * Publiczna klasa Window zawierająca wszystkie elementy wyświetlane w oknie aplikacji
 * oraz główną metodę Window przechowującą ich parametry i ActionListeners.
 */


public class Window extends JFrame implements ActionListener {

    int windowWidth=1000;
    int windowHeight=500;
    int runningButtonWidth=80, normalButtonWidth=100;
    int runningButtonHeight=80, normalButtonHeight=100;
    int runningButtonX, runningButtonY;
    int normalButtonX=windowWidth/2-normalButtonWidth/2;
    int normalButtonY=windowHeight/2-normalButtonHeight/2;

    double mouseX,mouseY;

    JButton JStart,JAgain,JEnd,runningButton;
    JLabel lSuccess;

    URL LGiconURL;

    public Window() {
        setSize(windowWidth, windowHeight);
        setTitle("Złap przycisk!");
        setLayout(null);
        getContentPane().setBackground(new Color(201, 241, 154));

        JStart = new JButton();
        JStart.setBounds(normalButtonX,normalButtonY,normalButtonWidth,normalButtonHeight);
        LGiconURL = getClass().getResource("/src/icons/start.png");
        assert LGiconURL != null : "start button icon not found";
        JStart.setIcon(new ImageIcon(LGiconURL));

        JAgain = new JButton();
        JAgain.setBounds(normalButtonX,normalButtonY,normalButtonWidth,normalButtonHeight);
        LGiconURL = getClass().getResource("/src/icons/again.png");
        assert LGiconURL != null : "again button icon not found";
        JAgain.setIcon(new ImageIcon(LGiconURL));

        JEnd = new JButton();
        JEnd.setBounds(normalButtonX,normalButtonY+100,normalButtonWidth,normalButtonHeight);
        LGiconURL = getClass().getResource("/src/icons/end.png");
        assert LGiconURL != null : "again button icon not found";
        JEnd.setIcon(new ImageIcon(LGiconURL));


        runningButton = new JButton();
        LGiconURL = getClass().getResource("/src/icons/runningButton.png");
        assert LGiconURL != null : "running button icon not found";
        runningButton.setIcon(new ImageIcon(LGiconURL));

        lSuccess = new JLabel("Przycisk złapany!");
        lSuccess.setBounds(windowWidth/2-150, windowHeight/2-130, 500, 80);
        lSuccess.setFont(new Font("Dialog", Font.ITALIC, 40));

        runningButton.addActionListener(this);
        JStart.addActionListener(this);
        JAgain.addActionListener(this);
        JEnd.addActionListener(this);

        add(JStart);
    }

    public void Movement(){
        runningButtonX=(int)(Math.random()*(windowWidth-runningButtonX+1))+runningButtonWidth;
        runningButtonY=(int)(Math.random()*(windowHeight-runningButtonY+1))+runningButtonHeight;

        runningButton.setBounds(runningButtonX,runningButtonY,runningButtonWidth,runningButtonHeight);
    }

    public void RunningButtonSetter(){
        runningButtonX=windowWidth/2-runningButtonWidth/2;
        runningButtonY=windowHeight/2-runningButtonHeight/2;
        System.out.println(runningButtonX+"   "+runningButtonY);
        runningButton.setBounds(runningButtonX,runningButtonY,runningButtonWidth,runningButtonHeight);
        add(runningButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object source = e.getSource();

        if(source==JStart){
            remove(JStart);
            getContentPane().setBackground(new Color(154, 241, 241));

            RunningButtonSetter();
        }

        if(source==runningButton){
            mouseX = MouseInfo.getPointerInfo().getLocation().getX();
            mouseY = MouseInfo.getPointerInfo().getLocation().getY();
            System.out.println(mouseX+" "+mouseY);
            System.out.println(runningButtonX+" "+runningButtonWidth);
            System.out.println(runningButtonY+" "+runningButtonHeight);

            if(mouseX>=(runningButtonX+runningButtonWidth) && mouseX<=(runningButtonX+runningButtonWidth+10)
            && mouseY<=(runningButtonY+runningButtonHeight) && mouseY>=runningButtonY){
                remove(runningButton);

                getContentPane().setBackground(new Color(10,150,80));

                add(lSuccess);
                add(JAgain);
                add(JEnd);
            }
            else{
                Movement();
            }
        }

        if(source==JAgain){
            getContentPane().setBackground(new Color(154, 241, 241));

            remove(lSuccess);
            remove(JAgain);
            remove(JEnd);

            RunningButtonSetter();
            add(runningButton);
        }

        if(source==JEnd) {
            System.out.println("lolo");
            super.dispose();
        }
    }
}
