package Mvc2.domain.repository;

import Mvc2.domain.entity.Money;

public interface MoneyRepository {
    Money get();
    void save(Money money);
}
