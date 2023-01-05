package IHM.info;
import Object.Match;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class TableauMatch extends AbstractTableModel {
    private String[] columnNames = {"Equipe 1", "Equipe 2"};
    private List<Match> matchs;

    public TableauMatch(List<Match> matchs) {
        this.matchs = matchs;
    }

    @Override
    public int getRowCount() {
        return matchs.size();
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
        Match match = matchs.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return match.getEquipe1();
            case 1:
                return match.getEquipe2();
            default:
                return null;
        }
    }
}
