package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.GamePad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class ArmServo {

    //Atributos
    private static Servo servo = null;
    private static GamePad gamePad;

    //Constructor
    public ArmServo (HardwareMap hardwareMap, GamePad gamePad){
        this.servo = hardwareMap.get(Servo.class, "back_servo");
        this.gamePad = gamePad;

    }

    public void moverServo (){
        if (gamePad.a) {
            servo.setPosition(0.5);
        } else if (gamePad.b) {
            servo.setPosition(0);
        } else if (gamePad.x){
            servo.setPosition(1);
        }else{

        }

    }

}

//Los encoders controlar el movimiento del motor
//How long
//El motor tiene 20 ticks
//Diámetro para la circunferencia, y la cantidad de ticks
//longCirferencia (cm) =  nTicks encoder
// N_cm = nTicks ????
//nTicks = DistanciaDeseada/circunferencia


