package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

//Clase del subsistema "piernas" del robot
public class DriveTrain extends OpMode {
    //Atributos
    private static DcMotor motorDerecha = null;
    private static DcMotor motorIzquierda = null;
    @Override
    public void init() {}
    @Override
    public void loop() {}
    //Constructor
    public DriveTrain (){
        motorIzquierda  = hardwareMap.get(DcMotor.class, "left_motor");
        motorDerecha = hardwareMap.get(DcMotor.class, "right_motor");
        
        
        motorIzquierda.setDirection(DcMotor.Direction.FORWARD);
        motorDerecha.setDirection(DcMotor.Direction.REVERSE);
    }
    
    //Conducir con POV
    public void conducirPOV (){
        double leftPower;
        double rightPower;

        double drive = -gamepad1.left_stick_y;
        double turn  =  gamepad1.right_stick_x;
        leftPower    = Range.clip(drive + turn, -1.0, 1.0);
        rightPower   = Range.clip(drive - turn, -1.0, 1.0);

        motorIzquierda.setPower(leftPower);
        motorDerecha.setPower(rightPower);
    }
    //Conducir con TankDrive
    public void conducirTankDrive(){
        double leftPower;
        double rightPower;

        leftPower  = -gamepad1.left_stick_y ;
        rightPower = -gamepad1.right_stick_y ;

        motorIzquierda.setPower(leftPower);
        motorDerecha.setPower(rightPower);
    }

}