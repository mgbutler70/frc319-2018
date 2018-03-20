package org.usfirst.frc.team319.robot.commands.autonomous_paths;

import org.usfirst.frc.team319.arcs.ThreeFeetArc;
import org.usfirst.frc.team319.robot.commands.FollowArc;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class DriveForwardThreeFeet extends CommandGroup {

	public DriveForwardThreeFeet() {

		addSequential(new FollowArc(new ThreeFeetArc()));

	}
}
