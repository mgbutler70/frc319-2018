package org.usfirst.frc.team319.robot.subsystems;

import org.usfirst.frc.team319.models.BobTalonSRX;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class CubeCollector extends Subsystem {
	
	public final BobTalonSRX collectorLeftMotor = new BobTalonSRX(3); // 11
	public final BobTalonSRX collectorRightMotor = new BobTalonSRX(4);
	AnalogInput collectorDistanceSensor = new AnalogInput(0);

	private static final double cubeCollectedDistanceThreshhold = 1.5;
	private static final double cubeLostDistanceThreshhold = 1.5;

	public CubeCollector() {

		this.collectorLeftMotor.setInverted(true);
		this.collectorRightMotor.setInverted(false);

		this.collectorLeftMotor.setNeutralMode(NeutralMode.Coast);
		this.collectorRightMotor.setNeutralMode(NeutralMode.Coast);

	}

	public void initDefaultCommand() { }

	// set leftmotor speed to negative to combat issues with it running full
	// speed and not PIDing to the set speed
	public void setCubeCollector(ControlMode controlMode, double speed) {
		collectorLeftMotor.set(controlMode, speed);
		collectorRightMotor.set(controlMode, speed);
	}

	public void setCubeCollectorIndependently(ControlMode controlMode, double left, double right) {
		collectorLeftMotor.set(controlMode, left);
		collectorRightMotor.set(controlMode, right);
	}

	public void setCubeCollectorLeftMotor(ControlMode controlMode, double speed) {
		collectorLeftMotor.set(controlMode, speed);
	}

	public double getCollectorDistanceSensorValue() {
		return this.collectorDistanceSensor.getVoltage();
	}

	public double getLeftCurrent() {
		return this.collectorLeftMotor.getOutputCurrent();
	}

	public double getRightCurrent() {
		return this.collectorRightMotor.getOutputCurrent();
	}
	
	@Override
	public void periodic() {
		SmartDashboard.putNumber("IR Sensor", this.getCollectorDistanceSensorValue());
		// SmartDashboard.putNumber("Left Collector Current", this.getLeftCurrent());
		// SmartDashboard.putNumber("Right Collector Current", this.getRightCurrent());

	}

	public boolean isCubeCollected() {
		return this.getCollectorDistanceSensorValue() > cubeCollectedDistanceThreshhold;
	}

	public boolean isCubeLost() {
		return this.getCollectorDistanceSensorValue() < cubeLostDistanceThreshhold;
	}

}
