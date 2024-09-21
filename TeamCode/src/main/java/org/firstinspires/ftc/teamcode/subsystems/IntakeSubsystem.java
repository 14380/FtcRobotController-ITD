package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class IntakeSubsystem extends SubsystemBase {

    //Define motors and servos
    private DcMotor intakeMotor;

    private Servo intakeSlideLeft;
    private Servo intakeSlideRight;
    public Servo intakePivot;

    // Define variables
    private int intakeSlidesInPosition = 0;
    private int intakeSlidesOutPosition = 0;

    private int intakePivotUpPosition = 0;
    private int intakePivotDownPosition = 0;

    public IntakeSubsystem(final HardwareMap hMap){
        intakeMotor = hMap.get(DcMotor.class, "intakeMotor");

        intakeSlideLeft = hMap.get(Servo.class, "intakeSlideLeft");
        intakeSlideRight = hMap.get(Servo.class, "intakeSlideRight");
        intakePivot = hMap.get(Servo.class, "pivotIntake");
    }

    public void Intake() {
        //Turns the intake on
        intakeMotor.setPower(1);
    }

    public void Outtake() {
        //Revers the intake
        intakeMotor.setPower(-1);
    }

    public void intakeSlidesIn() {
        //Brings the slides in
        intakeSlideLeft.setPosition(intakeSlidesInPosition);
        intakeSlideRight.setPosition(intakeSlidesInPosition);
    }

    public boolean AreIntakeSlidesIn() {
        return true;
    }

    public void intakeSlidesOut() {
        //Brings the slides out
        intakeSlideLeft.setPosition(intakeSlidesOutPosition);
        intakeSlideRight.setPosition(intakeSlidesOutPosition);
    }

    public boolean AreIntakeSlidesOut() {
        return true;
    }

    public void intakePivotUp () {
        intakePivot.setPosition(intakePivotUpPosition);
    }

    public boolean IsIntakePivotedUp() {
        return true;
    }

    public void intakePivotDown () {
        intakePivot.setPosition(intakePivotDownPosition);
    }

    public boolean IsIntakePivotedDown() {
        return true;
    }
}
