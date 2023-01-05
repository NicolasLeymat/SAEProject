package IHM.info;

import javax.swing.table.AbstractTableModel;
import Object.Tournoi;

import java.util.List;

public class TableauTournoi  extends AbstractTableModel {
    private String[] columnNames = {"Tournoi", "Jeu", "Notoriété"};
    private List<Tournoi> tournois;

    public TableauTournoi(List<Tournoi> tournois) {
        this.tournois = tournois;
    }

    @Override
    public int getRowCount() {
        return tournois.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Tournoi tournoi = tournois.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return tournoi.getNom();
            case 1:
                return tournoi.getId_Mode().getJeu().getNom();
            case 2:
                return tournoi.getNotoriete();
            default:
                return null;
        }
    }
}
