package org.usfirst.frc.team7072.robot.subsystems;


import org.usfirst.frc.team7072.robot.RobotMap;
import org.usfirst.frc.team7072.robot.commands.MoveElevatorWithJoystick;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.command.PIDSubsystem;



public class Elevator extends PIDSubsystem {

	private WPI_TalonSRX liftMotor = new WPI_TalonSRX(RobotMap.liftMotor);	
	
	public Elevator() {
		super(0.5, 0, 0);
		
		setAbsoluteTolerance(2048);
		
		setSetpoint(0);
		
		liftMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 0);
	}
	
	
	public double getLiftEncoderPosition() {
		return liftMotor.getSelectedSensorPosition(0);
	}
	
	public void resetEncoder() {
		liftMotor.setSelectedSensorPosition(0, 0, 0);
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

}
