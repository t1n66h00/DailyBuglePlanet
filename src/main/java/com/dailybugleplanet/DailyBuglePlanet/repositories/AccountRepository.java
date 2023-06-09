/*
// Curso Egg FullStack
 */
package com.dailybugleplanet.DailyBuglePlanet.repositories;

import com.dailybugleplanet.DailyBuglePlanet.entities.Account;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

// @author Ramiro Aybar
@Repository
public interface AccountRepository extends JpaRepository<Account, String> {

    @Query("SELECT a FROM Account a WHERE a.id = :id")
    public Account searchAccountById(@Param("id") String id);

    @Query("SELECT a FROM Account a WHERE a.id = :id AND a.accountType = 'JOURNALIST'")
    public Account searchJournalistById(@Param("id") String id);

    @Query("SELECT a FROM Account a WHERE a.id = :id AND a.accountType = 'ADMIN'")
    public Account searchAdminById(@Param("id") String id);

    //Name field is unique
    @Query("SELECT n FROM Account n WHERE n.name = :name")
    public Account searchUserByName(@Param("name") String name);

    @Query("SELECT a FROM Account a WHERE a.accountType = 'JOURNALIST'")
    public List<Account> getAllJournalists();

    @Query("SELECT a FROM Account a WHERE a.accountType = 'ADMIN'")
    public List<Account> getAllAdmins();

}
