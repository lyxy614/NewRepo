package Models;

public class Ability {
    public final int maxHealth;
    public final int maxEmpiricalValue;
    public final int attackPower;
    public final double bodyLength;
    public final int defendPower;

    public Ability(int maxHealth, int maxEmpiricalValue, int attackPower, double bodyLength, int defendPower) {
        this.maxHealth = maxHealth;
        this.maxEmpiricalValue = maxEmpiricalValue;
        this.bodyLength = bodyLength;
        this.attackPower = attackPower;
        this.defendPower = defendPower;
    }
}
