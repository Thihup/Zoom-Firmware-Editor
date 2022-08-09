package zoomeditor.gui.tablemodel;

import zoomeditor.ZoomFirmwareEditor;
import zoomeditor.model.Patch;
import zoomeditor.service.PatchService;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.util.List;

public class PatchTableModel implements TableModel {

    private final List<Patch> patches;

    public PatchTableModel(List<Patch> patches) {
        this.patches = patches;
    }

    @Override
    public int getRowCount() {
        return patches.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return switch (columnIndex) {
            case 0 -> ZoomFirmwareEditor.getMessage("fileNameColumn");
            case 1 -> ZoomFirmwareEditor.getMessage("patchNameColumn");
            case 2 -> ZoomFirmwareEditor.getMessage("sizeColumn");
            case 3 -> ZoomFirmwareEditor.getMessage("blocksColumn");
            default -> "";
        };
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        //return getValueAt(0, columnIndex).getClass();
        if (columnIndex == 2 || columnIndex == 3) {
            return Number.class;
        }
        return String.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Patch bean = patches.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> bean.getFileName();
            case 1 -> bean.getName();
            case 2 -> bean.getSize();
            case 3 -> PatchService.calculatePatchBlocksCount(bean.getSize());
            default -> "";
        };
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
    }

    @Override
    public void addTableModelListener(TableModelListener l) {
    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
    }

}
