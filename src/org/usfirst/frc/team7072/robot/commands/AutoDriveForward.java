package org.usfirst.frc.team7072.robot.commands;

import org.usfirst.frc.team7072.robot.Robot;

import edu.wpi.first.wpilibj.command.*;

/**
 *
 */
public class AutoDriveForward extends PIDCommand {
	
	private double wheelRotations;
	private double travelDistance;
	private double Circumference = 6 * Math.PI;
	
    public AutoDriveForward(double distance) {
    	super(0.5, 0, 0);
    	requires(Robot.driveTrain);
    	
    	getPIDController().setAbsoluteTolerance(.1);
    	getPIDController().setSetpoint(distance);
    	
    	
    	// Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }
    
    // Called just before this Command runs the first time
    protected void initialize() {
    	super.initialize();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	getPIDController().enable();
    	
    }
    
    
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return getPIDController().onTarget();
    }

    
    @Override
    protected void end() {
    	Robot.driveTrain.stopDrive();
    }
    
	@Override
	protected double returnPIDInput() {
		wheelRotations = Robot.driveTrain.getLeftEncoderPosition() / 4096;
    	travelDistance = wheelRotations * Circumference;
    	
		return travelDistance;
	}

	@Override
	protected void usePIDOutput(double output) {
		// TODO Auto-generated method stub
		Robot.driveTrain.tankDrive(output, output);
		
	}
}