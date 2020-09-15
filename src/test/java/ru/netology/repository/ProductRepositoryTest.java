package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.TShirt;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();
    private Book coreJava = new Book();
    private TShirt coreJava2 = new TShirt();

    @Test
    public void shouldSaveOneItem() {
        repository.save(coreJava);

        Product[] expected = new Product[]{coreJava};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveById(){
        repository.save(coreJava2);

        repository.removeById(1);

        Product[] expected = new Product[]{coreJava};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldExceptionRemoveById(){
        repository.save(coreJava);
        repository.save(coreJava2);

        assertThrows(RuntimeException.class, ()->repository.removeById(10));
    }

}