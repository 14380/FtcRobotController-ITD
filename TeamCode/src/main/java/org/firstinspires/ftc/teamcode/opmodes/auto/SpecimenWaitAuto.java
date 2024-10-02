package org.firstinspires.ftc.teamcode.opmodes.auto;
import androidx.collection.ArraySet;


import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.CommandScheduler;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitUntilCommand;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.TrajectoryActionBuilder;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.MecanumDrive;
import org.firstinspires.ftc.teamcode.commands.ActionCommand;
import org.firstinspires.ftc.teamcode.subsystems.VisionSubsystem;
import org.firstinspires.ftc.teamcode.utils.OTOSDrive;
import org.firstinspires.ftc.teamcode.MecanumDrive.*;


@Autonomous(name = "SpecimenWaitAuto", group = "Autonomous")
public class SpecimenWaitAuto extends CommandOpMode {

    private Action specimenAction;

    private Action pickupAction1;
    private Action dropOffAction1;

    private Action pickupAction2;

    private Action pickupAction3;

    private TrajectoryActionBuilder t0;
    private TrajectoryActionBuilder t1;
    private TrajectoryActionBuilder t2;

    private VisionSubsystem vision;

    @Override
    public void initialize() {
 // instantiate your MecanumDrive at a particular pose.
        OTOSDrive drive = new OTOSDrive(hardwareMap,
                new Pose2d(25, -61, Math.toRadians(90)));


        vision = new VisionSubsystem(hardwareMap);

        vision.StartLimelight();


       t0 = drive.actionBuilder(drive.pose)
                .strafeToConstantHeading(new Vector2d(47, -44))
                .waitSeconds(0.25)

                .turnTo(Math.toRadians(70))
                .waitSeconds(0.25)

                .strafeToConstantHeading(new Vector2d(57,-44))
                .waitSeconds(0.25)

                .setTangent(Math.toRadians(180))
                .splineToLinearHeading(new Pose2d(35, -49, Math.toRadians(-45)), Math.toRadians(-135))
                .waitSeconds(0.25)

                .strafeTo(new Vector2d(12,-37))
                //.splineToLinearHeading(new Pose2d(10, -35, Math.toRadians(-90)), Math.toRadians(90))
                .waitSeconds(0.25);

                /*.strafeTo(new Vector2d(35, -49))
                .waitSeconds(0.25)

                .strafeTo(new Vector2d(12,-37))
                .waitSeconds(0.25)

                .strafeTo(new Vector2d(35, -49))
                .waitSeconds(0.25)

                .strafeTo(new Vector2d(12,-37))
                .waitSeconds(0.25)

                .strafeTo(new Vector2d(35, -49))
                .waitSeconds(0.25)

                .strafeTo(new Vector2d(12,-37))
                .waitSeconds(0.25)

                .strafeTo(new Vector2d(35, -49))
                .waitSeconds(0.25)

                .strafeTo(new Vector2d(12,-37))
                .waitSeconds(0.25)

                .strafeTo(new Vector2d(39, -53))
                .waitSeconds(0.25)*/

               // .build();


        t1 = t0.fresh()
                .strafeTo(new Vector2d(35, -49))
                .waitSeconds(0.25);




        t2 = t1.fresh()
                .strafeTo(new Vector2d(12,-37))
                .waitSeconds(0.25);



        specimenAction = t0.build();
        pickupAction1 = t1.build();
        dropOffAction1 = t2.build();

        CommandScheduler.getInstance().schedule(
                new WaitUntilCommand(this::isStarted).andThen(
                    new SequentialCommandGroup(
                            new ActionCommand( specimenAction, new ArraySet<>()),
                            new WaitUntilCommand(vision::IsBlueSampleReady),
                            new ActionCommand(pickupAction1, new ArraySet<>()),
                            new ActionCommand(dropOffAction1, new ArraySet<>())
                    )
                )
        );

    }

}
