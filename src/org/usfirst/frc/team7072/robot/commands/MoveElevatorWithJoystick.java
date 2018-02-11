package org.usfirst.frc.team7072.robot.commands;

import org.usfirst.frc.team7072.robot.Robot;
import org.usfirst.frc.team7072.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class MoveElevatorWithJoystick extends Command {
	

	public MoveElevatorWithJoystick() {
		requires(Robot.elevator);
	}
	
	@Override
	protected void execute() {
		super.execute();
		
		double liftValue = Robot.oi.getCopilotController().getRawAxis(RobotMap.rightJoystickYAxis);
		
		Robot.elevator.getLiftEncoderPosition();
		
		Robot.elevator.setSetpoint(liftValue * 4096);
		
		
		
	}
	
	@Override
	protected boolean isFinished() {
		
		return false;
	}

}
