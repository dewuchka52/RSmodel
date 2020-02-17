import arduino.Arduino;

class ServoController {
    private Arduino arduino = new Arduino("COM9", 9600);

    private String data = "<a=0 v=0>";

    private int saveValueCameraX = 15;
    private int saveValueCameraY = 21;
    private int saveValueArmX = 9;
    private int saveValueArmY = 4;

    ServoController() {
        boolean connected = arduino.openConnection();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        arduino.serialWrite(data);
    }


    void sendCommand(String s) {
        switch (s) {
            case "BodyStop":
                data = "<a=0 v=>";
                arduino.serialWrite(data);

                break;
            case "BodyFront":
                data = "<a=1 v=0>";
                arduino.serialWrite(data);
                break;

            case "BodyBack":
                data = "<a=2 v=0>";
                arduino.serialWrite(data);
                break;

            case "BodyRight":
                data = "<a=0 v=24>";
                arduino.serialWrite(data);
                break;

            case "BodyLeft":
                data = "<a=0 v=25>";
                arduino.serialWrite(data);
                break;

            case "ArmYTurnDown":
                data = "<a=0 v=";
                if (saveValueArmY > 2) {
                    saveValueArmY--;
                    data = data + saveValueArmY;
                    data = data + ">";
                    arduino.serialWrite(data);
                }
                break;

            case "ArmYTurnUp":
                data = "<a=0 v=";
                if (saveValueArmY < 6) {
                    saveValueArmY++;
                    data = data + saveValueArmY;
                    data = data + ">";
                    arduino.serialWrite(data);
                }
                break;

            case "ArmXTurnRight":
                data = "<a=0 v=";
                if (saveValueArmX > 7) {
                    saveValueArmX--;
                    data = data + saveValueArmX;
                    data = data + ">";
                    arduino.serialWrite(data);
                }
                break;

            case "ArmXTurnLeft":
                data = "<a=0 v=";
                if (saveValueArmX < 11) {
                    saveValueArmX++;
                    data = data + saveValueArmX;
                    data = data + ">";
                    arduino.serialWrite(data);
                }
                break;

            case "ArmCompress":
                data = "<a=0 v=12>";
                arduino.serialWrite(data);
                break;

            case "ArmDeCompress":
                data = "<a=0 v=13>";
                arduino.serialWrite(data);
                break;

            case "CameraXTurnRight":
                data = "<a=0 v=";
                if (saveValueCameraX > 14) {
                    saveValueCameraX--;
                    data = data + saveValueCameraX;
                    data = data + ">";
                    arduino.serialWrite(data);
                }
                break;

            case "CameraXTurnLeft":
                data = "<a=0 v=";
                if (saveValueCameraX < 18) {
                    saveValueCameraX++;
                    data = data + saveValueCameraX;
                    data = data + ">";
                    arduino.serialWrite(data);
                }
                break;

            case "CameraYTurnDown":
                data = "<a=0 v=";
                if (saveValueCameraY > 19) {
                    saveValueCameraY--;
                    data = data + saveValueCameraY;
                    data = data + ">";
                    arduino.serialWrite(data);
                }
                break;

            case "CameraYTurnUp":
                data = "<a=0 v=";
                if (saveValueCameraY < 23) {
                    saveValueCameraY++;
                    data = data + saveValueCameraY;
                    data = data + ">";
                    arduino.serialWrite(data);
                }
                break;


            case "exit":
                arduino.serialWrite('0');
                arduino.closeConnection();
                break;

            default:
                System.out.println(s + " - не является командой");
                break;
        }
    }
}



