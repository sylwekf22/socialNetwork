package dto;

import pojo.Title;

public class TitleDtoConverter {

    public TitleDtoConverter() {
    }

    public static TitleDto convert(Title title){
        TitleDto titleDto = new TitleDto();
        titleDto.setId(title.getId());
        titleDto.setTitle(title.getTitle());
        titleDto.setPublication_place(title.getPublication_place());
        titleDto.setPublication_year(title.getPublication_year());
        titleDto.setPublisher_id(title.getPublisher_id());
        titleDto.setPublication_month(title.getPublication_month());
        titleDto.setBook_chapter(title.getBook_chapter());
        titleDto.setPages(title.getPages());
        titleDto.setBook_volume(title.getBook_volume());
        titleDto.setNote(title.getNote());
        titleDto.setBook_series(title.getBook_series());
        titleDto.setSubtitle(title.getSubtitle());
        titleDto.setSchool(title.getSchool());
        titleDto.setUser_id(title.getUser_id());
        titleDto.setUrl(title.getUrl());
        titleDto.setIsbn(title.getIsbn());
        titleDto.setPreface(title.getPreface());
        titleDto.setIssn(title.getIssn());
        titleDto.setClassifier(title.getClassifier());
        titleDto.setReturn_date(title.getReturn_date());
        titleDto.setPublic_key(title.getPublic_key());
        titleDto.setEe_dblp(title.getEe_dblp());
        titleDto.setUrl_dblp(title.getUrl_dblp());
        titleDto.setCdrom_dblp(title.getCdrom_dblp());
        titleDto.setCrossref_dblp(title.getCrossref_dblp());
        titleDto.setHowpublished(title.getHowpublished());
        titleDto.setType(title.getType());
        titleDto.setInstitution(title.getInstitution());
        titleDto.setConfirmation(title.getConfirmation());

        return titleDto;
    }

}
