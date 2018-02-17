package org.usfirst.frc.team7072.robot.subsystems;

import org.usfirst.frc.team7072.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Intake extends Subsystem {
	
	public WPI_TalonSRX leftClaw = new WPI_TalonSRX(RobotMap.leftClaw);
	public WPI_TalonSRX rightClaw = new WPI_TalonSRX(RobotMap.rightClaw);
	public Ultrasonic ultrasonic = new Ultrasonic(0, 1);

	public Intake() {
		leftClaw.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 0);
		rightClaw.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 0);
		
		ultrasonic.setEnabled(true);
		ultrasonic.setAutomaticMode(true);
	}
	
	public double getLeftEncoderPosition() {
		return leftClaw.getSelectedSensorPosition(0);
	}
	
	public double getRightEncoderPosition() {
		return rightClaw.getSelectedSensorPosition(0);
	}
	
	public void resetEncoders() {
		leftClaw.setSelectedSensorPosition(0, 0, 0);
		rightClaw.setSelectedSensorPosition(0, 0, 0);
	}
	
	public double getRange() {
		return ultrasonic.getRangeInches();
	}
	
	public void writeToDashboard() {
		SmartDashboard.putNumber("Ultrasonic Range", ultrasonic.getRangeInches());
		System.out.println(getRange());
	}
	
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub

	}

}
