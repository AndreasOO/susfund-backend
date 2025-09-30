package org.andjos.susfund.mapper.general;

import org.andjos.susfund.mapper.DtoToEntityMapper;
import org.andjos.susfund.mapper.EntityToDtoMapper;

public interface GeneralMapper<E,D> extends EntityToDtoMapper<E, D>, DtoToEntityMapper<D, E> {
}
