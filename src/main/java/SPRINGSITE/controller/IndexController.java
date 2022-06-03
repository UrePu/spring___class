package SPRINGSITE.controller;

import SPRINGSITE.entity.TestEntity;
import SPRINGSITE.entity.TestRepository;
import org.aspectj.weaver.ast.Test;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/")
public class IndexController {
    @GetMapping("/main")
    public String home() {return "main";} //Response 요구가 없을 경우 타임리프 HTML 반환

    @Autowired
    TestRepository testRepository;


    @GetMapping("/save")
    @ResponseBody
    public String getdata(HttpServletRequest request){
        //0. 변수 요청
        String content = request.getParameter("content");
        //1. 엔티티 생성
        TestEntity testEntity = new TestEntity();
        testEntity.content = content;
        //2. 엔티티 save
        testRepository.save(testEntity);
        //3. 반환
        return "작성성공";
    }

    @GetMapping("getlist")
    public void getlist(HttpServletResponse response) {
        List<TestEntity> testEntities = testRepository.findAll();
        JSONArray jsonArray = new JSONArray();
        for(TestEntity e : testEntities){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("no",e.no);
            jsonObject.put("content",e.content);
            jsonArray.put(jsonObject);

        }
        try {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json");
            response.getWriter().print(jsonArray);

        }catch(IOException e) {throw new RuntimeException((e));}

    }
    @GetMapping("/delete")
    @ResponseBody
    @Transactional
    public String delete(HttpServletRequest request){
        int no = Integer.parseInt(request.getParameter("no"));

        //1. pk 값 이용한 엔티티 찾기
        Optional<TestEntity> optionalTestEntity = testRepository.findById(no);
        //2. Optional 객체 내 엔티티 빼오기
        TestEntity entity = optionalTestEntity.get();
        testRepository.delete(entity);

        return "1";
    }

    @GetMapping("/update")
    @ResponseBody
    @Transactional
    public String update(HttpServletRequest request){
        int no = Integer.parseInt(request.getParameter("no"));
        String content = request.getParameter("content");
        System.out.println(content);
        //1. pk 값 이용한 엔티티 찾기
        Optional<TestEntity> optionalTestEntity = testRepository.findById(no);

        TestEntity entity = optionalTestEntity.get();
        entity.content = content;
        return "1";
    }



        //@RequestMapping : 모든 URL 매핑 가능
        //@GetMapping : Get 메소드 URL 매핑 [ 요청변수 보인다 = 보안x 캐시 o]
        //@PostMapping : POST 메소드 URL 매잎ㅇ[요청변수 x = 보안O 캐시x]

        /////// 스프링에서 ㅈ원하는 요청방식 구분////////

        //@PutMapping : PUT 메소드 URl 매핑[삽입, 수정사용]
        //@DeleteMapping : DELETE 메소드 URL 매핑 [ 삭제시 사용]
        //@PathVariable : 경로에 변수를 바인딩(넘겨주기)

        //멱등성 : 요청후에 서버에 상태를 남김
}
