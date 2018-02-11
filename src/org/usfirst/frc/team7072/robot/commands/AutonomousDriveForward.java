package org.usfirst.frc.team7072.robot.commands;

import org.usfirst.frc.team7072.robot.Robot;
import org.usfirst.frc.team7072.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.command.PIDCommand;

public class AutonomousDriveForward extends PIDCommand {
	

	public AutonomousDriveForward(double distance) {
		super(1, 0, 0);
		
		setSetpoint(distance);
		getPIDController(). setAbsoluteTolerance(distance / 0.10);
		requires(Robot.driveTrain);
	}
	
	
	@Override
	protected void initialize() {
		super.initialize();
		
		Robot.driveTrain.resetEncoders();
	}

	@Override
	protected double returnPIDInput() {
		return Robot.driveTrain.getRightEncoderPosition();
		
	}

	@Override
	protected void usePIDOutput(double output) {
		Robot.driveTrain.tankDrive(output, output);

	}

	@Override
	protected boolean isFinished() {
		return getPIDController().onTarget();
		
	}

}
