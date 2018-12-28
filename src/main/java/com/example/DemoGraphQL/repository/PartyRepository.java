package com.example.DemoGraphQL.repository;

import com.example.DemoGraphQL.model.Party;
import org.springframework.data.repository.CrudRepository;

public interface PartyRepository extends CrudRepository<Party, Long> {

}
