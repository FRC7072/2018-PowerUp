package org.usfirst.frc.team7072.robot.commands;

import org.usfirst.frc.team7072.robot.Robot;

import edu.wpi.first.wpilibj.command.PIDCommand;

public class AutoDriveRotate extends PIDCommand{
	
    public AutoDriveRotate(double rotations) {
    	
    	super(0.5, 0, 0);
    	requires(Robot.driveTrain);
    	
    	getPIDController().setAbsoluteTolerance(5);
    	getPIDController().setSetpoint(rotations);
    	
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	super.initialize();
    	Robot.driveTrain.resetGyro();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	getPIDController().enable();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return getPIDController().onTarget();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    @Override
    protected double returnPIDInput() {
    	return Robot.driveTrain.getAngle();
    }
    
    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }

	@Override
	protected void usePIDOutput(double output) {
		// TODO Auto-generated method stub
		Robot.driveTrain.tankDrive(output, -output);
	}
}
