package com.mahdi.entity;

public abstract class Entity<I> {

    protected I id;

    public Entity() {
    }

    public Entity(I id) {
        this.id = id;
    }

    public I getId() {
        return id;
    }

    public void setId(I id) {
        this.id = id;
    }
}
