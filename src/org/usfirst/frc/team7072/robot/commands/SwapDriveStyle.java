package org.usfirst.frc.team7072.robot.commands;

import org.usfirst.frc.team7072.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class SwapDriveStyle extends Command {
	
	@Override
	protected void execute() {
		
		boolean currentDriveStyle = Robot.driveTrain.shouldUseTankControl();
		
		Robot.driveTrain.setUseTankControl(! currentDriveStyle);
		Robot.driveTrain.resetEncoders();
		super.execute();
	}

	@Override
	protected boolean isFinished() {
		
		return true;
	}

}
