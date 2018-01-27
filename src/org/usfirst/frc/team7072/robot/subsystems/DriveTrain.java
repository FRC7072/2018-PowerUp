package org.usfirst.frc.team7072.robot.subsystems;

import org.usfirst.frc.team7072.robot.RobotMap;
import org.usfirst.frc.team7072.robot.commands.DriveWithJoysticks;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class DriveTrain extends Subsystem {
	
	
	private WPI_TalonSRX leftBackMotor = new WPI_TalonSRX(RobotMap.leftBackMotor);
	private WPI_TalonSRX leftFrontMotor = new WPI_TalonSRX(RobotMap.leftFrontMotor);
	private WPI_TalonSRX rightBackMotor = new WPI_TalonSRX(RobotMap.rightBackMotor);
	private WPI_TalonSRX rightFrontMotor = new WPI_TalonSRX(RobotMap.rightFrontMotor);

	private SpeedControllerGroup leftMotors = new SpeedControllerGroup(leftBackMotor, leftFrontMotor);
	private SpeedControllerGroup rightMotors = new SpeedControllerGroup(rightBackMotor, rightFrontMotor);
	
	private DifferentialDrive drive = new DifferentialDrive(leftMotors, rightMotors);
	
	private boolean useTankControl = true;
	
	
	@Override
	protected void initDefaultCommand() {
		
		setDefaultCommand(new DriveWithJoysticks());

	}
	
	public void tankDrive(double leftSpeed, double rightSpeed) {
		drive.tankDrive(leftSpeed, rightSpeed, true);
		
	}
	
	public void arcadeDrive(double speed, double rotation) {
		drive.arcadeDrive(speed, rotation);
	}
	public void stopDrive() {
		drive.tankDrive(0, 0);
	}

	public boolean shouldUseTankControl() {
		return useTankControl;
	}

	public void setUseTankControl(boolean useTankControl) {
		this.useTankControl = useTankControl;
	}
	
}
