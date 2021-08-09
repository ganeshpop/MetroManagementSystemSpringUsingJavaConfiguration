package com.ganesh.service.station;

import com.ganesh.persistence.station.StationDaoInterface;
import com.ganesh.pojos.Station;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;

public class StationService implements StationServiceInterface{
    StationDaoInterface stationDao;

    public void setStationDao(StationDaoInterface stationDao) {
        this.stationDao = stationDao;
    }

    @Override
    public Collection<Station> getAllStations() throws SQLException, ClassNotFoundException, IOException {
        return stationDao.getAllStations();
    }
}
