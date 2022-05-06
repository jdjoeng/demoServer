package com.rest.web.stockTrading;

import com.rest.web.demandForecasting.DemandForecastingInfo;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface StockTradingRepository extends JpaRepository<DemandForecastingInfo, Long> {

    @Query(
        value = "" +
        " SELECT " +
        "   new com.rest.web.stockTrading.StockTradingDto(st.name, st.date, st.stockPrice, st.budgetHistory, st.portfolioHistory) " +
        " FROM StockTrading st " +
        " WHERE st.name = :name " +
        " ORDER BY st.date"
    )
    List<StockTradingDto> findStockTradingAll(String name);

    @Query(
            value = "" +
                    " SELECT " +
                    "   new com.rest.web.stockTrading.StockTradingDto(st.name, st.date, st.stockPrice, st.budgetHistory, st.portfolioHistory) " +
                    " FROM StockTrading st " +
                    " WHERE st.name = :name " +
                    "   AND st.date >= :year" +
                    " ORDER BY st.date"
    )
    List<StockTradingDto> findStockTradingYear(String name, String year);

    @Query(
            value = "" +
                    " SELECT " +
                    "   new com.rest.web.stockTrading.StockTradingDto(st.name, st.date, st.stockPrice, st.budgetHistory, st.portfolioHistory) " +
                    " FROM StockTrading st " +
                    " WHERE st.name = :name "
    )
    List<StockTradingDto> findStockTradingTop(String name, Pageable pageable);

}
