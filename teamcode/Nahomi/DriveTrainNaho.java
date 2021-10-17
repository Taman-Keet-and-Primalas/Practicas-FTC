package Nahomi;
import org.firstinspires.ftc.teamcode;


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

    public int calcular (int distancia){
        int ticks = 1400;
        double circumferencia = 5*(Math.PI);
        double tickscm = ticks/circumferencia;
        double avance = distancia*tickscm;

        return (int) avance;
    }

    public void moveWencoders(int ticks, int distance, double power){
        motorDerecha.setMode(DCMotorController.RunMode.STOP_AND_RESET_ENCODER);
        motorIzquierda.setMode(DCMotorController.RunMode.STOP_AND_RESET_ENCODER);

        //ser Target position 
        motorDerecha.setTargetPosition(calcular(distancia));
        motorIzquierda.setTargetPosition(calcular(distancia));

        //set to Run To Position mode
        motorDerecha.setMode(DcMotorController.RunMode.RUN_TO_POSITION);
        motorIzquierda.setMode(DcMotorController.RunMode.RUN_TO_POSITION);

        //set drive power
        DriveForward(power);
        motorDerecha.setPower(power);
        motorIzquierda.setPower(power);

        while (motorDerecha.isBusy() && motorIzquierda.isBusy()){
            telemetry.addData("Left Position", motorIzquierda.getCurrentPostion());
            telemetry.addData("Right Position", motorDerecha.getCurrentPosition());
        }

        DriveForward(0);
        motorDerecha.setPower(0);
        motorIzquierda.setPower(0);
     
    }
}