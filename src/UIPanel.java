import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


class UIPanel extends JPanel {
    private JLabel body = new JLabel("Body");
    private JButton bodyLeft = new JButton("A");
    private JButton bodyRight = new JButton("D");
    private JButton bodyBack = new JButton("S");
    private JButton bodyFront = new JButton("W");
    private JButton bodyStop = new JButton(" ");
    private JLabel camera = new JLabel("Camera");
    private JButton cameraLeft = new JButton("⬅");
    private JButton cameraRight = new JButton("➡");
    private JButton cameraUp = new JButton("⬆");
    private JButton cameraDown = new JButton("⬇");
    private JLabel arm = new JLabel("Arm");
    private JButton armLeft = new JButton("J");
    private JButton armRight = new JButton("L");
    private JButton armUp = new JButton("I");
    private JButton armDown = new JButton("K");
    private JButton armFront = new JButton("U");
    private JButton armBack = new JButton("O");
    private JLabel empty = new JLabel(" ");



    private ServoController servoController;

    UIPanel(ServoController servoController) {
        this.servoController = servoController;
    }


    void createAndShowGUI() {
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 5, 5, 5);
        int firstCellX = 0;
        int secondCellX = 1;
        int thirdCellX = 2;
        int fourthCellX = 3;
        int fifthCellX = 4;
        int sixthCellX = 5;

        int firstCellY = 0;
        int secondCellY = 1;
        int thirdCellY = 2;
        int fourthCellY = 3;
        int fifthCellY = 4;
        int sixthCellY = 5;
        int seventhCellY = 6;
        int eighthCellY = 7;
        int ninthCellY = 8;
        int tenthCellY = 9;
        int eleventhCellY = 10;

        constraints.gridx = firstCellX;
        constraints.gridy = secondCellY;
        add(this.body, constraints);

        constraints.gridx = secondCellX;
        constraints.gridy = secondCellY;
        add(this.empty, constraints);

        constraints.gridx = thirdCellX;
        constraints.gridy = secondCellY;
        add(this.bodyLeft, constraints);

        constraints.gridx = fourthCellX;
        constraints.gridy = secondCellY;
        add(this.bodyStop, constraints);

        constraints.gridx = fifthCellX;
        constraints.gridy = secondCellY;
        add(this.bodyRight, constraints);

        constraints.gridx = fourthCellX;
        constraints.gridy = firstCellY;
        add(this.bodyFront, constraints);

        constraints.gridx = fourthCellX;
        constraints.gridy = thirdCellY;
        add(this.bodyBack, constraints);

        constraints.gridx = fourthCellX;

        constraints.gridy = fourthCellY;
        add(this.empty, constraints);

        constraints.gridx = fourthCellX;
        constraints.gridy = sixthCellY;
        add(this.camera, constraints);

        constraints.gridx = secondCellX;
        constraints.gridy = sixthCellY;
        add(this.empty, constraints);

        constraints.gridx = thirdCellX;
        constraints.gridy = sixthCellY;
        add(this.cameraLeft, constraints);

        constraints.gridx = fifthCellX;
        constraints.gridy = sixthCellY;
        add(this.cameraRight, constraints);

        constraints.gridx = fourthCellX;
        constraints.gridy = fifthCellY;
        add(this.cameraUp, constraints);

        constraints.gridx = fourthCellX;
        constraints.gridy = seventhCellY;
        add(this.cameraDown, constraints);

        constraints.gridx = fourthCellX;
        constraints.gridy = eighthCellY;
        add(this.empty, constraints);

        constraints.gridx = firstCellX;
        constraints.gridy = tenthCellY;
        add(this.arm, constraints);

        constraints.gridx = secondCellX;
        constraints.gridy = tenthCellY;
        add(this.empty, constraints);

        constraints.gridx = thirdCellX;
        constraints.gridy = tenthCellY;
        add(this.armLeft, constraints);

        constraints.gridx = fifthCellX;
        constraints.gridy = tenthCellY;
        add(this.armRight, constraints);

        constraints.gridx = fourthCellX;
        constraints.gridy = ninthCellY;
        add(this.armUp, constraints);

        constraints.gridx = fourthCellX;
        constraints.gridy = eleventhCellY;
        add(this.armDown, constraints);

        constraints.gridx = sixthCellX;
        constraints.gridy = ninthCellY;
        add(this.armFront, constraints);

        constraints.gridx = sixthCellX;
        constraints.gridy = eleventhCellY;
        add(this.armBack, constraints);
    }

    void setKeyboardButtons() {

        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                int c = e.getKeyCode();
                switch (c) {
                    case KeyEvent.VK_W:
                    case KeyEvent.VK_S:
                        bodyStop.doClick();
                        break;
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                int c = e.getKeyCode();
                switch (c) {
                    case KeyEvent.VK_A:
                        bodyLeft.doClick();
                        break;
                    case KeyEvent.VK_D:
                        bodyRight.doClick();
                        break;
                    case KeyEvent.VK_W:
                        bodyFront.doClick();
                        break;
                    case KeyEvent.VK_S:
                        bodyBack.doClick();
                        break;
                    case KeyEvent.VK_LEFT:
                        cameraLeft.doClick();
                        break;
                    case KeyEvent.VK_RIGHT:
                        cameraRight.doClick();
                        break;
                    case KeyEvent.VK_UP:
                        cameraUp.doClick();
                        break;
                    case KeyEvent.VK_DOWN:
                        cameraDown.doClick();
                        break;
                    case KeyEvent.VK_J:
                        armLeft.doClick();
                        break;
                    case KeyEvent.VK_L:
                        armRight.doClick();
                        break;
                    case KeyEvent.VK_I:
                        armUp.doClick();
                        break;
                    case KeyEvent.VK_K:
                        armDown.doClick();
                        break;
                    case KeyEvent.VK_U:
                        armBack.doClick();
                        break;
                    case KeyEvent.VK_O:
                        armFront.doClick();
                        break;
                }
            }
        });
    }

    void setListeners() {
        bodyLeft.addActionListener(actionEvent -> servoController.sendCommand("BodyLeft"));
        bodyRight.addActionListener(actionEvent -> servoController.sendCommand("BodyRight"));
        bodyFront.addActionListener(actionEvent -> servoController.sendCommand("BodyFront"));
        bodyBack.addActionListener(actionEvent -> servoController.sendCommand("BodyBack"));
        bodyStop.addActionListener(actionEvent -> servoController.sendCommand("BodyStop"));
        cameraLeft.addActionListener(actionEvent -> servoController.sendCommand("CameraXTurnLeft"));
        cameraRight.addActionListener(actionEvent -> servoController.sendCommand("CameraXTurnRight"));
        cameraUp.addActionListener(actionEvent -> servoController.sendCommand("CameraYTurnUp"));
        cameraDown.addActionListener(actionEvent -> servoController.sendCommand("CameraYTurnDown"));
        armLeft.addActionListener(actionEvent -> servoController.sendCommand("ArmXTurnLeft"));
        armRight.addActionListener(actionEvent -> servoController.sendCommand("ArmXTurnRight"));
        armUp.addActionListener(actionEvent -> servoController.sendCommand("ArmYTurnUp"));
        armDown.addActionListener(actionEvent -> servoController.sendCommand("ArmYTurnDown"));
        armFront.addActionListener(actionEvent -> servoController.sendCommand("ArmCompress"));
        armBack.addActionListener(actionEvent -> servoController.sendCommand("ArmDeCompress"));
    }
}
