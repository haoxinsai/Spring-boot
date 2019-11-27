package com.test.tests_b.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PaginationDTO {
    private List<QuestionDTO> question;
    private Boolean showPrevious;//是否有向前一页的按钮
    private Boolean showFirstPage;//是否有首页摁扭
    private Boolean showNext ;//是否有向后一页的摁扭
    private Boolean showEndPage ;//是否有最后一页的摁扭
    private Integer page;//当前页
    private List<Integer> pages = new ArrayList<>();//有多少页
    private Integer totalPage;//总页数
    public void setPagination(Integer totalPage, Integer page) {
        this.totalPage=totalPage;
        this.page=page;

        pages.add(page);
        for(int i = 1; i <= 3; i++){
            if(page-i > 0){
                pages.add(0,page-i);
                System.out.println(page-i+"--------------------");
            }

            if(page + i <= totalPage){
                pages.add(page+i);
                System.out.println(page+i+"++++++++++++++++++++");
            }
        }


        //是否有向前一页的按钮
        if (page == 1){
            showPrevious = false;
        }else{
            showPrevious = true;
        }
        //是否有向后一页的摁扭
        if(page == totalPage){
            showNext = false;
        }else{
            showNext = true;
        }
        //是否有首页摁扭
        if(pages.contains(1)){
            showFirstPage = false;
        }else{
            showFirstPage = true;
        }
        //是否有最后一页的摁扭
        if(pages.contains(totalPage)){
            showEndPage = false;
        }else{
            showEndPage = true;
        }

    }
}
