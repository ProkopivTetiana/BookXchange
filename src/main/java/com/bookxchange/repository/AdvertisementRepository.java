package com.bookxchange.repository;

import com.bookxchange.model.Advertisement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AdvertisementRepository extends JpaRepository<Advertisement, String> {

    @Query("SELECT a FROM Advertisement a ORDER BY a.publicationDate DESC LIMIT 5")
    List<Advertisement> getFiveNewestAdvertisements();

    @Query("SELECT a FROM Advertisement a join AdvertisementCategory bc WHERE bc.category.id = ?1 ORDER BY a.publicationDate DESC")
    List<Advertisement> getAdvertisementsByCategory(String categoryId);

    @Query("SELECT a FROM Advertisement a WHERE a.user.id = ?1 ORDER BY a.publicationDate DESC")
    List<Advertisement> getAdvertisementsByUserId(String userId);

    @Query("SELECT a FROM Advertisement a WHERE a.title LIKE %?1%")
    List<Advertisement> searchAdvertisementsByTitle(String name);

    @Query("SELECT a FROM Advertisement a WHERE a.title = ?1 AND a.user.id = ?2")
    Advertisement getAdvertisementByTitleAndUserId(String title, String userId);
}
