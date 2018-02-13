package org.usfirst.frc.team7072.robot.commands;

import org.usfirst.frc.team7072.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class AutoMoveElevatorToPosition extends Command {
	
	double position;
	
	public AutoMoveElevatorToPosition(double position) {
		requires(Robot.elevator);
		
		this.position = position;
	
	}
	
	@Override
	protected void initialize() {
		super.initialize();
		
		Robot.elevator.setSetpoint(position);
	}
	@Override
	protected void execute() {
		super.execute();
		
		Robot.elevator.enable();
	}
	
	
	@Override
	protected boolean isFinished() {
		return Robot.elevator.onTarget();
	}

}
