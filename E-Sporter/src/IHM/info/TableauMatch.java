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

    /**
     * Rend les valeurs de chaque cellule du tableau
     * @param rowIndex        la ligne
     * @param columnIndex     la colonne
     * @return
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Match match = matchs.get(rowIndex);
        String stringE1="";
        String stringE2="";
        //Affichage du nom de joueur avec une couronne s'il est gagnant
        if (match.getWinner() == match.getEquipe1()) {
            stringE1 +="👑 ";
        }
        if (match.getWinner() == match.getEquipe2()) {
            stringE2 +="👑 ";
        }
        stringE1 += match.getEquipe1().getNom();
        stringE2 += match.getEquipe2().getNom();
        switch (columnIndex) {
            case 0:
                return stringE1;
            case 1:
                return stringE2;
            default:
                return null;
        }
    }

    public Object getValueAt(int rowIndex) {
        return matchs.get(rowIndex);
    }
}
