package org.vanilladb.core.sql.distfn;

import org.vanilladb.core.sql.VectorConstant;

public abstract class DistanceFn {

    protected VectorConstant query;
    private String fieldName;

    public DistanceFn(String fieldName) {
        this.fieldName = fieldName;
    }

    public void setQueryVector(VectorConstant query) {
        this.query = query;
    }
    
    /**
     * Calculating the distance between vector entries.
     * 
     * @param vec input vector
     * @return
     */
    public double distance(VectorConstant vec) {
        // check vector dimension
        if (query.dimension() != vec.dimension()) {
            throw new IllegalArgumentException("Vector length does not match");
        }
        return calculateDistance(vec);
    }

    public abstract double calculateDistance(VectorConstant vec);

    public String fieldName() {
        return fieldName;
    }
}
