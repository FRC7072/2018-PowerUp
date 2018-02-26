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
		
//		double currentPosition = Robot.elevator.getLiftEncoderPosition();
//		double setpoint = currentPosition + (liftValue * 4096);
//		
//		setpoint = Math.max(0, Math.min(setpoint, Robot.elevator.getMaxHeight()));
//		
//		Robot.elevator.setSetpoint(setpoint);
//		
//		if(!Robot.elevator.onTarget())
//			Robot.elevator.enable();
		
		Robot.elevator.moveElevator(liftValue);
	}
	
	@Override
	protected boolean isFinished() {
		return false;
	}

}
