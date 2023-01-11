package com.com.smart.greenhouse.models;
import jakarta.nosql.mapping.Column;
import jakarta.nosql.mapping.Entity;
import jakarta.nosql.mapping.Id;
import java.util.*;
@Entity
public class Sensor {
    @Id
    private  Integer id ;

    @Column()
    private  SensorType type ;
    @Column()
    private Set<Double> values =new HashSet<>() ;

    public Integer getId() {
        return id;
    }

    public SensorType getType() {
        return type;
    }
    public Set<Double> getValues() {
        return values;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id + " " +
                ", type=" + type +
                '}';
    }
    public static SensorBuilder builder(){
        return new SensorBuilder ();
    }
    public static class SensorBuilder {
        private Integer id;
        private SensorType type;

        public SensorBuilder withId(Integer id){
            this.id = id;
            return this;
        }

        public SensorBuilder withType(SensorType type){
            this.type = type;
            return this ;
        }

        public Sensor build (){
            Sensor sensor = new Sensor();
            sensor.id=id;
            sensor.type=type;
            return sensor;

        }
    }


}
