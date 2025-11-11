package org.example.Models;

import lombok.*;

@RequiredArgsConstructor
public enum Position {
    PREZES(25000),
    WICEPREZES(18000),
    MANAGER(12000),
    PROGRAMISTA(8000),
    STAZYSTA(3000);
    @Getter
    private final int salary;
}