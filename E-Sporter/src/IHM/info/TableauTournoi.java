package IHM.info;

import javax.swing.table.AbstractTableModel;
import Object.Tournoi;
import Object.Equipe;

import java.util.List;
import java.util.Map;

public class TableauTournoi  extends AbstractTableModel {
    private String[] columnNames = {"#", "Joueur", "Victoires","Defaites"};
    private Tournoi tournoi;

    public TableauTournoi(Tournoi tournoi) {
        this.tournoi = tournoi;
    }

    @Override
    public int getRowCount() {
        try {
            return tournoi.getPhaseElim().getClassement().length;
        }
        catch (Exception e) {
            return 0;
        }

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
        Equipe[] equipes;
        Map<Equipe,Integer[]> victoires = tournoi.getVictoires();
        try {
            equipes = tournoi.getPhaseElim().getClassement();
        }
        catch (Exception e){
            return 0;
        }
        switch (columnIndex) {
            case 0:
                return rowIndex +1;
            case 1:
                return equipes[rowIndex];
            case 2:
                return victoires.get(equipes[rowIndex])[0];
            case 3:
                return victoires.get(equipes[rowIndex])[1];
            default:
                return null;
        }
    }
}
