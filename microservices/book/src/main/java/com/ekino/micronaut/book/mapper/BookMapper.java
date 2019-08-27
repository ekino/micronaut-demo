package com.ekino.micronaut.book.mapper;

import com.ekino.micronaut.book.domain.Book;
import com.ekino.micronaut.book.dto.BookDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookMapper {

    static BookMapper getInstance() {
        return Mappers.getMapper(BookMapper.class);
    }

    BookDTO booToBookDto(Book source);

}
