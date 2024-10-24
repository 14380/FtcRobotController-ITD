package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class SlidesSubsystem extends SubsystemBase {

    //Define motors and servos
    private DcMotor verticalSlideMotor;

    // Define variables
    private int stowedSlidesPosition = 0;
    private int lowChamberPosition = 0;
    private int highChamberPosition = 0;
    private int lowBasketPosition = 0;
    private int highBasketPosition = 0;

    public SlidesSubsystem(final HardwareMap hMap) {
        verticalSlideMotor = hMap.get(DcMotor.class, "verticalSlidesMotor");
    }

    public void stowSlides() {
        verticalSlideMotor.setTargetPosition(stowedSlidesPosition);
        verticalSlideMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        verticalSlideMotor.setPower(1);
    }

    public boolean AreSlidesStowed() {
        return verticalSlideMotor.getCurrentPosition() < (stowedSlidesPosition + 50);
    }

    public void lowChamber() {
        verticalSlideMotor.setTargetPosition(lowChamberPosition);
        verticalSlideMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        verticalSlideMotor.setPower(1);
    }

    public boolean IsAtLowChamber() {
        return verticalSlideMotor.getCurrentPosition() > (lowChamberPosition - 50);
    }
    public void highChamber() {
        verticalSlideMotor.setTargetPosition(highChamberPosition);
        verticalSlideMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        verticalSlideMotor.setPower(1);
    }

    public boolean IsAtHighChamber() {
        return verticalSlideMotor.getCurrentPosition() > (highChamberPosition - 50);
    }

    public void lowBasket() {
        verticalSlideMotor.setTargetPosition(lowBasketPosition);
        verticalSlideMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        verticalSlideMotor.setPower(1);
    }

    public boolean IsAtLowBasket() {
        return verticalSlideMotor.getCurrentPosition() > (lowBasketPosition - 50);
    }
    public void highBasket() {
        verticalSlideMotor.setTargetPosition(highBasketPosition);
        verticalSlideMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        verticalSlideMotor.setPower(1);
    }

    public boolean IsAtHighBasket() {
        return verticalSlideMotor.getCurrentPosition() > (highBasketPosition - 50);
    }
}