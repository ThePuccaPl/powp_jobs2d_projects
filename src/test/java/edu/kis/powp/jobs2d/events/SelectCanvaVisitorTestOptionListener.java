package edu.kis.powp.jobs2d.events;

import edu.kis.powp.jobs2d.command.CanvasVisitor;
import edu.kis.powp.jobs2d.command.DriverCommand;
import edu.kis.powp.jobs2d.features.CommandsFeature;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Logger;

public class SelectCanvaVisitorTestOptionListener implements ActionListener {

    private Shape canvaShape;
    private final static Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public SelectCanvaVisitorTestOptionListener(Shape canvaShape) {
        this.canvaShape = canvaShape;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        DriverCommand command = CommandsFeature.getDriverCommandManager().getCurrentCommand();
        CanvasVisitor canvasVisitor = new CanvasVisitor(canvaShape);

        command.accept(canvasVisitor);

        logger.info("CanvasVisitor test");
        if(canvasVisitor.isIncluded()){
            logger.info("Current command does not match the shape of canva");
        }else{
            logger.info("Command match the shape of canva");
        }
    }
}
