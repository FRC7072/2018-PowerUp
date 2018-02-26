package org.usfirst.frc.team7072.robot.commands;

import org.usfirst.frc.team7072.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class OutputCube extends Command {


	public OutputCube(double range) {
		requires(Robot.intake);
		
	}
	
	
	@Override
	protected void execute() {
		Robot.intake.leftClaw.set(.4);
		Robot.intake.rightClaw.set(-.4);
	}
	
	@Override
	protected boolean isFinished() {
		return Robot.intake.getRange() >= 14;
	}
	
	@Override
	protected void end() {
		Robot.intake.leftClaw.set(0);
		Robot.intake.rightClaw.set(0);
		Robot.intake.free();
	}

}
