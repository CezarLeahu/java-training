package org.example.lombok;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
//@Builder
public class CarWithLombok {

    private int seats;
    private String color;
    //private final String vin;
    private String vin;
}
