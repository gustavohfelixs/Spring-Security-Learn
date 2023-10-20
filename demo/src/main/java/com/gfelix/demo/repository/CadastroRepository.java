package com.gfelix.demo.repository;

import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.locator.UseClasspathSqlLocator;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.springframework.stereotype.Repository;

import com.gfelix.demo.domain.CadastroDTO;

@Repository
@UseClasspathSqlLocator
public interface CadastroRepository {

    @SqlUpdate
    public void cadastro(@BindBean CadastroDTO cadastroDTO) ;
    
}
