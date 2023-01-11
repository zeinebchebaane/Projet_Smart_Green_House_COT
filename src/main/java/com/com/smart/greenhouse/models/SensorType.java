
package com.com.smart.greenhouse.models;
import java.util.function.Supplier;

public enum SensorType implements Supplier<String> {
    TEMPERATURE_SENSOR ,
    HUMIDITY_SENSOR,
    MOISTURE_SENSOR;
    @Override
    public String get() {
        return this.name();
    }
}