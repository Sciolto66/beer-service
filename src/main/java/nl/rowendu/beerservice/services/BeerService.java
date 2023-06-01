package nl.rowendu.beerservice.services;

import nl.rowendu.beerservice.web.model.BeerDto;

import java.util.UUID;

/**
 * Created by ronlangeveld on 01/06/2023
 */

public interface BeerService {
    BeerDto getBeerById(UUID beerId);

    BeerDto saveNewBeer(BeerDto beerDto);

    BeerDto updateBeer(UUID beerId, BeerDto beerDto);
}
