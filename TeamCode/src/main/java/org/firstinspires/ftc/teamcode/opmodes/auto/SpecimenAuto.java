package org.firstinspires.ftc.teamcode.opmodes.auto;
import androidx.collection.ArraySet;

import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.CommandScheduler;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitUntilCommand;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.commands.ActionCommand;
import org.firstinspires.ftc.teamcode.utils.OTOSDrive;

@Autonomous(name = "SpecimenAuto", group = "Autonomous")
public class SpecimenAuto extends CommandOpMode {

    Action specimenAction;
    @Override
    public void initialize() {

        // instantiate your MecanumDrive at a particular pose.
        OTOSDrive drive = new OTOSDrive(hardwareMap,
                new Pose2d(25, -61, Math.toRadians(90)));

        specimenAction = drive.actionBuilder(drive.pose)
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

                .strafeTo(new Vector2d(35, -49))
                .waitSeconds(0.25)

                .strafeTo(new Vector2d(12,-37))
                .waitSeconds(0.25)

                .strafeTo(new Vector2d(39, -53))
                .waitSeconds(0.25)

                .build();

        CommandScheduler.getInstance().schedule(
                new WaitUntilCommand(this::isStarted).andThen(
                    new SequentialCommandGroup(
                            new ActionCommand( specimenAction, new ArraySet<>())
                    )
                )
        );

    }

}
