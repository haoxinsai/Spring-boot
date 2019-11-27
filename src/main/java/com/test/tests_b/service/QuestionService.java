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
        Integer totalPage;
        Integer totalCount=this.quesstionMapper.count();//总页数
        if(totalCount % size == 0){
            totalPage = totalCount / size;
        }else{
            totalPage = totalCount / size + 1;
        }


        if(page<1){
            page=1;
        }
        if(page>totalPage){
            page=totalPage;
        }

        paginationDTO.setPagination(totalPage,page);
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

    public PaginationDTO listByUserId(Integer userid, Integer page, Integer size) {
        PaginationDTO paginationDTO = new PaginationDTO();
        Integer totalPage;
        Integer totalCount=this.quesstionMapper.countByUserId(userid);//总页数
        if(totalCount % size == 0){
            totalPage = totalCount / size;
        }else{
            totalPage = totalCount / size + 1;
        }


        if(page<1){
            page=1;
        }
        if(page>totalPage){
            page=totalPage;
        }

        paginationDTO.setPagination(totalPage,page);

        //size*(page-1)
        Integer offset = size * (page - 1);
        List<Quesstion> quesstions=this.quesstionMapper.listByUserId(userid,offset,size);
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
