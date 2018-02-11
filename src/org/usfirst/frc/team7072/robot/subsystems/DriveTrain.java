package org.usfirst.frc.team7072.robot.subsystems;

import org.usfirst.frc.team7072.robot.RobotMap;
import org.usfirst.frc.team7072.robot.commands.DriveWithJoysticks;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveTrain extends Subsystem {
	
	
	private WPI_TalonSRX leftBackMotor = new WPI_TalonSRX(RobotMap.leftBackMotor);
	private WPI_TalonSRX leftFrontMotor = new WPI_TalonSRX(RobotMap.leftFrontMotor);
	private WPI_TalonSRX rightBackMotor = new WPI_TalonSRX(RobotMap.rightBackMotor);
	private WPI_TalonSRX rightFrontMotor = new WPI_TalonSRX(RobotMap.rightFrontMotor);
	
	private SpeedControllerGroup leftMotors = new SpeedControllerGroup(leftBackMotor, leftFrontMotor);
	private SpeedControllerGroup rightMotors = new SpeedControllerGroup(rightBackMotor, rightFrontMotor);
	
	private DifferentialDrive drive = new DifferentialDrive(leftMotors, rightMotors);
	
	private boolean useTankControl = true;
	
	public DriveTrain() {
//		super("Drive Train", 0.0, 0.0, 0.0);
		
		configureTalons();
		
		drive = new DifferentialDrive(leftMotors, rightMotors);
	
	}
	
	
	@Override
	protected void initDefaultCommand() {
		
		setDefaultCommand(new DriveWithJoysticks());

	}
	

	private void configureTalons() {
		
		leftFrontMotor.configClosedloopRamp(.1, 0);
		leftBackMotor.configClosedloopRamp(.1, 0);
		rightFrontMotor.configClosedloopRamp(.1, 0);
		rightBackMotor.configClosedloopRamp(.1, 0);
		
		leftFrontMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 0);
		rightFrontMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 0);
	
	}
	
	public double getLeftEncoderPosition() {
		return leftFrontMotor.getSelectedSensorPosition(0);
		
	}

	public double getRightEncoderPosition() {
		return rightFrontMotor.getSelectedSensorPosition(0);
	}
	public double getLeftEncoderVelocity() {
		return leftFrontMotor.getSelectedSensorVelocity(0);
		
	}

	public double getRightEncoderVelocity() {
		return rightFrontMotor.getSelectedSensorVelocity(0);
	}
	
 	
	public void writeToDashboard() {
		SmartDashboard.putNumber("Right Sensor (Encoder)", rightFrontMotor.getSelectedSensorVelocity(0));
		SmartDashboard.putNumber("Left Sensor (Encoder)", leftFrontMotor.getSelectedSensorVelocity(0));
		SmartDashboard.putBoolean("Use Tank Control", useTankControl);
	}
	
	public void resetEncoders() {
		leftFrontMotor.setSelectedSensorPosition(0, 0, 0);
		rightFrontMotor.setSelectedSensorPosition(0, 0, 0);
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