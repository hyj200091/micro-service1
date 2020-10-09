package com.soft1851.share;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.soft1851.share.domain.dto.UserDto;
import com.soft1851.share.feignclient.TestBaiduFeignClient;
import com.soft1851.share.feignclient.TestCenterFeignClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName TestController
 * @Description TODO
 * @Author hyj
 * @Date 2020/9/23
 **/
@Slf4j
@RestController
@RequestMapping(value = "/api")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TestController {

    private final DiscoveryClient discoveryClient;

//    private final RestTemplate restTemplate;

    /**
     * 测试服务发现 证明内容中心总能找到用户
     * @return 用户中心所有实例列表
     */
    @GetMapping("/discovery")
    public List<ServiceInstance> getInstances(){
        //查询指定服务的所有实例信息，使用的是spring cloud接口和具体实现的组件无关
        //consul eureka zookeeper 都可以使用
        return this.discoveryClient.getInstances("user-center");
    }

//    @GetMapping("/call/hello")
//    public String callUserCenter(){
        //用户中心所有的实例
//        List<ServiceInstance> instances = discoveryClient.getInstances("user-center");
        //stream编程 lambda表达式 函数式编程
        // 理解这段代码的含义？它实现了什么功能
//        String targetUrl = instances.stream()
////                .map(instance -> instance.getUri().toString() + "/user/hello")
////                .findFirst()
//                .orElseThrow(() -> new IllegalArgumentException("当前没有实例"));
//        log.info("地址",targetUrl);
//        return restTemplate.getForObject(targetUrl,String.class);


//        int leng = instances.size();
//        int i = (int)(Math.random()*leng);
//        String  targetUrl = instances.get(i).getUri().toString() +"/user/hello";
//        log.info("请求的地址：",targetUrl);
//        System.out.println(targetUrl);
//        return restTemplate.getForObject(targetUrl,String.class);
//    }

//    @GetMapping("/call/ribbon")
//    public String callByRibbon() {
//        return restTemplate.getForObject("http://user-center/user/hello",String.class);
//    }

//    @GetMapping("/call/list")
//    public List<Object> getUserList() {
//        return restTemplate.getForObject("http://user-center/user/list",List.class);
//    }

    @Autowired
    private TestCenterFeignClient testCenterFeignClient;

    @GetMapping("/test-q")
    public UserDto query(UserDto userDto){
        return testCenterFeignClient.query(userDto);
    }

    @Autowired
    private TestBaiduFeignClient testBaiduFeignClient;
    @GetMapping("/baidu")
    public String BaiduIndex(){
        return testBaiduFeignClient.index();
    }
    @GetMapping("/docker/test")
    public String TestDocker(){
        return "docker test!!!";
    }

    @GetMapping("/ByResource")
    @SentinelResource(value = "ByResource",blockHandler = "handleException")
    public String byResource(){
        return "按名称限流";
    }
    public String handleException(BlockException blockException){
        return "服务不可调用";
    }
}