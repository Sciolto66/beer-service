package nl.rowendu.beerservice.web.controller;

import java.io.Serializable;
import java.util.UUID;
import nl.rowendu.beerservice.web.model.BeerDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/** Created by ronlangeveld on 04/05/2023 */
@RequestMapping("/api/v1/beer/")
@RestController
public class BeerController {
  @GetMapping("{beerId}")
  public ResponseEntity<BeerDto> getBeerById(@PathVariable("beerId") UUID beerId) {

    // todo impl
    return new ResponseEntity<>(BeerDto.builder().build(), HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<Serializable> saveNewBeer(@RequestBody BeerDto beerDto) {

    // todo impl
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @PutMapping("/{beerId}")
  public ResponseEntity<Serializable> updateBeerByid(
      @PathVariable("beerId") UUID beerId, @RequestBody BeerDto beerDto) {

    // todo impl
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
