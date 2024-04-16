package com.baeldung.jparepository.repository;

import com.baeldung.jparepository.model.Book;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

// po JpaRepository pirma eina enticio pavadinimas (Book), Long atitinka id klase.
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    // @Modifying - nurodo, kad metodas atliks įrašymo į duomenų bazę operaciją,
    // pvz: įves, atnaujins arba ištrins duomenis.
    // @Transactional - naudojama transakcijoms valdyti. Jei operacija tampa sėkminga, duomenų bazėje atlikti pakeitimai yra įpareigoti,
    // o jei kuri nors operacija nepavyksta, visi tos konkrečios operacijos pakeitimai gali būti atšaukti.
    @Modifying
    @Transactional
    // b.id ir b.name yra entičio lenteles vietos. :#{#book.id}, :#{#book.name} prieina prie book objekto reiksmiu.
    @Query("insert into Book b (b.name) values (:#{#book.name})")
    void insertEntity(@Param("book") Book book);

    @Query("select b from Book b")
    List<Book> findAllEntities();
}
