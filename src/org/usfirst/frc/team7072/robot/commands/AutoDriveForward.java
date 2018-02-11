package org.usfirst.frc.team7072.robot.commands;

import org.usfirst.frc.team7072.robot.Robot;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.*;
import edu.wpi.first.wpilibj.interfaces.Gyro;

/**
 *
 */
public class AutoDriveForward extends PIDCommand {
	
	private double wheelRotations;
	private double travelDistance;
	private double Circumference = 6 * Math.PI;
	
    public AutoDriveForward() {
    	super(.5, 0, 0);
    	requires(Robot.driveTrain);
    	
    	
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	wheelRotations = Robot.driveTrain.getLeftEncoderPosition() / 4096;
    	travelDistance = wheelRotations * Circumference;
    	
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }

	@Override
	protected double returnPIDInput() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected void usePIDOutput(double output) {
		// TODO Auto-generated method stub
		
	}
}
