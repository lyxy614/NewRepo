package main.java;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Iterator;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Results {
    @JsonProperty("TotalPoints")
    private Double totalPoints;
    @JsonProperty("Rank")
    private Integer rank;
    @JsonProperty("FullName")
    private String fullName;
    @JsonProperty("Dives")
    private List<Dives> dives;

    public Results() {}

    public Double getTotalPoints() {
        return totalPoints;
    }
    public void setTotalPoints(Double totalPoints) {
        this.totalPoints = totalPoints;
    }
    public Integer getRank() {
        return rank;
    }
    public void setRank(Integer rank) {
        this.rank = rank;
    }
    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public List<Dives> getDives() {
        return dives;
    }
    public void setDives(List<Dives> dives) {
        this.dives = dives;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        Iterator<Dives> iterator = dives.iterator();
        while(iterator.hasNext()){
            Dives dive = iterator.next();
            sb.append(dive);
            if(iterator.hasNext()){
                sb.append(" + ");
            }
        }
        return  "Full Name:" + fullName + "\n" +
                "Rank:" + rank + "\n" +
                "DivePoints:" + sb + " = " + String.format("%.2f", totalPoints) + "\n" +
                "-----" + "\n";
    }

}
