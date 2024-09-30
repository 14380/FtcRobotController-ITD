package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.hardware.limelightvision.LLResult;
import com.qualcomm.hardware.limelightvision.Limelight3A;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class VisionSubsystem extends SubsystemBase {

    private Limelight3A limelight;

    private final int RED_PIPELINE = 1;
    private final int BLUE_PIPELINE = 1;


    public VisionSubsystem(final HardwareMap hMap) {

        limelight = hMap.get(Limelight3A.class, "limelight");

    }

    public void StartLimelight(){
        limelight.start();
    }

    public void StopLimelight(){
        limelight.stop();
    }

    public boolean IsBlueSampleReady(){

        //Switch to the correct pipeline
        limelight.pipelineSwitch(BLUE_PIPELINE);

        //check the results from the limelight

        return IsItemFound();
    }

    public boolean IsRedSampleReady(){

        //Switch to the correct pipeline
        limelight.pipelineSwitch(RED_PIPELINE);

        //check the results from the limelight

        return IsItemFound();
    }

    private boolean IsItemFound(){

        LLResult result = limelight.getLatestResult();
        if (result != null && result.isValid()) {

            //can add further checks, but for now, we have found an object,
            return true;
        }
        return false;
    }
}
