// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package org.usfirst.frc.team319.robot.commands;

import org.usfirst.frc.team319.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class StartOperatorControllerRumble extends Command {

	private double leftRumbleStrength = 0;
	private double rightRumbleStrength = 0;

	public StartOperatorControllerRumble(double strength) {
		this.leftRumbleStrength = strength;
		this.rightRumbleStrength = strength;
	}

	public StartOperatorControllerRumble(double leftStrength, double rightStrength) {
		this.leftRumbleStrength = leftStrength;
		this.rightRumbleStrength = rightStrength;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		Robot.oi.operatorController.setRumble(leftRumbleStrength, rightRumbleStrength);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {

	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return true; // nothing else to do
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
