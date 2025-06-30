package com.gn.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Visitor {
	private String name;
	private String message;
	private LocalDateTime datetime;
}
