package src;

import java.awt.*;

public class MousePosition {
    public MousePosition(double mouseX, double mouseY){
            mouseX = MouseInfo.getPointerInfo().getLocation().getX();
            mouseY = MouseInfo.getPointerInfo().getLocation().getY();

            System.out.println("X:" + mouseX);
            System.out.println("Y:" + mouseY);
    }
}
