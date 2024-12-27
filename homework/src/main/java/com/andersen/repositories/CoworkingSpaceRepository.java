package com.andersen.repositories;

import com.andersen.entities.CoworkingSpace;
import com.andersen.enums.CoworkingSpaceType;

import java.util.Arrays;
import java.util.List;

public class CoworkingSpaceRepository {
    public static List<CoworkingSpace> coworkingSpaces = Arrays.asList(
            new CoworkingSpace(CoworkingSpaceType.OPEN, 100, true, null),
            new CoworkingSpace(CoworkingSpaceType.PRIVATE, 200, true, null)
    );
}
