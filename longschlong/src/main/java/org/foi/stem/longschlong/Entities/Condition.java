package org.foi.stem.longschlong.Entities;

public record Condition(
        int id,
        String parameter,
        float minimum,
        float maximum,
        float time_between_points
) {}
