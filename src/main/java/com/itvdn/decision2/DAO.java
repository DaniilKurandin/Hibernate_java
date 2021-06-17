package com.itvdn.decision2;

public interface DAO<Entity, Key>{
        Entity getAnimal(Key id);
        void updateAnimal(Entity entity);
        void deleteAnimal(Entity entity);
}
