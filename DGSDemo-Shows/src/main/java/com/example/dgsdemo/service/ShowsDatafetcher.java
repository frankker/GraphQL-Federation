package com.example.dgsdemo.service;

import com.example.dgsdemo.domain.Show;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@DgsComponent
public class ShowsDatafetcher {

  private final List<Show> shows = List.of(
      new Show(1,"Stranger Things", 2016),
      new Show(2, "Ozark", 2017),
      new Show(3, "The Crown", 2016),
      new Show(4, "Dead to Me", 2019),
      new Show(5, "Orange is the New Black", 2013)
  );

  @DgsQuery
  public List<Show> shows(@InputArgument String titleFilter) {

    System.out.println("titleFilter" + titleFilter);

    if(titleFilter == null) {
      return shows;
    }

    if (titleFilter.equals("0")) {
      throw new IllegalArgumentException();
    }
    if (titleFilter.equals("1")) {
      throw new RuntimeException();
    }


    return shows.stream().filter(s -> s.getTitle().contains(titleFilter)).collect(Collectors.toList());
  }

//  @DgsData(parentType = "Query", field = "allShows")
//  @DgsQuery
  /*@DgsData.List({
      @DgsData(parentType = "Query", field = "movies"),
      @DgsData(parentType = "Query", field = "shows")
  })
  public List<Show> shows2(@InputArgument String titleFilter) {
    if(titleFilter == null) {
      return shows;
    }

    return shows.stream().filter(s -> s.getTitle().contains(titleFilter)).collect(Collectors.toList());
  }*/


  @DgsQuery
  public List<Show> showsByHeaders(@RequestHeader String titleFilter) {
    if(titleFilter == null) {
      return shows;
    }

    return shows.stream().filter(s -> s.getTitle().contains(titleFilter)).collect(Collectors.toList());
  }

  @DgsQuery
  public List<Show> showsByReqParam(@RequestParam(defaultValue="Ozark") String titleFilter) {
    if(titleFilter == null) {
      return shows;
    }

    return shows.stream().filter(s -> s.getTitle().contains(titleFilter)).collect(Collectors.toList());
  }
}


