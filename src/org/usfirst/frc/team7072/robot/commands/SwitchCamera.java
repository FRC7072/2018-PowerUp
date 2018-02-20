package org.usfirst.frc.team7072.robot.commands;

import org.usfirst.frc.team7072.robot.Robot;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

public class SwitchCamera extends Command {
	
	UsbCamera camera;
	
	public SwitchCamera(UsbCamera cam) {
		camera = cam;
	}
	
	@Override
	protected void execute() {
//		Robot.cameraServer.setSource(camera);
		NetworkTable.getTable("").putString("CameraSelection", camera.getName());
	}

	@Override
	protected boolean isFinished() {
		return true;
	}

}
