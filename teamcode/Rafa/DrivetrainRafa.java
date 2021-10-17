package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.GamePad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.Range;
import virtual_robot.controller.VirtualRobotController;

//Clase del subsistema "piernas" del robot
public class DriveTrain {

    //Atributos
    private static DcMotor motorDerecha = null;
    private static DcMotor motorIzquierda = null;
    private static GamePad gamepad1;

    public DriveTrain (HardwareMap hardwareMap, GamePad gamepad1){
        this.gamepad1 = gamepad1;

        System.out.println("Started maps");
        motorIzquierda  = hardwareMap.get(DcMotor.class, "left_motor");
        motorDerecha = hardwareMap.get(DcMotor.class, "right_motor");
        System.out.println("Finished maps");
        motorIzquierda.setDirection(DcMotor.Direction.FORWARD);
        motorDerecha.setDirection(DcMotor.Direction.REVERSE);

    }
    
    //Conducir con POV
    //Pasamos como parametro los valores drive y turn
    public void conducirPOV (double drive, double turn){
        double leftPower;
        double rightPower;


        leftPower    = Range.clip(drive + turn, -1.0, 1.0);
        rightPower   = Range.clip(drive - turn, -1.0, 1.0);

        motorIzquierda.setPower(leftPower);
        motorDerecha.setPower(rightPower);
    }
    //Conducir con TankDrive
    //Pasar como atributo el objeto gamepad1
    public void conducirTankDrive(){
        double leftPower;
        double rightPower;

        leftPower  = -gamepad1.left_stick_y ;
        rightPower = -gamepad1.right_stick_y ;

        motorIzquierda.setPower(leftPower);
        motorDerecha.setPower(rightPower);
    }

}