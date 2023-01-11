
package com.com.smart.greenhouse.models;
import jakarta.nosql.mapping.Column;
import jakarta.nosql.mapping.Id;
public class SmartGreenHouse {
    @Id
    private Integer Id;
    @Column
    private String username;

    public int getId() {
        return Id;
    }

    public String getUsername() {
        return username;
    }
    public static GreenHouseBuilder builder(){
        return new GreenHouseBuilder();
    }
    public static class GreenHouseBuilder {
        private Integer Id;
        private String username;

        public GreenHouseBuilder withId (){
            this.Id = Id;
            return this;

        }
        public GreenHouseBuilder withUsername (){
            this.username = username;
            return this;

        }
        public SmartGreenHouse build(){
            SmartGreenHouse greenHouse = new SmartGreenHouse();
            greenHouse.Id=this.Id;
            greenHouse.username=this.username;
            return greenHouse;

        }


    }

    @Override
    public String toString() {
        return "SmartGreenHouse{" +
                "Id=" + Id +
                '}';
    }
}
