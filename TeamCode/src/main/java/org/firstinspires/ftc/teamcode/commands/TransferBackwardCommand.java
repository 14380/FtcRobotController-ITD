package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystems.TransferSubsystem;

public class TransferBackwardCommand extends CommandBase {

    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
    private final TransferSubsystem transferSubsystem;


    public TransferBackwardCommand(TransferSubsystem subsystem) {
        transferSubsystem = subsystem;
        // Use addRequirements() here to declare subsystem dependencies.
        addRequirements(subsystem);
    }

    @Override
    public void initialize() {
        transferSubsystem.backwardsTransfer();
    }

    @Override
    public boolean isFinished() {
        return transferSubsystem.IsTransferBackwards();
    }
}