package com.dronedb.persistence.scheme.apis;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.io.Serializable;

/**
 * Created by taljmars on 3/25/17.
 */
@Entity
public class RegionOfInterest extends MissionItem implements Altitudable, Serializable {

    @Column(nullable = true)
    protected Double altitude;

    public RegionOfInterest() {
        super();
    }

    public RegionOfInterest(RegionOfInterest regionOfInterest) {
        super(regionOfInterest);
        this.altitude = regionOfInterest.getAltitude();
    }

    @Override
    public RegionOfInterest clone() {
        return new RegionOfInterest(this);
    }

    @Override
    public BaseObject copy() {
        RegionOfInterest regionOfInterest = this.clone();
        regionOfInterest.objId = this.objId;
        return regionOfInterest;
    }

    @Override
    public void set(BaseObject baseObject) {
        super.set(baseObject);
        RegionOfInterest regionOfInterest = (RegionOfInterest) baseObject;
        this.altitude = regionOfInterest.getAltitude();
    }

    @Override
    public void setAltitude(Double altitude) {
        this.altitude = altitude;
    }

    @Override
    public Double getAltitude() {
        return this.altitude;
    }

    @Override
    public void accept(ConvertDatabaseVisitor convertDatabaseVisitor) {
        convertDatabaseVisitor.visit(this);
    }
}