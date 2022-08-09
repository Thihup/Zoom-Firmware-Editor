package zoomeditor.gui.listener;

import zoomeditor.controller.ApplicationController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UniversalListener implements ActionListener {
    public enum Action {OPEN_FIRMWARE, SAVE_FIRMWARE, EXTRACT_PATCH, INJECT_PATCH, MOVE_UP, MOVE_DOWN, REMOVE_PATCH}

    private final ApplicationController applicationController = ApplicationController.getInstance();
    private final Action action;

    public UniversalListener(Action action) {
        this.action = action;
    }

    public void actionPerformed(ActionEvent e) {
        switch (action) {
            case OPEN_FIRMWARE -> applicationController.showOpenFirmwareDialog();
            case SAVE_FIRMWARE -> applicationController.showSaveFirmwareDialog();
            case EXTRACT_PATCH -> applicationController.showSavePatchDialog();
            case INJECT_PATCH -> applicationController.showOpenPatchDialog();
            case REMOVE_PATCH -> applicationController.removePatch();
            case MOVE_UP -> applicationController.moveUpOrDown(true);
            case MOVE_DOWN -> applicationController.moveUpOrDown(false);
        }
    }

}
