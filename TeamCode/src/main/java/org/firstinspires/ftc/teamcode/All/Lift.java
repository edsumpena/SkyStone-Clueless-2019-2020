package org.firstinspires.ftc.teamcode.All;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Lift {
    public enum Direction{
        UP, DOWN
    }
    double speedMultiplier = 1;

    // Constants used to adjust various parameters / characteristics of the drivetrain
    final double rotSpeed = 0.75;
    final double speedThreshold = 0.05;
    private org.firstinspires.ftc.teamcode.All.HardwareMap hwMap;

    public Lift(HardwareMap map){
        hwMap = new org.firstinspires.ftc.teamcode.All.HardwareMap(map);
    }

    public void resetEncoders() {
        DcMotor.RunMode runMode = hwMap.liftOne.getMode();
        setMotorMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        setMotorMode(runMode);
    }

    public void setMotorMode(DcMotor.RunMode runMode) {
        hwMap.liftOne.setMode(runMode);
    }

    // Sets the "overall" speed of the drivetrain
    public void setSpeedMultiplier(double speedMultiplier) {
        this.speedMultiplier = speedMultiplier;
    }

    public void stop() {
        hwMap.liftOne.setPower(0);
        hwMap.liftTwo.setPower(0);
    }

    public void setMotorZeroPower(DcMotor.ZeroPowerBehavior zeroPower) {
        hwMap.liftOne.setZeroPowerBehavior(zeroPower);
        hwMap.liftTwo.setZeroPowerBehavior(zeroPower);
    }

    public void setPower(DcMotor motor, double speed) {
        motor.setPower((speed * speedMultiplier));
    }

    public void moveLift(double power){
        setPower(hwMap.liftOne, power);
        setPower(hwMap.liftTwo, power);
    }

    public void detectResetEncoder(){
        if(hwMap.liftReset.getState())
            resetEncoders();
    }


}