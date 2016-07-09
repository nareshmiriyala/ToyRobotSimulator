package com.rea.trs.builders;

import com.rea.trs.model.Dimension;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class DimensionBuilderTest {

    @Test
    void testBuildCreation() {
        Dimension dimension = DimensionBuilder.aDimension().withX(10).withY(10).build();
        assertNotNull(dimension);
        assertEquals(dimension.getX(), 10);
        assertEquals(dimension.getY(), 10);
    }
}