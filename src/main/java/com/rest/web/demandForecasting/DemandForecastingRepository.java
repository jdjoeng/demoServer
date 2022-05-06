package com.rest.web.demandForecasting;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface DemandForecastingRepository extends JpaRepository<DemandForecastingInfo, Long> {

    @Query(
            value = "" +
                    " SELECT " +
                    "   new com.rest.web.demandForecasting.DemandForecastingInfoDto(dfi.id, dfm.name, SUM(dfi.itemQty), SUM(dfi.q10), SUM(dfi.q50), SUM(dfi.q90)) " +
                    " FROM DemandForecastingInfo dfi " +
                    "   JOIN DemandForecastingMapping dfm ON dfi.id = dfm.id " +
                    " WHERE dfi.infoType = :type " +
                    " GROUP BY dfi.id "
    )
    List<DemandForecastingInfoDto> findResultList(String type);

    @Query(
            value = "" +
                    " SELECT " +
                    "   new com.rest.web.demandForecasting.DemandForecastingInfoDto(dfi.id, dfm.name, dfi.date, dfi.itemQty, dfi.q10, dfi.q50, dfi.q90) " +
                    " FROM DemandForecastingInfo dfi " +
                    "   JOIN DemandForecastingMapping dfm ON dfi.id = dfm.id " +
                    " WHERE dfi.id = :id " +
                    "   AND dfi.infoType = :type"
    )
    List<DemandForecastingInfoDto> findResultListByIdType(String id, String type);

    @Query(
            value = "" +
                    " SELECT " +
                    "   new com.rest.web.demandForecasting.DemandForecastingInfoDto(dfi.id, dfm.name, dfi.date, dfi.itemQty, dfi.q10, dfi.q50, dfi.q90) " +
                    " FROM DemandForecastingInfo dfi " +
                    "   JOIN DemandForecastingMapping dfm ON dfi.id = dfm.id " +
                    " WHERE dfi.infoType = :type " +
                    "   AND dfm.name = :name "
    )
    List<DemandForecastingInfoDto> findResultListByTypeName(String type, String name);

    @Query(
            value = "" +
                    " SELECT " +
                    "   new com.rest.web.demandForecasting.DemandForecastingInfoDto(dfi.id, dfm.name, dfi.date, dfi.itemQty, dfi.q10, dfi.q50, dfi.q90) " +
                    " FROM DemandForecastingInfo dfi " +
                    "   JOIN DemandForecastingMapping dfm ON dfi.id = dfm.id " +
                    " WHERE dfi.infoType = :type " +
                    "   AND dfm.name = :name " +
                    " ORDER BY dfi.itemQty desc"
    )
    List<DemandForecastingInfoDto> findResultListByTypeNameOrderItem(String type, String name);

}
