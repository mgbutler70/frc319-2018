package org.usfirst.frc.team319.robot.commands;

import org.usfirst.frc.team319.robot.commands.cubecollector.CubeCollectorCollect;
import org.usfirst.frc.team319.robot.commands.cubecollector.CubeCollectorStop;
import org.usfirst.frc.team319.robot.commands.cubecollector.HoldCube;
import org.usfirst.frc.team319.robot.commands.pneumatics.CloseCollector;
import org.usfirst.frc.team319.robot.commands.pneumatics.OpenCollector;
import org.usfirst.frc.team319.robot.commands.wrist.WristGoHome;
import org.usfirst.frc.team319.robot.commands.wrist.WristGoToCollectCube;
import org.usfirst.frc.team319.robot.commands.wrist.WristGoToExchange;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class AutoCollectCubeOpened extends CommandGroup {

    public AutoCollectCubeOpened() {

    	addParallel(new WristGoToCollectCube());
    	addParallel(new OpenCollector());
    	addSequential(new CubeCollectorCollect());
    	addSequential(new CloseCollector());
    	addSequential(new WaitCommand(0.25));
    	addSequential(new HoldCube());
    	addSequential(new WristGoToExchange());
    	
    }
}
