package com.example.DemoGraphQL.repository;

import com.example.DemoGraphQL.model.Organization;
import org.springframework.data.repository.CrudRepository;

public interface OrganizationRepository extends CrudRepository<Organization, Long> {

    Organization findByInn(String inn);

}
