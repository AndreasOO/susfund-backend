package org.andjos.susfund.mapper;

public interface DtoToEntityMapper<D, E> {
    E mapToEntity(D dto);
}
