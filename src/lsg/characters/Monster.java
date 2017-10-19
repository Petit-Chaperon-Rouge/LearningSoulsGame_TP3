package lsg.characters;

/**
 * Created by alecoeuc on 22/09/17.
 */
public class Monster extends Character {


    static int INSTANCES_COUNT = 0;
    private float skinThickness = 20;


    // Getteurs & Setteurs

    public float getSkinThickness() {
        return this.skinThickness;
    }

    protected void setSkinThickness(float skinThickness) {
        this.skinThickness = skinThickness;
    }

    // Constructeurs


    /**
     * Crée un monstre par défault nommé Monstre_N où N est le nombre de monstre déjà créé
     */
    public Monster(){
        INSTANCES_COUNT++;
        this.setName("Monster_" + INSTANCES_COUNT);
        this.setMaxLife(10);
        this.setLife(this.getMaxLife());
        this.setMaxStamina(10);
        this.setStamina(this.getMaxStamina());
    }

    /**
     * Crée un monstre avec le nom choisi
     * @param name Le nom a donner au monstre
     */
    public Monster(String name){
        super(name);
        INSTANCES_COUNT++;
        this.setMaxLife(10);
        this.setLife(this.getMaxLife());
        this.setMaxStamina(10);
        this.setStamina(this.getMaxStamina());
    }


    // Méthodes


    @Override
    protected float computeProtection() {
        return this.getSkinThickness();
    }
}