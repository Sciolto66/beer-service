package nl.rowendu.beerservice.repositories;

import nl.rowendu.beerservice.domain.Beer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

/**
 * Created by ronlangeveld on 07/05/2023
 */

public interface BeerRepository extends JpaRepository<Beer, UUID> {

}
