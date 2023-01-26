package com.stackroute.oops;

/*
Class is having 3 fields name, modelName and type.
Type varies for different vehicles.
eg. Car is of type sedan, sports...
Bike is of type cruiser, sports...
 */
public abstract class AbstractManufacturer {
    private String name;
    private String modelName;
    private String type;

    public AbstractManufacturer(String name, String modelName, String bikeType) {
        this.name =name;
        this.modelName=modelName;
        this.type=bikeType;
    }

    public String getModelName() {
        return this.modelName;
    }

    public String getType() {
        return this.type;
    }

    public String getName() {
        return this.name;
    }

    public abstract String getManufacturerInformation();
}
