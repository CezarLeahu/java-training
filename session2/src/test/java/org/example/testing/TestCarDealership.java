package org.example.testing;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class TestCarDealership {

    @Mock
    BodyShop bodyShop;
    @Spy
    RepairShop repairShop;

    @InjectMocks
    CarDealership carDealership;

    @Test
    public void testMethodOutputForTheGivenInput() {
        assertEquals(800, new CarDealership().repairCost("{}"));
    }

    @Test
    public void testMethodOutputForTheGivenInputWithMocks() {
        doReturn(1).when(bodyShop).repairCost(any());
        doReturn(3).when(repairShop).repairCost(any());

        assertEquals(4, carDealership.repairCost("{}"));
    }

    @Test
    public void testMethodOutputOtherThanTheReturnValue() {
        carDealership.fixVehicle("{}");

        verify(bodyShop, times(1)).fix(eq("{}"));
        verify(repairShop, times(1)).fix(any());
        verify(repairShop, times(1)).fixElectricalIssues(any());
    }
}
