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
		
		double currentPosition = Robot.elevator.getLiftEncoderPosition();
		double setpoint = currentPosition + (liftValue * 4096);
		
		//TODO: cap setpoint at top and bottom limit
		
		Robot.elevator.setSetpoint(setpoint);
		
		Robot.elevator.enable();
	}
	
	@Override
	protected boolean isFinished() {
		
		return false;
	}

}
