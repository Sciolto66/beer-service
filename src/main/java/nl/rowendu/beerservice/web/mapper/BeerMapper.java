package nl.rowendu.beerservice.web.mapper;

import nl.rowendu.beerservice.domain.Beer;
import nl.rowendu.beerservice.web.model.BeerDto;
import org.mapstruct.Mapper;

/**
 * Created by ronlangeveld on 11/05/2023
 */

@Mapper(uses = {DateMapper.class})
public interface BeerMapper {

    BeerDto beerToBeerDto(Beer beer);
    Beer beerDtoToBeer(BeerDto dto);
}
