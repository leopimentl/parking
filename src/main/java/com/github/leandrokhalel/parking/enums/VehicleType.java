package com.github.leandrokhalel.parking.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

@Getter
@AllArgsConstructor
public enum VehicleType {
    CAR("c"),
    MOTORCYCLE("m");

    private final String value;
    private static final Map<String, VehicleType> map = new HashMap<>();

    static {
        for (final VehicleType type : EnumSet.allOf(VehicleType.class)) {
            map.put(type.value, type);
        }
    }

    @JsonCreator
    public static VehicleType entryOf(final String type) {
        return map.get(type.toLowerCase());
    }

    @JsonValue
    public String getValue() {
        return value;
    }

}
