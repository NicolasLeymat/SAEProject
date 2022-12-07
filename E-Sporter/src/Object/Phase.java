package Object;

import Application.Connexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class Phase {
    private Tournoi tournoi;
    private List<Match> matchs;
    private int id;

    public abstract void genererMatchs();

    public abstract boolean isElim();

    public Tournoi getTournoi() {
        return tournoi;
    }

    public Phase(Tournoi tournoi) {
        this.tournoi = tournoi;
        this.matchs = new ArrayList<>();
        this.id =-1;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Match> getMatchs() {
        return matchs;
    }

    public Match getMatch(int i) {
        return matchs.get(i);
    }

    public int getId() {
        return id;
    }

    public static int getLastId() {
        Connection connex = Connexion.connexion();
        Statement st;
        ResultSet rs;
        int r = 0;

        try {

            st = connex.createStatement();
            rs = st.executeQuery("select max(id_phase) from LMN3783A.sae_phase");
            rs.next();
            r = rs.getInt(1);

            rs.close();
            st.close();

        } catch (Exception ee) {
            ee.printStackTrace();
        }
        return r;
    }

    public static int enregistrerPhase(Phase p) {
        Connection connex = Connexion.connexion();
        PreparedStatement pst;
        try {


            if (p.getId() == -1) {
                p.setId(p.getLastId()+1);
            }

            pst = connex.prepareStatement("insert into LMN3783A.sae_tournoi(id_phase, elim, id_tournoi values(?,?,?)");
            pst.setInt(1, p.getId());
            pst.setInt(2, (p.isElim()) ? 1 : 0);
            pst.setInt(3, p.getTournoi().getId());
            pst.executeUpdate();

            pst.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            return -1;
        }
        return 1;

    }

    //Verifie que tous les matchs à jouer ont un gagnant
    public abstract boolean matchsFinis() ;

    @Override
    public String toString() {
        return "Phase{" +
                "elim=" + isElim() +
                ", matchs=\n" + getMatchs() +
                '}';
    }
}
