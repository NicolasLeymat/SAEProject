package IHM.info;

import javax.swing.table.AbstractTableModel;
import Object.Tournoi;
import Object.Equipe;


import java.util.Map;

public class TableauClassementTournoi extends AbstractTableModel {
    private String[] columnNames = {"#", "Equipe", "V","D"};
    private Tournoi tournoi;
    private Equipe[] equipes;
    private Map<Equipe,Integer[]> victoires;
    public TableauClassementTournoi(Tournoi tournoi) {
        //Recupere les equipes triés par leur classement
        try {
            equipes = tournoi.getPhaseElim().getClassement();
        }
        catch (Exception e){
            e.printStackTrace();
            return;
        }
        //Recupere les victoires
        victoires = tournoi.getVictoires();
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

    /**
     * Affiche les infos à partir d'une ligne et d'une colonne
     * @param rowIndex        la ligne
     * @param columnIndex     la colonne
     * @return
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        //Compare les ID car deux objets differents sont crées
        Equipe equipet = victoires.keySet().stream().filter((e) -> e.getId() == equipes[rowIndex].getId()).findFirst().orElse(null);
        switch (columnIndex) {
            case 0:
                //Affiche le classement
                return rowIndex +1;
            case 1:
                return equipes[rowIndex].getNom();
            case 2:
                return victoires.get(equipet)[0];
            case 3:
                return victoires.get(equipet)[1];
            default:
                return null;
        }
    }
}
