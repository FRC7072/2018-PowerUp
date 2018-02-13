package org.usfirst.frc.team7072.robot.subsystems;

import org.usfirst.frc.team7072.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Intake extends Subsystem {

//	private WPI_TalonSRX leftClaw = new WPI_TalonSRX(RobotMap.leftClaw);
//	private WPI_TalonSRX rightClaw = new WPI_TalonSRX(RobotMap.rightClaw);
	
	public Intake() {
		leftClaw.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 0);
		rightClaw.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 0);
	}
	
	public void resetClawEncoders() {
		leftClaw.setSelectedSensorPosition(0, 0, 0);
		rightClaw.setSelectedSensorPosition(0, 0, 0);
	}
	
	public double getLeftClawEncoderPosition() {
		return leftClaw.getSelectedSensorPosition(0);
	}
	
	public double getRightClawEncoderPosition() {
		return rightClaw.getSelectedSensorPosition(0);
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub

	}

}