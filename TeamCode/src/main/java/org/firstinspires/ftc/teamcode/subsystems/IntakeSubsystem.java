package org.firstinspires.ftc.teamcode.subsystems;

import android.graphics.Color;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.ColorRangeSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.NormalizedColorSensor;
import com.qualcomm.robotcore.hardware.NormalizedRGBA;

public class IntakeSubsystem extends SubsystemBase {

    //Define motors and servos
    private DcMotor intakeMotor;
    private DcMotor intakeSlideMotor;

    public Servo intakePivot;

    private NormalizedColorSensor colourSensor;

    // Define variables
    private int intakeSlidesInPosition = 0;
    private int intakeSlidesOutPosition = 0;

    private int intakePivotUpPosition = 0;
    private int intakePivotDownPosition = 0;

    private final float[] hsvValues = new float[3];

    private SampleColour desiredColour = SampleColour.NONE;

    public enum SampleColour
    {
        NONE,
        RED,
        BLUE,
        NEUTRAL,

        RED_OR_NEUTRAL,

        BLUE_OR_NEUTRAL
    }

    public IntakeSubsystem(final HardwareMap hMap){
        intakeMotor = hMap.get(DcMotor.class, "intakeMotor");
        intakeSlideMotor = hMap.get(DcMotor.class, "intakeSlideMotor");

        intakePivot = hMap.get(Servo.class, "pivotIntake");

        colourSensor = hMap.get(NormalizedColorSensor.class, "colourSensor");
    }

    public void Intake() {
        //Turns the intake on
        intakeMotor.setPower(1);
    }

    public void IntakeOff(){
        intakeMotor.setPower(0);
    }

    public void Outtake() {
        //Revers the intake
        intakeMotor.setPower(-1);
    }

    public void intakeSlidesIn() {
        //Brings the slides in
        intakeSlideMotor.setTargetPosition(intakeSlidesInPosition);
        intakeSlideMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        intakeSlideMotor.setPower(1);
    }

    public boolean AreIntakeSlidesIn() {
        return intakeSlideMotor.getCurrentPosition() < (intakeSlidesInPosition + 50);
    }

    public void intakeSlidesOut() {
        //Brings the slides out
        intakeSlideMotor.setTargetPosition(intakeSlidesOutPosition);
        intakeSlideMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        intakeSlideMotor.setPower(1);
    }

    public boolean AreIntakeSlidesOut() {
        return intakeSlideMotor.getCurrentPosition() > (intakeSlidesInPosition - 50);
    }

    public void intakePivotUp () {
        intakePivot.setPosition(intakePivotUpPosition);
    }

    public boolean IsIntakePivotedUp() {
        return intakePivot.getPosition() > (intakePivotUpPosition - 0.3);
    }

    public void intakePivotDown () {
        intakePivot.setPosition(intakePivotDownPosition);
    }

    public boolean IsIntakePivotedDown() {
        return intakePivot.getPosition() < (intakePivotDownPosition + 0.3);
    }

    public void setDesiredColourBlue() {
        desiredColour = SampleColour.BLUE;
    }

    public boolean IsDesiredColourBlueSet() {
        return true;
    }

    public void setDesiredColourRed() {
        desiredColour = SampleColour.RED;
    }

    public boolean IsDesiredColourRedSet() {
        return true;
    }

    public void setDesiredColourNeutral() {
        desiredColour = SampleColour.NEUTRAL;
    }

    public boolean IsDesiredColourNeutralSet() {
        return true;
    }

    public SampleColour getCurrentIntakeColour(){
        NormalizedRGBA colors = colourSensor.getNormalizedColors();
        Color.colorToHSV(colors.toColor(), hsvValues);

        if(hsvValues[0] > 200) {
            return SampleColour.BLUE;
        }
        if(hsvValues[0] >= 70 && hsvValues[0] <= 100) {
            return SampleColour.NEUTRAL;
        }
        if(hsvValues[0] >= 20) {
            return SampleColour.RED;
        }
        return SampleColour.NONE;
    }

    public void colourAwareIntake(){

        if(getCurrentIntakeColour() == SampleColour.NONE){
            this.Intake();
        }else if(getCurrentIntakeColour() == desiredColour){
            this.IntakeOff();
        }else{
            this.Outtake();
        }
    }
}
