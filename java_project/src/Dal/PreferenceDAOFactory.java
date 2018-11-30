package src.Dal;

public class PreferenceDAOFactory {

    public PreferenceDAO createPreferenceDAO(){
        return new PreferenceDAOImpl();
    }



}
