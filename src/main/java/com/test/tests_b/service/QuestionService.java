package com.test.tests_b.service;

import com.test.tests_b.dto.PaginationDTO;
import com.test.tests_b.dto.QuestionDTO;
import com.test.tests_b.mapper.QuesstionMapper;
import com.test.tests_b.mapper.UserMapper;
import com.test.tests_b.model.Quesstion;
import com.test.tests_b.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private QuesstionMapper quesstionMapper;

    public PaginationDTO list(Integer page, Integer size){

        PaginationDTO paginationDTO = new PaginationDTO();
        Integer totalCount=this.quesstionMapper.count();//总页数
        paginationDTO.setPagination(totalCount,page,size);
        if(page<1){
            page=1;
        }
        if(page>paginationDTO.getTotalPage()){
            page=paginationDTO.getTotalPage();
        }

        //size*(page-1)
        Integer offset = size * (page - 1);
        List<Quesstion> quesstions=this.quesstionMapper.list(offset,size);
        List<QuestionDTO> questionDTOList= new ArrayList<>();


        for(Quesstion quesstion : quesstions){
            User user = userMapper.findById(quesstion.getCreator());
            QuestionDTO questionDTO =new QuestionDTO();
            BeanUtils.copyProperties(quesstion,questionDTO);//可以将quesstion里的属性copy到questionDTO里
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }
        paginationDTO.setQuestion(questionDTOList);
        return paginationDTO;
    }
}
