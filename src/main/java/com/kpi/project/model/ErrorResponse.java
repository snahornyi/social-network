package com.kpi.project.model;

import com.kpi.project.model.enums.ErrorTypes;
import lombok.Builder;
import lombok.Value;

@Builder(toBuilder = true)
@Value
public class ErrorResponse {

    ErrorTypes errorType;
    String message;
}
