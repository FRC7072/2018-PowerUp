package org.usfirst.frc.team7072.robot.commands;

import org.opencv.calib3d.StereoBM;
import org.usfirst.frc.team7072.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.PIDCommand;

public class IntakeCube extends Command {

	double range;
	
	public IntakeCube(double range) {
		requires(Robot.intake);
		
		this.range = range;
	}
	
	
	@Override
	protected void execute() {
		Robot.intake.ultrasonic.isEnabled();
		
		if (Robot.intake.ultrasonic.getRangeInches() > 3) {
			Robot.intake.leftClaw.set(.4);
			Robot.intake.rightClaw.set(-.4);
		}
	}
	
	@Override
	protected boolean isFinished() {
		return Robot.intake.getRange() <= 3;
	}
	
	@Override
	protected void end() {
		super.end();
		Robot.intake.leftClaw.set(0);
		Robot.intake.rightClaw.set(0);
	}

}
