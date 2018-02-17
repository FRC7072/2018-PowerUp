package org.usfirst.frc.team7072.robot.commands;

import org.usfirst.frc.team7072.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ConfigElevator extends Command {

	private boolean bottomedOut = false;
	
    public ConfigElevator() {
    	requires(Robot.elevator);
    }
    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (Robot.elevator.getLowerSwitch()) {
    		bottomedOut = true;
    		Robot.elevator.resetEncoder();
    	}
    	
    	if (bottomedOut) {
    		Robot.elevator.elevatorUp();
    	} else {
        	Robot.elevator.elevatorDown();
    	}
	}

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return false;// Robot.elevator.getUpperSwitch();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.elevator.setMaxHeight(Robot.elevator.getLiftEncoderPosition());
    	
    	Robot.elevator.free();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
