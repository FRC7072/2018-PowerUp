package org.usfirst.frc.team7072.robot.commands;

import org.usfirst.frc.team7072.robot.Robot;
import org.usfirst.frc.team7072.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class DriveWithJoysticks extends Command {
	
	public DriveWithJoysticks() {
		requires(Robot.driveTrain);
	}
	
	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		super.initialize();
	}
	
	@Override
	protected void execute() {
		super.execute();
		if (Robot.driveTrain.shouldUseTankControl()) {
			double leftValue = Robot.oi.getPilotController(). getRawAxis(RobotMap.leftJoystickYAxis);
			double rightValue = Robot.oi.getPilotController(). getRawAxis(RobotMap.rightJoystickYAxis);
			
			Robot.driveTrain.tankDrive(-leftValue, -rightValue);
		} else {
			double speed = Robot.oi.getPilotController().getRawAxis(RobotMap.leftJoystickYAxis);
			double rotation = Robot.oi.getPilotController().getRawAxis(RobotMap.rightJoystickXAxis);
			
			Robot.driveTrain.arcadeDrive(-speed, rotation * 0.75);
		}
	}
	

	@Override
	protected boolean isFinished() {
		return false;
	}

}
