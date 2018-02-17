package org.usfirst.frc.team7072.robot.subsystems;


import org.usfirst.frc.team7072.robot.RobotMap;
import org.usfirst.frc.team7072.robot.commands.MoveElevatorWithJoystick;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Elevator extends PIDSubsystem {
	DigitalInput lowerLimit = new DigitalInput(RobotMap.liftLowerLimitSwitch);
	DigitalInput upperLimit = new DigitalInput(RobotMap.liftUpperLimitSwitch);
	
	private double maxHeight = 0;
	
	private WPI_TalonSRX liftMotor = new WPI_TalonSRX(RobotMap.liftMotor);	
	
	public Elevator() {
		super(-0.02, 5, 0);
		
		
		setAbsoluteTolerance(2048);
		
		setSetpoint(0);
		
		liftMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 0);
	}

	public boolean getUpperSwitch() {
		return upperLimit.get();
	}

	public boolean getLowerSwitch() {
		return lowerLimit.get();
	}
	
	public void elevatorUp() {
		if (!getUpperSwitch()) {
			liftMotor.set(1);	
		} else {
			elevatorStop();
		}
	}
	
	public void elevatorDown() {
		if (!getLowerSwitch()) {
			liftMotor.set(-1);	
		} else {
			elevatorStop();
		}
	}
	
	public void elevatorStop() {
		liftMotor.set(0);
	}
	
	public double getLiftEncoderPosition() {
		return liftMotor.getSelectedSensorPosition(0);
	}
	
	public void resetEncoder() {
		liftMotor.setSelectedSensorPosition(0, 0, 0);
	}
	
	public void liftStop() {
		liftMotor.set(0);
	}
	
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new MoveElevatorWithJoystick());
	}

	@Override
	protected double returnPIDInput() {
		
		return getLiftEncoderPosition();
	}
	
	//1 rotation of driveshaft = 1.57079632679 ft traveled

	@Override
	protected void usePIDOutput(double output) {
		
		liftMotor.set(output);
		
	}
	
	public void writeToDashboard() {
		SmartDashboard.putNumber("Lift Encoder", getLiftEncoderPosition());
		SmartDashboard.putBoolean("Lower Limit Switch", getLowerSwitch());
	}

	public double getMaxHeight() {
		return maxHeight;
	}

	public void setMaxHeight(double d) {
		this.maxHeight = d;
	}

}
