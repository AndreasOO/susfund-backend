package org.andjos.susfund.mapper;

public interface EntityToDtoMapper<E, D> {
    D mapToDTO(E entity);
}
