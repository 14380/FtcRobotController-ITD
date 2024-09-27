package com.example.meepmeeptesting;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

public class MeepMeepTesting {
    public static void main(String[] args) {
        System.setProperty("sun.java2d.opengl", "true");
        MeepMeep meepMeep = new MeepMeep(400,120);

        RoadRunnerBotEntity myBot = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(50, 50, Math.toRadians(180), Math.toRadians(180), 15)
                .setDimensions(18,18)
                .build();

        myBot.runAction(myBot.getDrive().actionBuilder(new Pose2d(25, -61, Math.toRadians(90)))
                .strafeToConstantHeading(new Vector2d(47, -44))
                .waitSeconds(0.25)

                .turnTo(Math.toRadians(70))
                        .waitSeconds(0.25)

                        .strafeToConstantHeading(new Vector2d(57,-44))
                        .waitSeconds(0.25)


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

                .strafeTo(new Vector2d(35, -49))
                .waitSeconds(0.25)

                .build());

        meepMeep.setBackground(MeepMeep.Background.FIELD_INTO_THE_DEEP_JUICE_DARK)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot)
                .start();
    }
}