/*
// Curso Egg FullStack
 */
package com.dailybugleplanet.DailyBuglePlanet.repositories;

// @author Ramiro Aybar
import com.dailybugleplanet.DailyBuglePlanet.entities.News;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsRepository extends JpaRepository<News, String> {

    @Query("SELECT n FROM News n WHERE n.deleted = false")
    List<News> getAllNews();

    //Title is unique
    @Query("SELECT n FROM News n WHERE n.title = :title")
    News searchByTitle(@Param("title") String title);

}
