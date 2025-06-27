package com.gn.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data

public class Planet {
	private String name;
	private double distance;
	private boolean habitable;
}
