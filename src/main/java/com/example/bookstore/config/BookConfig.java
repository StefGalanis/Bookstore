package com.example.bookstore.config;

import com.example.bookstore.model.Book;
import com.example.bookstore.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class BookConfig {

    @Bean
    CommandLineRunner bookSeeder(BookRepository repository){
        return args -> {

            Book book1 = new Book(
                    "The Wicther",
                    "Andrzej Sapkowski",
                    1990,
                    "Geralt of Rivia. A witcher whose mission is to protect ordinary people from the monsters created with magic. A mutant who has the task of killing unnatural beings. He uses a magical sign, potions and the pride of every witcher -- two swords, steel and silver. But what would happen if Geralt lost his weapons?\n" +
                            "\n" +
                            "In this standalone novel, Geralt fights, travels and loves again, Dandelion sings and flies from trouble to trouble, sorcerers are scheming ... and across the whole world clouds are gathering - the season of storms is coming..."
            );

            Book book2 = new Book(
                    "Sword of Destiny",
                    "Andrzej Sapkowski",
                    2015,
                    "Geralt is a witcher, a man whose magic powers, enhanced by long training and a mysterious elixir, have made him a brilliant fighter and a merciless assassin. Yet he is no ordinary murderer: his targets are the multifarious monsters and vile fiends that ravage the land and attack the innocent.\n" +
                            "\n" +
                            "This is a collection of short stories, following the adventures of the hit collection THE LAST WISH. Join Geralt as he battles monsters, demons and prejudices alike..."
            );

            repository.saveAll(
                    List.of(book1, book2)
            );
        };
    }
}
