package nl.rowendu.beerservice.web.controller;

import java.io.Serializable;
import java.util.UUID;

import lombok.RequiredArgsConstructor;
import nl.rowendu.beerservice.domain.Beer;
import nl.rowendu.beerservice.repositories.BeerRepository;
import nl.rowendu.beerservice.web.mapper.BeerMapper;
import nl.rowendu.beerservice.web.model.BeerDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/** Created by ronlangeveld on 04/05/2023 */
@RequiredArgsConstructor
@RequestMapping("/api/v1/beer/")
@RestController
public class BeerController {

  private final BeerMapper beerMapper;
  private final BeerRepository beerRepository;

  @GetMapping("{beerId}")
  public ResponseEntity<BeerDto> getBeerById(@PathVariable("beerId") UUID beerId) {

    return new ResponseEntity<>(beerMapper.beerToBeerDto(getBeer(beerId)), HttpStatus.OK);
  }

  private Beer getBeer(UUID beerId) {
    return beerRepository.findById(beerId)
            .orElseThrow(() -> new BeerNotFoundException("Beer not found with id " + beerId));
  }

  @PostMapping
  public ResponseEntity<Serializable> saveNewBeer(@Validated @RequestBody BeerDto beerDto) {

    beerRepository.save(beerMapper.beerDtoToBeer(beerDto));
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @PutMapping("/{beerId}")
  public ResponseEntity<Serializable> updateBeerByid(
      @PathVariable("beerId") UUID beerId, @Validated @RequestBody BeerDto beerDto) {
    beerRepository.findById(beerId).ifPresent(beer -> {
      beer.setBeerName(beerDto.getBeerName());
      beer.setBeerStyle(beerDto.getBeerStyle().name());
      beer.setPrice(beerDto.getPrice());
      beer.setUpc(beerDto.getUpc());
      beerRepository.save(beer);
    });
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

}
