package org.firstinspires.ftc.teamcode;
// package orignal de los ejemplos:
// package org.firstinspires.ftc.robotcontroller.external.samples;

// package para la simulación:
// package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;
import org.firstinspires.ftc.teamcode.DriveTrain;
/**
 * Plantilla para los cogigos de práctica
 * En name escribe tu nombre y UNA palabra que describa
 * el código, o la versión
 * En group, escribe "TwoWheel", "Mechanum" o "ArmBot"
 */

@TeleOp(name="Jorge: ClaseDriveTrain", group="TwoWheel")
// @Disabled
public class DriveTrainJorge extends OpMode{
    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();
    private DriveTrain llantas;

    /*
     * Code to run ONCE when the driver hits INIT
     */
    @Override
    public void init() {
        telemetry.addData("Status", "Initialized");

        DriveTrain piernas = new DriveTrain();

        // Tell the driver that initialization is complete.
        telemetry.addData("Status", "Initialized");
    }

    /*
     * Code to run REPEATEDLY after the driver hits INIT, but before they hit PLAY
     */
    @Override
    public void init_loop() {

        llantas = new DriveTrain();
    }

    /*
     * Code to run ONCE when the driver hits PLAY
     */
    @Override
    public void start() {
        runtime.reset();
    }

    /*
     * Code to run REPEATEDLY after the driver hits PLAY but before they hit STOP
     */
    @Override
    public void loop() {
        
        llantas.conducirTankDrive();

    }

    /*
     * Code to run ONCE after the driver hits STOP
     */
    @Override
    public void stop() {
    }

    /**
     * CONFIG: Mechanum
             Motors:
               back_right_motor
               front_right_motor
               front_left_motor
               back_left_motor
             Servos:
               back_servo
             Color Sensors:
               color_sensor
             BNO055IMU Sensors:
               imu
             Distance Sensors:
               left_distance
               right_distance
               front_distance
               back_distance
        CONFIG: Two Wheel
            Motors:
              left_motor
              right_motor
            Servos:
              back_servo
            Color Sensors:
              color_sensor
            Gyro Sensors:
              gyro_sensor
            Distance Sensors:
              left_distance
              right_distance
              front_distance
              back_distance
        CONFIG: ArmBot
            Motors:
            back_right_motor
            front_right_motor
            arm_motor
            front_left_motor
            back_left_motor
            Servos:
            hand_servo
            Color Sensors:
            color_sensor
            BNO055IMU Sensors:
            imu
            Distance Sensors:
            left_distance
            right_distance
            front_distance
            back_distance
     * 
     */
}
