package com.codeclan.example.WhiskyTracker.repositories;

import com.codeclan.example.WhiskyTracker.models.Whisky;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WhiskyRepository extends JpaRepository<Whisky, Long> {

    List<Whisky> findByYear(int year);

    List<Whisky> findByAgeAndDistilleryName( int age, String distillery);

    List<Whisky> findByDistilleryRegion(String region);

    List<Whisky> findByAgeLessThanEqual(int age);

    // 12 years old -> (2022-year) + age = 12
//    get all the whiskies

//    empty set
//    for each whisky, if age<12:
//      if ((age + (2022-year)) == 12)
//            add to whisky distillery name to set
//    return set
//

}
