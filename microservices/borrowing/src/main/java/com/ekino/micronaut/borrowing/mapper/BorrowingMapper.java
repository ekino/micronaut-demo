package com.ekino.micronaut.borrowing.mapper;

import com.ekino.micronaut.borrowing.domain.Borrowing;
import com.ekino.micronaut.borrowing.dto.BorrowingOutputDto;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BorrowingMapper {

    static BorrowingMapper getInstance() {
        return Mappers.getMapper(BorrowingMapper.class);
    }

    @Mapping(target = "user", ignore = true)
    @Mapping(target = "book", ignore = true)
    BorrowingOutputDto borrowingToBorrowingDto(Borrowing source);

}
