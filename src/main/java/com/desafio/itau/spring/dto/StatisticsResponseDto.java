package com.desafio.itau.spring.dto;

import java.util.DoubleSummaryStatistics;

public record StatisticsResponseDto(
        long count,
        double sum,
        double avg,
        double min,
        double max
) {
    public static StatisticsResponseDto from(DoubleSummaryStatistics stats) {
        return new StatisticsResponseDto(
                stats.getCount(),
                stats.getSum(),
                stats.getAverage(),
                stats.getMin(),
                stats.getMax()
        );
    }
}
