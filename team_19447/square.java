package org.firstinspires.ftc.teamcode.team_19447;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

public class square extends LinearOpMode {

    //Set motor variables
    private DcMotor motorFL;
    private DcMotor motorBL;
    private DcMotor motorFR;
    private DcMotor motorBR;

    @Override
    public void runOpMode() {

        //Initialize motors
        motorFL = hardwareMap.get(DcMotor.class, "motorFrontLeft");
        motorBL = hardwareMap.get(DcMotor.class, "motorBackLeft");
        motorFR = hardwareMap.get(DcMotor.class, "motorFrontRight");
        motorBR = hardwareMap.get(DcMotor.class, "motorBackRight");

        //set mode to stop and reset encoders -- resets encoders to the 0 position
        motorFL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorBL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorFR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorBR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        //Reverse left side motors
        motorFL.setDirection(DcMotorSimple.Direction.REVERSE);
        motorBL.setDirection(DcMotorSimple.Direction.REVERSE);

        //Initialize the positions to zero, since the motor has not moved yet
        //Initializing encoder positions

        motorFL.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorBL.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorFR.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorBR.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        //any code after this command will not be executed until the match has started
        waitForStart();

        //can now set drive distance because of the function below; now we just need to input the distance
        //can also control the direction using the mecanum drivetrain directions here: https://gm0.org/en/latest/docs/software/tutorials/mecanum-drive.html
        encoderTestingFinal encoders = new encoderTestingFinal();

        //ex: this command will get the robot to travel forward (all target values are positive) for 10cm at a speed of 2
        encoders.drive(60, 60, 60, 60, 1);

        //ex: this command will get the robot to strafe left for 9cm at a speed of 1
        encoders.drive(-60, 60, 60, -60, 1);

        encoders.drive(-60, -60, -60,-60, 1);

        //Strafe right:
        encoders.drive(60, -60, -60, 60, 1);

        encoders.drive(60, 60, 60, 60, 1);

        motorFL.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        motorBL.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        motorFR.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        motorBR.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        while (opModeIsActive()) {
            telemetry.addData("motorFL Encoder Position: ", motorFL.getCurrentPosition());
            telemetry.addData("motorBL Encoder Position: ", motorBL.getCurrentPosition());
            telemetry.addData("motorFR Encoder Position: ", motorFR.getCurrentPosition());
            telemetry.addData("motorBR Encoder Position: ", motorBR.getCurrentPosition());
            telemetry.update();
        }
    }

}