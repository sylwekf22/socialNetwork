package dto;

import pojo.Author;

public class AuthorDtoConverter {

    public AuthorDtoConverter() {
    }

    public static AuthorDto convert(Author author){
        AuthorDto authorDto = new AuthorDto();
        authorDto.setId(author.getId());
        authorDto.setMail(author.getMail());
        authorDto.setWww(author.getWww());
        authorDto.setCity(author.getCity());
        authorDto.setCountry(author.getCountry());
        authorDto.setContinent(author.getContinent());
        authorDto.setFirstName(author.getFirstName());
        authorDto.setSecondName(author.getSecondName());
        authorDto.setGroup(author.getGroup());
        authorDto.setLeader(author.getLeader());
        authorDto.setHistory(author.getHistory());
        authorDto.setTested(author.getTested());
        authorDto.setAdd_date(author.getAdd_date());
        authorDto.setConfirmation(author.getConfirmation());

        return authorDto;
    }
}

