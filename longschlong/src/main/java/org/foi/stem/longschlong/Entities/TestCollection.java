package org.foi.stem.longschlong.Entities;

public record TestCollection(
        int id,
        int input_condition_id,
        int sample_id,
        Float[] test_points
) {}
